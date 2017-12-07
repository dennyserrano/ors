'use strict';

angular.module('UserApp')
    .factory('FilterService', [
        function() {

            var schoolProfileDatasetId = 8; // value came from the database (sisdbtest.dataset_head).
            var regionFilterId = 8; // number 8 is from sisdbtest.dataset_criteria.id where filter_name = 'Region'
            var divisionFilterId = 9; // number 9 is from sisdbtest.dataset_criteria.id where filter_name = 'Divison'
            var divisionCriterion;
            
            var setDivisionCriterion = function(c) {
                divisionCriterion = c;
            };
            
            var regionFilterCallback = function(selectedOption, selectedFilters, availableCriteria) {
                
            };
            
            return {
                regionFilterCallback: regionFilterCallback,
                setDivisionCriterion: setDivisionCriterion
            };
        }
    ]
);