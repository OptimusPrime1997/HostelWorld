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
<jsp:include page="../part/m_navbar.jsp"/>
<div class="container">
    <%--<jps:include page="../part/navbar.jsp"/>--%>
    <div class="col-md-2 col-sm-2 col-lg-2" role="complementary">
        <nav class="bs-docs-sidebar hidden-print hidden-xs hidden-sm affix">
            <ul class="nav bs-docs-sidenav">
                <li class="active">
                    <a href="#incomeSum">营收统计</a>
                </li>
                <li>
                    <a href="#orderSum">订单统计</a>
                </li>
                <li>
                    <a href="#hostelRank">酒店排行</a>
                </li>
                <li>
                    <a href="#memberRank">会员排行</a>
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
                    <h2>营收统计</h2>
                </div>
                    日营业额柱状图
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
            <div id="orderSum" class="box pageInnerBg">
                <h2 class="text-left">订单统计</h2>
                入住统计-预订-柱状图和入住-柱状图在同一张图
            </div>
            <div id="hostelRank" class="box pageInnerBg">
                <h2 class="text-left">酒店排行</h2>
                酒店营收额排行前十
            </div>
            <div id="memberRank" class="box pageInnerBg">
                <h2 class="text-left">会员排行</h2>
                会员消费额排行前十
            </div>
        </div>
    </div>

</div>
<jsp:include page="../part/footer.jsp"/>
</html>


