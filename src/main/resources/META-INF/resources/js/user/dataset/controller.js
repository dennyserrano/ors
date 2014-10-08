'use strict';

angular.module('UserApp')
    .controller('UserDatasetCtrl', ['$scope', 'DatasetService', 'ElementService', 'CriteriaService', 'PreviewDataService',
        function($scope, DatasetService, ElementService, CriteriaService, PreviewDataService) {

            $scope.datasets = [];
            $scope.elements = [];

            $scope.availableDatasets = null;

            $scope.selectedValues = {};

            $scope.step1 = 'active';
            $scope.step2 = 'disabled';
            $scope.step3 = 'disabled';
            $scope.step4 = 'disabled';

            DatasetService.query(function(datasets) {
                $scope.datasets = datasets;
            });
            
            var scopeCriteria = $scope.criteria || [];
            CriteriaService.get({ 'headId': 8 }, function(criteria) {
                angular.forEach(criteria, function(criterion) {
                    angular.forEach(scopeCriteria, function(scopeCriterion, idx) {
                    	if (criterion.filterId === scopeCriterion.filterId) {
                    		scopeCriterion.splice(idx, 1);
                    	}
                    });
                    scopeCriteria.push(criterion);
                });
                $scope.criteria = scopeCriteria;
            });

            $scope.setDataset = function(selectedDataset) {
                $scope.dataset = selectedDataset;
                var subDatasets = $scope.subDatasets ? $scope.subDatasets : [];
                subDatasets.push($scope.dataset);
                var headId = selectedDataset.id;
                var availableElements = $scope.availableElements ? $scope.availableElements : {};
                if (!availableElements[headId]) {
                    ElementService.get({ 'headId': headId }, function(elements) {
                        availableElements[headId] = elements;
                    });
                }
                
                $scope.availableElements = availableElements;
                $scope.subDatasets = subDatasets;

                $scope.step1 = 'complete';
                $scope.step2 = 'active';
                $scope.step3 = 'disabled';
                $scope.step4 = 'disabled';
            };

            $scope.elementsSelected = function() {
                $scope.step1 = 'complete';
                $scope.step2 = 'complete';
                $scope.step3 = 'active';
                $scope.step4 = 'disabled';
            };

            $scope.setFilter = function(criterion, option) {
                var filters = $scope.filters ? $scope.filters : [];
                angular.forEach(filters, function(filter, idx) {
                    if (filter.criterion === criterion.filterId) {
                        filters.splice(idx, 1);
                    }
                });
                filters.push({
                    criterion: criterion.filterId,
                    element: criterion.elementId,
                    selectedValue: option.key
                });
                $scope.filters = filters;
                $scope.selectedValues[criterion.filterId] = option.value;
                if (criterion.filterId === 8) { // number 8 is from sisdbtest.dataset_criteria.id where filter_name = 'Region'
                    angular.forEach($scope.criteria, function(c) {
                        if (c.filterId === 9) { // number 9 is from sisdbtest.dataset_criteria.id where filter_name = 'Division'
                            c.selection = option.childKeyValues;
                        }
                    });
                }
            };

            $scope.previewData = function() {
                var elements = [];
                angular.forEach($scope.subDatasets, function(subdataset) {
                    angular.forEach(subdataset.elements, function(subdatasetElement) {
                        elements.push(subdatasetElement);
                    });
                });
                var subDatasets = $scope.subDatasets;
                var datasetToSubmit = {
                    elements: elements,
                    subDatasets: subDatasets,
                    filters: $scope.filters
                };
                PreviewDataService.preview(datasetToSubmit, function(data) {
                    $scope.headers = data[0];
                    data.splice(0, 1);
                    $scope.datas = data;
                    $scope.datasetJson = JSON.stringify(datasetToSubmit);
                });
            };
        }
    ]);