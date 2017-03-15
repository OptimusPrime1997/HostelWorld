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
<jsp:include page="../part/navbar.jsp"/>
<div class="container">
    <%--<jps:include page="../part/navbar.jsp"/>--%>
    <div class="col-md-2 col-sm-2 col-lg-2" role="complementary">
        <nav class="bs-docs-sidebar hidden-print hidden-xs hidden-sm affix">
            <ul class="nav bs-docs-sidenav">
                <li class="active">
                    <a href="#individualInfo">个人信息</a>
                </li>
                <li>
                    <a href="#scoreExchange">积分兑换</a>
                </li>
                <li>
                    <a href="#chargeMoney">余额充值</a>
                </li>
            </ul>
        </nav>
    </div>

    <div class="col-md-10 col-lg-10 col-sm-10  pageBg">

        <div class="text-center">
            <h1>个人中心</h1>
        </div>
        <div class="row">
            <div class="box pageInnerBg">
                <div id="individualInfo" class="text-left">
                    <h2>个人信息</h2>
                </div>
                加注销按钮
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

            <div class="box pageInnerBg">
                <div id="scoreExchange" class="text-left">
                    <h2>积分兑换</h2>
                </div>
                积分兑换记录列表
            </div>
            <div class="box pageInnerBg">
                <div id="chargeMoney" class="text-left">
                    <h2>余额充值</h2>
                </div>
                当前显示，充值记录列表
            </div>
        </div>
    </div>
    <%--搜索框--%>
</div>
<!--container closed-->
</div>

<jsp:include page="../part/footer.jsp"/>
</html>




