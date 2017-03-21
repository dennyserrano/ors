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
    .factory('CorrectionalDatasetService',['DatasetService',
        function(DatasetService)
        {
    		return {
    			correct:correct
    		}
    		
    		function correct(requestData)
    		{
//    			var subDataset=[];
//    			var elements=[];
//    			var reference=getReference();
//    			angular.forEach(requestData.subDataset,function(subDatasetValue){
//    				
//    				angular.forEach(reference,function(referenceValue){
//    					 if(subDatasetValue.id===referenceValue.targetElementId)
//						 {
//    						 var addDatasetId=referenceValue.addDatasetId;
//    						 var addedDataset=fetchDataset(addDatasetId);
//    						 elements.push(addedDataset);
//						 }
//    					 else
//    						 elements.push(subDatasetValue);
//    				});
//    				
//    			});
    	
//    			fetchDataset(8);
    			
    		}
    		
    		function fetchDataset(id)
    		{
    			
		    	var promise=DatasetService.get({datasetId:8},function(ldataset){
						
				});
		    	
		    	console.log(promise);
		    	
    		}
    		
    		function fetchElement(id)
    		{
    			
    		}
    		
    		function getReference()
    		{
    			return
    			[
					 
	    			 {
	    				 targetElementId:888,
	    				 addDatasetId:8,
	    				 substituteElementId:99
	    			 }		
					 
    			 ]
    		}
    		
        }
    ])
;