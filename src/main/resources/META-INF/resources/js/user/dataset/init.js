'use strict';

angular.module('UserApp').run(function($rootScope) {
    $rootScope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams) {
        if (toState.name !== 'step1') {
            $('#sidebar-btn').hide();
        }
    });
});