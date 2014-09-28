'use strict';

angular.module('DatasetApp')
    .config(['$stateProvider', '$urlRouterProvider',
        function($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise('/');

            $stateProvider
                .state('form', {
                    url: '/:id',
                    views: {
                        'datasetForm@': {
                            templateUrl: '/static/dataset/form.html',
                            controller: 'DatasetFormCtrl'
                        }
                    }
                });
        }
    ]);