'use strict';

angular.module('UserApp')
    .controller('Step2Ctrl', ['$scope', '$state', '$window', '$timeout', '$compile', 'UserDatasetService', 'ElementService',
        function($scope, $state, $window, $timeout, $compile, UserDatasetService, ElementService) {
            
            $scope.step1 = 'complete';
            $scope.step2 = 'active';
            $scope.step3 = 'disabled';
            $scope.step4 = 'disabled';
            
            $scope.loadingElements = 0;
            $scope.allElementsSelected = {};
            
            $scope.$watch('loadingElements', function(newVal, oldVal) {
                if (oldVal === 0 && newVal === 1) {
                    $timeout(function() {
                        var elementsTable = $('#elementsTable');
                        var trackerRow = $('#trackerRow');
                        elementsTable.stickyTableHeaders({
                            fixedOffset: trackerRow.outerHeight() + 54
                        });
                        $('#nextBtn').on('click', function(e){
                            elementsTable.stickyTableHeaders('destroy');
                        });
                        $window.ORS.FitToWidth($('#elements'));
                        $window.ORS.AdjustDatasetContents(0);
                        $window.scrollTo(0, 0);
                    }, 50);
                }
            });

            $scope.selectedElements = {};
            UserDatasetService.get({}, function(dataset) {
                $scope.dataset = dataset;
                angular.forEach(dataset.subDatasets, function(subdataset) {
                    $scope.allElementsSelected[subdataset.id] = false;
                    $scope.selectedElements[subdataset.id] = [];
                    $scope.selectAllElements(subdataset);
                });
                ElementService.query({}, function(table) { // table: ElementsTable
                    $scope.elementsTable = table;
                    $scope.loadingElements = 1;
                }, function(response) {
                    $scope.loadingElements = 2;
                    $scope.loadingElementsError = 'Failed to load Elements. [HTTP Status: ' + response.status + '].';
                });
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