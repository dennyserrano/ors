angular.module('DatasetApp')
    .controller('DatasetListCtrl', ['$scope', 'DatasetService',
        function($scope, DatasetService) {
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

            $scope.save = function() {
                DatasetService.post(this.dataset, function(data) {

                });
            };
        }
    ]);