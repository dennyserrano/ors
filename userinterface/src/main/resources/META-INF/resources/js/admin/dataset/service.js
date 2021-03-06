'use strict';

angular.module('DatasetApp')
    .factory('DatasetService', ['$resource', '$cacheFactory',
        function($resource, $cacheFactory) {
            return $resource('/dataset/:datasetId', {
                    datasetId : '@id'
                }, {
                    get: {
                        method: 'GET',
                        cache: $cacheFactory('datasets')
                    }
                });
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
                }
            })
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
    ]);