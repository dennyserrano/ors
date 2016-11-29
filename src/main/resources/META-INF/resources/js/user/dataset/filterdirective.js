'use strict';

angular.module('UserApp').directive('filterDirective',[function(){

	function link(scope, element, attrs) 
	{
		
		scope.onSelect=function()
		{
			
		};
		
		
		
		
		
		
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