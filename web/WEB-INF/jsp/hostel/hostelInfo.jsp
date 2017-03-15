<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<html lang="en"/>

<head>
    <jsp:include page="../part/meta.jsp"/>
    <title>旅馆之家</title>
    <!-- Custom CSS -->
    <link href='../../css/hostelworld.css' rel="stylesheet">
    <script src='../../js/jquery.js'></script>
</head>
<jsp:include page="../part/h_navbar.jsp"/>
<div class="container">
    <%--<jps:include page="../part/navbar.jsp"/>--%>
    <div class="col-md-2 col-sm-2 col-lg-2" role="complementary">
        <nav class="bs-docs-sidebar hidden-print hidden-xs hidden-sm affix">
            <ul class="nav bs-docs-sidenav">
                <li class="active">
                    <a href="#hostel_BaseInfo">基本信息</a>
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

                <div class="col-md-4 col-lg-4 col-sm-4">
                    <div class="text-center">
                        <%-- <img class="image150" src='../../img/day.png'>
                         <h4><span class="num"><?php echo $total_day;?></span> days in Healthier</h4>--%>
                    </div>
                </div>

                <div class="col-md-4 col-lg-4 col-sm-4">
                    <div class="text-center">
                        <%-- <img class="image150" src='../../img/run.png'>
                         <h4>Run　<span class="num"><?php echo $total_distance;?></span> m</h4>--%>
                    </div>
                </div>

                <div class="col-md-4 col-lg-4 col-sm-4">
                    <div class="text-center">

                    </div>
                </div>
            </div>
            <div id="checkSum" class="box pageInnerBg">
                <h2 class="text-left">入住统计</h2>
                入住统计-预订-柱状图和入住-柱状图在同一张图
            </div>
            <div id="incomeSum" class="box pageInnerBg">
                <h2 class="text-left">收入统计</h2>
                收入统计-日营业额折线图
            </div>
        </div>
    </div>

</div>
<!--container closed-->

<jsp:include page="../part/footer.jsp"/>
</html>


