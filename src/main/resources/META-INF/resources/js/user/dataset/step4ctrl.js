'use strict';

angular.module('UserApp')
    .controller('Step4Ctrl', ['$scope', 'UserDatasetService',
        function($scope, UserDatasetService) {

            $scope.step1 = 'complete';
            $scope.step2 = 'complete';
            $scope.step3 = 'complete';
            $scope.step4 = 'active';
            
        }
    ]
);