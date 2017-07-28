'use strict';

angular.module('UserApp')
    .controller('Step2Ctrl', ['$scope', '$state', '$window', '$timeout', '$compile', 'UserDatasetService', 'ElementService','localStorageService','CorrectionalDatasetService',
        function($scope, $state, $window, $timeout, $compile, UserDatasetService, ElementService,localStorageService) {
            
            $scope.step1 = 'complete';
            $scope.step2 = 'active';
            $scope.step3 = 'disabled';
            $scope.step4 = 'disabled';
            $scope.aggregateList=['SUM','AVERAGE'];
            $scope.aggregateOptions={
	                                     
	                                    	 '0':{
		                                    	 name:null,
		                                    	 elements:null
	                                    	 	 },
	                                     
	                                     
	                                    	 'Region':
	                                    	 	 {
			                                    	 name:'Region',
			                                    	 elements:[{id:281}]
		                                     	 },
	                                     
	                                     
	                                    	 'Division':
	                                    	 	{
	                                    		 name:'Division',
		                                    	 elements:[{id:285}],
		                                    	 next:'Region'
	                                    	 	},
	                                    	 
	                                     
	                                     
	                                    	 'District':
	                                    	 	{
	                                    		 name:'District',
		                                    	 elements:[{id:286}],
		                                    	 next:'Division'
	                                    	 	},
	                                     
	                                     
	                                    	 'Province':
	                                    	 {
	                                    		 name:'Province',
		                                    	 elements:[{id:282}],
		                                    	 next:'District'
	                                    	 },
	                                    	 
	                                     
	                                     
	                                    	 'Municipality':
	                                    	 {
	                                    		 name:'Municipality',
		                                    	 elements:[{id:283}],
		                                    	 next:'Province'
	                                    	 },
	                                    	 
	                                     
	                                     
	                                    	 'Legislative':
	                                    	 {
	                                    		 name:'Legislative',
		                                    	 elements:[{id:284}],
		                                    	 next:'Municipality'
	                                    	 }
	                                    	 
	                                     
    								}	
            $scope.userSelection=[];
            $window.ORS.AdjustDatasetContents(0);
            
            $scope.checkAll=function(index,check,dataset){
            	
            	var userSelection=$scope.userSelection[index];
            	if(check)
    			angular.forEach(dataset.elements,function(element){
    				userSelection[element.id]=[];
    				userSelection[element.id].push(element);
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
                				us[element.id]=[];
                				us[element.id].push(element);
                			});
                			
                			
                		}else
                			angular.forEach(dataset.elements,function(element){
                				us[element.id]=[];
                				us[element.id].push(element);
                			});
                    	$scope.userSelection[index]=us;
                    });
                    
                    
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
            
            $scope.itemCheckBoxChange=function(parentIndex,elem,indexContainer){

//            	var userSelection=$scope.userSelection;
//            	angular.forEach($scope.userSelection,function(datasetContainer){
//            		console.log(datasetContainer.length);
//            	});
//            	delete $scope.userSelection[parentIndex][elem.id][0];
            }
            
            $scope.save = function() {
                $scope.saving = true;
                var dataset = $scope.dataset;
                dataset.elements = [];
                
                
                
                
                var userSelection = mapAggregateFunctions($scope.userSelection);
                var elementsSelection=[];
                
                angular.forEach($scope.userSelection,function(selection){
                	
                	for(var key in selection)
                    {
                    	var userSelect= selection[key]
                    	if(angular.isUndefined(userSelect))
                    		continue;
                    	
                    	if(angular.isUndefined(selection[key][0]))
                    		continue;
                    	
                    	userSelect=selection[key][0];
                    	var datasetLayer=elementsSelection[userSelect.datasetId];
                    	if(angular.isUndefined(datasetLayer))
                    	{
                    		datasetLayer={};
                    		datasetLayer[userSelect.id]=userSelect;
                    	}else
                		{
                    		datasetLayer[userSelect.id]=userSelect;
                		}
                    	
                    	elementsSelection[userSelect.datasetId]=datasetLayer;
                    	
                    }
                	
                	
                });
                
                if($scope.chosenAggregateOption.name!==null)
            	{
                	
					var aggregateBy=$scope.chosenAggregateOption;
					aggregateBy.elements=findAggregates($scope.chosenAggregateOption,$scope.aggregateOptions).reverse();
					delete aggregateBy.next;
					dataset.aggregateBy=aggregateBy;
            	}
                
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
            
            
            
            var findAggregates=function(chosenAggregate,aggregateOptions)
            {
            	var elements;
            	if(angular.isDefined(chosenAggregate.next))
            	{  
            		var nextAggregate=aggregateOptions[chosenAggregate.next];
            		elements=findAggregates(nextAggregate,aggregateOptions);
            		elements=chosenAggregate.elements.concat(elements);
            		
            	}
            	
            	if(angular.isUndefined(elements))
            		return chosenAggregate.elements;
            	else
            		return elements;
            }
            
            
            var mapAggregateFunctions=function(selections)
            {
            	
            	angular.forEach(selections,function(selection,selectionIndex){
            		angular.forEach(selection,function(elementArray,elementIndex){
            			
            			if(angular.isDefined(elementArray))
        				{
            				var element=elementArray[0];
            				var optionSelectedText=$("#select_aggregate_func"+element.id+" option:selected").text();
                			if(optionSelectedText=='')
                				selection[elementIndex][0].aggregate=undefined;
                			else
                				selection[elementIndex][0].aggregate=optionSelectedText;
        				}
            			
            		});
            	});
            	return selections;
            }
        }
    ]
);