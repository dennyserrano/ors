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
            
            var subdatasetsCallback = function(selectedDataset) {
                $scope.selectedDatasets.push(selectedDataset);
            };

            UserDatasetService.get({}, function(dataset) {
                angular.forEach(dataset.subDatasets, subdatasetsCallback);
            });
            
            var datasetsScopeWatcherCallback = function(newValue, oldValue) {
                if (newValue && newValue.length > 0) {
                    $timeout(function() {
                        $('#side-menu').metisMenu();
                    }, 50);
                }
            };
            
            $scope.$watch('datasets', datasetsScopeWatcherCallback);
            
            $scope.loadingDatasets = true;
            var subDataset;
            var selectedDatasetsIteratorCallback = function(selectedDataset, index) {
                if (subDataset.id === selectedDataset.id) {
                    $scope.selectedDatasets[index] = subDataset;
                }
            };
            var subDatasetsIteratorCallback = function(sd) {
                subDataset = sd;
                angular.forEach($scope.selectedDatasets, selectedDatasetsIteratorCallback);
            }
            var datasetsIteratorCallback = function(dataset) {
                angular.forEach(dataset.subDatasets, subDatasetsIteratorCallback);
            };
            DatasetService.query(function(datasets) {
                $scope.datasets = datasets;
                $scope.loadingDatasets = false;
                angular.forEach($scope.datasets, datasetsIteratorCallback);
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
                var selectedDatasetIteratorCallback = function(selectedSubdataset) {
                    if (subdataset.id === selectedSubdataset.id) {
                        selected = true;
                    }
                };
                angular.forEach($scope.selectedDatasets, selectedDatasetIteratorCallback);
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