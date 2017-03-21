<%@ page import="java.util.List" %>
<%@ page import="com.nju.entity.Room" %>
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
            <nav class="pageBg bs-docs-sidebar hidden-print hidden-xs hidden-sm affix">
                <ul class="nav bs-docs-sidenav">
                    <li class="active">
                        <a href="#addRoom">新增房间</a>
                    </li>
                    <li>
                        <a href="#allRoom">所有房间</a>
                    </li>
                </ul>
            </nav>
    </div>

    <div class="col-md-10 col-lg-10 col-sm-10  pageBg">
        <div class="text-center">
            <h1>房间管理</h1>
        </div>
        <div class="row">
            <div class="box pageInnerBg">
                <div id="addRoom" class="text-left">
                    <h2>新增房间</h2>
                </div>
                <div id="addBtn" class="m_center">
                    <button class="btn btn-default btn-success">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true">添加房间</span>
                    </button>
                </div>
                <div id="addRoomTable" class="hidden">
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">房间编号</span>
                        <input name="roomno" type="text" class="form-control" palceholder="请输入房间编号">
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">房间类型</span>
                        <%--<input name="roomType" type="text" class="form-control" value="<%=u.getName()%>">--%>
                        <div class="form-group">
                            <select name="roomType" class="form-control">
                                <option value="1" selected>大床房</option>
                                <option value="2">标准间</option>
                            </select>
                        </div>
                    </div>
                    <div class="blank10"></div>
                    <div class="m_center">
                        <button id="saveBtn" class="btn btn-default btn-success">
                            <span class="glyphicon glyphicon-floppy-disk" aria-hidden="true">保存</span>
                        </button>
                    </div>
                </div>

                <%--保存的script--%>
                <script>
                    /*jQuery(function ($) {
                     //已有删除按钮初始化绑定删除事件
                     $(".underline-nav-item").click(function () {
                     if (!$(this).hasClass('.selected')) {
                     $('.underline-nav-item').attr('aria-selected', 'false')
                     $('.underline-nav-item').removeClass('selected');
                     $(this).attr('aria-selected', 'true');
                     $(this).addClass('selected');
                     var temp = $(this).attr('value');
                     $('.display-container').addClass('hidden');
                     //										alert(temp+" -- "+$('#'+temp).attr('id')+" is id");
                     $('#' + temp).removeClass('hidden');
                     }
                     });
                     });*/
                    jQuery(function ($) {
                        $('#addBtn').click(function () {
                            $('#addRoomTable').removeClass("hidden");
                            $('#addBtn').addClass('hidden');
                        });
                        $("#saveBtn").click(function () {
                            $('#addRoomTable').addClass("hidden");
                            $("#addBtn").removeClass('hidden');
                        });
                    });
                </script>
            </div>
            <div class="box pageInnerBg">
                <div id="allRoom" class="text-left">
                    <h2>所有房间</h2>
                </div>
                <%
                    List<Room> allRoom = (List<Room>) request.getAttribute("allRoom");
                    if (allRoom != null) {
                        for (int i = 0; i < allRoom.size(); i++) {
                            Room allR = allRoom.get(i);
                %>
                <form method="post" action="">
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">房间编号</span>
                        <input name="roomno" type="text" class="form-control" value="<%=allR.getHostelno()%>">
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">房间类型</span>
                        <%--<input name="roomType" type="text" class="form-control" value="<%=u.getName()%>">--%>
                        <div class="form-group">
                            <select name="roomType" class="form-control" value="<%=allR.getRoomType().getCode()%>">
                                <option value="1" selected>大床房</option>
                                <option value="2">标准间</option>
                            </select>
                        </div>
                    </div>
                    <div class="blank10"></div>
                    <div class="m_right">
                        <button class="btn btn-default btn-success m_inline">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true">修改</span>
                        </button>
                        <button class="btn btn-default btn-warning m_inline">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true">删除</span>
                        </button>
                    </div>
                    <div class="blank20"></div>
                </form>
                <%
                        }
                    }
                %>
                <%--保存的script--%>
                <script>
                </script>
            </div>
        </div>
    </div>

</div>
<!--container closed-->

<jsp:include page="../part/footer.jsp"/>
</html>


