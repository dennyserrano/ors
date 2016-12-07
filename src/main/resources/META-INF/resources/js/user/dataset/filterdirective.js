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
				                 		onClick:function(criterion,chosenItem,option)
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
		
//		prepare(scope.criteria,filterContainer);
		initContainer(filterContainer,scope.criteria);
	};

	
	function prepare(criteria,container)
	{
		var x;
		
		for(x=0;x<criteria.length;x++)
		{
			var criterion=criteria[x];
			var filter=findInFilterContainer(container,criterion.filterName);
			if(angular.isUndefined(filter))
				continue;
			filter.dataset=[];
			filter.dataset=criterion.selection.slice();
		}
	}
	
	function initContainer(filterContainer,criteria)
	{
		for(var x=0;x<criteria.length;x++)
		{
			var criterion = criteria[x];
			var filter=findInFilterContainer(filterContainer,criterion.filterName);
			var altered;
			if(angular.isUndefined(filter))
				altered=mapDefaultToFilter(criterion);
			else
				altered=mapToFilter(criterion,filter);
			
			
			console.log(altered);
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
	
	function getCommonFields()
	{
		return ['label','filterName','inputType','filterId'];
	}
	
	function mapToFilter(criterion, filter)
	{
		var commonFields=getCommonFields();
		for(var x=0;x<commonFields.length;x++)
		{
			var commonField=commonFields[x];
			filter[commonField]= criterion[commonField]
			
		}
		return filter;
	}
	
	function mapDefaultToFilter(criterion)
	{
		var defField=filterContainerDefaultFields();
		defField=mapToFilter(criterion,defField);
		return defField;
	}
	
	
	
	function filterContainerDefaultFields()
	{
		return{
			filterName:'',
			dataset:[],
     		onClick:function(criterion,chosenItem,option)
     		{
     			
     		}
		};
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