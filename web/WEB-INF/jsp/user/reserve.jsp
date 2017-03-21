<%@ page import="com.nju.entity.Roomdisplay" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<html lang="en"/>

<head>

    <title>旅馆之家</title>
    <!-- Custom CSS -->
    <link href="../../css/github-css1.css" rel="stylesheet">
    <link href="../../css/github-css2.css" rel="stylesheet">
    <link href='../../css/hostelworld.css' rel="stylesheet">
    <link href="../../css/bootstrap-datetimepicker.min.css" rel="stylesheet">

    <script src='../../js/jquery.js'></script>
    <%--<script src='../../js/docs.min.js'></script>--%>
    <script src='../../js/bootstrap.min.js'></script>
    <script src='../../js/jquery.datetimepicker.js'></script>

    <jsp:include page="../part/meta.jsp"/>
</head>
<jsp:include page="../part/navbar.jsp"/>
<div class="container">
    <%--搜索框--%>
    <div class="col-md-2 col-sm-2 col-lg-2" role="complementary">

        <nav class="pageBg bs-docs-sidebar hidden-print hidden-xs hidden-sm affix">
                <ul class="nav bs-docs-sidenav">
                    <li class="active">
                        <a href="#timeChooser">选择时间</a>
                    </li>
                    <li>
                        <a href="#hostelDetail">酒店详情</a>
                    </li>
                </ul>
        </nav>
    </div>
    <div class="col-md-10 col-lg-10 col-sm-10  pageBg">
        <div class="text-center">
            <h1>酒店预订</h1>
        </div>
        <div class="row">
            <div class="box pageInnerBg">
                <div id="timeChooser" class="text-left">
                    <h2>选择时间</h2>
                </div>
                <form action="<%=response.encodeURL(request.getContextPath()+"/ReserveServlet")%>" method="post">
                    <div class="m_inline">
                        <div class="col-md-3 col-lg-3">
                            <!--<input type="text" class="form_control m_inline"
                                   placeholder="2016-10-01 00:00:00">-->
                            <div class="input-append date form_datetime m_left">
                                <input id="start_time" size="16" type="text" name="Start" data-date="2017-03-21"
                                       value="2017-03-21" >
                                <span class="add-on"><i class="icon-remove"></i></span>
                                <span class="add-on"><i class="icon-calendar"></i></span>
                            </div>
                        </div>
                        <div class="col-md-1 col-lg-1">
                            <span>至</span>
                        </div>
                        <div class="col-md-3 col-lg-3">
                            <div class="input-append date form_datetime m_left">
                                <input id="end_time" size="16" type="text" name="End" data-date="2018-03-22"
                                       value="2017-03-22" >
                                <span class="add-on"><i class="icon-remove"></i></span>
                                <span class="add-on"><i class="icon-calendar"></i></span>
                            </div>
                        </div>
                        <div class="col-md-3 col-lg-3">
                            <div>
                                <buttn type="submit" class="btn btn-default btn-success">
                                    <span class="glyphicon glyphicon-search"></span>查找
                                </buttn>
                            </div>
                        </div>
                    </div>
                </form>
                <script type="text/javascript">
                    $(".form_datetime").datetimepicker({
                        format: "yyyy-mm-dd",
                        autoclose: true,
                        todayBtn: false,
                        minView: 'month',
                        viewSelect: 'month',
                        showMeridian: 'month',
                        pickerPosition: "bottom-left",
                        todayHighlight: true
                    });
                </script>
            </div>
            <%--</div>
            <div class="row">--%>
            <%--<h2 id="glyphicons-glyphs"></h2>--%>
            <div class="box pageInnerBg">
                <%--<div class="row">--%>
                <h2 id="hostelDetail" class="text-left">酒店详情</h2>
                <div class="user-profile-nav js-sticky top-0">
                    <nav class="underline-nav" data-pjax role="navigation">
                        <a href="#"
                           class="underline-nav-item selected"
                           aria-selected="true"
                           role="tab"
                           value="availableRoom">
                            可用房间
                            <span class="counter">
          </span>
                        </a>
                    </nav>
                </div>
                <script>
                    jQuery(function ($) {
                        $(".reserveBtn").click(function () {
                            if ($(this).click(1)) {
//                                alert($(this).attr("title"));
                                $.ajax({
                                    url: 'MyReserveServlet',
                                    data: {
                                        Hostelno: $(this).attr("title"),
                                        Roomno: $(this).attr("value"),
                                        Start:$("#start_time").val(),
                                        End:$("#end_time").val()
                                    },
                                    success: function (responseText) {
//                                        $(this).addClass('hidden');
//                                        $(this).attr('disabled','disabled');
//                                        $(this).addClass("btn-warning");
//                                            $("#"+$(this).attr("title")+$(this).attr("value")).addClass("hidden");
                                        alert("成功预定" + responseText + "房间");
                                        $.post('ReserveServlet');

                                    },
                                    error: function () {
                                        alert("reserve失败");
                                    }
                                })
                            }
                        })
                    });
                </script>
                <div class="display-container" id="availableRoom">
                    <%
                        List<Roomdisplay> rdList = (List<Roomdisplay>) request.getAttribute("roomdisplayList");
                        for (int i = 0; i < rdList.size(); i++) {
                            Roomdisplay rd = rdList.get(i);
                    %>
                    <div class="d-table col-12 width-full py-4 border-bottom border-gray-light">
                        <div class="d-table-cell col-1 v-align-top">
                            <a href="/14dtj"><img alt="###"
                                                  class="avatar"
                                                  height="50"
                                                  src="../../img/logo.png"
                                                  width="50"/></a>
                        </div>
                        <div class="d-table-cell col-9 v-align-top pr-3">
                            <a href="/14dtj" class="d-inline-block no-underline mb-1">
                                <span class="f4 link-gray-dark"><%=rd.getHostelname()%></span>
                                <span class="link-gray pl-1"><%=rd.getHostelno()%></span>
                            </a>
                            <p class="text-gray text-small"><%=rd.getRoomType().getStr()%>
                            </p>

                            <p class="text-gray text-small mb-0">
										<span class="mr-3">
										  <svg aria-hidden="true" class="octicon octicon-organization" height="16"
                                               version="1.1"
                                               viewBox="0 0 16 16"
                                               width="16"><path fill-rule="evenodd"
                                                                d="M16 12.999c0 .439-.45 1-1 1H7.995c-.539 0-.994-.447-.995-.999H1c-.54 0-1-.561-1-1 0-2.634 3-4 3-4s.229-.409 0-1c-.841-.621-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.442.58 2.5 3c.058 2.41-.159 2.379-1 3-.229.59 0 1 0 1s1.549.711 2.42 2.088C9.196 9.369 10 8.999 10 8.999s.229-.409 0-1c-.841-.62-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.437.581 2.495 3c.059 2.41-.158 2.38-1 3-.229.59 0 1 0 1s3.005 1.366 3.005 4"/>
										  </svg>
                                            <%=rd.getRoomno()%>
										</span>
                                <svg aria-hidden="true" class="octicon octicon-location" height="16"
                                     version="1.1"
                                     viewBox="0 0 12 16" width="12">
                                    <path fill-rule="evenodd"
                                          d="M6 0C2.69 0 0 2.5 0 5.5 0 10.02 6 16 6 16s6-5.98 6-10.5C12 2.5 9.31 0 6 0zm0 14.55C4.14 12.52 1 8.44 1 5.5 1 3.02 3.25 1 6 1c1.34 0 2.61.48 3.56 1.36.92.86 1.44 1.97 1.44 3.14 0 2.94-3.14 7.02-5 9.05zM8 5.5c0 1.11-.89 2-2 2-1.11 0-2-.89-2-2 0-1.11.89-2 2-2 1.11 0 2 .89 2 2z"/>
                                </svg>
                                <%=rd.getAddress()%>
                            </p>
                        </div>
                        <div class="d-table-cell col-2 v-align-top text-right">
						<span class="user-following-container js-toggler-container js-social-container on">
                            <span class="unfollow">
                                <div>
                                    <div
                                            style="margin:0;padding:0;display:inline">
								  </div>
							  <button
                                      class="btn btn-sm  js-toggler-target reserveBtn"
                                      aria-label="Follow this person" title="<%=rd.getHostelno()%>"
                                      value="<%=rd.getRoomno()%>">
								预定
							  </button>
							  </div>
						  </span>
					    </span>
                        </div>
                    </div>
                    <%}%>
                    <%--//                        jQuery(function ($) {--%>
                    <%--//                            //已有删除按钮初始化绑定删除事件--%>
                    <%--//                            $(".underline-nav-item").click(function () {--%>
                    <%--//                                if (!$(this).hasClass('.selected')) {--%>
                    <%--//                                    $('.underline-nav-item').attr('aria-selected', 'false')--%>
                    <%--//                                    $('.underline-nav-item').removeClass('selected');--%>
                    <%--//                                    $(this).attr('aria-selected', 'true');--%>
                    <%--//                                    $(this).addClass('selected');--%>
                    <%--//                                    var temp = $(this).attr('value');--%>
                    <%--//                                    $('.display-container').addClass('hidden');--%>
                    <%--////										alert(temp+" -- "+$('#'+temp).attr('id')+" is id");--%>
                    <%--//                                    $('#' + temp).removeClass('hidden');--%>
                    <%--//                                }--%>
                    <%--//                            });--%>
                    <%--//                        });--%>

                    <%-- //                          $(".reserveBtn").click(function(){
                     //                              $.ajax({
                     //                                  url : 'reserveServlet',
                     //                                  data : {
                     //                                      HostelRoom : $(this).val()
                     //                                  },
                     //                                  success : function(responseText) {
                     //                                      alert("成功预定"+responseText+"房间");
                     //                                      $(this).addClass("disabled");
                     //                                  }
                     //                              });
                     //                          });
                     //                          });
--%>
                    <%--  </c:forEach>--%>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../part/footer.jsp"/>
</html>


