angular.module('DatasetApp').config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('dataset', {
                url: '',
                views: {
                    'datasetList@': {
                        templateUrl: '/static/dataset/list.html'
                    }
                }
            })
            .state('dataset.id', {
                url: ':datasetId',
                views: {
                    'datasetDetail@': {
                        templateUrl: '/static/dataset/detail.html',
                        controller: 'DatasetDetailCtrl'
                    }
                }
            });
    }
]);