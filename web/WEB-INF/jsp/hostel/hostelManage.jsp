<%@ page import="com.nju.entity.Order" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<html lang="en"/>

<head>
    <link href="../../css/github-css1.css" rel="stylesheet">
    <link href="../../css/github-css2.css" rel="stylesheet">
    <jsp:include page="../part/meta.jsp"/>
    <title>旅馆之家</title>
    <!-- Custom CSS -->
    <link href='../../css/hostelworld.css' rel="stylesheet">
    <link href="../../css/bootstrap-datetimepicker.min.css">
    <script src='../../js/jquery.js'></script>
    <script src='../../js/jquery.datetimepicker.min.js'></script>
</head>
<jsp:include page="../part/h_navbar.jsp"/>
<div class="container">
    <div class="col-md-2 col-sm-2 col-lg-2" role="complementary">
        <nav class="pageBg bs-docs-sidebar hidden-print hidden-xs hidden-sm affix">
            <ul class="nav bs-docs-sidenav">
                <li class="active">
                    <a href="#not_member_check">非会员入住</a>
                </li>
                <li>
                    <a href="#checkManage">入住管理</a>
                </li>
            </ul>
        </nav>
    </div>

    <div class="col-md-10 col-lg-10 col-sm-10  pageBg">


        <div class="text-center">
            <h1>酒店管理</h1>
        </div>
        <div class="row">
            <div class="box pageInnerBg">
                <div id="not_member_check" class="text-left">
                    <h2>非会员入住</h2>
                </div>
                <script>
                    jQuery(function ($) {
                        //已有删除按钮初始化绑定删除事件
                        $("#multi").click(function () {
                            $('#name1').removeClass('hidden');

                        });
                        $("#single").click(function () {
                            1
                            $('#name1').addClass('hidden');
                        });

                        $("#multiRoom").click(function () {
                            $('#secondRoom').removeClass('hidden');
                        });
                        $("#singleRoom").click(function () {
                            1
                            $('#secondRoom').addClass('hidden');
                        });

                    });
                </script>


                <form action="<%=response.encodeURL(request.getContextPath()+"/CheckInServlet")%>" method="post">
                    <div id="nonMemberForm">
                         <div class="m_inline">
                              <div class="col-md-3 col-lg-3 col-sm-3">
                                  <span class="input-group-addon m_inline">选择日期</span>
                              </div>
                              <div class="col-md-4 col-lg-4 col-sm-4">
                                  <div class="input-append date form_datetime m_left">
                                      <input id="start_time" size="16" type="text" name="Start" data-date="2017-03-21"
                                             value="2017-03-21">
                                      <span class="add-on"><i class="icon-remove"></i></span>
                                      <span class="add-on"><i class="icon-calendar"></i></span>
                                  </div>
                              </div>

                              <div class="col-md-1 col-lg-1">
                                  <span>至</span>
                              </div>

                              <div class="col-md-4 col-lg-4 col-sm-4">
                                  <div class="input-append date form_datetime m_left">
                                      <input id="end_time" size="16" type="text" name="End" data-date="2018-03-22"
                                             value="2017-03-22">
                                      <span class="add-on"><i class="icon-remove"></i></span>
                                      <span class="add-on"><i class="icon-calendar"></i></span>
                                  </div>
                              </div>
                          </div>
                          <div class="blank10"></div>
                        <%--<div class="input-group input-group-lg input-group-md input-group-sm">
                            <span class="input-group-addon">开始日期</span>
                            <div class="input-append date form_datetime m_left">
                                <input id="start_time" size="16" type="text" value="2017-03-20" data-date="2017-03-20"
                                       placeholder="2017-03-20"
                                       readonly>
                                <span class="add-on"><i class="icon-remove"></i></span>
                                <span class="add-on"><i class="icon-calendar"></i></span>
                            </div>
                        </div>
                        <div class="blank10"></div>
                        <div class="input-group input-group-lg input-group-md input-group-sm">
                            <span class="input-group-addon">结束日期</span>
                            <div class="input-append date form_datetime m_left">
                                <input id="end_time" size="16" type="text" value="2018-03-20" data-date="2018-03-21"
                                       placeholder="2018-03-21"
                                       readonly>
                                <span class="add-on"><i class="icon-remove"></i></span>
                                <span class="add-on"><i class="icon-calendar"></i></span>
                            </div>
                        </div>--%>
                        <%--<div class="blank20"></div>--%>
                        <div class="blank20"></div>
                        <div class="input-group input-group-lg input-group-md input-group-sm">
                            <span class="input-group-addon m_inline">入住人数</span>
                            <div class="form-group m_inline">
                                <label class="radio-inline">
                                    <input type="radio" id="single" name="peopleNum" value="1" checked>单人入住
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="multi" name="peopleNum" value="2">两人入住
                                </label>
                            </div>
                        </div>
                        <div class="blank20"></div>
                        <div class="input-group input-group-lg input-group-md input-group-sm">
                            <span class="input-group-addon m_inline">房间数量</span>
                            <div class="form-group m_inline">
                                <label class="radio-inline">
                                    <input type="radio" id="singleRoom" name="roomNum" value="1" checked>一个房间
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="multiRoom" name="roomNum" value="2">两个房间
                                </label>
                            </div>
                        </div>
                        <div class="blank20"></div>

                        <div class="input-group input-group-lg input-group-md input-group-sm">
                            <span class="input-group-addon m_inline">房间类型</span>
                            <div class="form-group m_inline">
                                <label class="radio-inline">
                                    <input type="radio" name="roomType" value="1" checked>大床房&nbsp;&nbsp;&nbsp;&nbsp;
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="roomType" value="2">标准间
                                </label>
                            </div>
                        </div>
                        <div class="blank10"></div>

                        <div class="input-group input-group-lg input-group-md input-group-sm">
                            <span class="input-group-addon">房间编号</span>
                            <input name="roomno" type="text" class="form-control" placeholder="请输入房间编号">
                        </div>
                        <div class="blank10"></div>

                        <div id="secondRoom" class="hidden">
                            <%--<div class="blank10"></div>--%>
                            <div class="input-group input-group-lg input-group-md input-group-sm">
                                <span class="input-group-addon">房间编号</span>
                                <input name="roomno1" type="text" class="form-control" placeholder="请输入房间编号">
                            </div>
                            <div class="blank10"></div>
                        </div>

                        <div class="input-group input-group-lg input-group-md input-group-sm">
                            <span class="input-group-addon">联系电话</span>
                            <input name="phoneNum" type="text" class="form-control" placeholder="请输入联系电话">
                        </div>
                        <div class="blank10"></div>
                        <div class="input-group input-group-lg input-group-md input-group-sm">
                            <span class="input-group-addon">身份证号</span>
                            <input name="id" type="text" class="form-control" placeholder="请输入旅客身份证号">
                        </div>
                        <div class="blank10"></div>
                        <div class="input-group input-group-lg input-group-md input-group-sm">
                            <span class="input-group-addon">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</span>
                            <input name="name" type="text" class="form-control" placeholder="请输入旅客姓名">
                        </div>
                        <div class="blank10"></div>

                        <div id="name1" class="input-group input-group-lg input-group-md input-group-sm hidden">
                            <span class="input-group-addon">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</span>
                            <input name="name1" type="text" class="form-control" placeholder="请输入旅客姓名">
                        </div>
                        <div class="blank20"></div>
                        <div class="m_center">
                            <button type="submit" class="btn btn-default btn-success">
                                <span class="glyphicon glyphicon-ok" aria-hidden="true">办理入住</span>
                            </button>
                        </div>
                    </div>
                </form>

            </div>
            <script type="text/javascript" src="../../js/bootstrap-datetimepicker.min.js">
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
            <%--</div>

            <div class="row">--%>
            <%--<h2 id="glyphicons-glyphs"></h2>--%>
            <div id="checkManage" class="box pageInnerBg">
                <%--<div class="row">--%>
                <h2 class="text-left">入住管理</h2>
                <div class="user-profile-nav js-sticky top-0">
                    <nav class="underline-nav" data-pjax role="navigation">
                        <a href="#"
                           class="underline-nav-item selected"
                           aria-selected="true"
                           role="tab"
                           value="HReserved">
                            已预订
                            <span class="counter">
          </span>
                        </a>
                        <a href="#"
                           class="underline-nav-item"
                           aria-selected="false"
                           role="tab"
                           value="HChecked">
                            已入住
                            <span class="counter">
          </span>
                        </a>
                        <a href="#"
                           class="underline-nav-item "
                           aria-selected="false"
                           role="tab"
                           value="HCompleted">
                            已完成
                            <span class="counter">
          </span>
                        </a>
                    </nav>
                </div>
                <script>
                    jQuery(function ($) {
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
                    });
                </script>
                <div class="display-container" id="HReserved">
                    <%
                        List<Order> reservedList = (List<Order>) request.getAttribute("reservedList");
                        if (reservedList != null) {

                            for (int i = 0; i < reservedList.size(); i++) {
                                Order allR = reservedList.get(i);
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
                                <span class="f4 link-gray-dark">订单号：<%=allR.getOrderno()%></span>
                                <span class="link-gray pl-1">房间类型：<%=allR.getRoomType().getStr()%></span>
                            </a>
                            <p class="text-gray text-small">实际支付：<%=allR.getPay()%>&nbsp;&nbsp;&nbsp;&nbsp;房间号：<%=allR.getRoomNum()%>
                            </p>

                            <p class="text-gray text-small mb-0">
										<span class="mr-3">
										  <svg aria-hidden="true" class="octicon octicon-organization" height="16"
                                               version="1.1"
                                               viewBox="0 0 16 16"
                                               width="16"><path fill-rule="evenodd"
                                                                d="M16 12.999c0 .439-.45 1-1 1H7.995c-.539 0-.994-.447-.995-.999H1c-.54 0-1-.561-1-1 0-2.634 3-4 3-4s.229-.409 0-1c-.841-.621-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.442.58 2.5 3c.058 2.41-.159 2.379-1 3-.229.59 0 1 0 1s1.549.711 2.42 2.088C9.196 9.369 10 8.999 10 8.999s.229-.409 0-1c-.841-.62-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.437.581 2.495 3c.059 2.41-.158 2.38-1 3-.229.59 0 1 0 1s3.005 1.366 3.005 4"/>
										  </svg>
                                            房间单价:<%=allR.getRoomPrice()%>
										</span>
                                <svg aria-hidden="true" class="octicon octicon-location" height="16"
                                     version="1.1"
                                     viewBox="0 0 12 16" width="12">
                                    <path fill-rule="evenodd"
                                          d="M6 0C2.69 0 0 2.5 0 5.5 0 10.02 6 16 6 16s6-5.98 6-10.5C12 2.5 9.31 0 6 0zm0 14.55C4.14 12.52 1 8.44 1 5.5 1 3.02 3.25 1 6 1c1.34 0 2.61.48 3.56 1.36.92.86 1.44 1.97 1.44 3.14 0 2.94-3.14 7.02-5 9.05zM8 5.5c0 1.11-.89 2-2 2-1.11 0-2-.89-2-2 0-1.11.89-2 2-2 1.11 0 2 .89 2 2z"/>
                                </svg>
                                订单状态：<%=allR.getOrderState().getStr()%>&nbsp;&nbsp;&nbsp;&nbsp;开始日期：<%=allR.getStartTime()%>&nbsp;&nbsp;&nbsp;&nbsp;结束日期：<%=allR.getEndTime()%>
                            </p>
                        </div>

                        <div class="d-table-cell col-2 v-align-top text-right">
						<span class="user-following-container js-toggler-container js-social-container on">

						  <span class="unfollow">
							<!-- '"` --><!-- </textarea></xmp> -->
                              </option>
                              </form>
                              <form accept-charset="UTF-8"
                                    action="<%=response.encodeURL(request.getContextPath()+"/MakeCheckServlet")%>"
                                    data-form-nonce="66033770d550dc277e426c8ecdcc013da1d43bab" data-remote="true"
                                    method="post">
                                  <div
                                          style="margin:0;padding:0;display:inline">

								  <input name="orderno" value="<%=allR.getOrderno()%>" type="hidden">
								  </div>
							  <button
                                      type="submit"
                                      class="btn btn-sm js-toggler-target"
                                      aria-label="Unfollow this person" title="Unfollow 14dtj">
								办理入住
							  </button>
							  </form>
						  </span>
					    </span>
                        </div>
                    </div>
                    <% }
                    }%>

                </div>

                <div class="display-container hidden" id="HChecked">

                    <%
                        List<Order> checkInList = (List<Order>) request.getAttribute("checkInList");
                        if (checkInList != null) {
                            for (int i = 0; i < checkInList.size(); i++) {
                                Order allR = checkInList.get(i);
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
                                <span class="f4 link-gray-dark">订单号：<%=allR.getOrderno()%></span>
                                <span class="link-gray pl-1">房间类型：<%=allR.getRoomType().getStr()%></span>
                            </a>
                            <p class="text-gray text-small">实际支付：<%=allR.getPay()%>&nbsp;&nbsp;&nbsp;&nbsp;房间号：<%=allR.getRoomNum()%>
                            </p>

                            <p class="text-gray text-small mb-0">
										<span class="mr-3">
										  <svg aria-hidden="true" class="octicon octicon-organization" height="16"
                                               version="1.1"
                                               viewBox="0 0 16 16"
                                               width="16"><path fill-rule="evenodd"
                                                                d="M16 12.999c0 .439-.45 1-1 1H7.995c-.539 0-.994-.447-.995-.999H1c-.54 0-1-.561-1-1 0-2.634 3-4 3-4s.229-.409 0-1c-.841-.621-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.442.58 2.5 3c.058 2.41-.159 2.379-1 3-.229.59 0 1 0 1s1.549.711 2.42 2.088C9.196 9.369 10 8.999 10 8.999s.229-.409 0-1c-.841-.62-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.437.581 2.495 3c.059 2.41-.158 2.38-1 3-.229.59 0 1 0 1s3.005 1.366 3.005 4"/>
										  </svg>
                                            房间单价:<%=allR.getRoomPrice()%>
										</span>
                                <svg aria-hidden="true" class="octicon octicon-location" height="16"
                                     version="1.1"
                                     viewBox="0 0 12 16" width="12">
                                    <path fill-rule="evenodd"
                                          d="M6 0C2.69 0 0 2.5 0 5.5 0 10.02 6 16 6 16s6-5.98 6-10.5C12 2.5 9.31 0 6 0zm0 14.55C4.14 12.52 1 8.44 1 5.5 1 3.02 3.25 1 6 1c1.34 0 2.61.48 3.56 1.36.92.86 1.44 1.97 1.44 3.14 0 2.94-3.14 7.02-5 9.05zM8 5.5c0 1.11-.89 2-2 2-1.11 0-2-.89-2-2 0-1.11.89-2 2-2 1.11 0 2 .89 2 2z"/>
                                </svg>
                                订单状态：<%=allR.getOrderState().getStr()%>&nbsp;&nbsp;&nbsp;&nbsp;开始日期：<%=allR.getStartTime()%>&nbsp;&nbsp;&nbsp;&nbsp;结束日期：<%=allR.getEndTime()%>
                            </p>
                        </div>

                        <div class="d-table-cell col-2 v-align-top text-right">
						<span class="user-following-container js-toggler-container js-social-container on">

						  <span class="unfollow">
							<!-- '"` --><!-- </textarea></xmp> -->
                              </option>
                              </form>
                              <form accept-charset="UTF-8"
                                    action="<%=response.encodeURL(request.getContextPath()+"/MakeCheckServlet")%>"
                                    data-form-nonce="66033770d550dc277e426c8ecdcc013da1d43bab" data-remote="true"
                                    method="get"><div
                                      style="margin:0;padding:0;display:inline">
								  <input name="orderno" value="<%=allR.getOrderno()%>" type="hidden">
								  </div>
							  <button
                                      type="submit"
                                      class="btn btn-sm js-toggler-target"
                                      aria-label="Unfollow this person" title="Unfollow 14dtj">
								办理退房
							  </button>
							  </form>
						  </span>
					    </span>
                        </div>
                    </div>
                    <%
                            }
                        }
                    %>
                </div>

                <div class="display-container hidden" id="HCompleted">
                    <%
                        List<Order> checkOutList = (List<Order>) request.getAttribute("checkOutList");
                        if (checkInList != null) {
                            for (int i = 0; i < checkOutList.size(); i++) {
                                Order allR = checkOutList.get(i);
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
                                <span class="f4 link-gray-dark">订单号：<%=allR.getOrderno()%></span>
                                <span class="link-gray pl-1">房间类型：<%=allR.getRoomType().getStr()%></span>
                            </a>
                            <p class="text-gray text-small">实际支付：<%=allR.getPay()%>&nbsp;&nbsp;&nbsp;&nbsp;房间号：<%=allR.getRoomNum()%>
                            </p>

                            <p class="text-gray text-small mb-0">
										<span class="mr-3">
										  <svg aria-hidden="true" class="octicon octicon-organization" height="16"
                                               version="1.1"
                                               viewBox="0 0 16 16"
                                               width="16"><path fill-rule="evenodd"
                                                                d="M16 12.999c0 .439-.45 1-1 1H7.995c-.539 0-.994-.447-.995-.999H1c-.54 0-1-.561-1-1 0-2.634 3-4 3-4s.229-.409 0-1c-.841-.621-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.442.58 2.5 3c.058 2.41-.159 2.379-1 3-.229.59 0 1 0 1s1.549.711 2.42 2.088C9.196 9.369 10 8.999 10 8.999s.229-.409 0-1c-.841-.62-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.437.581 2.495 3c.059 2.41-.158 2.38-1 3-.229.59 0 1 0 1s3.005 1.366 3.005 4"/>
										  </svg>
                                            房间单价:<%=allR.getRoomPrice()%>
										</span>
                                <svg aria-hidden="true" class="octicon octicon-location" height="16"
                                     version="1.1"
                                     viewBox="0 0 12 16" width="12">
                                    <path fill-rule="evenodd"
                                          d="M6 0C2.69 0 0 2.5 0 5.5 0 10.02 6 16 6 16s6-5.98 6-10.5C12 2.5 9.31 0 6 0zm0 14.55C4.14 12.52 1 8.44 1 5.5 1 3.02 3.25 1 6 1c1.34 0 2.61.48 3.56 1.36.92.86 1.44 1.97 1.44 3.14 0 2.94-3.14 7.02-5 9.05zM8 5.5c0 1.11-.89 2-2 2-1.11 0-2-.89-2-2 0-1.11.89-2 2-2 1.11 0 2 .89 2 2z"/>
                                </svg>
                                订单状态：<%=allR.getOrderState().getStr()%>&nbsp;&nbsp;&nbsp;&nbsp;开始日期：<%=allR.getStartTime()%>&nbsp;&nbsp;&nbsp;&nbsp;结束日期：<%=allR.getEndTime()%>
                            </p>
                        </div>

                        <div class="d-table-cell col-2 v-align-top text-right">
						<span class="user-following-container js-toggler-container js-social-container on">

					    </span>
                        </div>
                    </div>
                    <%
                            }
                        }
                    %>
                </div>
                <%--</div>--%>
            </div>
        </div>
    </div>


    <%--搜索框--%>
</div>
<!--container closed-->
</div>

<jsp:include page="../part/footer.jsp"/>
</html>




