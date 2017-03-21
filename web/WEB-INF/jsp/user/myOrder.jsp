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
    <script src='../../js/jquery.js'></script>
</head>
<jsp:include page="../part/navbar.jsp"/>
<div class="container">
    <%--搜索框--%>
    <div class="col-md-2 col-sm-2 col-lg-2" role="complementary">
            <nav class="pageBg bs-docs-sidebar hidden-print hidden-xs hidden-sm affix">
                <ul class="nav bs-docs-sidenav">
                    <li class="active">
                        <a href="#orderDetail">订单详情</a>
                    </li>
                </ul>
            </nav>
    </div>

    <div class="col-md-10 col-lg-10 col-sm-10  pageBg">
        <div class="text-center">
            <h1>我的订单</h1>
        </div>
        <div class="row">
            <div class="box pageInnerBg">
                <h2 id="orderDetail" class="text-left">订单详情</h2>
                <div class="user-profile-nav js-sticky top-0">
                    <nav class="underline-nav" data-pjax role="navigation">

                        <%-- <a href="#"
                            class="underline-nav-item selected"
                            aria-selected="true"
                            role="tab"
                            value="AllOrder">
                             所有订单
                             <span class="counter">
           </span>
                         </a>--%>

                        <a href="#"
                           class="underline-nav-item selected"
                           aria-selected="true"
                           role="tab"
                           value="Reserved">
                            已预订
                            <span class="counter">

          </span>
                        </a>

                        <a href="#"
                           class="underline-nav-item"
                           aria-selected="false"
                           role="tab"
                           value="Checked">
                            已入住
                            <span class="counter">
          </span>
                        </a>

                        <a href="#"
                           class="underline-nav-item"
                           aria-selected="false"
                           role="tab"
                           value="Completed">
                            已结束
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

                <%--            <div class="display-container" id="AllOrder">
                                <%
                                    List<Order> allList = (List<Order>) request.getAttribute("allList");
                                    if (allList != null) {
                                        for (int i = 0; i < allList.size(); i++) {
                                            Order allR = allList.get(i);
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

                                      <span class="follow">
                                        <!-- '"` --><!-- </textarea></xmp> --></option></form>
                                          <form accept-charset="UTF-8" action="/users/follow?target=14dtj"
                                                data-form-nonce="66033770d550dc277e426c8ecdcc013da1d43bab" data-remote="true"
                                                method="post"><div
                                                  style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden"
                                                                                                   value="&#x2713;"/><input
                                                  name="authenticity_token" type="hidden"
                                                  value="EnsfcaXlnl7TiMhl6RVlCnLHTdS0XTyDhr1DVzKBjEuyr93fL1CZsZOHP5VERXCEJYNbdzcbjCgBkmC0Gin2FA=="/></div>
                                          <button
                                                  type="submit"
                                                  class="btn btn-sm  js-toggler-target"
                                                  aria-label="Follow this person" title="Follow 14dtj">
                                            Delete
                                          </button>
                                          </form>
                                      </span>

                                      <span class="unfollow">
                                        <!-- '"` --><!-- </textarea></xmp> -->
                                          </option>
                                          </form>
                                          <form accept-charset="UTF-8"
                                                action="#"
                                                data-form-nonce="66033770d550dc277e426c8ecdcc013da1d43bab" data-remote="true"
                                                method="post"><div
                                                  style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden"
                                                                                                   value="&#x2713;"/><input
                                                  name="authenticity_token" type="hidden"
                                                  value="pH5VJHaUbtGzmG14FVGzU3n9cbVExTdLJIewYsl8EpoEqpeK/CFpPvOXmoi4AabdLrlnFseDh+CjqJOB4dRoxQ=="/>
                                              <input name="follower_id" value="#" type="hidden">
                                              </div>
                                          <button
                                                  type="submit"
                                                  class="btn btn-sm js-toggler-target"
                                                  aria-label="Unfollow this person" title="Unfollow 14dtj">
                                            Delete
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
                            </div>--%>
                <%--</div>--%>

                <div class="display-container" id="Reserved">

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

						 <%-- <span class="follow">
							<!-- '"` --><!-- </textarea></xmp> --></option></form>
                              <form accept-charset="UTF-8" action="/users/follow?target=14dtj"
                                    data-form-nonce="66033770d550dc277e426c8ecdcc013da1d43bab" data-remote="true"
                                    method="post"><div
                                      style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden"
                                                                                       value="&#x2713;"/><input
                                      name="authenticity_token" type="hidden"
                                      value="EnsfcaXlnl7TiMhl6RVlCnLHTdS0XTyDhr1DVzKBjEuyr93fL1CZsZOHP5VERXCEJYNbdzcbjCgBkmC0Gin2FA=="/></div>
							  <button
                                      type="submit"
                                      class="btn btn-sm  js-toggler-target"
                                      aria-label="Follow this person" title="Follow 14dtj">
								Delete
							  </button>
							  </form>
						  </span>--%>

						  <span class="unfollow">
							<!-- '"` --><!-- </textarea></xmp> -->
                              </option>
                              </form>
                              <div>
                                  <div
                                          style="margin:0;padding:0;display:inline">
                                  <input name="utf8" type="hidden" value="&#x2713;"/>
                                      <input name="authenticity_token" type="hidden" value=""/>
								  <input name="follower_id" value="#" type="hidden">
								  </div>
							  <button
                                      type="submit"
                                      class="btn btn-sm js-toggler-target cancelBtn" value="<%=allR.getOrderno()%>"
                                      aria-label="Unfollow this person" title="Unfollow 14dtj">
                                  取消
							  </button>
							  </div>
						  </span>
					    </span>
                        </div>
                    </div>

                    <% }
                    }%>
                </div>
                <%--</div>--%>
                <script>
                    jQuery(function ($) {
                        $(".cancelBtn").click(function () {
                            if ($(this).click(1)) {
//                                alert($(this).attr("value"));
                                $.ajax({
                                    url: 'CancelServlet',
                                    data: {
                                        Orderno: $(this).attr('value')
                                    },
                                    success: function (responseText) {
                                        alert("成功取消" + responseText + "订单");
//                                        $.post('ReserveServlet');
                                    },
                                    error: function (msg) {
                                        alert("取消订单失败！" + msg);
                                    }
                                })
                            }
                        })
                    });
                </script>

                <div class="display-container hidden" id="Checked">
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

						  <%--<span class="unfollow">--%>
							<%--<!-- '"` --><!-- </textarea></xmp> -->--%>
                              <%--</option>--%>
                              <%--</form>--%>
                              <%--<form accept-charset="UTF-8"--%>
                                    <%--action="#"--%>
                                    <%--data-form-nonce="66033770d550dc277e426c8ecdcc013da1d43bab" data-remote="true"--%>
                                    <%--method="post"><div--%>
                                      <%--style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden"--%>
                                                                                       <%--value="&#x2713;"/><input--%>
                                      <%--name="authenticity_token" type="hidden"--%>
                                      <%--value="pH5VJHaUbtGzmG14FVGzU3n9cbVExTdLJIewYsl8EpoEqpeK/CFpPvOXmoi4AabdLrlnFseDh+CjqJOB4dRoxQ=="/>--%>
								  <%--<input name="follower_id" value="#" type="hidden">--%>
								  <%--</div>--%>
							  <%--<button--%>
                                      <%--type="submit"--%>
                                      <%--class="btn btn-sm js-toggler-target"--%>
                                      <%--aria-label="Unfollow this person" title="Unfollow 14dtj">--%>
								<%--Delete--%>
							  <%--</button>--%>
							  <%--</form>--%>
						  <%--</span>--%>
					    </span>
                        </div>
                    </div>
                    <%
                            }
                        }
                    %>
                </div>
                <%--</div>--%>

                <div class="display-container hidden" id="Completed">

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

                            <%--<span class="unfollow">
                              <!-- '"` --><!-- </textarea></xmp> -->
                                </option>
                                </form>
                                <form accept-charset="UTF-8"
                                      action="#"
                                      data-form-nonce="66033770d550dc277e426c8ecdcc013da1d43bab" data-remote="true"
                                      method="post"><div
                                        style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden"
                                                                                         value="&#x2713;"/><input
                                        name="authenticity_token" type="hidden"
                                        value="pH5VJHaUbtGzmG14FVGzU3n9cbVExTdLJIewYsl8EpoEqpeK/CFpPvOXmoi4AabdLrlnFseDh+CjqJOB4dRoxQ=="/>
                                    <input name="follower_id" value="#" type="hidden">
                                    </div>
                                <button
                                        type="submit"
                                        class="btn btn-sm js-toggler-target"
                                        aria-label="Unfollow this person" title="Unfollow 14dtj">
                                  Delete
                                </button>
                                </form>
                            </span>--%>
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
</div>
</div>
</div>
<!--container closed-->
</div>
<!--container closed-->
</div>

<jsp:include page="../part/footer.jsp"/>
</html>


