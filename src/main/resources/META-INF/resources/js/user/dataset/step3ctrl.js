'use strict';

angular.module('UserApp')
    .controller('Step3Ctrl', ['$scope', 'UserDatasetService', 'CriteriaService',
        function($scope, UserDatasetService, CriteriaService) {
            
            var schoolProfileDatasetId = 8; // check from the database.

            $scope.step1 = 'complete';
            $scope.step2 = 'complete';
            $scope.step3 = 'active';
            $scope.step4 = 'disabled';

            UserDatasetService.get({}, function(dataset) {
                $scope.dataset = dataset;
            });

            var availableCriteria = $scope.availableCriteria || [];
            var hasSchoolProfileSelected = false;
            angular.forEach($scope.dataset.subDatasets, function(selectedDataset) {
                if (selectedDataset.id === schoolProfileDatasetId) {
                    hasSchoolProfileSelected = true;
                }
            });
            angular.forEach($scope.dataset.subDatasets, function(selectedDataset) {
                CriteriaService.get({ 'headId': selectedDataset.id }, function(criteria) {
                    angular.forEach(criteria, function(criterion) {
                        angular.forEach(availableCriteria, function(availableCriterion, idx) {
                            if (criterion.filterId === availableCriterion.filterId) {
                                availableCriterion.splice(idx, 1);
                            }
                        });
                        availableCriteria.push(criterion);
                    });
                    $scope.availableCriteria = availableCriteria;
                });
            });
        }
    ]
);