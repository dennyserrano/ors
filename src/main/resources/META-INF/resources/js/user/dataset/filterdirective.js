'use strict';

angular.module('UserApp').directive('filterDirective',[function(){

	function link(scope, element, attrs) 
	{
		var connections={
		                 'sp_region':
				                 	{
				                 		filterName:'sp_region',
				                 		dataset:[],
				                 		onClick:function(criterion,chosenItem)
				                 		{
				                 			
				                 			var criteria=findCriteria(criterion,chosenItem.filterName);
				                 			connections['sp_schoolType'].dataset.clear();
				                 			connections['sp_schoolType'].dataset.concat(criteria.selection);
				                 		}
				                 	},
		                'sp_schoolType':
				                	{
				                 		filterName:'sp_schoolType',
				                 		dataset:[],
				                 		onClick:function(criterion,chosenItem)
				                 		{
				                 			
				                 		}
				                 	}
						};

		
		scope.onSelect=function()
		{
			
		};
		
		scope.getCriteria=function(criteriaParameter)
		{
			
			
			
			
			return criteriaParameter;
		};
		
		
	};

	
	function prepare(criteria,connections)
	{
		var x;
		for(x=0;x<criteria.length;x++)
			
	}
	
	function findCriteria(criterion, filterName)
	{
		if(angular.isDefined(criterion))
		{
			var x;
			for(x=0;x<criterion.length;x++)
			{
				var element=criterion[x];
				if(element.filterName===filterName)					
					return element;
					
			}
		}
		
		throw "Unable to find filterName:"+filterName;
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