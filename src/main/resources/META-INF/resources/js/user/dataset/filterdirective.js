'use strict';

angular.module('UserApp').directive('filterDirective',function(){

	function link(scope, element, attrs) 
	{
		console.log('hello');
	};


	return {
	
		restrict:'E',
		templateUrl:'../../../templates/user/filters/filters.html',
		scope:'',
		link:''
	
	};

});