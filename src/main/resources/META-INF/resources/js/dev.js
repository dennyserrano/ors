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
        $.ajax({
            mimeType: 'application/json; charset=x-user-defined',
            beforeSend: function(xhr) {
                xhr.overrideMimeType('application/json; charset=x-user-defined');
            },
            url: '../../js/icons.json',
            type: 'GET',
            dataType: 'json',
            cache: false
        })
        .done(function(data) {
            $.each(data.icons, function(idx, icon) {
                $('#iconsList').append('<div class="list-group-item"><i class="pull-left fa fa-' + icon + '"></i><p class="list-group-item-text">' + icon + '</p></div>');
            });
        });
        ORS.Icons = ORS.Icons || {};
        ORS.Icons.show = function() {
            $('#fontAwesomeIcons').modal('show');
        };
    });
})(document, jQuery);

$(".modal").on("show.bs.modal", function() {
    var height = $(window).height() - 200;
    $(this).find(".modal-body").css("max-height", height);
});

