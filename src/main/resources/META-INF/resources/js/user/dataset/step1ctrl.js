'use strict';

angular.module('UserApp')
    .controller('Step1Ctrl', ['$scope', '$timeout', '$state', 'DatasetService', 'ElementService', 'UserDatasetService',
        function($scope, $timeout, $state, DatasetService, ElementService, UserDatasetService) {

            UserDatasetService.get({}, function(dataset) {
                $scope.dataset = dataset;
            });
            
            $scope.subDatasets = []; // selected datasets
            $scope.datasets = []; // the dataset menu
            $scope.step1 = 'active';
            $scope.step2 = 'disabled';
            $scope.step3 = 'disabled';
            $scope.step4 = 'disabled';
            
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
            });
            
            $scope.loadElements = function(subdataset) {
                if (!subdataset.elements || subdataset.elements.length == 0) {
                    ElementService.get({ 'headId': subdataset.id }, function(elements) {
                        subdataset.elements = elements;
                    });
                }
            };
            
            $scope.save = function(dataset) {
                dataset.subDatasets = $scope.subDatasets;
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