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
        }
    ])
    .controller('DatasetDetailCtrl', ['$scope', '$stateParams', 'DatasetService',
        function($scope, $stateParams, DatasetService) {
            $scope.loadingDetail = true;
            $scope.selectedId = $stateParams.datasetId;
            DatasetService.get({'datasetId' : $stateParams.datasetId}, function(dataset) {
                $scope.dataset = dataset;
                $scope.loadingDetail = false;
            });
        }
    ])
    .controller('DatasetFormCtrl', ['$scope', '$state', '$stateParams', '$modalInstance', 'DatasetService', 
        function($scope, $state, $stateParams, $modalInstance, DatasetService) {
    	
    		$scope.dismiss = function() {
    			$modalInstance.dismiss();
    		};
    		
    		$scope.save = function(isValid) {
    	    	$modalInstance.close($scope.dataset);
    	    };
    		
    	    if ($stateParams.datasetId) {
    	    	DatasetService.get({'datasetId': $stateParams.datasetId}, function(dataset) {
    	    		$scope.dataset = dataset;
    	    	});
    	    }
    	}
    ]);