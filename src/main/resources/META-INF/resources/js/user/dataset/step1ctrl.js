'use strict';

angular.module('UserApp')
    .controller('Step1Ctrl', ['$scope', '$timeout', 'DatasetService', 'ElementService',
        function($scope, $timeout, DatasetService, ElementService) {
            
            $scope.subdatasets = [];
            $scope.datasets = [];
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
        }
    ]
);