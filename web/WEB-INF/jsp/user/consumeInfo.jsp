<%@ page import="com.nju.entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.sql.Date" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<html lang="en"/>

<head>
    <jsp:include page="../part/meta.jsp"/>
    <title>旅馆之家</title>
    <!-- Custom CSS -->
    <link href='../../css/hostelworld.css' rel="stylesheet">
    <script src='../../js/jquery.js'></script>
    <script src='../../js/echarts.min.js'></script>
    <script src='../../js/mychart.js'></script>

</head>
<jsp:include page="../part/navbar.jsp"/>
<div class="container">
    <%--<jps:include page="../part/navbar.jsp"/>--%>
    <div class="col-md-2 col-sm-2 col-lg-2" role="complementary">
            <nav class="pageBg bs-docs-sidebar hidden-print hidden-xs hidden-sm affix">
                <ul class="nav bs-docs-sidenav">
                    <li class="active">
                        <a href="#myReserved">我的预定</a>
                    </li>
                    <li>
                        <a href="#myChecked">我的入住</a>
                    </li>
                    <li>
                        <a href="#myConsume">我的消费</a>
                    </li>
                </ul>
            </nav>
    </div>

    <div class="col-md-10 col-lg-10 col-sm-10  pageBg">

        <div class="text-center">
            <h1>消费信息</h1>
        </div>
        <div class="row">
            <div class="box pageInnerBg">
                <div id="myReserved" class="text-left">
                    <h2>我的预定</h2>
                </div>
                <script>
                    <%
                         List<Map.Entry<Date, Integer>> dayResersvedEntryList = (List<Map.Entry<Date, Integer>>) request.getAttribute("dayReservedMap");
                    %>
                    var orderArr1 = new Array();
                    <%for (int i = 0, size = dayResersvedEntryList.size(); i < size; i++) {%>
                    var sObj = {};
                    sObj.date = "<%=dayResersvedEntryList.get(i).getKey().toString()%>";
                    sObj.value = "<%=dayResersvedEntryList.get(i).getValue()%>";
                    orderArr1[<%=i%>] = sObj;
                    <%}%>
                </script>
                <%--后面填写数据--%>
                <div id="myReservedLineChart" style="height:300px;padding:5px;">
                </div>
                <script>
                    var myReservedLineChart = echarts.init(document.getElementById("myReservedLineChart"));
                    var dateArr1 = getMyConsumeInfoArr(orderArr1, "date");
                    var valueArr1 = getMyConsumeInfoArr(orderArr1, "value");
                    option = {
                        title: {
                            text: '我的预定情况折线图',
                            subtext: '最近数据'
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        legend: {
                            data: ['预定量']
                        },
                        toolbox: {
                            show: true,
                            feature: {
                                /*dataZoom: {
                                 yAxisIndex: 'none'
                                 },*/
                                /*dataView: {readOnly: false},*/
                                magicType: {type: ['line', 'bar']}
                                /*restore: {},
                                 saveAsImage: {}*/
                            }
                        },
                        xAxis: {
                            type: 'category',
                            boundaryGap: false,
                            data: dateArr1
                        },
                        yAxis: {
                            type: 'value',
                            axisLabel: {
                                formatter: '{value} 个'
                            }
                        },
                        series: [
                            {
                                name: '预定量',
                                type: 'line',
                                data: valueArr1,
                                markPoint: {
                                    data: [
                                        {type: 'max', name: '最大值'},
                                        {type: 'min', name: '最小值'}
                                    ]
                                },
                                markLine: {
                                    data: [
                                        {type: 'average', name: '平均值'}
                                    ]
                                }
                            }
                        ]
                    };
                    myReservedLineChart.setOption(option);
                </script>
            </div>

            <div class="box pageInnerBg">
                <div id="myChecked" class="text-left">
                    <h2>我的入住</h2>
                </div>
                <script>
                    <%
                         List<Map.Entry<Date, Integer>> dayCheckedEntryList = (List<Map.Entry<Date, Integer>>) request.getAttribute("dayCheckedMap");
                    %>
                    var orderArr2 = new Array();
                    <%for (int i = 0, size = dayCheckedEntryList.size(); i < size; i++) {%>
                    var sObj = {};
                    sObj.date = "<%=dayCheckedEntryList.get(i).getKey().toString()%>";
                    sObj.value = "<%=dayCheckedEntryList.get(i).getValue()%>";
                    orderArr2[<%=i%>] = sObj;
                    <%}%>

                </script>
                <%--后面填写数据--%>
                <div id="myCheckedLineChart" style="height:300px;padding:5px;">
                </div>
                <script>
                    var myCheckedLineChart = echarts.init(document.getElementById("myCheckedLineChart"));
                    var dateArr2 = getMyConsumeInfoArr(orderArr2, "date");
                    var valueArr2 = getMyConsumeInfoArr(orderArr2, "value");
                    option = {
                        title: {
                            text: '我的入住情况折线图',
                            subtext: '最近数据'
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        legend: {
                            data: ['入住量']
                        },
                        toolbox: {
                            show: true,
                            feature: {
                                /*dataZoom: {
                                 yAxisIndex: 'none'
                                 },*/
                                /*dataView: {readOnly: false},*/
                                magicType: {type: ['line', 'bar']}
                                /*restore: {},
                                 saveAsImage: {}*/
                            }
                        },
                        xAxis: {
                            type: 'category',
                            boundaryGap: false,
                            data: dateArr2
                        },
                        yAxis: {
                            type: 'value',
                            axisLabel: {
                                formatter: '{value} 个'
                            }
                        },
                        series: [
                            {
                                name: '入住量',
                                type: 'line',
                                data: valueArr2,
                                markPoint: {
                                    data: [
                                        {type: 'max', name: '最大值'},
                                        {type: 'min', name: '最小值'}
                                    ]
                                },
                                markLine: {
                                    data: [
                                        {type: 'average', name: '平均值'}
                                    ]
                                }
                            }
                        ]
                    };
                    myCheckedLineChart.setOption(option);
                </script>
            </div>

            <div class="box pageInnerBg">
                <div id="myConsume" class="text-left">
                    <h2>我的消费</h2>
                </div>
                <script>
                    <%
                         List<Order> userList = (List<Order>) request.getAttribute("myConsumeList");
                    %>
                    var orderArr3 = new Array();
                    <%for (int i = 0, size = userList.size(); i < size; i++) {%>
                    var sObj = {};
                    sObj.date = "<%=userList.get(i).getEndTime().toString()%>";
                    sObj.value = "<%=userList.get(i).getPay()%>";
                    orderArr3[<%=i%>] = sObj;
                    <%}%>
                </script>
                <%--后面填写数据--%>
                <div id="myConsumeLineChart" style="height:300px;padding:5px;">
                </div>
                <script>
                    var myConsumeLineChart = echarts.init(document.getElementById("myConsumeLineChart"));
                    var dateArr3 = getMyConsumeInfoArr(orderArr3, "date");
                    var valueArr3 = getMyConsumeInfoArr(orderArr3, "value");
                    option = {
                        title: {
                            text: '我的消费情况折线图',
                            subtext: '最近数据'
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        legend: {
                            data: ['消费金额']
                        },
                        toolbox: {
                            show: true,
                            feature: {
                                /*dataZoom: {
                                 yAxisIndex: 'none'
                                 },*/
                                /*dataView: {readOnly: false},*/
                                magicType: {type: ['line', 'bar']}
                                /*restore: {},
                                 saveAsImage: {}*/
                            }
                        },
                        xAxis: {
                            type: 'category',
                            boundaryGap: false,
                            data: dateArr3
                        },
                        yAxis: {
                            type: 'value',
                            axisLabel: {
                                formatter: '{value} 元'
                            }
                        },
                        series: [
                            {
                                name: '消费金额',
                                type: 'line',
                                data: valueArr3,
                                markPoint: {
                                    data: [
                                        {type: 'max', name: '最大值'},
                                        {type: 'min', name: '最小值'}
                                    ]
                                },
                                markLine: {
                                    data: [
                                        {type: 'average', name: '平均值'}
                                    ]
                                }
                            }
                        ]
                    };
                    myConsumeLineChart.setOption(option);
                </script>
            </div>

        </div>
    </div>

</div>
<!--container closed-->

<jsp:include page="../part/footer.jsp"/>
</html>


