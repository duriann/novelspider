<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>章节列表-小说搜搜-免费且无广告的小说阅读网</title>

    <!-- Bootstrap core CSS -->
     <link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
    	.jumbotron {
    		padding-top:10px;
    		padding-bottom:10px;
    	}
    </style>
  </head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" style="display:none;">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="../../">菠萝</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="../../">主页</a></li>
					<li><a href="#">关于</a></li>
					<li><a href="#">联系我</a></li>
					<li class="dropdown"><a href="javascript:void(0);"
						class="dropdown-toggle" data-toggle="dropdown">我的项目<b
							class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="../jwsys/index.html">教务查询</a></li>
							<li><a href="../ttsys/index.html">铁通查询</a></li>
							<li><a href="#">尔雅题库</a></li>
						</ul></li>
				</ul>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>
	<div class="jumbotron">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<!-- <div class="input-group">
						<input type="text" id="keyword" class="form-control"  placeholder="可以输入书名，作者名，甚至可以是符合条件的URL...">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button" id="btnSearch">小说搜搜</button>
						</span>
					</div> -->
					<a href="./search.html">回到搜索页</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container no-table-responsive">
		<table class="table table-striped table-bordered table-condensed table-hover">
			<thead>
				<tr>
					<th colspan="4" style="text-align:center;">
						章节列表
					</th>
				</tr>
			</thead>
			<tbody>
				<!-- 每四章换一列 -->
				<c:if test="${isSuccess }">
					<c:forEach var="chapter" items="${chapters }" varStatus="status">
						<c:if test="${status.index % 4 == 0}" var="testResult"><tr></c:if>
							<td><a href="./chapter.do?base64Url=${chapter.url }&chapterBase64Url=${chapterBase64Url}" target="_blank">${chapter.text}</a></td>
						<c:if test="${(status.index + 1) % 4 == 0 }"></tr></c:if>
					</c:forEach>		
				</c:if>
				<c:if test="${!isSuccess }">
					<tr>
						<td colspan="4" style="text-align:center;">
							很抱歉，章节列表下载失败，您可以再试一次！
						</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.base64.js"></script>

</body>
</html>