'use strict';

angular.module('UserApp').directive('filterDirective',[function(){

	function link(scope, element, attrs) 
	{
		var connections=[
		                 	{
		                 		filterName:'sp_region',
		                 		connectedTo:'sp_division',
		                 		dataset:[],
		                 		onClick:function(criterion,innerName)
		                 		{
		                 			
		                 		}
		                 	},
		                 	{
		                 		filterName:'sp_schoolType',
		                 		connectedTo:'',
		                 		dataset:[],
		                 		onClick:function(criterion,innerName)
		                 		{
		                 			
		                 		}
		                 	}
		                 ];
		
		scope.onSelect=function()
		{
			
		};
		
		scope.getCriteria=function(criteriaParameter)
		{
			
			
			
			
			return criteriaParameter;
		};
		
		
	};

	
	function prepare(criteria)
	{
		
	}
	
	function findCriteria(source, criteriaName)
	{
		
	}
	
	function control($scope)	
	{
		$scope.chosen=[];
		$scope.data=[{key:'1',value:'hehe'}];
		
	}
	
	return {
	
		restrict:'E',
		templateUrl:'../../../templates/user/filters/filters.html',
		link:link,
		scope:
		{
			criteria:'=',
			filters:'='
		},
		controller:control
	
	};

}]);