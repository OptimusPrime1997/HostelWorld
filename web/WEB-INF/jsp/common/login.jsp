<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<html lang="en">

<head>
    <jsp:include page="../part/meta.jsp"/>
    <title>旅馆之家</title>

    <!-- Custom CSS -->
    <link href='../../css/hostelworld.css' rel="stylesheet">
    <link href='../../css/sport.css' rel="stylesheet">
    <script src='../../js/jquery.js'></script>

</head>

<jsp:include page="../part/i_navbar.jsp"/>

<div class="container">
    <div class="col-md-6 col-lg-6 col-md-offset-3 col-lg-offset-3">
        <div class="row pageBg">
            <div class="box pageBg">
                <form action="<%=response.encodeURL(request.getContextPath()+"/LoginServlet")%>" method="post">
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon">账号</span>
                        <input type="text" name="userno" id="Userno" class="form-control"
                               placeholder="请输入您的账号">
                    </div>
                    <div class="blank40"></div>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon">密码</span>
                        <input type="password" name="password" class="form-control" placeholder="请输入您的密码">
                    </div>
                    <div class="blank20"></div>
                    <div class="row  m_inline">
                        <div class="col-md-2 col-lg-2 col-md-offset-2 col-lg-offset-2 m_inline m_left m_margin-left0">
                            <a href="#" class="m_inline ">忘记密码</a>
                        </div>
                        <div class="col-md-2 col-lg-2 col-md-offset-2 col-lg-offset-2 m_inline text-center">

                            <button type="submit" class="btn btn-success" id="submitBt" onsubmit="testUsername()">
                                <span class="glyphicon glyphicon-log-in"></span> 登录
                            </button>
                        </div>
                        <div class="col-md-2 col-lg-2 col-md-offset-2 col-lg-offset-2 m_right">
                            <a href='<%=response.encodeURL(request.getContextPath()+"/RegisteServlet")%>'
                               class="m_right non_dec">去注册</a>
                        </div>
                    </div>
                </form>
                <script>
                    function testUsername() {
                        var name = $('#Userno').val();
                        var expr=/^[a-zA-Z0-9]+$/;
                        if(expr.test(name)==null){
                            alert(expr.test(name));
                            return false;
                        }else{
                            return true;
                        }
//                        var reg = new RegExp('[0-9]', 'g');
//                        if (reg.exec(name) == null) {
//                            return true;
//                        } else {
//                            alert('用户名中只能使字母');
//                            return false;
//                        }
                    }
                    jQuery(function ($) {
                        $('#submitBt').click(testUsername);
                    });
                </script>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../part/footer.jsp"/>
</html>