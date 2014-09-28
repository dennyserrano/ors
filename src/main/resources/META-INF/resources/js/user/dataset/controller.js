'use strict';

angular.module('UserApp')
    .controller('UserDatasetCtrl', ['$scope', 'DatasetService', 'ElementService',
        function($scope, DatasetService, ElementService) {

            $scope.datasets = [];
            $scope.subDatasets = {};

            DatasetService.query(function(datasets) {
                $scope.datasets = datasets;
            });

            $scope.findSubdatasets = function(headId) {
                ElementService.get({ 'headId': headId }, function(elements) {
                    $scope.subDatasets[headId] = elements;
                });
            };
        }
    ]);