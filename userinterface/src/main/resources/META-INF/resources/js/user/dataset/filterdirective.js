'use strict';

angular.module('UserApp').directive('filterDirective',['CriteriaService',function(CriteriaService){

	function link(scope, element, attrs) 
	{
		var ordinal=['sp_region','sp_division','sp_district','sp_province','sp_municipality','sp_legislative','sp_schoolType','sp_sector','sp_subsector','sp_level','sp_sublevel','sp_sy_from','sp_schoolName'];
		var showHideRef={
						'Region':{
									'Division':{
												'District':null
											  },
								    'Province':{
								    			'Municipality':null,
								    			'Legislative':null
								    }
								}
						
						};
		var ordinalReference=['Region','Division','District','Province','Municipality','Legislative'];
		
		var _data=
			[
				{
					filterName:'sp_region',
					dataset:[],
					onClick:function(chosenItems,currentIndex)
					{				                 			
						var divisionContainer=filterContainer.find('sp_division');
						var provinceContainer=filterContainer.find('sp_province');
						var municipalityContainer=filterContainer.find('sp_municipality');
						var legislativeContainer=filterContainer.find('sp_legislative');
						
						divisionContainer.dataset=[];
						provinceContainer.dataset=[];
						municipalityContainer.dataset=[];
						legislativeContainer.dataset=[];
						
						if(divisionContainer.show)
						{
							var option=chosenItems[currentIndex]; //region fetches division already when the page loads..it has a different impl from the other hierarchy.
							var selectedOption=option.selectedOptions[0].childKeyValues;
							divisionContainer.dataset=[];
							divisionContainer.dataset=selectedOption.slice();
						}
						
						if(provinceContainer.show)
						{
							var option=chosenItems[currentIndex];
							var selectedRegionKey=option.selectedOptions[0].key;
							if(selectedRegionKey!=="")
							CriteriaService.listProvinces({regionId:selectedRegionKey},function(list){
								provinceContainer.dataset=list;
							});
						}
				
					}
				},
				{      	
					filterName:'sp_division',
					dataset:[],
					onClick:function(chosenItems,currentIndex)
					{				                 			
						var option=chosenItems[0];
						var choseRegion=option.selectedOptions[0].key;
						
						var chosenDivision=chosenItems[currentIndex].selectedOptions[0].key;
						var districtContainer=filterContainer.find('sp_district');
						districtContainer.dataset=[];
						
						if(angular.isDefined(choseRegion) && angular.isDefined(chosenDivision))
						CriteriaService.listDistricts({regionId:choseRegion,divisionId:chosenDivision},function(list){
							districtContainer.dataset=list;
						});
					}
				},
				{
					filterName:'sp_province',
					dataset:[],
					onClick:function(chosenItems,currentIndex)
					{				                 			
						var municipalityContainer=filterContainer.find('sp_municipality');
						var legislativeContainer=filterContainer.find('sp_legislative');
						
						var regionOption=chosenItems[0].selectedOptions[0].key; //region chosenItem
						
						if(angular.isDefined(chosenItems[currentIndex].selectedOptions[0]))
						var provinceOption=chosenItems[currentIndex].selectedOptions[0].key; //province chosenItem
						
						municipalityContainer.dataset=[];
						legislativeContainer.dataset=[];
						if(municipalityContainer.show)
						{
							if(angular.isDefined(regionOption) && angular.isDefined(provinceOption))
							CriteriaService.listMunicipalities({regionId:regionOption,provinceId:provinceOption},function(list){
								municipalityContainer.dataset=list;
							});
						}
						
						if(legislativeContainer.show)
						{
							if(angular.isDefined(regionOption) && angular.isDefined(provinceOption))
							CriteriaService.listLegislatives({regionId:regionOption,provinceId:provinceOption},function(list){
								legislativeContainer.dataset=list;
							});
						}
						
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
						
						if(!chosenItems[currentIndex+1])
						{
							chosenItems[currentIndex+1]={};
							chosenItems[currentIndex+1].selectedOptions=selectedOption.slice();
						}
					else
						chosenItems[currentIndex+1].selectedOptions=selectedOption.slice();
						
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
						if(!chosenItems[currentIndex+1])
							{
								chosenItems[currentIndex+1]={};
								chosenItems[currentIndex+1].selectedOptions=selectedOption.slice();
							}
						else
							chosenItems[currentIndex+1].selectedOptions=selectedOption.slice();
						
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
										
										if(angular.isUndefined(item))
											continue;
										
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
			
			showHideFilters:function(chosenFilter,filterContainer,hierarchyRef,ordinalReference)
			{
				var involvedFilters=[];
				var ordinalRef=ordinalReference;
				var res=findHierarchy(chosenFilter,hierarchyRef);
			    var recursiveHierarchyPath=res.path;
				recursiveHierarchyPath.push(chosenFilter);
				for(var x=0;x<ordinalReference.length;x++)
				{	
					var present=false;
					var left=ordinalReference[x];
					for(var y=0;y<recursiveHierarchyPath.length;y++)
						{
							var right=recursiveHierarchyPath[y];
							if(left==right)
								present=true;
						}	
					
					if(!present)
						involvedFilters.push(left);
				}

			
				angular.forEach(filterContainer.data,function(data){
					data.show=true;
				});
				
				
				for(x=0;x<involvedFilters.length;x++)
				{
					var involveFilter=involvedFilters[x];
					var data=filterContainer.find("sp_"+involveFilter.toLowerCase());
					data.show=false;
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
		
		scope.onInit2=function(chosenItem,filterContainerData,currentIndex)
		{
			chosenItem[currentIndex];
			chosenItem[currentIndex]={};
			
			
			chosenItem[currentIndex].selectedOptions=filterContainerData.dataset;
			
			chosenItem[currentIndex].element=filterContainerData.elementId;
			chosenItem[currentIndex].criterion=filterContainerData.filterId;
		}
		
		scope.onInit3=function(chosenItem,filterContainerData,currentIndex)
		{
			
			chosenItem[currentIndex].element=filterContainerData.elementId;
			chosenItem[currentIndex].criterion=filterContainerData.filterId;
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
		CriteriaUtility.showHideFilters(scope.chosenFilter,filterContainer,showHideRef,ordinalReference);
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
	
	
	var findHierarchy=function(searchStr,ordinal) 
	{
	  
	   var data={found:false,path:[]}; 

	   for(var key in ordinal)
	    {
	      var nextKey=ordinal[key];    
	      if(nextKey!==null)  
	       {
	         
	          if(key==searchStr)
	            {
	              data.found=true; 
	              return data;
	            }
	           data=findHierarchy(searchStr,nextKey);    
	          
	          
	          if(data.found) 
	           {
	            data.path.push(key);
	            return data;
	           }
	       }
	      else //if last child
	        if(key==searchStr)
	          {
	            
	            data.found=true;
	            return data;
	          }
	      
	      
	    }
	     return data;
	    
	} 

	
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
			chosenItems:'=',
			chosenFilter:'='
		},
		controller:control
	
	};

}]);