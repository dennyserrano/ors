'use strict';

angular.module('UserApp')
    .controller('Step3Ctrl', ['$scope', '$state', 'UserDatasetService', 'CriteriaService',
        function($scope, $state, UserDatasetService, CriteriaService) {
            
            $scope.step1 = 'complete';
            $scope.step2 = 'complete';
            $scope.step3 = 'active';
            $scope.step4 = 'disabled';

            $scope.selectedValues = {};
            $scope.filters = [];
            $scope.loadingFilters = 0;

            var schoolProfileDatasetId = 8; // value came from the database (sisdbtest.dataset_head).
            var regionFilterId = 8; // number 8 is from sisdbtest.dataset_criteria.id where filter_name = 'Region'
            var divisionFilterId = 9; // number 9 is from sisdbtest.dataset_criteria.id where filter_name = 'Divison'
            var availableCriteria = [];
            var hasSchoolProfileSelected = false;
            var divisionCriterion;

            var criteriaIteratorCallback = function(c) {
                availableCriteria.push(c);
                $scope.selectedValues[c.filterId] = c.selection[0];
                angular.forEach($scope.filters, function(filter) {
                    if (filter.criterion === c.filterId) {
                        $scope.selectedValues[c.filterId] = filter.selectedValue;
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
                $scope.dataset = dataset;
                $scope.filters = dataset.filters;
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
                        selectedValue: selectedOption.key
                    });
                }
                else {
                    angular.forEach($scope.filters, function(filter) {
                        if (filter.criterion === criterion.filterId && filter.element === criterion.elementId) {
                            filter.selectedValue = selectedOption.key;
                        }
                    });
                }
                if (criterion.filterId === regionFilterId) {
                    divisionCriterion.selection = selectedOption.childKeyValues;
                }
            };
            
            $scope.save = function() {
                var dataset = $scope.dataset;
                dataset.filters = $scope.filters;
                UserDatasetService.save({}, dataset, function(response) {
                    if (response.code === 'SUCCESS') {
                        $state.go('step4');
                    }
                });
            };
        }
    ]
);