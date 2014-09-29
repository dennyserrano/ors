'use strict';

angular.module('UserApp')
    .controller('UserDatasetCtrl', ['$scope', 'DatasetService', 'ElementService', 'OwnerService',
        function($scope, DatasetService, ElementService, OwnerService) {

            $scope.datasets = [];
            $scope.subDatasets = {};

            $scope.availableDatasets = [];
            $scope.availableElements = {};

            DatasetService.query(function(datasets) {
                $scope.datasets = datasets;
            });

            $scope.findAvailableDatasets = function() {
                OwnerService.get({ 'ownerId': 0 }, function(datasets) {
                    $scope.availableDatasets = datasets;
                });
            };

            $scope.findAvailableElements = function(headId) {
                if (!$scope.availableElements[headId]) {
                    ElementService.get({ 'headId': headId }, function(elements) {
                        $scope.availableElements[headId] = elements;
                    });
                }
            };

            $scope.setDataset = function(selectedDataset) {
                $scope.dataset = selectedDataset;
            }
        }
    ]);