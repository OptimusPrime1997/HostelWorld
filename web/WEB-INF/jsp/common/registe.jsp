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
                <form action="" method="post">
                    <div class="m_inline">
                        <span>&nbsp;&nbsp;注册类型：</span>
                    </div>
                    <%--<div class="btn-group m_inline" role="group" aria-label="类型">
                        <button type="button" class="btn btn-default">会员注册</button>
                        <button type="button" class="btn btn-default">酒店注册</button>
                    </div>
                    <div class="input-group">
                      <span class="input-group-addon">
                        <input type="radio" name="memberReg" aria-label="...">
                      </span>
                        <label class="btn btn-default disabled">会员注册</label>
                        <span class="input-group-addon">
                        <input type="radio" name="hostelReg" aria-label="...">
                      </span>
                        <label class="btn btn-default disabled">酒店注册</label>
                    </div>
--%>
                    <div class="form-group m_inline">
                        <label class="radio-inline">
                            <input type="radio" name="userType" value="1" checked>会员注册
                        </label>
                        <label class="radio-inline">
                            <input type="radio"  name="userType" value="2">酒店注册
                        </label>
                    </div>
                    <div class="blank10"></div>

                    <!-- /input-group -->
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</span>
                        <input name="name" type="text" class="form-control" placeholder="请输入名称">
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">电话号码</span>
                        <input name="phoneNum" type="text" class="form-control" placeholder="请输入电话号码">
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址</span>
                        <input name="address" type="text" class="form-control" placeholder="请输入地址">
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">银行卡号</span>
                        <input name="bankAccount" type="text" class="form-control" placeholder="请输入银行卡号">
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">身份证号</span>
                        <input name="id" type="text" class="form-control" placeholder="请输入身份证号">
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">输入密码</span>
                        <input type="password" name="passwordInput" class="form-control" placeholder="请输入密码">
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">确认密码</span>
                        <input type="password" class="form-control" placeholder="请再次输入密码">
                    </div>
                    <div class="blank20"></div>
                    <div>
                        <a href="#"
                           class="">忘记密码</a>
                        <div class="m_inline text-center col-center-block">
                            <button type="submit" class="m_center btn btn-success">注册</button>
                        </div>
                        <a href="<%=response.encodeURL(request.getContextPath()+"/LoginServlet")%>"
                           class="m_right non_dec">已有账号</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../part/footer.jsp"/>
</html>