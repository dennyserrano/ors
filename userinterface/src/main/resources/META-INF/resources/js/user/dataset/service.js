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
                headId: '@id',
                regionId:'@regionId',
                divisionId:'@divisionId'
            }, {
                get: {
                    method: 'GET',
                    isArray: true,
                    cache: $cacheFactory('criteria')
                },
                listDistricts:{
                	method:'GET',
                	isArray:true,
                	url:'/criteria/districts',
                	params:{regionId:1,divisionId:1}
                },
                listProvinces:{
                	method:'GET',
                	isArray:true,
                	url:'/criteria/provinces',
                	params:{regionId:1}
                },
                listLegislatives:{
                	method:'GET',
                	isArray:true,
                	url:'/criteria/legislatives',
                	params:{regionId:1,provinceId:1}
                },
                listMunicipalities:{
                	method:'GET',
                	isArray:true,
                	url:'/criteria/municipalities',
                	params:{regionId:1,provinceId:1}
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
                    method: 'POST'
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
    			
    			var newDatasetIds=toArray(matches,'newDatasetIds');
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
    				var e=list[x];
    				if(!Array.isArray(e[k]))
    					ret.push(e[k]);
    				else
    					for(var y=0;y<e[k].length;y++)
    						ret.push(e[k][y]);
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
								 		    newDatasetIds:referenceValue.addDatasetIds
								 		   });	
		    				
		    			});
    			});
    			
				return matches;
    		}
    		
    		function getReference()
    		{

    			//targetElementId: tells the UI that whenever the said element is chosen the correction would occur
    			//substituteElementId : the element to be substituted in targetElementId
    			//addDatasetId: whenever the targetElementId is present, this datasetId is added as if the user chose this dataset
    			return [
//	    			 {
//		   				 targetElementId:11032,
//						 addDatasetIds:[9017],
//						 substituteElementId:11089
//	    			 },
//	    			 {
//		   				 targetElementId:11034,
//						 addDatasetIds:[9019],
//						 substituteElementId:11093
//	    			 },
//	    			 {
//		   				 targetElementId:11036,
//						 addDatasetIds:[9018],
//						 substituteElementId:11091
//	    			 },

//	    			 {
//		   				 targetElementId:11039,
//						 addDatasetIds:[9021],
//						 substituteElementId:11097
//	    			 },
//	    			 {
//		   				 targetElementId:11041,
//						 addDatasetIds:[9023],
//						 substituteElementId:11101
//	    			 }
    			 ];
    		}
    		
        }
    ])
;