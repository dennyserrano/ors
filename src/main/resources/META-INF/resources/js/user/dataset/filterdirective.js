'use strict';

angular.module('UserApp').directive('filterDirective',[function(){

	function link(scope, element, attrs) 
	{
		var ordinal=['sp_region','sp_division','sp_schoolType','sp_sector','sp_subsector','sp_level','sp_sublevel','sp_sy_from','sp_schoolName'];
		var filterContainer={
		                 		data:
		                 			[
		                 			 		{
												filterName:'sp_region',
												dataset:[],
												onClick:function(criterion,chosenItem,option)
												{				                 			
													
													if(angular.isUndefined(option))
														return;
													
													var container=filterContainer.find('sp_division');
								
													var selectedOption=option.selectedOptions[0];
													
													container.dataset=[];
													container.dataset=selectedOption.childKeyValues.slice();
//													container.dataset=options.selectedOptions[0].childKeyValues.slice();
												}
											},
											{
												filterName:'sp_sector',
												dataset:[],
												onClick:function(criterion,chosenItem,option)
												{
													if(angular.isUndefined(option))
														return;
													
													var container=filterContainer.find('sp_subsector');
								
													container.dataset=[];
													container.dataset=option.selectedOptions.childKeyValues.slice();
//													container.dataset=option.childKeyValues.slice();
												}
											},
											{
												filterName:'sp_level',
												dataset:[],
												onClick:function(criterion,chosenItem,option)
												{
													if(angular.isUndefined(option))
														return;
													
													var container=filterContainer.find('sp_sublevel');
								
													container.dataset=[];
													container.dataset=option.selectedOptions.childKeyValues.slice();
//													container.dataset=option.childKeyValues.slice();
												}
											}
		                 			 ],
						          arrange:function(data)
						          {
						        	  
						        	  
						        	  var ldata=[];
						        	  var instance=this;
						        	  ordinal.forEach(function(item,index){
						        		 var i= instance.find(item)
						        		 ldata.push(i);
						        	  });
						        	  
						        	  return ldata;
						        	  
						          },
								
								add:function(element)
								{
									this.data.push(element);
								},
								update:function(filterName,element)
								{
									this.remove(filterName);
									this.add(element);
								},
								find:function(filterName)
								{
									if(angular.isUndefined(this.data))
										return;
									
									for(var x=0;x<this.data.length;x++)
									{
										var item=this.data[x];
										if(item.filterName===filterName)
											return item;
									}
										
								},
								remove:function(filterName)
								{
									for(var i=0;i<this.data.length;i++)
									{
										var item=this.data[i];
										if(item.filterName===filterName)
										{
											this.data.splice(i,1);
											break;
										}
									}
								},
								set:function(incomingData)
								{
									this.data=incomingData;
									
								}
						};

		
		var CriteriaUtility={
			
			find:function (criteria, filterName)
			{
				if(angular.isDefined(criteria))
				{
					var x;
					for(x=0;x<criteria.length;x++)
					{
						var element=criteria[x];
						if(element.filterName===filterName)					
							return element;
							
					}
				}
				
			},
			getPopulatedData:function(filterContainerData,criteria)
			{
				if(angular.isUndefined(criteria))
					return ;
				if(angular.isUndefined(filterContainerData))
					return ;
				
				var container=[];
				
				for(var x=0;x<criteria.length;x++)
				{
					var criterion = criteria[x];
					var filter=this.find(filterContainerData,criterion.filterName);
					var altered;
					if(angular.isUndefined(filter))
						altered=this.mapDefaultToFilter(criterion);
					else
						altered=this.mapToFilter(criterion,filter);
						
					container.push(altered);
					
				}
				
				return container;
			},
			
			mapToFilter: function(criterion, filter)
			{
				var commonFields=getCommonFields();
				for(var x=0;x<commonFields.length;x++)
				{
					var commonField=commonFields[x];
					filter[commonField]= criterion[commonField]
					
				}
				return filter;
			},
			mapDefaultToFilter:function(criterion)
			{
				var defField=filterContainerDefaultFields();
				defField=this.mapToFilter(criterion,defField);
				return defField;
			}
			
		
		};
		
		
		scope.onSelect=function()
		{
		
		};
		
		scope.getCriteria=function()
		{	
			return filterContainer.data;
		};
		
		filterContainer.data= CriteriaUtility.getPopulatedData(filterContainer.data,scope.criteria);
		filterContainer.data=filterContainer.arrange(filterContainer.data);
		bind(CriteriaUtility,filterContainer,scope.criteria,scope.chosenItems);
		initializeChosenItems(scope.chosenItems,filterContainer);
		
		
		function bind(criteriaUtility,filterContainer,criteria,chosenItems)
		{
			var x;
			
			for(x=0;x<criteria.length;x++)
			{
				var criterion=criteria[x];
				var filter=filterContainer.find(criterion.filterName);
				if(angular.isUndefined(filter))
					continue;
				
				filter.dataset=criterion.selection.slice();
				
				
			}
			
		}
		
		function initializeChosenItems(chosenItems,filterContainer)
		{
			
			
			for(var x=0;x<filterContainer.data.length;x++)
			{
				var data=filterContainer.data[x];
				chosenItems.push(toChosenItem(data.dataset[0],data));
			}
			
		}
		
		
	};
	
	
	function toChosenItem(option,parentData)
	{
		var cItem={};
		
		cItem.selectedOptions=[];
		
		if(angular.isDefined(option))
			cItem.selectedOptions.push(option);
		
		
		cItem.element=parentData.elementId;
		cItem.criterion=parentData.filterId;
		
		
		return cItem;
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
			
//			console.log(altered);
		}
	}
	
//	function findInFilterContainer(container,name)
//	{
//		container.data.forEach(function(item,index){
//			if(item.filterName===name)
//				return item;
//		});
//	}
	
	function getCommonFields()
	{
		return ['label','filterName','inputType','filterId','elementId'];
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
			chosenItems:'='
		},
		controller:control
	
	};

}]);