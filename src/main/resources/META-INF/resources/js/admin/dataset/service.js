'use strict';

angular.module('DatasetApp').factory('DatasetService', ['$resource', '$cacheFactory',
    function($resource, $cacheFactory) {
	    return $resource('/dataset/:datasetId', {
				datasetId : '@id'
			}, {
				get: {
					method: 'GET',
					cache : $cacheFactory('datasets')
				}
			});
    }
]);