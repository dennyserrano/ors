'use strict';

angular.module('UserApp')
    .controller('Step2Ctrl', ['$scope', '$state', '$window', 'UserDatasetService',
        function($scope, $state, $window, UserDatasetService) {
            
            $scope.step1 = 'complete';
            $scope.step2 = 'active';
            $scope.step3 = 'disabled';
            $scope.step4 = 'disabled';
            
            $scope.loadingElements = 0;
            $window.ORS.ResizeElements();
            $window.ORS.FitToWidth($('#elements')[0]);
            $scope.allElementsSelected = {};

            $scope.selectedElements = {};
            UserDatasetService.get({}, function(dataset) {
                $scope.dataset = dataset;
                angular.forEach(dataset.subDatasets, function(subdataset) {
                    $scope.allElementsSelected[subdataset.id] = false;
                    $scope.selectedElements[subdataset.id] = [];
                    $scope.selectAllElements(subdataset);
                })
                $scope.loadingElements = 1;
            }, function(response) {
                $scope.loadingElements = 2;
                $scope.loadingElementsError = 'Failed to load Elements. [HTTP Status: ' + response.status + '].';
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
                $scope.saving = true;
                var dataset = $scope.dataset;
                dataset.elements = [];
                var elementsIteratorCallback = function(selectedElement) {
                    dataset.elements.push(selectedElement);
                };
                var selectedElementsIteratorCallback = function(elements, datasetId, obj) {
                    angular.forEach(elements, elementsIteratorCallback);
                };
                angular.forEach($scope.selectedElements, selectedElementsIteratorCallback);
                UserDatasetService.save({}, dataset, function(response) {
                    if (response.code === 'SUCCESS') {
                        $state.go('step3');
                    }
                });
            };
        }
    ]
);