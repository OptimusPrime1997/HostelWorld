<%@ page import="com.nju.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
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
<jsp:include page="../part/m_navbar.jsp"/>
<div class="container">
    <div class="col-md-2 col-sm-2 col-lg-2" role="complementary">
        <nav class="pageBg bs-docs-sidebar hidden-print hidden-xs hidden-sm affix">
            <ul class="nav bs-docs-sidenav">
                <li class="active">
                    <a href="#checkManage">审批管理</a>
                </li>
            </ul>
        </nav>
    </div>
    <div class="col-md-10 col-lg-10 col-sm-10  pageBg">
        <div class="text-center">
            <h1>信息审批</h1>
        </div>
        <div class="row">
            <div class="box pageInnerBg">
                <h2 id="checkManage" class="text-left">审批管理</h2>
                <div class="user-profile-nav js-sticky top-0">
                    <nav class="underline-nav" data-pjax role="navigation">
                        <a href="#"
                           class="underline-nav-item selected"
                           aria-selected="true"
                           role="tab"
                           value="joinCheck">
                            入住申请
                            <span class="counter">
          </span>
                        </a>
                        <a href="#"
                           class="underline-nav-item"
                           aria-selected="true"
                           role="tab"
                           value="modifyCheck">
                            修改申请
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
                <div class="display-container" id="joinCheck">
                    <%
                        List<User> joinCheckList = (List<User>) request.getAttribute("joinCheckList");
                        if (joinCheckList != null) {
                            for (int i = 0; i < joinCheckList.size(); i++) {
                                User allR = joinCheckList.get(i);
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
                                <span class="f4 link-gray-dark">酒店编号：<%=allR.getUserno()%></span>
                                <span class="link-gray pl-1">酒店名称：<%=allR.getName()%></span>
                            </a>
                            <p class="text-gray text-small">银行账户：<%=allR.getBankAccount()%>
                            </p>

                            <p class="text-gray text-small mb-0">
										<span class="mr-3">
										  <svg aria-hidden="true" class="octicon octicon-organization" height="16"
                                               version="1.1"
                                               viewBox="0 0 16 16"
                                               width="16"><path fill-rule="evenodd"
                                                                d="M16 12.999c0 .439-.45 1-1 1H7.995c-.539 0-.994-.447-.995-.999H1c-.54 0-1-.561-1-1 0-2.634 3-4 3-4s.229-.409 0-1c-.841-.621-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.442.58 2.5 3c.058 2.41-.159 2.379-1 3-.229.59 0 1 0 1s1.549.711 2.42 2.088C9.196 9.369 10 8.999 10 8.999s.229-.409 0-1c-.841-.62-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.437.581 2.495 3c.059 2.41-.158 2.38-1 3-.229.59 0 1 0 1s3.005 1.366 3.005 4"/>
										  </svg>
                                           酒店地址:<%=allR.getAddress()%>
										</span>
                                <svg aria-hidden="true" class="octicon octicon-location" height="16"
                                     version="1.1"
                                     viewBox="0 0 12 16" width="12">
                                    <path fill-rule="evenodd"
                                          d="M6 0C2.69 0 0 2.5 0 5.5 0 10.02 6 16 6 16s6-5.98 6-10.5C12 2.5 9.31 0 6 0zm0 14.55C4.14 12.52 1 8.44 1 5.5 1 3.02 3.25 1 6 1c1.34 0 2.61.48 3.56 1.36.92.86 1.44 1.97 1.44 3.14 0 2.94-3.14 7.02-5 9.05zM8 5.5c0 1.11-.89 2-2 2-1.11 0-2-.89-2-2 0-1.11.89-2 2-2 1.11 0 2 .89 2 2z"/>
                                </svg>
                                联系电话：<%=allR.getPhoneNum()%>
                            </p>
                        </div>

                        <div class="d-table-cell col-2 v-align-top text-right">
						<span class="user-following-container js-toggler-container js-social-container on">
						  <span class="unfollow">
							<!-- '"` --><!-- </textarea></xmp> -->
                              </option>
                              <form accept-charset="UTF-8" id="checkFormId"
                                    action="<%=response.encodeURL(request.getContextPath()+"/JoinCheckServlet")%>"
                                    value="checkFormTest"
                                    data-form-nonce="66033770d550dc277e426c8ecdcc013da1d43bab" data-remote="true"
                                    method="post"><div
                                      style="margin:0;padding:0;display:inline">
                                   <input name="hostelno" value="<%=allR.getUserno()%>" type="hidden">
								  </div>
							  <button
                                      type="button"
                                      class="btn btn-sm js-toggler-target m_inline btn-success"
                                      aria-label="Unfollow this person" title="Unfollow 14dtj" id="passBtn">
								通过
							  </button>
                                  <button
                                          type="button"
                                          class="btn btn-sm js-toggler-target m_inline btn-warning"
                                          aria-label="Unfollow this person" title="Unfollow 14dtj" id="rejectBtn">
								拒绝
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
                <script>
                    jQuery(function ($) {
                        $("#passBtn").click(function () {
                            $("#checkFormId").attr("method", 'post');
                            /*alert($("#checkFormId").val());*/
                            $("#checkFormId").submit();
                        });
                        $("#rejectBtn").click(function () {
                            $("#checkFormId").attr("method", 'get');
                            /*alert($("#checkFormId").val());*/
                            $("#checkFormId").submit();
                        });
                        $("#modifyPassBtn").click(function () {
                            $("#modifyCheckForm").attr("method", 'post');
                            /*alert($("#modifyCheckForm").val());*/
                            $("#modifyCheckForm").submit();
                        });
                        $("#modifyRejectBtn").click(function () {
                            $("#modifyCheckForm").attr("method", 'get');
                            /*alert($("#modifyCheckForm").val());*/
                            $("#modifyCheckForm").submit();
                        });


                    });
                </script>
                <div class="display-container hidden" id="modifyCheck">
                    <%
                        Map<User, User> modifyMap = (Map<User, User>) request.getAttribute("modifyMap");
                        if (modifyMap != null) {
                            Set<User> userSet = modifyMap.keySet();
                            for (Iterator<User> t = userSet.iterator(); t.hasNext(); ) {
                                User raw = t.next();
                                User modify = modifyMap.get(raw);
                    %>
                    <div>
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
                                    <span class="f4 link-gray-dark">酒店编号：<%=raw.getUserno()%></span>
                                    <span class="link-gray pl-1">原酒店名称：<%=raw.getName()%></span>
                                </a>
                                <p class="text-gray text-small">原联系方式：<%=raw.getPhoneNum()%>
                                </p>

                                <p class="text-gray text-small mb-0">
										<span class="mr-3">
										  <svg aria-hidden="true" class="octicon octicon-organization" height="16"
                                               version="1.1"
                                               viewBox="0 0 16 16"
                                               width="16"><path fill-rule="evenodd"
                                                                d="M16 12.999c0 .439-.45 1-1 1H7.995c-.539 0-.994-.447-.995-.999H1c-.54 0-1-.561-1-1 0-2.634 3-4 3-4s.229-.409 0-1c-.841-.621-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.442.58 2.5 3c.058 2.41-.159 2.379-1 3-.229.59 0 1 0 1s1.549.711 2.42 2.088C9.196 9.369 10 8.999 10 8.999s.229-.409 0-1c-.841-.62-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.437.581 2.495 3c.059 2.41-.158 2.38-1 3-.229.59 0 1 0 1s3.005 1.366 3.005 4"/>
										  </svg>
                                            原酒店地址:<%=raw.getAddress()%>
										</span>
                                    <svg aria-hidden="true" class="octicon octicon-location" height="16"
                                         version="1.1"
                                         viewBox="0 0 12 16" width="12">
                                        <path fill-rule="evenodd"
                                              d="M6 0C2.69 0 0 2.5 0 5.5 0 10.02 6 16 6 16s6-5.98 6-10.5C12 2.5 9.31 0 6 0zm0 14.55C4.14 12.52 1 8.44 1 5.5 1 3.02 3.25 1 6 1c1.34 0 2.61.48 3.56 1.36.92.86 1.44 1.97 1.44 3.14 0 2.94-3.14 7.02-5 9.05zM8 5.5c0 1.11-.89 2-2 2-1.11 0-2-.89-2-2 0-1.11.89-2 2-2 1.11 0 2 .89 2 2z"/>
                                    </svg>
                                    原银行账号：<%=raw.getBankAccount()%>
                                </p>
                            </div>

                            <div class="d-table-cell col-2 v-align-top text-right">
						<span class="user-following-container js-toggler-container js-social-container on">

					    </span>
                            </div>
                        </div>
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
                                    <span class="f4 link-gray-dark">酒店编号：<%=modify.getUserno().substring(0, 7)%></span>
                                    <span class="link-gray pl-1">现酒店名称：<%=modify.getName()%></span>
                                </a>
                                <p class="text-gray text-small">现联系方式：<%=modify.getPhoneNum()%>
                                </p>

                                <p class="text-gray text-small mb-0">
										<span class="mr-3">
										  <svg aria-hidden="true" class="octicon octicon-organization" height="16"
                                               version="1.1"
                                               viewBox="0 0 16 16"
                                               width="16"><path fill-rule="evenodd"
                                                                d="M16 12.999c0 .439-.45 1-1 1H7.995c-.539 0-.994-.447-.995-.999H1c-.54 0-1-.561-1-1 0-2.634 3-4 3-4s.229-.409 0-1c-.841-.621-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.442.58 2.5 3c.058 2.41-.159 2.379-1 3-.229.59 0 1 0 1s1.549.711 2.42 2.088C9.196 9.369 10 8.999 10 8.999s.229-.409 0-1c-.841-.62-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.437.581 2.495 3c.059 2.41-.158 2.38-1 3-.229.59 0 1 0 1s3.005 1.366 3.005 4"/>
										  </svg>
                                            现酒店地址:<%=modify.getAddress()%>
										</span>
                                    <svg aria-hidden="true" class="octicon octicon-location" height="16"
                                         version="1.1"
                                         viewBox="0 0 12 16" width="12">
                                        <path fill-rule="evenodd"
                                              d="M6 0C2.69 0 0 2.5 0 5.5 0 10.02 6 16 6 16s6-5.98 6-10.5C12 2.5 9.31 0 6 0zm0 14.55C4.14 12.52 1 8.44 1 5.5 1 3.02 3.25 1 6 1c1.34 0 2.61.48 3.56 1.36.92.86 1.44 1.97 1.44 3.14 0 2.94-3.14 7.02-5 9.05zM8 5.5c0 1.11-.89 2-2 2-1.11 0-2-.89-2-2 0-1.11.89-2 2-2 1.11 0 2 .89 2 2z"/>
                                    </svg>
                                    现银行账号：<%=modify.getBankAccount()%>
                                </p>
                            </div>

                            <div class="d-table-cell col-2 v-align-top text-right">
						<span class="user-following-container js-toggler-container js-social-container on">

						  <span class="unfollow">
							<!-- '"` --><!-- </textarea></xmp> -->
                              </option>
                              <form accept-charset="UTF-8"
                                    action="<%=response.encodeURL(request.getContextPath()+"/ModifyCheckServlet")%>"
                                    id="modifyCheckForm"
                                    data-form-nonce="" data-remote="true" value="modifyCheckTest"
                                    method="post"><div
                                      style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden"
                                                                                       value="&#x2713;"/>
                                  <input name="rawHostelno" value="<%=raw.getUserno()%>" type="hidden">
                                  <input name="modifyHostelno" value="<%=modify.getUserno()%>" type="hidden"></div>
							  <button
                                      type="submit"
                                      class="btn btn-sm  js-toggler-target m_inline btn-success"
                                      aria-label="Follow this person" title="Follow 14dtj" id="modifyPassBtn">
								通过
							  </button>
                                   <button
                                           type="submit"
                                           class="btn btn-sm  js-toggler-target m_inline btn-warning"
                                           aria-label="Follow this person" title="Follow 14dtj" id="modifyRejectBtn">
								拒绝
							  </button>
							  </form>
						  </span>
					    </span>
                            </div>
                        </div>
                    </div>
                    <%
                            }
                        }
                    %>

                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../part/footer.jsp"/>

</html>


