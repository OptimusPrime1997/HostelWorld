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
<jsp:include page="../part/m_navbar.jsp"/>
<div class="container">
    <%--<jps:include page="../part/navbar.jsp"/>--%>
    <div class="col-md-2 col-sm-2 col-lg-2" role="complementary">

        <nav class="pageBg bs-docs-sidebar hidden-print hidden-xs hidden-sm affix">
            <ul class="nav bs-docs-sidenav">
                <li class="active">
                    <a href="#incomeSum">网站收入</a>
                </li>
                <li>
                    <a href="#hostelChecked">酒店入住</a>
                </li>
                <li>
                    <a href="#memberConsume">会员消费</a>
                </li>
            </ul>
        </nav>

    </div>

    <div class="col-md-10 col-lg-10 col-sm-10  pageBg">
        <div class="text-center">
            <h1>酒店信息</h1>
        </div>
        <div class="row">
            <div class="box pageInnerBg">
                <div id="incomeSum" class="text-left">
                    <h2>网站收入</h2>
                </div>
                <script>
                    <%
                        String userno=(String)request.getAttribute("userno");
                        String hostelno=(String)request.getAttribute("hostelno");
                         List<Order> allListe = (List<Order>) request.getAttribute("allList");
                    %>
                    var orderArr1 = new Array();
                    <%for (int i = 0, size = allListe.size(); i < size; i++) {%>
                    var sObj = {};
                    sObj.date = "<%=allListe.get(i).getStartTime().toString()%>";
                    sObj.value = "<%=allListe.get(i).getPay()%>";
                    orderArr1[<%=i%>] = sObj;
                    <%}%>
                </script>
                <%--后面填写数据--%>
                <span class="blank10"/>
                <div id="inComeLineChart" style="height:300px;padding:5px;">
                </div>
                <script>
                    var inComeLineChart = echarts.init(document.getElementById("inComeLineChart"));
                    var dateArr1 = getMyConsumeInfoArr(orderArr1, "date");
                    var valueArr1 = getMyConsumeInfoArr(orderArr1, "value");
                    option = {
                        title: {
                            text: '酒店日营业额统计图',
                            subtext: '最近数据'
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        legend: {
                            data: ['营业额']
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
                                formatter: '{value} 元'
                            }
                        },
                        series: [
                            {
                                name: '营业额',
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
                    inComeLineChart.setOption(option);
                </script>
            </div>
        </div>
        <div id="hostelChecked" class="box pageInnerBg">
            <h2 class="text-left">酒店入住</h2>
            <form action="<%=response.encodeURL(request.getContextPath()+"/ManageInfoServlet")%>" method="post">
                <div class="input-group">
                    <%--#为要查看的酒店hostelno--%>
                    <input type="text" name="queryHostelno" class="form-control" value="<%=hostelno%>"
                           placeholder="<%=hostelno%>">
                    <span class="input-group-btn">
                            <button class="btn btn-default btn-success" type="submit">
                                <span
                                        class="glyphicon glyphicon-check">查看酒店</span>
                            </button>
                         </span>
                </div>
            </form>
            <%--酒店营收额--%>
            <script>
                <%
                         List<Map.Entry<Date, Integer>> dayCheckedEntryList = (List<Map.Entry<Date, Integer>>) request.getAttribute("hostelList");
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
            <span class="blank10"/>
            <div id="dayCheckedChart" style="height:300px;padding:5px;">
            </div>
            <script>
                var inComeLineChart = echarts.init(document.getElementById("dayCheckedChart"));
                var dateArr2 = getMyConsumeInfoArr(orderArr2, "date");
                var valueArr2 = getMyConsumeInfoArr(orderArr2, "value");
                option = {
                    title: {
                        text: '酒店日入住人数统计图',
                        subtext: '最近数据'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data: ['入住人数']
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
                            formatter: '{value} 人'
                        }
                    },
                    series: [
                        {
                            name: '入住人数',
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
                inComeLineChart.setOption(option);
            </script>
        </div>
        <div id="memberConsume" class="box pageInnerBg">
            <h2 class="text-left">会员统计</h2>
            <%--#为要查看的会员userno--%>
            <form action="<%=response.encodeURL(request.getContextPath()+"/ManageInfoServlet")%>" method="post">
                <div class="input-group">
                    <input type="text" name="queryUserno" class="form-control" value="<%=userno%>"
                           placeholder="<%=userno%>">
                    <span class="input-group-btn">
                            <button class="btn btn-default btn-success" type="submit"><span
                                    class="glyphicon glyphicon-check">查看会员</span>
                            </button>
                         </span>
                </div>
            </form>
            <script>

                <%
                     List<Order> userList = (List<Order>) request.getAttribute("userList");
                %>
                var orderArr = new Array();
                <%for (int i = 0, size = userList.size(); i < size; i++) {%>
                var sObj = {};
                sObj.date = "<%=userList.get(i).getEndTime().toString()%>";
                sObj.value = "<%=userList.get(i).getPay()%>";
                orderArr[<%=i%>] = sObj;
                <%}%>
            </script>
            <%--后面填写数据--%>
            <span class="blank10"/>
            <div id="myConsumeLineChart" style="height:300px;padding:5px;">
            </div>
            <script>
                var myConsumeLineChart = echarts.init(document.getElementById("myConsumeLineChart"));
                var dateArr = getMyConsumeInfoArr(orderArr, "date");
                var valueArr = getMyConsumeInfoArr(orderArr, "value");
                option = {
                    title: {
                        text: '个人消费情况折线图',
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
                        data: dateArr
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
                            data: valueArr,
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
<jsp:include page="../part/footer.jsp"/>
</html>


