(function(window) {

    var ORS = ORS || {};

    ORS.Admin = ORS.Admin || {};
    ORS.User = ORS.User || {};

    //Loads the correct sidebar on window load,
    //collapses the sidebar on window resize.
    // Sets the min-height of #page-wrapper to window size
    ORS.ResizeElements = function() {
        var topOffset = 50;
        var width = $(window).width();
        if (width < 768) {
            $('div#sidebar-nav').addClass('collapse');
            topOffset = 100; // 2-row-menu
        } else {
            $('div#sidebar-nav').removeClass('collapse');
            $('div#sidebar-nav').removeAttr('style');
        }

        var height = $(document).height();
        height = height - topOffset;
        if (height < 1) height = 1;
        if (height > topOffset) {
            $("#page-wrapper").css("min-height", (height) + "px");
            //$('#sidebar-nav').css('height', height + 'px');
            //$('#sidebar-nav').css('overflow', 'auto');
        }

        var trackerHeight = $('#trackerRow').height();
        $('#datasetContents').css('padding-top', trackerHeight + 'px');
    };
    
    ORS.DoubleScroll = function(element) {
        ORS.FitToWidth(element);
        $(element).doubleScroll({
            resetOnWindowResize: true
        });
    };
    
    ORS.FitToWidth = function(element) {
        var windowWidth = $(window).width();
        $(element).css('width', windowWidth + 'px');
    };

    window.ORS = ORS;

})(window);

(function($) {
    $(document).ready(function() {
        $("body").tooltip({ selector: '[data-toggle=tooltip]' });
    });
})(jQuery);

(function(document, $) {
    $(document).ready(function() {
        ORS.Icons = ORS.Icons || {};
        ORS.Icons.show = function() {
            $.getJSON('/js/icons.json', function(data) {
                $.each(data.icons, function(idx, icon) {
                    $('#iconsList').append('<div class="list-group-item"><i class="pull-left fa fa-' + icon + '"></i><p class="list-group-item-text">' + icon + '</p></div>');
                });
            });
            $('#fontAwesomeIcons').modal('show');
        };
    });
})(document, jQuery);

$(".modal").on("show.bs.modal", function() {
    var height = $(window).height() - 200;
    $(this).find(".modal-body").css("max-height", height);
});

$(window).resize(function() {
    ORS.ResizeElements();
});

