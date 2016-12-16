'use strict';

angular.module('UserApp').directive('filterDirective',[function(){

	function link(scope, element, attrs) 
	{
		var filterContainer={
		                 		data:
		                 			[
		                 			 		{
												filterName:'sp_region',
												dataset:[],
												onClick:function(criterion,chosenItem,option)
												{				                 			
													
										//			filterContainer['sp_schoolType'].dataset=[];
										//			filterContainer['sp_schoolType'].dataset=option.childKeyValues.slice();
										//			console.log(filterContainer['sp_schoolType'].dataset);
												}
											},
										
											{
												filterName:'sp_schoolType',
												dataset:[],
												onClick:function(criterion,chosenItem,option)
												{
													
												}
											}
		                 			 ],
						          arrange:function(data)
						          {
						        	  var ordinal=['sp_schoolName','sp_sy_from','sp_level','sp_sector','sp_schoolType','sp_division','sp_region'];
						        	  var ldata=[];
						        	  var instance=this;
						        	  ordinal.forEach(function(item,index){
						        		 ldata.push(instance.find(item));
						        	  });
						        	  console.log('sdfsd',ldata);
						        	  return ldata;
						        	  
						          },
								
								add:function(element)
								{
									data.push(element);
								},
								update:function(filterName,element)
								{
									this.remove(filterName);
									this.add(element);
								},
								find:function(filterName)
								{
									
									$.each(this.data,function(i,item){
										console.log(item);
										if(item.filterName===filterName)
											return item;
									});
										
								},
								remove:function(filterName)
								{
									for(var i=0;i<this.data.length;x++)
									{
										var item=this.data[i];
										if(item.filterName===filterName)
										{
											this.data.splice(i,1);
											break;
										}
									}
								}
						};

		
		scope.onSelect=function()
		{
		
		};
		
		scope.getCriteria=function()
		{
			
			var m= filterContainer.arrange(filterContainer);
			return m;
		};
		
//		prepare(scope.criteria,filterContainer.data);
//		initContainer(filterContainer.data,scope.criteria);
		filterContainer.remove('sp_region');
		filterContainer.remove('sp_schoolType');
		console.log('haha',filterContainer.data);
		
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
			
			filterContainer[altered.filterName]=altered;
			
			console.log(altered);
		}
	}
	
	function findInFilterContainer(container,name)
	{
		container.data.forEach(function(item,index){
			if(item.filterName===name)
				return item;
		});
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