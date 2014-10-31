'use strict';

angular.module('UserApp')
    .controller('Step4Ctrl', ['$scope', 'UserDatasetService', 'PreviewDataService',
        function($scope, UserDatasetService, PreviewDataService) {

            $scope.step1 = 'complete';
            $scope.step2 = 'complete';
            $scope.step3 = 'complete';
            $scope.step4 = 'active';
            
            $scope.loadingData = 0;
            $scope.headers = [];
            $scope.datas = [];
            
            var previewDataCallback = function(data) {
                $scope.headers = data[0];
                data.splice(0, 1); // removes the header
                $scope.datas = angular.copy(data);
                $scope.loadingData = 1;
            };
            
            UserDatasetService.get({}, function(dataset) {
                $scope.dataset = dataset;
                $scope.datasetJson = angular.toJson(dataset);
                PreviewDataService(dataset, previewDataCallback);
            }, function(response) {
                $scope.loadingData = 2;
                $scope.loadingDataError = 'Failed to load Preview of Data. [HTTP Status: ' + response.status + '].';
            });

            $scope.keys = function(obj) {
                obj = angular.copy(obj);
                var returnedKeys =  obj ? Object.keys(obj) : [];
                return returnedKeys;
            };
        }
    ]
);