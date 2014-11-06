'use strict';

angular.module('UserApp').run(function($rootScope) {
    $rootScope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams) {
        var sidebarBtn = $('#sidebar-btn');
        if (fromState.name === 'step1') { // forward
            sidebarBtn.hide();
        }
        if (toState.name === 'step1') { // reverse
            sidebarBtn.show();
        }
    });
});