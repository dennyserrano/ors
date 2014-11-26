(function(window, $) {

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
        }

        var height = $(document).height();
        height = height - topOffset;
        if (height < 1) height = 1;
        if (height > topOffset) {
            $("#page-wrapper").css("min-height", (height) + "px");
            //$('#sidebar-nav').css('height', height + 'px');
            //$('#sidebar-nav').css('overflow', 'auto');
        }
    };
    
    ORS.AdjustDatasetContents = function(offset) {
        var width = $(window).width();
        if (width >= 768) {
            var trackerHeight = $('#trackerRow').outerHeight();
            var additionalOffset = offset || 0;
            $('#datasetContents').css('padding-top', (trackerHeight + additionalOffset) + 'px');
            $('#sidebar-nav').css('height', '');
        }
        else {
            $('#datasetContents').css('padding-top', '');
        }
    };
    
    ORS.FitToWidth = function(element) {
        var windowWidth = $(window).width();
        $(element).css('width', windowWidth + 'px');
    };
    
    ORS.AdjustElementTableHeaders = function() { // do not erase, being used in step2ctrl.js
        window.ORS.FitToWidth($('#elements'));
        var elementsTable = $('#elementsTable');
        var trackerRow = $('#trackerRow');
        var width = $(window).width();
        var offset = trackerRow.outerHeight() + 54;
        if (width < 768) {
            offset = 50;
        }
        elementsTable.stickyTableHeaders({
            fixedOffset: offset
        });

        $('#nextBtn').on('click', function(e) {
            elementsTable.stickyTableHeaders('destroy');
        });
    };
    
    ORS.AdjustPreviewTable = function() { // do not erase, being used in step4ctrl.js
        var width = $(window).width();
        var offset = 40;
        if (width < 768) {
            offset = 50;
        }
        else {
            offset = $('#trackerRow').outerHeight() + $('#datasetContents').height();
        }
        $('#previewTable').stickyTableHeaders({
            fixedOffset: offset
        });
        ORS.FitToWidth($('#previewContainer'));
    };

    window.ORS = ORS;

})(window, jQuery);

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
    ORS.AdjustDatasetContents(0);
    ORS.AdjustElementTableHeaders();
    ORS.AdjustPreviewTable();
});

$(document).ready(function ($) {
    $('.my-scroll').perfectScrollbar();
  });
