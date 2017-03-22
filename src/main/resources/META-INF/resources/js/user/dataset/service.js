'use strict';

angular.module('UserApp')
    .factory('DatasetService', ['$resource', '$cacheFactory',
        function($resource, $cacheFactory) {
            return $resource('/dataset/:datasetId', {
                    datasetId : '@id'
                }, {
                    get: {
                        method: 'GET',
                        cache: $cacheFactory('datasets')
                    },
                    list:{
                    	method: 'GET',
                    	url:'/dataset/list/:ids',
                    	isArray:true
                    }
                });
        }
    ])
    .factory('SubdatasetService', ['$resource', '$cacheFactory',
        function($resource, $cacheFactory) {
            return $resource('/dataset/:datasetId/sub', {
                datasetId: '@id',
                ids:'@ids'
            }, {
                get: {
                    method: 'GET',
                    cache: $cacheFactory('subdatasets')
                }
            })
        }
    ])
    .factory('ElementService', ['$resource', '$cacheFactory',
        function($resource, $cacheFactory) {
            return $resource('/elements/:headId', {
                headId: '@id',
                ids:'@ids'
            }, {
                get: {
                    method: 'GET',
                    isArray: true,
                    cache: $cacheFactory('elements')
                },
                query: {
                    method: 'GET',
                    isArray: false
                },
                listElementByDatasetId:{
                	method:'GET',
                	isArray:true,
                	url:'/elements/list/:headId/:ids'
                	
                }
            })
        }
    ])
    .factory('CriteriaService', ['$resource', '$cacheFactory',
        function($resource, $cacheFactory) {
            return $resource('/criteria/:headId', {
                headId: '@id'
            }, {
                get: {
                    method: 'GET',
                    isArray: true,
                    cache: $cacheFactory('criteria')
                }
            })
        }
    ])
    .factory('SchoolNameCriteriaService', ['$resource',
        function($resource) {
            return $resource('/criteria/school', {}, {
                'searchSchool': {
                    method: 'POST',
                    isArray: true
                }
            });
        }
    ])
    .factory('OwnerService', ['$resource', '$cacheFactory',
        function($resource, $cacheFactory) {
            return $resource('/dataset/owner/:ownerId', {
                ownerId: '@ownerId'
            }, {
                get: {
                    method: 'GET',
                    isArray: true,
                    cache: $cacheFactory('ownerDatasets')
                }
            });
        }
    ])
    .factory('PreviewDataService', ['$resource',
        function($resource) {
            return $resource('/preview', {}, {
                'preview': {
                    method: 'POST',
                    isArray: true
                }
            })
        }
    ])
    .factory('UserDatasetService', ['$resource',
        function($resource) {
            return $resource('/user/dataset');
        }
    ])
    .factory('CorrectionalDatasetService',['DatasetService','ElementService',
        function(DatasetService,ElementService)
        {
    		return {
    			correct:correct
    		}
    		
    		function correct(requestData,callback)
    		{
    			
    			var reference=getReference();
    			var matches=getMatches(requestData.elements,reference);
    			
    			var newDatasetIds=toArray(matches,'newDatasetId');
    			var newElementIds=toArray(matches,'substituteElementId');
    			
    			if(newElementIds.length==0)
    			{
    				callback(requestData);
    				return;
    			}
    			DatasetService.list({ids:newDatasetIds},function(datasets){
    				var newDatasets=[];
    				var newElements={}; //for easy access this forms a map instead of an array since we have to replace every elements 
    				for(var x=0;x<datasets.length;x++)
					{
    					var dataset=datasets[x];
    					newDatasets.push(dataset);
    					
    					var sourceElements=dataset.elements;
    					
    					for(var y=0;y<newElementIds.length;y++) //loop by substituted element ids
						{
    						var searchingNewElementId=newElementIds[y];
    						for(var z=0;z<sourceElements.length;z++) //loop by fetched elements in every dataset
							{
    							var sourceElement=sourceElements[z];
    							if(sourceElement.id==searchingNewElementId)
								{
    								newElements[sourceElement.id]=sourceElement;
    								break;
								}
							}
						}
					}
    				
    				angular.forEach(newDatasets,function(e,i){
    					requestData.subDatasets.push(e);
    				});
    				
    				angular.forEach(matches,function(e,i){
    					var elementIndex=e.indexFound;
    					requestData.elements[elementIndex]=newElements[e.substituteElementId];
    					
    				});
    				
    				if(callback)
    				callback(requestData);
    			});
    			
    			
    			
    			
    		}
    		
    		function toArray(list,k)
    		{
    			var ret=[];
    			
    			for(var x=0;x<list.length;x++)
    			{
    				var ll=k;
    				var e=list[x];
    				ret.push(e[k]);
    			}
    		
    			
    			return ret;
    		}
    		
    		function getMatches(elements,reference)
    		{
    			var matches=[];
    			angular.forEach(reference,function(referenceValue){
				 	
					 
					 angular.forEach(elements,function(elementValue,elementKey){
		    				
						 if(elementValue.id===referenceValue.targetElementId)
							 matches.push({
								 			indexFound:elementKey,
								 		    substituteElementId:referenceValue.substituteElementId,
								 		    newDatasetId:referenceValue.addDatasetId
								 		   });	
		    				
		    			});
    			});
    			
				return matches;
    		}
    		
    		function getReference()
    		{

    			
    			return [
	    			 {
	   				 targetElementId:11029,
					 addDatasetId:9015,
					 substituteElementId:11030
	    			 }	
    			 ];
    		}
    		
        }
    ])
;