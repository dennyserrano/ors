
//temp code on step2
//Correction facility in service.js
// hardcoded on step 2
//bug? what if only type_name is chosen?
// hard code on datasetserviceimpl specifics report
// selected dataset disable next
'use strict';

angular.module('UserApp')
    .controller('Step1Ctrl', ['$scope', '$timeout', '$state', '$window', 'DatasetService', 'ElementService', 'UserDatasetService','localStorageService','SubdatasetService',
        function($scope, $timeout, $state, $window, DatasetService, ElementService, UserDatasetService,localStorageService,SubdatasetService) {

            $scope.selectedDatasets = []; // selected datasets
            
            $scope.step1 = 'active';
            $scope.step2 = 'disabled';
            $scope.step3 = 'disabled';
            $scope.step4 = 'disabled';
            

            DatasetService.query(function(datasets) {
                $scope.datasets = datasets;
                UserDatasetService.get({}, function(dataset) {
                    if (!dataset) {
                        $scope.dataset = {};
                        
                        $scope.dataset.elements = [];
                    }
                    else {
                        $scope.dataset = dataset;
                        $('#side-menu').metisMenu();

                    }
                });
       
            }, function(response) {
               
                $scope.loadingDatasetsError = 'Failed to load Datasets. [HTTP Status: ' + response.status + ']';
            });

            $scope.accordionClick=function(dataset,datasetId){
            	
            	
            	if(dataset.subDatasets.length==0)
            	SubdatasetService.query({datasetId:datasetId},function(datasets){
            		dataset.subDatasets=datasets;
            	});
            }
            
            $scope.loadElements = function(subdataset) {
                if (!subdataset.elements || subdataset.elements.length === 0) {
                    ElementService.get({ 'headId': subdataset.id }, function(elements) {
                        subdataset.elements = elements;
                    });
                }
            };
            
            $scope.save = function() {
                $scope.saving = true;
                var dataset = $scope.dataset;
                dataset.elements = dataset.elements || [];
                dataset.subDatasets = $scope.selectedDatasets;
                UserDatasetService.save({}, dataset, function(response) {
                    if (response.code === 'SUCCESS') {
                    	localStorageService.set('dataset',dataset);
                        $state.go('step2');
                    }
                });
            };
        }
    ]
);