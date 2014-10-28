'use strict';

angular.module('UserApp')
    .controller('Step1Ctrl', ['$scope', '$timeout', '$state', 'DatasetService', 'ElementService', 'UserDatasetService',
        function($scope, $timeout, $state, DatasetService, ElementService, UserDatasetService) {

            $scope.selectedDatasets = []; // selected datasets
            $scope.datasets = []; // the dataset menu
            $scope.step1 = 'active';
            $scope.step2 = 'disabled';
            $scope.step3 = 'disabled';
            $scope.step4 = 'disabled';

            UserDatasetService.get({}, function(dataset) {
                angular.forEach(dataset.subDatasets, function(selectedDataset) {
                    $scope.selectedDatasets.push(selectedDataset);
                });
            });
            
            $scope.$watch('datasets', function(newValue, oldValue) {
                if (newValue && newValue.length > 0) {
                    $timeout(function() {
                        $('#side-menu').metisMenu();
                    }, 10);
                }
            });
            
            $scope.loadingDatasets = true;
            DatasetService.query(function(datasets) {
                $scope.datasets = datasets;
                $scope.loadingDatasets = false;
                angular.forEach($scope.datasets, function(dataset) {
                    angular.forEach(dataset.subDatasets, function(subDataset) {
                        angular.forEach($scope.selectedDatasets, function(selectedDataset, index) {
                            if (subDataset.id === selectedDataset.id) {
                                $scope.selectedDatasets[index] = subDataset;
                            }
                        });
                    });
                });
            });
            
            $scope.loadElements = function(subdataset) {
                if (!subdataset.elements || subdataset.elements.length === 0) {
                    ElementService.get({ 'headId': subdataset.id }, function(elements) {
                        subdataset.elements = elements;
                    });
                }
            };
            
            $scope.datasetSelected = function(subdataset) {
                var selected = false;
                angular.forEach($scope.selectedDatasets, function(selectedSubdataset) {
                    if (subdataset.id === selectedSubdataset.id) {
                        selected = true;
                    }
                });
                return selected;
            };
            
            $scope.save = function() {
                var dataset = {};
                dataset.subDatasets = $scope.selectedDatasets;
                dataset.elements = [];
                UserDatasetService.save({}, dataset, function(response) {
                    if (response.code === 'SUCCESS') {
                        $state.go('step2');
                    }
                });
            };
        }
    ]
);