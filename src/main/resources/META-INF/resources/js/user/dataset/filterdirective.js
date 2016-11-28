'use strict';

angular.module('UserApp').directive('filterDirective',[function(){

	function link(scope, element, attrs) 
	{
		scope.selected=[];
		scope.onSelect=function()
		{
			
		};
		
		scope.getCriteria=function(criteriaParameter)
		{
			
			return criteriaParameter;
		};
		
		scope.clickMe=function()
		{
			console.log(scope.selected);
		}
		
		
	};


	return {
	
		restrict:'E',
		templateUrl:'../../../templates/user/filters/filters.html',
		link:link,
		scope:
		{
			criteria:'=',
			filters:'='
		}
	
	};

}]);