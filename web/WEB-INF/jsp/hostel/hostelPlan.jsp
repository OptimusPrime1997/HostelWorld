<%@ page import="com.nju.entity.Hostelplan" %>
<%@ page import="java.util.List" %>
<%@ page import="com.nju.entity.User" %>
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
    <link href='../../css/bootstrap-datetimepicker.min.css' rel="stylesheet">
    <script src='../../js/jquery.js'></script>
    <script src='../../js/bootstrap-datetimepicker.min.js'></script>
</head>
<jsp:include page="../part/h_navbar.jsp"/>
<div class="container">
    <% User u = (User) session.getAttribute("user");%>
    <div class="col-md-2 col-sm-2 col-lg-2" role="complementary">
        <nav class="pageBg bs-docs-sidebar hidden-print hidden-xs hidden-sm affix">
            <ul class="nav bs-docs-sidenav">
                <li class="active">
                    <a href="#planManage">计划管理</a>
                </li>
                <li>
                    <a href="#launchPlan">发布计划</a>
                </li>
            </ul>
        </nav>
    </div>

    <div class="col-md-10 col-lg-10 col-sm-10  pageBg">
        <div class="text-center">
            <h1>经营计划</h1>
        </div>
        <div class="row">
            <div id="planManage" class="box pageInnerBg">
                <h2 class="text-left">计划管理</h2>
                <div class="user-profile-nav js-sticky top-0">
                    <nav class="underline-nav" data-pjax role="navigation">
                        <a href="#"
                           class="underline-nav-item selected"
                           aria-selected="true"
                           role="tab"
                           value="currentPlan">
                            当前计划
                            <span class="counter">
          </span>
                        </a>

                        <a href="#"
                           class="underline-nav-item"
                           aria-selected="false"
                           role="tab"
                           value="allPlan">
                            所有计划
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
                <div class="display-container" id="currentPlan">
                    <%
                        List<Hostelplan> nowList = (List<Hostelplan>) request.getAttribute("nowList");
                        if (nowList != null) {
                            for (int i = 0; i < nowList.size(); i++) {
                                Hostelplan allR = nowList.get(i);
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
                                <span class="f4 link-gray-dark">计划编号：<%=allR.getHostelplanno()%></span>
                                <span class="link-gray pl-1">房间类型：<%=allR.getRoomType().getStr()%></span>
                            </a>
                            <p class="text-gray text-small">房间单价：<%=allR.getPrice()%>&nbsp;&nbsp;&nbsp;&nbsp;计划状态：<%=allR.getPlanState().getStr()%>
                            </p>

                            <p class="text-gray text-small mb-0">
										<span class="mr-3">
										  <svg aria-hidden="true" class="octicon octicon-organization" height="16"
                                               version="1.1"
                                               viewBox="0 0 16 16"
                                               width="16"><path fill-rule="evenodd"
                                                                d="M16 12.999c0 .439-.45 1-1 1H7.995c-.539 0-.994-.447-.995-.999H1c-.54 0-1-.561-1-1 0-2.634 3-4 3-4s.229-.409 0-1c-.841-.621-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.442.58 2.5 3c.058 2.41-.159 2.379-1 3-.229.59 0 1 0 1s1.549.711 2.42 2.088C9.196 9.369 10 8.999 10 8.999s.229-.409 0-1c-.841-.62-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.437.581 2.495 3c.059 2.41-.158 2.38-1 3-.229.59 0 1 0 1s3.005 1.366 3.005 4"/>
										  </svg>
                                            开始日期:<%=allR.getStartDate().toString()%>
										</span>
                                <svg aria-hidden="true" class="octicon octicon-location" height="16"
                                     version="1.1"
                                     viewBox="0 0 12 16" width="12">
                                    <path fill-rule="evenodd"
                                          d="M6 0C2.69 0 0 2.5 0 5.5 0 10.02 6 16 6 16s6-5.98 6-10.5C12 2.5 9.31 0 6 0zm0 14.55C4.14 12.52 1 8.44 1 5.5 1 3.02 3.25 1 6 1c1.34 0 2.61.48 3.56 1.36.92.86 1.44 1.97 1.44 3.14 0 2.94-3.14 7.02-5 9.05zM8 5.5c0 1.11-.89 2-2 2-1.11 0-2-.89-2-2 0-1.11.89-2 2-2 1.11 0 2 .89 2 2z"/>
                                </svg>
                                结束日期：<%=allR.getEndDate().toString()%>
                            </p>
                        </div>

                        <div class="d-table-cell col-2 v-align-top text-right">
						<span class="user-following-container js-toggler-container js-social-container on">
						  <span class="unfollow">
							<!-- '"` --><!-- </textarea></xmp> -->
                              </option>
                              </form>
                              <form accept-charset="UTF-8"
                                    action="<%=response.encodeURL(request.getContextPath()+"/PublishPlanServlet")%>"
                                    data-form-nonce="66033770d550dc277e426c8ecdcc013da1d43bab" data-remote="true"
                                    method="get"><div
                                      style="margin:0;padding:0;display:inline">
								  <input name="hostelplanno" value="<%=allR.getHostelplanno()%>" type="hidden">
								  </div>
							  <button
                                      type="submit"
                                      class="btn btn-sm js-toggler-target"
                                      aria-label="Unfollow this person" title="Unfollow 14dtj">
								删除
							  </button>
							  </form>
						  </span>
					    </span>
                        </div>
                    </div>
                    <% }
                    }%>
                </div>

                <div class="display-container hidden" id="allPlan">
                    <%
                        List<Hostelplan> allList = (List<Hostelplan>) request.getAttribute("allList");
                        if (allList != null) {
                            for (int i = 0; i < allList.size(); i++) {
                                Hostelplan allR = allList.get(i);
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
                                <span class="f4 link-gray-dark">计划编号：<%=allR.getHostelplanno()%></span>
                                <span class="link-gray pl-1">房间类型：<%=allR.getRoomType().getStr()%></span>
                            </a>
                            <p class="text-gray text-small">房间单价：<%=allR.getPrice()%>&nbsp;&nbsp;&nbsp;&nbsp;计划状态：<%=allR.getPlanState().getStr()%>
                            </p>

                            <p class="text-gray text-small mb-0">
										<span class="mr-3">
										  <svg aria-hidden="true" class="octicon octicon-organization" height="16"
                                               version="1.1"
                                               viewBox="0 0 16 16"
                                               width="16"><path fill-rule="evenodd"
                                                                d="M16 12.999c0 .439-.45 1-1 1H7.995c-.539 0-.994-.447-.995-.999H1c-.54 0-1-.561-1-1 0-2.634 3-4 3-4s.229-.409 0-1c-.841-.621-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.442.58 2.5 3c.058 2.41-.159 2.379-1 3-.229.59 0 1 0 1s1.549.711 2.42 2.088C9.196 9.369 10 8.999 10 8.999s.229-.409 0-1c-.841-.62-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.437.581 2.495 3c.059 2.41-.158 2.38-1 3-.229.59 0 1 0 1s3.005 1.366 3.005 4"/>
										  </svg>
                                            开始日期:<%=allR.getStartDate().toString()%>
										</span>
                                <svg aria-hidden="true" class="octicon octicon-location" height="16"
                                     version="1.1"
                                     viewBox="0 0 12 16" width="12">
                                    <path fill-rule="evenodd"
                                          d="M6 0C2.69 0 0 2.5 0 5.5 0 10.02 6 16 6 16s6-5.98 6-10.5C12 2.5 9.31 0 6 0zm0 14.55C4.14 12.52 1 8.44 1 5.5 1 3.02 3.25 1 6 1c1.34 0 2.61.48 3.56 1.36.92.86 1.44 1.97 1.44 3.14 0 2.94-3.14 7.02-5 9.05zM8 5.5c0 1.11-.89 2-2 2-1.11 0-2-.89-2-2 0-1.11.89-2 2-2 1.11 0 2 .89 2 2z"/>
                                </svg>
                                结束日期：<%=allR.getEndDate().toString()%>
                            </p>
                        </div>

                        <div class="d-table-cell col-2 v-align-top text-right">
						<span class="user-following-container js-toggler-container js-social-container on">
					    </span>
                        </div>
                    </div>
                    <% }
                    }%>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="box pageInnerBg">
                <div id="launchPlan" class="text-left">
                    <h2>发布计划</h2>
                </div>
                <form action="/PublishPlanServlet" method="post">
                    <!-- /input-group -->
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">酒店编号</span>
                        <input name="hostelno" type="text" class="form-control" disabled="disabled"
                               value="<%=u.getUserno()%>">
                    </div>
                    <div class="blank10"></div>
                    <div class="m_inline">
                        <span>&nbsp;&nbsp;房间类型：</span>
                    </div>
                    <div class="form-group m_inline">
                        <label class="radio-inline">
                            <input type="radio" name="roomType" value="1" checked>大床房
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="roomType" value="2">标准间
                        </label>
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">房间单价</span>
                        <input name="price" type="text" class="form-control"
                               value="288" placeholder="288">
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">开始日期</span>
                        <div class="input-append date form_datetime m_left">
                            <input id="start_time" name="start_time" size="16" type="text" value="2017-03-21"
                                   data-date="2017-03-22"
                                   placeholder="2017-03-21"
                                   readonly>
                            <span class="add-on"><i class="icon-remove"></i></span>
                            <span class="add-on"><i class="icon-calendar"></i></span>
                        </div>
                    </div>
                    <div class="blank10"></div>
                    <div class="input-group input-group-lg input-group-md input-group-sm">
                        <span class="input-group-addon">结束日期</span>
                        <div class="input-append date form_datetime m_left">
                            <input id="end_time" name="end_time" size="16" type="text" value="2018-03-21"
                                   data-date="2018-03-21"
                                   placeholder="2018-03-21"
                                   readonly>
                            <span class="add-on"><i class="icon-remove"></i></span>
                            <span class="add-on"><i class="icon-calendar"></i></span>
                        </div>
                    </div>
                    <div class="blank20"></div>

                    <div class="m_inline text-center col-center-block">
                        <button type="submit" class="m_center btn btn-success">
                            <span class="glyphicon glyphicon-upload"> 立即发布</span>
                        </button>
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
                        <%--<a href="#">
                            <button type="button" class="btn btn-success" id="loginBt">
                                <span class="glyphicon glyphicon-search"></span>
                                搜索
                            </button>
                        </a>--%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--container closed-->

<jsp:include page="../part/footer.jsp"/>
</html>


