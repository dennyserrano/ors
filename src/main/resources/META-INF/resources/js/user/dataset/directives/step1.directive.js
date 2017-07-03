'use strict';

angular.module('UserApp')
.directive('stepOne',[function(){
	
	function link(scope,element,attrs)
	{
		alert("haha");
	}
	
	return{
		restrict:'E',
		templateUrl:'../dataset/user/step1.html',
		link:link
	};
	
}]);