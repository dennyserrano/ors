'use strict';

angular.module('UserApp').directive('filterDirective',[function(){

	function link(scope, element, attrs) 
	{
	
		var ordinal=['sp_region','sp_division','sp_schoolType','sp_sector','sp_subsector','sp_level','sp_sublevel','sp_sy_from','sp_schoolName'];
		var _data=
			[
				{
					filterName:'sp_region',
					dataset:[],
					onClick:function(chosenItems,currentIndex)
					{				                 			
						var container=filterContainer.find('sp_division');
						var option=chosenItems[currentIndex];
						var selectedOption=option.selectedOptions[0].childKeyValues;
						
						container.dataset=[];
						container.dataset=selectedOption.slice();
				
					}
				},
				{
					filterName:'sp_sector',
					dataset:[],
					onClick:function(chosenItems,currentIndex)
					{
						var container=filterContainer.find('sp_subsector');
						var option=chosenItems[currentIndex];
						var selectedOption=option.selectedOptions[0].childKeyValues;
						
						container.dataset=[];
						container.dataset=selectedOption.slice();
					}
				},
				{
					filterName:'sp_level',
					dataset:[],
					onClick:function(chosenItems,currentIndex)
					{
	
						var container=filterContainer.find('sp_sublevel');
						var option=chosenItems[currentIndex];
						var selectedOption=option.selectedOptions[0].childKeyValues;
						
						container.dataset=[];
						container.dataset=selectedOption.slice();
					}
				}
			 ];
		var filterContainer={
		                 		data:
		                 			[
		                 			 
										
		                 			 
		                 			 ],
						          arrange:function(ordinal)
						          {
						        	  
						        	  
						        	  var ldata=[];
						        	  var instance=this;
						        	  ordinal.forEach(function(item,index){
						        		 var i= instance.find(item)
						        		 ldata.push(i);
						        	  });
						        	  filterContainer.data=[];
						        	  ldata.forEach(function(item,index){
						        		 filterContainer.data.push(item); 
						        	  });
						        	  
						        	  
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
			populateData:function(filterContainer,criteria)
			{
				var filterContainerData=filterContainer.data;
				if(angular.isUndefined(criteria))
					return ;
				if(angular.isUndefined(filterContainerData))
					return ;
				
				for(var x=0;x<criteria.length;x++)
				{
					var criterion = criteria[x];
					var filter=this.find(filterContainerData,criterion.filterName);
					var altered;
					if(angular.isUndefined(filter))
						{
							altered=this.mapDefaultToFilter(criterion);
							filterContainer.add(altered);
						}
					else
						{
							altered=this.mapToFilter(criterion,filter);
							filterContainer.update(criterion.filterName,altered);
						}
						
						
					
					
				}
				
				
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
		
		scope.onInit=function(chosenItem,filterContainerData,currentIndex)
		{
			chosenItem[currentIndex];
			chosenItem[currentIndex]={};
			
			if(angular.isDefined(filterContainerData.dataset[0]))
				chosenItem[currentIndex].selectedOptions=[filterContainerData.dataset[0]];
			else
				chosenItem[currentIndex].selectedOptions=[];
			
			chosenItem[currentIndex].element=filterContainerData.elementId;
			chosenItem[currentIndex].criterion=filterContainerData.filterId;
			filterContainerData.onClick(chosenItem,currentIndex);
		}
		
		scope.onSelect=function()
		{
		
		};
		
		scope.getCriteria=function()
		{	
			if(angular.isUndefined(scope.criteria))
				{
					filterContainer.data=[];
					return filterContainer.data
				}
			else
				
			if(scope.criteria.length===0)
				{
				filterContainer.data=[];
				return filterContainer.data
				}
			
			return filterContainer.data;
		};
		
		if(angular.isUndefined(scope.criteria))
		{
			filterContainer.data=[];
			return;
		}
		
		
		
		filterContainer.data=[];
		filterContainer.data=angular.copy(_data);
		
		CriteriaUtility.populateData(filterContainer,scope.criteria);
		filterContainer.arrange(ordinal);
		bind(CriteriaUtility,filterContainer,scope.criteria,scope.chosenItems);
		
		function bind(criteriaUtility,filterContainer,criteria,chosenItems)
		{
			var x;
			
			for(x=0;x<criteria.length;x++)
			{
				var criterion=criteria[x];
				var filter=filterContainer.find(criterion.filterName);
//				if(angular.isUndefined(filter))
//					continue;
				
				filter.dataset=criterion.selection.slice();
				
				
			}
			
		}
		
		
	};
	
	
	function toChosenItem(option,filterContainerData)
	{
		var cItem={};
		
		cItem.selectedOptions=[];
		
		if(angular.isDefined(option))
			cItem.selectedOptions.push(option);
		
		
		cItem.element=filterContainerData.elementId;
		cItem.criterion=filterContainerData.filterId;
		
		
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
			
		}
	}
	
	
	function getCommonFields()
	{
		return ['label','filterName','inputType','filterId','elementId'];
	}
	
	function filterContainerDefaultFields()
	{
		return{
			filterName:'',
			dataset:[],
     		onClick:function(chosenItems,currentIndex)
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