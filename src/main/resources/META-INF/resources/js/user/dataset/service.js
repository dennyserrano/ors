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
                    }
                });
        }
    ])
    .factory('SubdatasetService', ['$resource', '$cacheFactory',
        function($resource, $cacheFactory) {
            return $resource('/dataset/:datasetId/sub', {
                datasetId: '@id'
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
    ]);