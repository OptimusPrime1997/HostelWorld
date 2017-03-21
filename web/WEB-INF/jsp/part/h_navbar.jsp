<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<body>
<a href="#" class="brand non_dec"><span>
    <img class="logo" src='../../img/logo.png'>
</span><span class="title-font-size">旅馆之家</span></a>


<!-- Navigation -->
<nav class="navbar navbar-defalut" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <!--<button type="button" class="logo-graph">
                <span class="icon-bar" ></span>
                <image class="logo" src="../img/logo.png"></image>
            </button>-->
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
            <a class="navbar-brand brand" href="#"><span>
    <img class="logo" src="../../img/logo.png">
</span>旅馆之家</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav addMargin">
                <li>
                    <a href="<%=response.encodeURL(request.getContextPath()+"/HostelManageServlet")%>">酒店管理</a>
                </li>
                <li>
                    <a href="<%=response.encodeURL(request.getContextPath()+"/HostelPlanServlet")%>">经营计划</a>
                </li>
               <%-- <li>
                    <a href="<%=response.encodeURL(request.getContextPath()+"/HostelRoomServlet")%>">房间管理</a>
                </li>--%>
                <li>
                    <a href="<%=response.encodeURL(request.getContextPath()+"/HostelInfoServlet")%>">酒店信息</a>
                </li>
              <%--  <li>
                    <a href="#">个人中心</a>
                </li>--%>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="<%=response.encodeURL(request.getContextPath()+"/LogoutServlet")%>">
                        <button type="button" class="btn btn-success" id="loginBt">
                            <span class="glyphicon glyphicon-log-in"></span>
                            登出
                        </button>
                    </a>

                </li>
                <%--<li class="m_inline">--%>
                    <%--<a href="#">--%>
                        <%--<button type="button" class="btn btn-success" id="registeBt">--%>
                            <%--<span class="glyphicon glyphicon-triangle-right"></span>--%>
                            <%--注册--%>
                        <%--</button>--%>
                    <%--</a>--%>
                <%--</li>--%>
            </ul>

        </div>
    </div>
</nav>
