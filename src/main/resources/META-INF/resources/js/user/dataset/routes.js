'use strict';

angular.module('UserApp').config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/1');
        
        $stateProvider
            .state('step1', {
                url: '/1',
                templateUrl: '/static/dataset/user/step1.html'
            })
            .state('step2', {
                url: '/2',
                templateUrl: '/static/dataset/user/step2.html'
            })
            .state('step3', {
                url: '/3',
                templateUrl: '/static/dataset/user/step3.html'
            })
            .state('step4', {
                url: '/4',
                templateUrl: '/static/dataset/user/step4.html'
            });
    }
]);