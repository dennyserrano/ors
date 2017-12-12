(function($, google) {

	'use strict';

    ORS.Admin.Dashboard = function($, google) {

        var memoryChartId = '#memoryChart';
        var freeMem = 0;
        var usedMem = 0;

        google.load('visualization', '1', {'packages':['corechart']});

        var drawMemoryChart = function(free, used, chartId) {
            if (chartId) {
                this.memoryChartId = chartId;
            }
            freeMem = free;
            usedMem = used;
            google.setOnLoadCallback(drawMemoryChartCallback);
        };

        var drawMemoryChartCallback = function() {
            var data = new google.visualization.arrayToDataTable([
                ['Type', 'Memory (MB)'],
                ['Free (MB)', this.freeMem],
                ['Used (MB)', this.usedMem]
            ]);

            var chartOptions = {
                title: 'Memory Usage',
                is3D: true
            };

            var chart = new google.visualization.PieChart($(memoryChartId).get(0));
            chart.draw(data, chartOptions);
        };

        return {
            drawMemory: drawMemoryChart
        };

    }($, google);

}(jQuery, google));