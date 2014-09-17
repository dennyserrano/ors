(function(window) {

    var ORS = ORS || {};

    ORS.Admin = ORS.Admin || {};
    ORS.User = ORS.User || {};

    window.ORS = ORS;

})(window);

(function(WebFont, $) {
    WebFont.load({
        custom: {
            families: ['ORSWebFont', 'Droid Sans', 'Droid Serif']
        }
    });
    $(document).ready(function() {
        $("body").tooltip({ selector: '[data-toggle=tooltip]' });
    });
})(WebFont, jQuery);

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
