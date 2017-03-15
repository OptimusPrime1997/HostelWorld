function circle_fun() {
    initCanvas();
    function initCanvas() {
        // 选出页面上所有class为process的canvas元素
        $('canvas.circle-process').each(function () {
            // 获取进度数值
            var text = $(this).attr('process');
            var process = text.substring(0, text.length - 1);
            drawProcess(this, process);
        });
        //hover事件
        var processInterval = null;
        $('.canvas-wrap').hover(function (e) {
            var start = 0,
                canvas = $(this).find('canvas.circle-process')[0],
                end = $(canvas).attr('process').split('%')[0],
                intervalTime = 500 / end;
            processInterval = setInterval(function () {
                //画帧
                drawProcess(canvas, start++);
                if (start > end) {
                    clearInterval(processInterval);
                    processInterval = null;
                }
            }, intervalTime);
        }, function (e) {
            var canvas = $(this).find('canvas.circle-process')[0],
                end = $(canvas).attr('process').split('%')[0];
            if (processInterval) {
                //有动画，直接显示最终效果
                clearInterval(processInterval);
                processInterval = null;
                drawProcess(canvas, end);
            }
        });
    }

    function drawProcess(canvas, process) {
        // 拿到绘图上下文
        var context = canvas.getContext('2d');
        var cWidth = canvas.width;
        var cHeight = canvas.height;
        var circleX = cWidth / 2;
        var circleY = cHeight / 2;
        var circleR = circleX - 2;
        // 将绘图区域清空
        context.clearRect(0, 0, cWidth, cHeight);
        //灰色背景
        context.beginPath();

        context.moveTo(circleX, circleY);

        context.arc(circleX, circleY, circleR, 0, Math.PI * 2, false);
        context.closePath();
        context.fillStyle = '#eee';
        context.fill();
        // 画进度
        context.beginPath();

        context.moveTo(circleX, circleY);

        context.arc(circleX, circleY, circleR, -Math.PI / 2, Math.PI * (2 * (process - .005) / 100 - .5), false);
        context.closePath();
        context.fillStyle = '#fd6424';
        context.fill();

        // 画内部空白
        context.beginPath();
        context.moveTo(circleX, circleY);
        context.arc(circleX, circleY, circleR - 2, 0, Math.PI * 2, true);
        context.closePath();
        context.fillStyle = '#fff';
        context.fill();

        if (process != 100) {
            //终端原点
            context.beginPath();
            //移动到终端位置
            var x1 = circleX + (circleR - 1) * Math.sin(Math.PI * 2 * process / 100);
            var y1 = circleY - (circleR - 1) * Math.cos(Math.PI * 2 * process / 100);
            context.moveTo(x1, y1);
            context.arc(x1, y1, 3, 0, Math.PI * 2, true);
            context.closePath();
            context.fillStyle = '#fd6424';
            context.fill();
        }
    }
};
