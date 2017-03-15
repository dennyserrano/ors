'use strict';

angular.module('UserApp')
    .controller('Step3Ctrl', ['$scope', '$state', '$window', '$timeout', 'UserDatasetService', 'CriteriaService', 'SchoolNameCriteriaService','localStorageService',
        function($scope, $state, $window, $timeout, UserDatasetService, CriteriaService, SchoolNameCriteriaService,localStorageService) {
            
            $scope.step1 = 'complete';
            $scope.step2 = 'complete';
            $scope.step3 = 'active';
            $scope.step4 = 'disabled';

            $scope.selectedValues = {};
            $scope.filters = [];
            $scope.loadingFilters = 0;

            $window.ORS.AdjustDatasetContents(0);
            
            $scope.$watch('loadingFilters', function(newVal, oldVal) {
                if (oldVal === 0 && newVal === 1) {
                    $window.scrollTo(0, 0);
                }
            });
            
            var schoolProfileDatasetId = 8; // value came from the database (sisdbtest.dataset_head).
            var regionFilterId = 8; // number 8 is from sisdbtest.dataset_criteria.id where filter_name = 'sp_region'
            var divisionFilterId = 9; // number 9 is from sisdbtest.dataset_criteria.id where filter_name = 'sp_division'
            var schoolNameFilterId = 16; // number 16 from sisdbtest.dataset_criteria.id where filter_name = 'sp_schoolName'
            var generalCurOfferingFilterId=12;
            var sectorSubChecklistFilterId=17;
            var gcoSubChecklistFilterId=18;
            var sectorFilterId=11;
            var availableCriteria = [];
            var hasSchoolProfileSelected = false;
            var divisionCriterion;
            
            var sectorCriterion;
            var sectorSubChecklistCriterion;
            var gcoSubChecklistCriterion;
            var curricularOfferCriterion;
            
            var criteriaIteratorCallback = function(c) {
                availableCriteria.push(c);
                if (c && c.selection) {
                    var selectedOptions = c.selection[0];
                    
                    if(angular.isUndefined(selectedOptions)) //my changes
                    {
                    	selectedOptions=[];
                    }
                    // find user selected option object
                    if ($scope.filters && $scope.filters.length > 0) {
                        angular.forEach($scope.filters, function(filter) {
                            if (filter.criterion === c.filterId) {
                                selectedOptions = filter.selectedOptions;
                            }
                        });
                    }
                    
                    $scope.selectedValues[c.filterId] = $.isArray(selectedOptions) ? selectedOptions : [selectedOptions];
                }
                $scope.setFilter(c);
            };
            
            
            var curricularOfferingFilter = function(criterion) {
                if (criterion.filterId === generalCurOfferingFilterId) {
                	curricularOfferCriterion = criterion;
                }
            };
            
            var divisionCriteriaFilter = function(criterion) {
                if (criterion.filterId === divisionFilterId) {
                    divisionCriterion = criterion;
                }
            };

            var sectorSubChecklistFilter = function(criterion) {
                if (criterion.filterId === sectorSubChecklistFilterId) {
                	sectorSubChecklistCriterion = criterion;
                }
            };
            
            var gcoSubChecklistFilter = function(criterion) {
                if (criterion.filterId === gcoSubChecklistFilterId) {
                	gcoSubChecklistCriterion = criterion;
                }
            };
            
            var sectorFilter = function(criterion) {
                if (criterion.filterId === sectorFilterId) {
                	sectorCriterion = criterion;
                }
            };
            
            var criteriaServiceCallback = function(criteria) {
            	angular.forEach(criteria,function(e,i){
            		availableCriteria.push(e);
            	});
            	
            	$scope.availableCriteria = availableCriteria;

            };

            var selectedDatsetsCallback = function(selectedDataset) {
                CriteriaService.get({ 'headId': selectedDataset.id }, criteriaServiceCallback);
            };

            $scope.$on('render-done', function(event) {
                $scope.loadingFilters = 1;
            });
            
            UserDatasetService.get({}, function(dataset) {
            	
            	
            	dataset=localStorageService.get('dataset');
            	
            	if(dataset==null)
        		{
        			$state.go("step1");
        		}
            	
                $scope.dataset = dataset || {};
                $scope.filters = dataset.filters || [];
                angular.forEach($scope.dataset.subDatasets, function(selectedDataset) {
                    if (selectedDataset.id === schoolProfileDatasetId) {
                        hasSchoolProfileSelected = true;
                    }
                });
                if (!hasSchoolProfileSelected) {
                    CriteriaService.get({ 'headId': schoolProfileDatasetId }, criteriaServiceCallback);
                }
                angular.forEach(dataset.subDatasets, selectedDatsetsCallback);
                
                $scope.loadingFilters = 1;
            }, function(response) {
                $scope.loadingFilters = 2;
                $scope.loadingFiltersError = 'Failed to load Filters. [HTTP Status: ' + response.status + '].';
            });
            
            
            $scope.setFilter = function(criterion) {
                var selectedOptions = $scope.selectedValues[criterion.filterId];
                var filterFound = false;
                var findFilterCallback = function(filter) {
                    if (filter.criterion === criterion.filterId) {
                        filterFound = true;
                    }
                };
                angular.forEach($scope.filters, findFilterCallback);
                if (!filterFound) {
                    $scope.filters.push({
                        criterion: criterion.filterId,
                        element: criterion.elementId,
                        selectedOptions: selectedOptions
                    });
                }
                else {
                    angular.forEach($scope.filters, function(filter) {
                        if (filter.criterion === criterion.filterId && filter.element === criterion.elementId) {
                            filter.selectedOptions = selectedOptions;
                        }
                    });
                }
                // TODO dynamic filters with callback or specialized actions.
                if (criterion.filterId === regionFilterId) {
                    divisionCriterion.selection = selectedOptions[0].childKeyValues;
                }
                
                if (criterion.filterId === sectorFilterId) {
                	sectorSubChecklistCriterion.selection = selectedOptions[0].childKeyValues;
                }
  
                if (criterion.filterId === generalCurOfferingFilterId) {
                	gcoSubChecklistCriterion.selection = selectedOptions[0].childKeyValues;
                }
                
    
            };
            
            $scope.searchSchools = function(schoolName) {
                var schoolFilters = [];
                angular.copy($scope.filters, schoolFilters);
                angular.forEach(schoolFilters, function(filter) {
                    if (filter.criterion === schoolNameFilterId) {
                        filter.selectedOptions = [
                            {
                                key: schoolName,
                                value: schoolName
                            }
                        ];
                    }
                });
                var promise = SchoolNameCriteriaService.searchSchool({}, schoolFilters).$promise;
                promise.then(function(response) {
                    return response;
                });
                return promise;
            };
            
            $scope.selectSchool = function(item, model, label, availableCriterion) {
                var filterId = availableCriterion.filterId;
                if (!$scope.selectedValues[filterId]) {
                    $scope.selectedValues[filterId] = [];
                }
                angular.forEach($scope.selectedValues[filterId], function(option, idx) {
                    if (option.key === '') {
                        $scope.selectedValues[filterId].splice(idx, idx + 1);
                    }
                });
                $scope.selectedValues[filterId].push(item);
                $scope.setFilter(availableCriterion);
                $scope.selectedSchoolName = '';
                $scope.$apply();
            };

            var saveDataset = function(dataset, saveCallback) {
                UserDatasetService.save({}, dataset, function(response) {
                    saveCallback();
                });
            };
            
            $scope.save = function() {
                $scope.saving = true;
                var dataset = $scope.dataset;
                dataset.filters = $scope.filters;
                
                dataset.filters=clean($scope.filters);
                
                saveDataset(dataset, function() {
                	localStorageService.set('dataset',dataset);
                    $state.go('step4');
                });
            };
            
            function clean(filters)
            {
            	var c=[];
            	
            	filters.forEach(function(item,index){
            		c.push(item);
            	})
            	
            	return c;
            }
            
            $scope.previous = function() {
                var dataset = $scope.dataset;
                saveDataset(dataset, function() {
                    $state.go('step2');
                });
            };
            
            $scope.isRawCriteriaDefined=function()
            {
            	return angular.isDefined($scope.availableCriteria) && $scope.availableCriteria.length!=0;
            }
            
        }
    ]
);