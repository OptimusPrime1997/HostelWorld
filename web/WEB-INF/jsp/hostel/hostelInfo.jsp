<%@ page import="com.nju.entity.User" %>
<%@ page import="com.nju.entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.Map" %>
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
<jsp:include page="../part/h_navbar.jsp"/>
<div class="container">
    <%--<jps:include page="../part/navbar.jsp"/>--%>
    <div class="col-md-2 col-sm-2 col-lg-2" role="complementary">
        <nav class="pageBg bs-docs-sidebar hidden-print hidden-xs hidden-sm affix">
            <ul class="nav bs-docs-sidenav">
                <li class="active">
                    <a href="#hostel_BaseInfo">基本信息</a>
                </li>
                <li>
                    <a href="#reservedSum">预定统计</a>
                </li>
                <li>
                    <a href="#checkSum">入住统计</a>
                </li>
                <li>
                    <a href="#incomeSum">收入统计</a>
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
                <div id="hostel_BaseInfo" class="text-left">
                    <h2>基本信息</h2>
                </div>
                <%User u = (User) session.getAttribute("user");%>
                <form id="infoTable" action="<%=response.encodeURL(request.getContextPath()+"/HostelModifyServlet")%>"
                      method="post">
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">酒店账号</span>
                        <input name="userno" type="text" class="form-control" disabled="disabled"
                               value="<%=u.getUserno()%>">
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">酒店名称</span>
                        <input name="name" type="text" class="form-control" value="<%=u.getName()%>">
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">电话号码</span>
                        <input name="phoneNum" type="text" class="form-control" value="<%=u.getPhoneNum()%>">
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">酒店地址</span>
                        <input name="address" type="text" class="form-control" value="<%=u.getAddress()%>">
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">银行卡号</span>
                        <input name="bankAccount" type="text" class="form-control" value="<%=u.getBankAccount()%>">
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">身份证号</span>
                        <input name="id" type="text" class="form-control" disabled="disabled" value="<%=u.getId()%>">
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">可用余额</span>
                        <input name="balance" type="text" class="form-control" disabled="disabled"
                               value="<%=u.getBalance()%>">
                    </div>
                    <div class="blank10"></div>
                    <div class="m_center">
                        <button class="btn btn-default btn-success">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true">修改</span>
                        </button>
                    </div>
                </form>
                <%--保存的script--%>
                <%--暂不考虑多天入住的情况--%>
                <%--预定+入住+退房  日期为开始日期--%>
            </div>
            <div id="reservedSum" class="box pageInnerBg">
                <h2 class="text-left">预定统计</h2>
                <%--入住统计-预订-柱状图和入住入住-柱状图在同一张图--%>
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
                <div id="reservedLineChart" style="height:300px;padding:5px;">
                </div>
                <script>
                    var reservedLineChart = echarts.init(document.getElementById("reservedLineChart"));
                    var dateArr1 = getMyConsumeInfoArr(orderArr1, "date");
                    var valueArr1 = getMyConsumeInfoArr(orderArr1, "value");
                    option = {
                        title: {
                            text: '酒店预定情况统计图',
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
                    reservedLineChart.setOption(option);
                </script>
            </div>
            <%--入住+退房 日期为开始日期 --%>
            <div id="checkSum" class="box pageInnerBg">
                <h2 class="text-left">入住统计</h2>
                <%--入住统计-预订-柱状图和入住-柱状图在同一张图--%>
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
                <div id="checkedLineChart" style="height:300px;padding:5px;">
                </div>
                <script>
                    var checkedLineChart = echarts.init(document.getElementById("checkedLineChart"));
                    var dateArr2 = getMyConsumeInfoArr(orderArr2, "date");
                    var valueArr2 = getMyConsumeInfoArr(orderArr2, "value");
                    option = {
                        title: {
                            text: '酒店入住情况统计图',
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
                    checkedLineChart.setOption(option);
                </script>
            </div>
            <div id="incomeSum" class="box pageInnerBg">
                <h2 class="text-left">收入统计</h2>
                <%--收入统计-日营业额折线图--%>
                <script>
                    <%
                         List<Order> inComeList = (List<Order>) request.getAttribute("inComeList");
                    %>
                    var orderArr3 = new Array();
                    <%for (int i = 0, size = inComeList.size(); i < size; i++) {%>
                    var sObj = {};
                    sObj.date = "<%=inComeList.get(i).getStartTime().toString()%>";
                    sObj.value = "<%=inComeList.get(i).getPay()%>";
                    orderArr3[<%=i%>] = sObj;
                    <%}%>
                </script>
                <%--后面填写数据--%>
                <div id="inComeLineChart" style="height:300px;padding:5px;">
                </div>
                <script>
                    var inComeLineChart = echarts.init(document.getElementById("inComeLineChart"));
                    var dateArr3 = getMyConsumeInfoArr(orderArr3, "date");
                    var valueArr3 = getMyConsumeInfoArr(orderArr3, "value");
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
                                name: '营业额',
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
                    inComeLineChart.setOption(option);
                </script>
            </div>
        </div>
    </div>

</div>
<!--container closed-->
</div>
<jsp:include page="../part/footer.jsp"/>
</html>


