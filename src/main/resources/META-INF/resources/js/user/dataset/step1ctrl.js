
//temp code on step2
//Correction facility in service.js
// hardcoded on step 2
//bug? what if only type_name is chosen?
// hard code on datasetserviceimpl specifics report
'use strict';

angular.module('UserApp')
    .controller('Step1Ctrl', ['$scope', '$timeout', '$state', '$window', 'DatasetService', 'ElementService', 'UserDatasetService','localStorageService',
        function($scope, $timeout, $state, $window, DatasetService, ElementService, UserDatasetService,localStorageService) {

            $scope.selectedDatasets = []; // selected datasets
            $scope.datasets = []; // the dataset menu
            $scope.step1 = 'active';
            $scope.step2 = 'disabled';
            $scope.step3 = 'disabled';
            $scope.step4 = 'disabled';
            $scope.loadingDatasets = 0;
            $window.ORS.AdjustDatasetContents(0);

            var datasetsScopeWatcherCallback = function(newValue, oldValue) {
                if (newValue && newValue.length > 0) {
                    $timeout(function() {
                        $('#side-menu').metisMenu();
                    }, 50);
                }
            };
            
            $scope.$watch('datasets', datasetsScopeWatcherCallback);

            var subDataset;
            var selectedDatasetsIteratorCallback = function(selectedDataset, index) {
                if (subDataset.id === selectedDataset.id) {
                    $scope.selectedDatasets[index] = subDataset;
                }
            };
            var subDatasetsIteratorCallback = function(sd) {
                subDataset = sd;
                angular.forEach($scope.selectedDatasets, selectedDatasetsIteratorCallback);
            };
            var datasetsIteratorCallback = function(dataset) {
                angular.forEach(dataset.subDatasets, subDatasetsIteratorCallback);
            };
            var subdatasetsCallback = function(selectedDataset) {
                $scope.selectedDatasets.push(selectedDataset);
            };
            
            DatasetService.query(function(datasets) {
                $scope.datasets = datasets;
                UserDatasetService.get({}, function(dataset) {
                    if (!dataset) {
                        $scope.dataset = {};
                        $scope.dataset.elements = [];
                    }
                    else {
                        $scope.dataset = dataset;
//                        if (dataset.subDatasets && dataset.subDatasets.length > 0) {
//                            angular.forEach(dataset.subDatasets, subdatasetsCallback);
//                        }
                    }
                });
                angular.forEach($scope.datasets, datasetsIteratorCallback);
                $scope.loadingDatasets = 1;
            }, function(response) {
                $scope.loadingDatasets = 2;
                $scope.loadingDatasetsError = 'Failed to load Datasets. [HTTP Status: ' + response.status + ']';
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
                $scope.saving = true;
                var dataset = $scope.dataset;
                dataset.elements = dataset.elements || [];
                dataset.subDatasets = $scope.selectedDatasets;
                UserDatasetService.save({}, dataset, function(response) {
                    if (response.code === 'SUCCESS') {
                    	localStorageService.set('dataset',dataset);
                        $state.go('step2');
                    }
                });
            };
        }
    ]
);