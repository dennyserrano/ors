'use strict';

angular.module('UserApp')
    .controller('Step2Ctrl', ['$scope', 'UserDatasetService',
        function($scope, UserDatasetService) {
            $scope.step1 = 'complete';
            $scope.step2 = 'active';
            $scope.step3 = 'disabled';
            $scope.step4 = 'disabled';
            
            UserDatasetService.get({}, function(dataset) {
                $scope.dataset = dataset;
                var elements = {};
                angular.forEach(dataset.subDatasets, function(subdataset) {
                    elements[subdataset.id] = subdataset;
                });
                $scope.elements = elements;
            });
        }
    ]
);