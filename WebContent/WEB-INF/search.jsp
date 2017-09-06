<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="UTF-8">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta content="all" name="robots" />
    <meta name="author" content="Fisher" />
    <meta name="Copyright" content="Copyright 2007-2008, 版权所有 www.reefdesign.cn" />
    <meta name="description" content="reefdesign" />
    <meta name="keywords" content="reefdesign" />
    <title>电子书城</title>
    <link rel="shortcut icon" href="favicon.ico">
    <link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
</head>
<body class="main">
<%@include file="header.jsp" %>
    <div id="divsearch">
        <table width="100%" border="0" cellspacing="0">
            <tr>
                <td style="text-align: right; padding-right: 220px">
                    Search
                    <input type="text" name="textfield" class="inputtable" />
                    <!--<input name="searchbutton" type="image" src="images/serchbutton.gif" style=" margin-bottom:-4px"/>-->
                    <a href="search.html">
                        <img src="${pageContext.request.contextPath }/images/serchbutton.gif" border="0" style="margin-bottom: -4px" /></a>
                </td>
            </tr>
        </table>
    </div>
    <div id="divpagecontent">
        <table width="100%" border="0" cellspacing="0">
                <td>
                    <div style="text-align: right; margin: 5px 10px 5px 0px">
                        <a href="${pageContext.request.contextPath }/index.do">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;公告新闻&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;文章标题</div>
                    <table cellspacing="0" class="infocontent">
                        <tr>
                            <td>
                                <table width="100%" border="0" cellspacing="0">
                                    <tr>
                                        <td style="padding: 10px">
                                            以下 <strong>${pageInfo.totalnumber }</strong> 条结果按 <strong>销量</strong> 排列 每页显示<strong>20</strong>条<hr />

                                            <table border="0" cellspacing="0" class="searchtable">
                                                <tr>
                                                    <td width="20%" rowspan="2">
                                                        <div class="divbookpic">
                                                            <p>
                                                                <a href="info.html">
                                                                    <img src="${pageContext.request.contextPath }/bookcover/dayongxiaohua.jpg" width="115" height="129" border="0" /></a></p>
                                                        </div>
                                                    </td>
                                                    <td colspan="2">
                                                        <font class="bookname">大勇和小花的欧洲日记</font><br />
                                                        作者：薛勇，林若岚 著<br />
                                                        《大勇和小花的欧洲日记》串起了欧洲文明的溯源之旅。从屹立在近现代艺术之巅的巴黎拾级而下，依次是蓬皮杜博物馆（现代艺术）、奥塞博物馆（印象派艺术）、卢浮宫博物馆（古典主义）....
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        售价：<font color="#FF0000">￥18.60</font>&nbsp;&nbsp;&nbsp;&nbsp;原价：<s>￥30.00</s>
                                                    </td>
                                                    <td style="text-align: right">
                                                        <a href="cart.html">
                                                            <img src="${pageContext.request.contextPath }/images/buy.gif" width="91" height="27" border="0" style="margin-bottom: -8px" /></a>
                                                    </td>
                                                </tr>
                                            </table>
                                            <table border="0" cellspacing="0" class="searchtable">
                                                <tr>
                                                    <td width="20%" rowspan="2">
                                                        <div class="divbookpic">
                                                            <p>
                                                                <a href="info.html">
                                                                    <img src="${pageContext.request.contextPath }/bookcover/dulala.jpg" width="109" height="141" border="0" /></a></p>
                                                        </div>
                                                    </td>
                                                    <td colspan="2">
                                                        <font class="bookname">大勇和小花的欧洲日记</font><br />
                                                        作者：薛勇，林若岚 著<br />
                                                        《大勇和小花的欧洲日记》串起了欧洲文明的溯源之旅。从屹立在近现代艺术之巅的巴黎拾级而下，依次是蓬皮杜博物馆（现代艺术）、奥塞博物馆（印象派艺术）、卢浮宫博物馆（古典主义）....
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        售价：<font color="#FF0000">￥18.60</font>&nbsp;&nbsp;&nbsp;&nbsp;原价：<s>￥30.00</s>
                                                    </td>
                                                    <td style="text-align: right">
                                                        <a href="cart.html">
                                                            <img src="${pageContext.request.contextPath }/images/buy.gif" width="91" height="27" border="0" style="margin-bottom: -8px" /></a>
                                                    </td>
                                                </tr>
                                            </table>
                                            <table border="0" cellspacing="0" class="searchtable">
                                                <tr>
                                                    <td width="20%" rowspan="2">
                                                        <div class="divbookpic">
                                                            <p>
                                                                <a href="info.html">
                                                                    <img src="${pageContext.request.contextPath }/bookcover/tripcn.jpg" width="83" height="135" border="0" /></a></p>
                                                        </div>
                                                    </td>
                                                    <td colspan="2">
                                                        <font class="bookname">大勇和小花的欧洲日记</font><br />
                                                        作者：薛勇，林若岚 著<br />
                                                        《大勇和小花的欧洲日记》串起了欧洲文明的溯源之旅。从屹立在近现代艺术之巅的巴黎拾级而下，依次是蓬皮杜博物馆（现代艺术）、奥塞博物馆（印象派艺术）、卢浮宫博物馆（古典主义）....
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        售价：<font color="#FF0000">￥18.60</font>&nbsp;&nbsp;&nbsp;&nbsp;原价：<s>￥30.00</s>
                                                    </td>
                                                    <td style="text-align: right">
                                                        <a href="cart.html">
                                                            <img src="${pageContext.request.contextPath }/images/buy.gif" width="91" height="27" border="0" style="margin-bottom: -8px" /></a>
                                                    </td>
                                                </tr>
                                            </table>
                                            <table border="0" cellspacing="0" class="searchtable">
                                                <tr>
                                                    <td width="20%" rowspan="2">
                                                        <div class="divbookpic">
                                                            <p>
                                                                <a href="info.html">
                                                                    <img src="${pageContext.request.contextPath }/bookcover/photog.jpg" width="92" height="128" border="0" /></a></p>
                                                        </div>
                                                    </td>
                                                    <td colspan="2">
                                                        <font class="bookname">大勇和小花的欧洲日记</font><br />
                                                        作者：薛勇，林若岚 著<br />
                                                        《大勇和小花的欧洲日记》串起了欧洲文明的溯源之旅。从屹立在近现代艺术之巅的巴黎拾级而下，依次是蓬皮杜博物馆（现代艺术）、奥塞博物馆（印象派艺术）、卢浮宫博物馆（古典主义）....
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        售价：<font color="#FF0000">￥18.60</font>&nbsp;&nbsp;&nbsp;&nbsp;原价：<s>￥30.00</s>
                                                    </td>
                                                    <td style="text-align: right">
                                                        <a href="cart.html">
                                                            <img src="${pageContext.request.contextPath }/images/buy.gif" width="91" height="27" border="0" style="margin-bottom: -8px" /></a>
                                                    </td>
                                                </tr>
                                            </table>
                                            <table border="0" cellspacing="0" class="searchtable">
                                                <tr>
                                                    <td width="20%" rowspan="2">
                                                        <div class="divbookpic">
                                                            <p>
                                                                <a href="info.html">
                                                                    <img src="${pageContext.request.contextPath }/bookcover/java2.jpg" width="102" height="130" border="0" /></a></p>
                                                        </div>
                                                    </td>
                                                    <td colspan="2">
                                                        <font class="bookname">大勇和小花的欧洲日记</font><br />
                                                        作者：薛勇，林若岚 著<br />
                                                        《大勇和小花的欧洲日记》串起了欧洲文明的溯源之旅。从屹立在近现代艺术之巅的巴黎拾级而下，依次是蓬皮杜博物馆（现代艺术）、奥塞博物馆（印象派艺术）、卢浮宫博物馆（古典主义）....
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        售价：<font color="#FF0000">￥18.60</font>&nbsp;&nbsp;&nbsp;&nbsp;原价：<s>￥30.00</s>
                                                    </td>
                                                    <td style="text-align: right">
                                                        <a href="cart.html">
                                                            <img src="${pageContext.request.contextPath }/images/buy.gif" width="91" height="27" border="0" style="margin-bottom: -8px" /></a>
                                                    </td>
                                                </tr>
                                            </table>
                                           
                                            <div class="pagination">
                                                <ul>
                                                    <li class="disablepage"><< 上一页 </li>
                                                    <li class="currentpage">1</li>
                                                    <li><a href="#">2</a></li>
                                                    <li><a href="#">3</a></li>
                                                    <li><a href="#">4</a></li>
                                                    <li><a href="#">5</a></li>
                                                    <li><a href="#">6</a></li>
                                                    <li><a href="#">7</a></li>
                                                    <li><a href="#">8</a></li>
                                                    <li><a href="#">9</a>...</li>
                                                    <li><a href="#">15</a></li>
                                                    <li><a href="#">16</a></li>
                                                    <li class="nextpage"><a href="#">下一页 >></a></li>
                                                </ul>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
    <%@include file="footer.jsp" %>
</body>
</html>