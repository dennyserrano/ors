'use strict';

angular.module('UserApp')
    .controller('UserDatasetCtrl', ['$scope', 'DatasetService', 'ElementService', 'PreviewDataService',
        function($scope, DatasetService, ElementService, PreviewDataService) {

            $scope.datasets = [];
            $scope.subDatasets = [];
            $scope.elements = [];

            $scope.availableDatasets = null;
            $scope.availableElements = {};

            DatasetService.query(function(datasets) {
                $scope.datasets = datasets;
            });

            $scope.setDataset = function(selectedDataset) {
                $scope.currentDataset = selectedDataset;
                $scope.dataset = selectedDataset;
                var headId = selectedDataset.parentDatasetHead;
                if (!$scope.availableElements[headId]) {
                    ElementService.get({ 'headId': headId }, function(elements) {
                        $scope.availableElements[headId] = elements;
                    });
                }
            };

            $scope.useElement = function() {
                angular.forEach($scope.subDatasets, function(subDataset, idx) {
                    if (subDataset.id === $scope.currentDataset.id) {
                        $scope.subDatasets.splice(idx, 1);
                    }
                });
                $scope.subDatasets.push(angular.copy($scope.currentDataset));
            };

            $scope.previewData = function() {
                angular.forEach($scope.subDatasets, function(subdataset) {
                    angular.forEach(subdataset.elements, function(subdatasetElement) {
                        $scope.elements.push(subdatasetElement);
                    });
                });
                $scope.dataset.elements = $scope.elements;
                $scope.dataset.subDatasets = $scope.subDatasets;
                PreviewDataService.preview($scope.dataset, function(data) {
                    $scope.headers = data[0];
                    data.splice(0, 1);
                    $scope.datas = data;
                    $scope.datasetJson = JSON.stringify($scope.dataset);
                    console.log($scope.datasetJson);
                });
            };
        }
    ]);