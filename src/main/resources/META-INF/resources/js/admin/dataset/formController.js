'use strict';

angular.module('DatasetApp')
    .controller('DatasetFormCtrl', ['$scope', '$state', '$stateParams', "$window", 'DatasetService', 'ElementService', 'OwnerService',
        function($scope, $state, $stateParams, $window, DatasetService, ElementService, OwnerService) {

            $scope.loading = false;

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
                console.log(JSON.stringify(dataset));
            };

            $scope.showAvailableDatasets = function() {
                $scope.loadingDatasets = true;
                OwnerService.query({ 'ownerId': 0 }, function(datasets) {
                    $scope.availableDatasets = datasets;
                    $scope.loadingDatasets = false;
                });
            };

            $scope.findElements = function(headId) {
                var foundElements = [];
                ElementService.query({ 'headId': headId}, function(elements) {
                    foundElements = elements;
                });
                $scope.foundElements = foundElements;
            };

            $scope.addSubdataset = function(selectedDataset) {
                $scope.subDatasets.unshift(selectedDataset);
                $('#availableDatasetsDialog').modal('hide');
            };

            $scope.subDatasets = [];
            $scope.elements = [];

            if ($stateParams.id) {
                $scope.loading = true;
                DatasetService.get({datasetId: $stateParams.id}, function(dataset) {
                    $scope.id = dataset.id;
                    $scope.name = dataset.name;
                    $scope.description = dataset.description;
                    $scope.tableName = dataset.tableName;
                    $scope.subDatasets = dataset.subDatasets;
                    $scope.elements = dataset.elements;
                    $scope.loading = false;
                });
            }
        }
    ]);