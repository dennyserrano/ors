'use strict';

angular.module('UserApp')
    .controller('Step4Ctrl', ['$scope', '$window', '$timeout', 'UserDatasetService', 'PreviewDataService',
        function($scope, $window, $timeout, UserDatasetService, PreviewDataService) {

            $scope.step1 = 'complete';
            $scope.step2 = 'complete';
            $scope.step3 = 'complete';
            $scope.step4 = 'active';
            
            $scope.loadingData = 0;
            $scope.headers = [];
            $scope.datas = [];

            $window.ORS.AdjustDatasetContents(0);

            $scope.$watch('loadingData', function(newVal, oldVal) {
                if (oldVal === 0 && newVal === 1) {
                    $timeout(function() {
                        $window.ORS.FitToWidth($('#previewContainer'));
                        $window.scrollTo(0, 0);
                    }, 50);
                }
            });
            
            $scope.$on('render-done', function(event) {
                $timeout($window.ORS.AdjustTable, 50);
            });
            
            var previewDataCallback = function(data) {
                $scope.headers = data[0];
                data.splice(0, 1); // removes the header
                $scope.datas = angular.copy(data);
                $scope.loadingData = 1;
            };
            
            UserDatasetService.get({}, function(dataset) {
                $scope.dataset = dataset;
                $scope.datasetJson = angular.toJson(dataset);
                PreviewDataService.preview(dataset, previewDataCallback);
            }, function(response) {
                $scope.loadingData = 2;
                $scope.loadingDataError = 'Failed to load Preview of Data. [HTTP Status: ' + response.status + '].';
            });

            $scope.keys = function(obj) {
                return obj ? Object.keys(obj) : [];
            };
        }
    ]
);