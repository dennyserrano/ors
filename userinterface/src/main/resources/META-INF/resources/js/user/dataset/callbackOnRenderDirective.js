'use strict';

angular.module('UserApp').directive('callbackOnRender', [
    function() {
        return function(scope, element, attrs) {
            if (scope.$last) {
                scope.$emit('render-done');
            }
        }
    }
]);