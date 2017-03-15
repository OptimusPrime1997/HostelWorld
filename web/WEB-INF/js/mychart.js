function initCircleChart() {
    option = {
        tooltip: {
            formatter: "{a} <br/>{b} : {c}%"
        },
        toolbox: {
            feature: {
                restore: {},
                saveAsImage: {}
            }
        },
        series: [
            {
                name: '业务指标',
                type: 'gauge',
                detail: {formatter: '{value}%'},
                data: [{value: 50, name: '完成率'}]
            }
        ]
    };

    app.timeTicket = setInterval(function () {
        option.series[0].data[0].value = (Math.random() * 100).toFixed(2) - 0;
        myChart.setOption(option, true);
    }, 2000);
}

/*get max item of the array*/
function getMax(parameter){
    var tempMax=-10000;
    var length=parameter.length;
    for(var i=0;i<length;i++){
        if(tempMax<parameter[i]){
            tempMax=parameter[i];
        }
    }
    return tempMax;
}
function getDataArray(sArray,index){
    var result=array();
    console.log(sArray);
    for(var i=0;i<sArray.length;i++){
        result[i]=sArray[index];
        console.log(result[i]);
    }
    return result;
}

/*f_discovery submit textarea data*/