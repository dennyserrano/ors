(function(window) {

    var ORS = ORS || {};

    ORS.Admin = ORS.Admin || {};
    ORS.User = ORS.User || {};

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

//Loads the correct sidebar on window load,
//collapses the sidebar on window resize.
// Sets the min-height of #page-wrapper to window size
$(function() {
    $(window).bind("load resize", function() {
        var topOffset = 50;
        var width = (this.window.innerWidth > 0) ? this.window.innerWidth : this.screen.width;
        if (width < 768) {
            $('div#sidebar-nav').addClass('collapse');
            topOffset = 100; // 2-row-menu
        } else {
            $('div#sidebar-nav').removeClass('collapse');
            $('div#sidebar-nav').removeAttr('style');
        }

        var height = (this.window.innerHeight > 0) ? this.window.innerHeight : this.screen.height;
        height = height - topOffset;
        if (height < 1) height = 1;
        if (height > topOffset) {
            $("#page-wrapper").css("min-height", (height) + "px");
        }
    })
});

$(function() {
    $(".change").click(function() {
        $('.progress').removeClass("progress-bar-success");
        $('.progress_2').addClass("progress-bar-info");
        $('.progress_3').addClass("progress-bar-info");
    });
});