'use strict';

angular.module('UserApp')
    .controller('Step2Ctrl', ['$scope', 'UserDatasetService',
        function($scope, UserDatasetService) {
            $scope.step1 = 'complete';
            $scope.step2 = 'active';
            $scope.step3 = 'disabled';
            $scope.step4 = 'disabled';

            $scope.elements = {};
            UserDatasetService.get({}, function(dataset) {
                $scope.dataset = dataset;
                angular.forEach(dataset.subDatasets, function(subdataset) {
                    $scope.elements[subdataset.id] = [];
                    angular.forEach(subdataset.elements, function(element) {
                        $scope.elements[subdataset.id].push(element);
                    });
                });
            });
            
            $scope.elementSelected = function(subdataset, element) {
                var selectedElements = $scope.elements[subdataset.id];
                angular.forEach(selectedElements, function(selectedElement) {
                    if (element.id === selectedElement.id) {
                        return true;
                    }
                });
                return false;
            };

            $scope.selectAllElements = function(subdataset) {
                $scope.elements[subdataset.id] = [];
                angular.forEach(subdataset.elements, function(element) {
                    if (!$scope.elementSelected(subdataset, element)) {
                        $scope.elements[subdataset.id].push(element);
                    }
                });
            };
        }
    ]
);