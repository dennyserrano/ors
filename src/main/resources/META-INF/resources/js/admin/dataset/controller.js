'use strict';

angular.module('DatasetApp')
    .controller('DatasetListCtrl', ['$scope', '$window', 'DatasetService',
        function($scope, $window, DatasetService) {
            $scope.loadingList = true;
            DatasetService.query(function(data) {
                $scope.datasets = data;
                $scope.loadingList = false;
            });
            
            $scope.selectDataset = function(datasetId) {
                $scope.selectedId = datasetId;
            };
            
            $scope.showForm = function() {
                $window.location.href = '/admin/datasets/form';
            }
        }
    ])
    .controller('DatasetDetailCtrl', ['$scope', '$window', '$stateParams', 'DatasetService', 'ElementService',
        function($scope, $window, $stateParams, DatasetService, ElementService) {
            $scope.loadingDetail = true;
            $scope.selectedId = $stateParams.datasetId;
            DatasetService.get({'datasetId' : $stateParams.datasetId}, function(dataset) {
                $scope.dataset = dataset;
                $scope.loadingDetail = false;
            });
            
            $scope.edit = function(datasetId) {
                $window.location.href = '/admin/datasets/form#/' + datasetId;
            };

            $scope.shownSubdataset = 0;

            $scope.elements = {};

            $scope.findElements = function(headId) {
                if ($scope.shownSubdataset !== 0) {
                    $('#sd' + $scope.shownSubdataset).collapse('hide');
                }
                if (!$scope.elements[headId]) {
                    ElementService.get({'headId': headId}, function(elements) {
                        $scope.elements[headId] = elements;
                        $scope.subdatasetElements = $scope.elements[headId];
                    });
                }
                else {
                    $scope.subdatasetElements = $scope.elements[headId];
                }
                $('#sd' + headId).collapse('show');
                $scope.shownSubdataset = headId;
            };
        }
    ]);