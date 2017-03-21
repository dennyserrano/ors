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
                headId: '@id'
            }, {
                get: {
                    method: 'GET',
                    isArray: true,
                    cache: $cacheFactory('elements')
                },
                query: {
                    method: 'GET',
                    isArray: false
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
    		
    		function correct(requestData)
    		{
    			var matches=[];
    			var reference=getReference();
    			
    			angular.forEach(reference,function(referenceValue){
					 	
					 
					 angular.forEach(requestData.elements,function(elementValue,elementKey){
		    				
						 if(elementValue.id===referenceValue.targetElementId)
							 matches.push({
								 			indexFound:elementKey,
								 		    substituteElementId:referenceValue.substituteElementId,
								 		    newDatasetId:referenceValue.addDatasetId
								 		   });	
		    				
		    			});
					 
				});
    			// if matches not = zero
    			
    			angular.forEach(matches,function(referenceInfo,key){
    				var elementList=ElementService.get({headId:referenceInfo.newDatasetId});
    				console.log(elementList);
    			});
    			
//    			fetchDataset(8);
    			
    		}
    		
    		function fetchDataset(id)
    		{
    			
		    	var promise=DatasetService.get({datasetId:8},function(ldataset){
						
				});
		    	
		    	console.log(promise);
		    	
    		}
    		
    		function fetchElement(list,id)
    		{
    			for(var x=0;x<list.length;x++)
    				if(id==list[x].id)
    					return list[x];
    		}
    		
    		function getReference()
    		{

    			
    			return [
	    			 {
	   				 targetElementId:9495,
					 addDatasetId:8,
					 substituteElementId:99
	    			 }	
    			 ];
    		}
    		
        }
    ])
;