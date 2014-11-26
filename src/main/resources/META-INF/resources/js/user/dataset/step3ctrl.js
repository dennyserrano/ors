'use strict';

angular.module('UserApp')
    .controller('Step3Ctrl', ['$scope', '$state', '$window', 'UserDatasetService', 'CriteriaService', 'SchoolNameCriteriaService',
        function($scope, $state, $window, UserDatasetService, CriteriaService, SchoolNameCriteriaService) {
            
            $scope.step1 = 'complete';
            $scope.step2 = 'complete';
            $scope.step3 = 'active';
            $scope.step4 = 'disabled';

            $scope.selectedValues = {};
            $scope.filters = [];
            $scope.loadingFilters = 0;

            $window.ORS.AdjustDatasetContents(0);
            
            $scope.$watch('loadingFilters', function(newVal, oldVal) {
                if (oldVal === 0 && newVal === 1) {
                    $window.scrollTo(0, 0);
                }
            });
            
            var schoolProfileDatasetId = 8; // value came from the database (sisdbtest.dataset_head).
            var regionFilterId = 8; // number 8 is from sisdbtest.dataset_criteria.id where filter_name = 'sp_region'
            var divisionFilterId = 9; // number 9 is from sisdbtest.dataset_criteria.id where filter_name = 'sp_division'
            var schoolNameFilterId = 16; // number 16 from sisdbtest.dataset_criteria.id where filter_name = 'sp_schoolName'
            var availableCriteria = [];
            var hasSchoolProfileSelected = false;
            var divisionCriterion;
            var schoolIdFilter;

            var criteriaIteratorCallback = function(c) {
                availableCriteria.push(c);
                if (c.filterId === divisionFilterId) {
                    divisionCriterion = c;
                }
                if (c && c.selection) {
                    $scope.selectedValues[c.filterId] = c.selection[0];
                }
                else {
                    $scope.selectedValues[c.filterId] = {
                        key: '',
                        value: ''
                    };
                }
                angular.forEach($scope.filters, function(filter) {
                    if (filter.criterion === c.filterId) {
                        $scope.selectedValues[c.filterId] = filter.selectedOption;
                    }
                });
                $scope.setFilter(c);
            };
            
            var divisionCriteriaFilter = function(criterion) {
                if (criterion.filterId === divisionFilterId) {
                    divisionCriterion = criterion;
                }
            };

            var criteriaServiceCallback = function(criteria) {
                angular.forEach(criteria, divisionCriteriaFilter);
                angular.forEach(criteria, criteriaIteratorCallback);
            };

            var selectedDatsetsCallback = function(selectedDataset) {
                CriteriaService.get({ 'headId': selectedDataset.id }, criteriaServiceCallback);
            };

            UserDatasetService.get({}, function(dataset) {
                $scope.dataset = dataset || {};
                $scope.filters = dataset.filters || [];
                angular.forEach($scope.dataset.subDatasets, function(selectedDataset) {
                    if (selectedDataset.id === schoolProfileDatasetId) {
                        hasSchoolProfileSelected = true;
                    }
                });
                if (!hasSchoolProfileSelected) {
                    CriteriaService.get({ 'headId': schoolProfileDatasetId }, criteriaServiceCallback);
                }
                angular.forEach($scope.dataset.subDatasets, selectedDatsetsCallback);
                $scope.availableCriteria = availableCriteria;
                $scope.loadingFilters = 1;
            }, function(response) {
                $scope.loadingFilters = 2;
                $scope.loadingFiltersError = 'Failed to load Filters. [HTTP Status: ' + response.status + '].';
            });
            
            $scope.setFilter = function(criterion) {
                var selectedOption = $scope.selectedValues[criterion.filterId];
                var filterFound = false;
                var findFilterCallback = function(filter) {
                    if (filter.criterion === criterion.filterId) {
                        filterFound = true;
                    }
                };
                angular.forEach($scope.filters, findFilterCallback);
                if (!filterFound) {
                    $scope.filters.push({
                        criterion: criterion.filterId,
                        element: criterion.elementId,
                        selectedOption: selectedOption
                    });
                }
                else {
                    angular.forEach($scope.filters, function(filter) {
                        if (filter.criterion === criterion.filterId && filter.element === criterion.elementId) {
                            filter.selectedOption = selectedOption;
                        }
                    });
                }
                // TODO dynamic filters with callback or specialized actions.
                if (criterion.filterId === regionFilterId) {
                    divisionCriterion.selection = selectedOption.childKeyValues;
                }
            };
            
            $scope.searchSchools = function(schoolName) {
                angular.forEach($scope.filters, function(filter) {
                    if (filter.criterion === schoolNameFilterId) {
                        filter.selectedOption = {
                            key: schoolName
                        };
                    }
                });
                var promise = SchoolNameCriteriaService.searchSchool({}, $scope.filters).$promise;
                promise.then(function(response) {
                    return response;
                });
                return promise;
            };
            
            $scope.selectSchool = function(item, model, label, availableCriterion) {
                $scope.selectedValues[availableCriterion.filterId] = item;
                $scope.selectedSchoolName = item.value;
                $scope.setFilter(availableCriterion);
            };
            
            $scope.save = function() {
                $scope.saving = true;
                var dataset = $scope.dataset;
                dataset.filters = $scope.filters;
                angular.forEach(dataset.filters, function(filter) {
                    if (filter.criterion === schoolNameFilterId) {
                        if (!$scope.selectedSchoolName) {
                            filter.selectedOption = $scope.selectedValues[schoolNameFilterId];
                        }
                    }
                });
                UserDatasetService.save({}, dataset, function(response) {
                    if (response.code === 'SUCCESS') {
                        $state.go('step4');
                    }
                });
            };
        }
    ]
);