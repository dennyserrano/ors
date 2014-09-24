'use strict';

angular.module('DatasetApp')
    .controller('DatasetListCtrl', ['$scope', '$state', 'DatasetService',
        function($scope, $state, DatasetService) {
            $scope.loadingList = true;
            DatasetService.query(function(data) {
                $scope.datasets = data;
                $scope.loadingList = false;
            });
            
            $scope.selectDataset = function(datasetId) {
                $scope.selectedId = datasetId;
            };
            
            $scope.showForm = function() {
            	$state.go('dataset.form');
            }
        }
    ])
    .controller('DatasetDetailCtrl', ['$scope', '$state', '$stateParams', 'DatasetService',
        function($scope, $state, $stateParams, DatasetService) {
            $scope.loadingDetail = true;
            $scope.selectedId = $stateParams.datasetId;
            DatasetService.get({'datasetId' : $stateParams.datasetId}, function(dataset) {
                $scope.dataset = dataset;
                $scope.loadingDetail = false;
            });
            
            $scope.edit = function(datasetId) {
            	$state.go('dataset.form', {'id': datasetId});
            };
        }
    ])
    .controller('DatasetFormCtrl', ['$scope', '$state', '$stateParams', '$modalInstance', 'DatasetService',
        function($scope, $state, $stateParams, $modalInstance, DatasetService) {
    	
    	    $scope.loading = false;
    	
    		$scope.dismiss = function() {
    			$modalInstance.dismiss('Cancel');
    		};
    		
    		$scope.save = function(isValid) {
    	    	$modalInstance.close(dataset);
    	    };
    		
    	    if ($stateParams.id) {
    	    	$scope.loading = true;
    	    	DatasetService.get({datasetId: $stateParams.id}, function(dataset) {
    	    		console.log(JSON.stringify(dataset));
    	    		$scope.id = dataset.id;
    	    		$scope.name = dataset.name;
    	    		$scope.description = dataset.description;
    	    		$scope.loading = false;
    	    	});
    	    }
    	}
    ]);