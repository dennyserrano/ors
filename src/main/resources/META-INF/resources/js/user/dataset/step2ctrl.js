'use strict';

angular.module('UserApp')
    .controller('Step2Ctrl', ['$scope', 'UserDatasetService',
        function($scope, UserDatasetService) {
            
            $scope.step1 = 'complete';
            $scope.step2 = 'active';
            $scope.step3 = 'disabled';
            $scope.step4 = 'disabled';
            
            $scope.allElementsSelected = {};

            $scope.selectedElements = {};
            UserDatasetService.get({}, function(dataset) {
                $scope.dataset = dataset;
                angular.forEach(dataset.subDatasets, function(subdataset) {
                    $scope.allElementsSelected[subdataset.id] = false;
                    $scope.selectedElements[subdataset.id] = [];
                    $scope.selectAllElements(subdataset);
                });
            });
            
            $scope.elementSelected = function(subdataset, element) {
                var selected = false;
                var selectedElements = $scope.selectedElements[subdataset.id];
                angular.forEach(selectedElements, function(selectedElement) {
                    if (element.id === selectedElement.id) {
                        selected = true;
                    }
                });
                $scope.allElementsSelected[subdataset.id] = $scope.selectedElements[subdataset.id].length == subdataset.elements.length;
                return selected;
            };

            $scope.selectAllElements = function(subdataset) {
                var result = !$scope.allElementsSelected[subdataset.id];
                if (!result) {
                    $scope.selectedElements[subdataset.id] = [];
                }
                else {
                    angular.forEach(subdataset.elements, function(element) {
                        if (!$scope.elementSelected(subdataset, element)) {
                            $scope.selectedElements[subdataset.id].push(element);
                        }
                    });
                }
                $scope.allElementsSelected[subdataset.id] = result;
            };
            
            $scope.save = function() {
                var dataset = $scope.dataset;
                dataset.elements = [];
                angular.forEach($scope.selectedElements, function(elements, datasetId, obj) {
                    angular.forEach(elements, function(selectedElement) {
                        dataset.elements.push(selectedElement);
                    });
                });
                UserDatasetService.save({}, dataset, function(response) {
                    if (response.code === 'SUCCESS') {
                        $state.go('step2');
                    }
                });
            };
        }
    ]
);