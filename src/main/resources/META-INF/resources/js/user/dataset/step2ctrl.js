'use strict';

angular.module('UserApp')
    .controller('Step2Ctrl', ['$scope', '$state', '$window', '$timeout', '$compile', 'UserDatasetService', 'ElementService','localStorageService','CorrectionalDatasetService',
        function($scope, $state, $window, $timeout, $compile, UserDatasetService, ElementService,localStorageService) {
            
            $scope.step1 = 'complete';
            $scope.step2 = 'active';
            $scope.step3 = 'disabled';
            $scope.step4 = 'disabled';
            
            $scope.loadingElements = 0;
            // Top checkbox per dataset for select all elements per dataset functionality
            $scope.allElementsSelected = {};
            // Index of Elements selection (elementsSelection[subdataset.id][element.id])
            $scope.elementsSelection = {};

            $window.ORS.AdjustDatasetContents(0);
            
            $scope.$watch('loadingElements', function(newVal, oldVal) {
                if (oldVal === 0 && newVal === 1) {
                    $timeout($window.ORS.AdjustElementTableHeaders, 50);
                    $window.scrollTo(0, 0);
                }
            });
            
            var initializeElementIndex = function(subdataset) {
                var elementsSelection = {};
                angular.forEach(subdataset.elements, function(subdatasetElement) {
                    elementsSelection[subdatasetElement.id] = false;
                });
                $scope.elementsSelection[subdataset.id] = elementsSelection;
            };
            
            var checkSelectedElements = function(dataset) {
                angular.forEach(dataset.elements, function(selectedElement) {
                    if ($scope.allElementsSelected[selectedElement.datasetId]) {
                        $scope.allElementsSelected[selectedElement.datasetId] = true;
                        $scope.toggleAllElementsSelection(selectedElement.datasetId);
                    }
                    $scope.elementsSelection[selectedElement.datasetId][selectedElement.id] = true;
                });
            };
            
            UserDatasetService.get({}, function(dataset) {
            	
            	
            	dataset=localStorageService.get('dataset');
            	
            	if(dataset==null)
        		{
        			$state.go("step1");
        		}
            	
                $scope.dataset = dataset;
                angular.forEach(dataset.subDatasets, function(subdataset) {
                    $scope.allElementsSelected[subdataset.id] = false;
                    initializeElementIndex(subdataset);
                });
                if (!dataset.elements || dataset.elements.length === 0) {
                    angular.forEach(dataset.subDatasets, function(subdataset) {
                        $scope.toggleAllElementsSelection(subdataset.id);
                    });
                }
//                else {
//                    checkSelectedElements(dataset);
//                }
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
            
            $scope.toggleAllElementsSelection = function(datasetId) {
                $scope.allElementsSelected[datasetId] = !$scope.allElementsSelected[datasetId];
                angular.forEach($scope.elementsSelection[datasetId], function(value, elementId, obj) {
                    $scope.elementsSelection[datasetId][elementId] = $scope.allElementsSelected[datasetId];
                });
            };
            
            var saveDataset = function(dataset, saveCallback) {
                UserDatasetService.save({}, dataset, function(response) {
                    saveCallback();
                });
            };
            
            $scope.previous = function() {
                if ($scope.dataset) {
                    saveDataset($scope.dataset, function() {
                        $state.go('step1');
                    });
                }
                else {
                    $state.go('step1');
                }
            };
            
            $scope.save = function() {
                $scope.saving = true;
                var dataset = $scope.dataset;
                dataset.elements = [];
                
                var elementsSelection = $scope.elementsSelection;
                angular.forEach(dataset.subDatasets, function(subdataset) {
                    angular.forEach(subdataset.elements, function(element) {
                        if (elementsSelection[subdataset.id][element.id]) {
                            dataset.elements.push(element);
                        }
                    });
                });
                
            	saveDataset(dataset, function() {
//            		//temporary
//            		if(dataset.name==='Specifics Report')
//        			{
//            			var temp=[]
//                		angular.forEach(dataset.elements,function(e,i){
//                			if(e.visible)
//                				temp.push(e);
//                		});
//                		
//                		dataset.elements=temp;
//        			}
//            		
//            		//temporary
            		
                	localStorageService.set('dataset',dataset);
                     $state.go('step3');
                });
                
                
            };
        }
    ]
);