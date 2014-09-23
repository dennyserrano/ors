'use strict';

angular.module('DatasetApp').config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('dataset', {
                url: '/',
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
            })
            .state('dataset.form', {
            	url: 'form/:datasetId',
            	onEnter: ['$modal', '$state', function($modal, $state) {
            		$modal.open({
            			templateUrl: '/static/dataset/form.html',
            			controller: 'DatasetFormCtrl',
            			size: 'lg'
            		})
            		.result.then(function(dataset) { // called when $modalInstance.close() is called
            			console.log(JSON.stringify(dataset));
            			$state.transitionTo('dataset');
            		}, function() { // called when $modalInstance.dismiss() is called
            			console.log('Dataset Form closed.');
            			$state.transitionTo('dataset');
            		});
            	}]
            });
    }
]);