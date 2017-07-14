'use strict';

angular.module('UserApp')
    .controller('Step2Ctrl', ['$scope', '$state', '$window', '$timeout', '$compile', 'UserDatasetService', 'ElementService','localStorageService','CorrectionalDatasetService',
        function($scope, $state, $window, $timeout, $compile, UserDatasetService, ElementService,localStorageService) {
            
            $scope.step1 = 'complete';
            $scope.step2 = 'active';
            $scope.step3 = 'disabled';
            $scope.step4 = 'disabled';
            
            $scope.aggregateList=['SUM','AVG'];
            $scope.aggregateOptions=['','Region','Division'];
            $scope.userSelection=[];
            $window.ORS.AdjustDatasetContents(0);
            
            $scope.checkAll=function(index,check,dataset){
            	
            	var userSelection=$scope.userSelection[index];
            	if(check)
    			angular.forEach(dataset.elements,function(element){
    				userSelection.push({'datasetId':dataset.id,'element':element});
    			});
            	else
            		userSelection=[];
            			
            	$scope.userSelection[index]=userSelection;
            		
            	
            }
            
            UserDatasetService.get({}, function(dataset) {
            	
            	
            	dataset=localStorageService.get('dataset');
            	
            	if(dataset==null)
        		{
        			$state.go("step1");
        		}
            	
                $scope.dataset = dataset;
       
                
                ElementService.query({}, function(table) { // table: ElementsTable
                    $scope.elementsTable = table;
                    $scope.loadingElements = 1;
                    
//                    $scope.userSelection[0]=table.datasets[0].elements;
                    
                    angular.forEach(table.datasets,function(dataset,index){
                    	var us=$scope.userSelection[index];
                    	if(angular.isUndefined(us))
                		{
                			us=[];
                			
                			angular.forEach(dataset.elements,function(element){
                				us.push({'datasetId':dataset.id,'element':element});
                			});
                			
                			
                		}else
                			angular.forEach(dataset.elements,function(element){
                				us.push({'datasetId':dataset.id,'element':element});
                			});
                    	$scope.userSelection[index]=us;
                    });
                    
                    console.log($scope.userSelection);
                }, function(response) {
                    $scope.loadingElements = 2;
                    $scope.loadingElementsError = 'Failed to load Elements. [HTTP Status: ' + response.status + '].';
                });
            }, function(response) {
                $scope.loadingElements = 2;
                $scope.loadingElementsError = 'Failed to load Elements. [HTTP Status: ' + response.status + '].';
            });
            
  
            
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
                
                var userSelection = $scope.userSelection;
                var elementsSelection=[];
                
                angular.forEach(userSelection,function(selection){
                	angular.forEach(selection,function(s){
                		var es=elementsSelection[s.datasetId];
                		if(angular.isUndefined(es))
            			{
                			es={};
                			es[s.element.id]=s.element;
            			}else
            				es[s.element.id]=s.element;
                		elementsSelection[s.datasetId]=es;
                	});
	                	
                });
               
                angular.forEach(dataset.subDatasets, function(subdataset) {
                    angular.forEach(subdataset.elements, function(element) {
                        if (elementsSelection[subdataset.id][element.id]) {
                            dataset.elements.push(elementsSelection[subdataset.id][element.id]);
                        }
                    });
                });
                
            	saveDataset(dataset, function() {
            		
                	localStorageService.set('dataset',dataset);
                     $state.go('step3');
                });
                
                
            };
        }
    ]
);