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

            $scope.setDataset = function(selectedDataset) {
                $scope.dataset = selectedDataset;
                var subDatasets = $scope.subDatasets ? $scope.subDatasets : [];
                subDatasets.push($scope.dataset);
                var headId = selectedDataset.parentDatasetHead;
                var availableElements = $scope.availableElements ? $scope.availableElements : {};
                if (!availableElements[headId]) {
                    ElementService.get({ 'headId': headId }, function(elements) {
                        availableElements[headId] = elements;
                    });
                }
                var scopeCriteria = $scope.criteria ? $scope.criteria : [];
                CriteriaService.get({ 'headId': headId }, function(criteria) {
                    angular.forEach(criteria, function(criterion) {
                        scopeCriteria.push(criterion);
                    });
                    $scope.criteria = scopeCriteria;
                });
                $scope.availableElements = availableElements;
                $scope.subDatasets = subDatasets;

                $scope.step1 = 'complete';
                $scope.step2 = 'active';
                $scope.step3 = 'disabled';
                $scope.step4 = 'disabled';
            };

            $scope.$watch('subDatasets', function() {
                if ($scope.subDatasets && $scope.subDatasets.length > 0 &&
                        $scope.subDatasets[0].elements && $scope.subDatasets[0].elements.length > 0) {
                    $scope.step1 = 'complete';
                    $scope.step2 = 'complete';
                    $scope.step3 = 'active';
                    $scope.step4 = 'disabled';
                }
            });

            $scope.setFilter = function(criterion, option) {
                var filters = $scope.dataset.filters ? $scope.dataset.filters : [];
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
                $scope.dataset.filters = filters;
                $scope.selectedValues[criterion.filterId] = option.value;
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
                    filters: $scope.dataset.filters
                };
                console.log(JSON.stringify(datasetToSubmit));
                PreviewDataService.preview(datasetToSubmit, function(data) {
                    $scope.headers = data[0];
                    data.splice(0, 1);
                    $scope.datas = data;
                    $scope.datasetJson = JSON.stringify(datasetToSubmit);
                });
            };
        }
    ]);