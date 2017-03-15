<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<html lang="en">

<head>

    <jsp:include page="../part/meta.jsp"/>

    <title>旅馆之家</title>

    <!-- Custom CSS -->
    <link href='../../css/hostelworld.css' rel="stylesheet">
    <link href='../../css/sport.css' rel="stylesheet">


</head>

<jsp:include page="../part/i_navbar.jsp"/>
<div class="container">
    <div class="col-md-6 col-lg-6 col-md-offset-3 col-lg-offset-3 ">
        <div class="row pageBg">
            <div class="box pageInnerBg">
                <div class="input-group input-group-lg">
                    <span class="input-group-addon">身份证号</span>
                    <input type="text" class="form-control" placeholder="请输入您的身份证号">
                </div>
                <div class="blank10"></div>
                <div class="input-group input-group-lg">
                    <span class="input-group-addon">输入密码</span>
                    <input type="text" class="form-control" placeholder="请输入您的密码">
                </div>
                <div class="blank10"></div>
                <div class="input-group input-group-lg">
                    <span class="input-group-addon">确认密码</span>
                    <input type="text" class="form-control" placeholder="请再次输入密码">
                </div>
                <div class="blank20"></div>
                <div>
                    <a href="<%=response.encodeURL(request.getContextPath()+"/LoginServlet")%>"
                       class="m_inline">已有账号</a>
                    <a href="login_c" class="m_right non_dec">注册账号</a>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../part/footer.jsp"/>
</html>