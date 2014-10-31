'use strict';

angular.module('UserApp')
    .controller('Step4Ctrl', ['$scope', 'UserDatasetService', 'PreviewDataService',
        function($scope, UserDatasetService, PreviewDataService) {

            $scope.step1 = 'complete';
            $scope.step2 = 'complete';
            $scope.step3 = 'complete';
            $scope.step4 = 'active';
            
            $scope.loadingData = true;
            $scope.datas = [];
            
            var previewDataCallback = function(data) {
                $scope.headers = data[0];
                data.splice(0, 1); // removes the header
                $scope.datas = angular.copy(data);
                $scope.loadingData = false;
            };
            
            UserDatasetService.get({}, function(dataset) {
                $scope.dataset = dataset;
                $scope.datasetJson = angular.toJson(dataset);
                PreviewDataService(dataset, previewDataCallback);
            });
            
            $scope.export = function() {
                $('#exportForm').submit();
            };
        }
    ]
);