'use strict';

angular.module('DatasetApp').factory('DatasetService', ['$resource',
    function($resource) {
        return $resource('/dataset/:datasetId', {datasetId: '@id'});
    }
]);