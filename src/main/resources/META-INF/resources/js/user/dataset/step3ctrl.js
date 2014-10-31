'use strict';

angular.module('UserApp')
    .controller('Step3Ctrl', ['$scope', '$state', 'UserDatasetService', 'CriteriaService',
        function($scope, $state, UserDatasetService, CriteriaService) {
            
            $scope.step1 = 'complete';
            $scope.step2 = 'complete';
            $scope.step3 = 'active';
            $scope.step4 = 'disabled';

            $scope.selectedValues = {};
            $scope.loadingFilters = true;

            var schoolProfileDatasetId = 8; // value came from the database (sisdbtest.dataset_head).
            var regionFilterId = 8; // number 8 is from sisdbtest.dataset_criteria.id where filter_name = 'Region'
            var divisionFilterId = 9; // number 9 is from sisdbtest.dataset_criteria.id where filter_name = 'Divison'
            var availableCriteria = [];
            var hasSchoolProfileSelected = false;
            var divisionCriterion;

            var criteriaIteratorCallback = function(c) {
                availableCriteria.push(c);
                $scope.selectedValues[c.filterId] = c.selection[0];
                $scope.setFilter(c);
            };

            var criteriaServiceCallback = function(criteria) {
                angular.forEach(criteria, function(criterion) {
                    if (criterion.filterId === divisionFilterId) {
                        divisionCriterion = criterion;
                    }

                });
                angular.forEach(criteria, criteriaIteratorCallback);
            };

            var selectedDatsetsCallback = function(selectedDataset) {
                CriteriaService.get({ 'headId': selectedDataset.id }, criteriaServiceCallback);
            };
            
            UserDatasetService.get({}, function(dataset) {
                $scope.dataset = dataset;
                availableCriteria = dataset.filters;
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
                $scope.loadingFilters = false;
            });
            
            $scope.setFilter = function(criterion) {
                var selectedOption = $scope.selectedValues[criterion.filterId]
                var filters = $scope.filters ? $scope.filters : [];
                angular.forEach(filters, function(filter, idx) {
                    if (filter.criterion === criterion.filterId) {
                        filters.splice(idx, 1);
                    }
                });
                filters.push({
                    criterion: criterion.filterId,
                    element: criterion.elementId,
                    selectedValue: selectedOption.key
                });
                $scope.filters = filters;
                if (!$scope.loadingFilters && criterion.filterId === regionFilterId) {
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