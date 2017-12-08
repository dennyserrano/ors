'use strict';

angular.module('DatasetApp')
    .controller('DatasetFormCtrl', ['$scope', '$state', '$stateParams', "$window", 'DatasetService', 'ElementService', 'OwnerService',
        function($scope, $state, $stateParams, $window, DatasetService, ElementService, OwnerService) {

            $scope.loading = false;

            // selected subdatasets
            $scope.subDatasets = [];
            // selected elements
            $scope.elements = [];

            // sub/dataset choices
            $scope.availableDatasets = [];
            // element options
            $scope.subdatasetElements = {};

            $scope.dismiss = function() {
                $window.location.href = '/admin/datasets';
            };

            $scope.save = function(isValid) {
                var dataset = {
                    name: this.name,
                    description: this.description,
                    tableName: this.tableName,
                    subDatasets: this.subDatasets,
                    elements: this.elements
                };
                console.log(JSON.stringify(dataset)); // TODO Remove when saving of dataset has been implemented.
                console.log('Elements Selected: ' + dataset.elements.length);
            };

            $scope.showAvailableDatasets = function() {
                $scope.loadingDatasets = true;
                OwnerService.query({ 'ownerId': 0 }, function(datasets) {
                    $scope.availableDatasets = datasets;
                    $scope.loadingDatasets = false;
                });
            };

            $scope.findElements = function(headId) {
                ElementService.query({ 'headId': headId}, function(elements) {
                    $scope.subdatasetElements = elements;
                });
                $scope.selectedId = headId;
            };

            $scope.addSubdataset = function(selectedDataset) {
                var foundDataset;
                angular.forEach($scope.subDatasets, function(subdataset, idx) {
                    if (selectedDataset.id === subdataset.id) {
                        $scope.subDatasets.splice(idx, 1);
                        foundDataset = subdataset;
                    }
                });
                $scope.subDatasets.unshift(!foundDataset ? selectedDataset : foundDataset);
                $('#availableDatasetsDialog').modal('hide');
                $scope.findElements(!foundDataset ? selectedDataset.id : foundDataset.id);
            };

            if ($stateParams.id) {
                $scope.loading = true;
                DatasetService.get({datasetId: $stateParams.id}, function(dataset) {
                    $scope.id = dataset.id;
                    $scope.name = dataset.name;
                    $scope.description = dataset.description;
                    $scope.tableName = dataset.tableName;
                    $scope.subDatasets = dataset.subDatasets;
                    if (dataset.elements) {
                        $scope.elements = dataset.elements;
                    }
                    $scope.loading = false;
                });
            }
        }
    ]);