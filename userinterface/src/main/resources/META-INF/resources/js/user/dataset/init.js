'use strict';

angular.module('UserApp').run(function($rootScope, $window) {
    $rootScope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams) {
        var sidebarBtn = $('#sidebar-btn');
        if (fromState.name === 'step1') { // forward
            sidebarBtn.hide();
        }
        if (toState.name === 'step1') { // reverse
            var width = $(window).width();
            if (width < 768) {
                sidebarBtn.show();
            }
        }
    });
});