window.onload = function() {

    var dps = [[]];
    var chart = new CanvasJS.Chart("chartContainer", {
        theme: "light2", // "light1", "dark1", "dark2"
        animationEnabled: true,
        title: {
            text: "Diamond Production - Canada"
        },
        subtitles: [{
            text: "2006 - 2016"
        }],
        axisX: {
            valueFormatString: "####"
        },
        axisY: {
            title: "Volume (in million carats)"
        },
        data: [{
            type: "spline",
            xValueFormatString: "####",
            yValueFormatString: "#,##0.0 million carats",
            dataPoints: dps[0]
        }]
    });

    var xValue;
    var yValue;
}