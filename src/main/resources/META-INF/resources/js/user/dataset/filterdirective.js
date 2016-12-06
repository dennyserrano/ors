'use strict';

angular.module('UserApp').directive('filterDirective',[function(){

	function link(scope, element, attrs) 
	{
		var filterContainer={
		                 'sp_region':
				                 	{
				                 		filterName:'sp_region',
				                 		dataset:[],
				                 		onClick:function(criterion,chosenItem,option)
				                 		{				                 			
				                 			
//				                 			filterContainer['sp_schoolType'].dataset=[];
//				                 			filterContainer['sp_schoolType'].dataset=option.childKeyValues.slice();
//				                 			console.log(filterContainer['sp_schoolType'].dataset);
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
		
		scope.getCriteria=function()
		{
			
			return filterContainer;
		};
		
		prepare(scope.criteria,filterContainer);
		
	};

	
	function prepare(criteria,container)
	{
		var x;
		
		for(x=0;x<criteria.length;x++)
		{
			var criterion=criteria[x];
			console.log(criterion);
			var filter=findInFilterContainer(container,criterion.filterName);
			if(angular.isUndefined(filter))
				continue;
			filter.dataset=[];
			filter.dataset=criterion.selection.slice();
		}
	}
	
	function findInFilterContainer(container,name)
	{
		return container[name];
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