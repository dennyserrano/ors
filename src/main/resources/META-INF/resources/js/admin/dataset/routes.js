'use strict';

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
            })
            .state('dataset.form', {
            	url: 'form/:id',
            	onEnter: ['$modal', '$state', '$stateParams', 'DatasetService', function($modal, $state, $stateParams, DatasetService) {
            		$modal.open({
            			templateUrl: '/static/dataset/form.html',
            			controller: 'DatasetFormCtrl'
            		})
            		.result.then(function(dataset) { // called when $modalInstance.close() is called
            			// TODO Save/Update Dataset here.
            			console.log(JSON.stringify(dataset));
            			$state.go('dataset');
            		}, function(reason) { // called when $modalInstance.dismiss() is called
            			console.log('Dataset Form closed [' + reason + '].');
            			$state.go('dataset');
            		});
            	}]
            });
    }
]);