<%@ page import="com.nju.entity.User" %>
<%@ page import="com.nju.util.Constant" %>
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
            <nav class="pageBg bs-docs-sidebar hidden-print hidden-xs hidden-sm affix">
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
                <%User u = (User) session.getAttribute("user");%>
                <form action="<%=response.encodeURL(request.getContextPath()+"/ModifyServlet")%>" method="post">
                    <div id="infoTable">
                        <div class="input-group input-group-lg input-group-md input-group-sm">
                            <span class="input-group-addon">用户账号</span>
                            <input name="userno" type="text" class="form-control" disabled="disabled"
                                   value="<%=u.getUserno()%>">
                        </div>
                        <div class="blank10"></div>
                        <div class="input-group input-group-lg input-group-md input-group-sm">
                            <span class="input-group-addon">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</span>
                            <input name="name" type="text" class="form-control" value="<%=u.getName()%>">
                        </div>
                        <div class="blank10"></div>
                        <div class="input-group input-group-lg input-group-md input-group-sm">
                            <span class="input-group-addon">电话号码</span>
                            <input name="phoneNum" type="text" class="form-control" value="<%=u.getPhoneNum()%>">
                        </div>
                        <div class="blank10"></div>
                        <div class="input-group input-group-lg input-group-md input-group-sm">
                            <span class="input-group-addon">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址</span>
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
                            <input name="id" type="text" class="form-control" value="<%=u.getId()%>">
                        </div>
                        <div class="blank10"></div>
                        <div class="input-group input-group-lg input-group-md input-group-sm">
                            <span class="input-group-addon">账户余额</span>
                            <input name="balance" type="text" class="form-control" disabled="disabled"
                                   value="<%=u.getBalance()%>">
                        </div>
                        <div class="blank10"></div>
                        <div class="input-group input-group-lg input-group-md input-group-sm">
                            <span class="input-group-addon">账户类型</span>
                            <input name="usetType" type="text" class="form-control disabled" disabled="disabled"
                                   value="<%=Constant.getUserType(u.getUserType())%>">
                        </div>
                        <div class="blank10"></div>
                        <div class="input-group input-group-lg input-group-md input-group-sm">
                            <span class="input-group-addon">账户状态</span>
                            <input name="userState" type="text" class="form-control disabled" disabled="disabled"
                                   value="<%=u.getState().getStr()%>">
                        </div>
                        <div class="blank20"></div>
                        <div class="m_center">
                            <button type="submit" class="btn btn-default btn-success">
                                <span class="glyphicon glyphicon-floppy-disk" aria-hidden="true">保存</span>
                            </button>
                        </div>
                    </div>
                </form>
                <%--未完成script代码，后面再写--%>
                <script>
                </script>

                <div class="blank20"></div>

                <%--需要确定该按钮的调整--%>
                <a href="<%=response.encodeURL(request.getContextPath()+"/LogoutServlet")%>">
                    <button type="button" class="btn btn-default btn-warning" id="loginBt">
                        <span class="glyphicon glyphicon-log-out"></span>
                        注销账户
                    </button>
                </a>
            </div>

            <div class="box pageInnerBg">
                <div id="scoreExchange" class="text-left">
                    <h2>积分兑换</h2>
                </div>
                <div class="blank10"></div>
                <form action="<%=response.encodeURL(request.getContextPath()+"/ExchangeServlet")%>" method="post">
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">当前积分</span>
                        <input name="score" type="text" class="form-control" value="<%=u.getScore()%>">
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">兑换比例</span>
                        <input name="changeRatio" type="text" class="form-control" disabled="disabled" value="0.1" %>
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">当前余额</span>
                        <input name="balance" type="text" class="form-control" value="<%=u.getBalance()%>">
                    </div>
                    <div class="blank10"></div>
                    <div class="m_center">
                        <button class="btn btn-default btn-success">
                            <span class="glyphicon glyphicon-jpy" aria-hidden="true">全部兑换</span>
                        </button>
                    </div>
                </form>
            </div>
            <div class="box pageInnerBg">
                <div id="chargeMoney" class="text-left">
                    <h2>余额充值</h2>
                </div>
                <div class="blank10"></div>
                <form action="<%=response.encodeURL(request.getContextPath()+"/ChargeServlet")%>" method="post">
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">充值金额</span>
                        <input name="chargeAmount" type="text" class="form-control" value="1000" placeholder="1000">
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">支付卡号</span>
                        <input name="bankAccount" type="text" class="form-control" disabled="disabled"
                               value="<%=u.getBankAccount()%>">
                    </div>
                    <div class="blank10"></div>
                    <div class="m_center">
                        <button type="submit" class="btn btn-default btn-success">
                            <span class="glyphicon glyphicon-piggy-bank" aria-hidden="true">立即充值</span>
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%--搜索框--%>
</div>
<!--container closed-->
</div>

<jsp:include page="../part/footer.jsp"/>
</html>




