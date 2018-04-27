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
    <link rel="icon" href="http://182.254.145.242/ifengxue/favicon.ico">

    <title>章节内容-小说搜搜-免费且无广告的小说阅读网</title>

    <!-- Bootstrap core CSS -->
    <link href="http://182.254.145.242/ifengxue/res/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
    	body {
    		background-color:#E5E4DB;
    	}
    	.content {
    		font-size:16px;
    		background-color:#F6F4EC;
    		color:#333;
    		padding:20px;
    		border-radius:5px;
    		-webkit-border-radiu:5px;
    	}
    	.jumbotron {
    		padding-top:10px;
    		padding-bottom:10px;
    		background-color:#F5F5F5;
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
				<a class="navbar-brand" href="../../">疯雪</a>
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
							<li><a href="#">教务查询</a></li>
							<li><a href="#">铁通查询</a></li>
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
	<div class="container">
		<h3 style="text-align:center;">${chapterDetail.title}</h3>
		<div class="content">
			<c:if test="${isSuccess }">
					${chapterDetail.content }
			</c:if>
			<c:if test="${!isSuccess }">
				很抱歉，章节内容下载失败了，请您再试一次！	
			</c:if>
		</div>
		<div style="text-align:center;">
			<c:if test="${isSuccess }">
				<c:if test="${empty chapterDetail.prev }">
					<a class="btn btn-link" href="javascript:alert('哎呀，已经是第一章了！');"><span id="prev" >前一章（&lt;-）</span></a>
				</c:if>
				<c:if test="${not empty chapterDetail.prev }">
					<a class="btn btn-link" href="./getChapterDetail?url=${chapterDetail.prev }&chapterBase64Url=${chapterBase64Url}"><span id="prev"  >前一章（&lt;-）</span></a>
				</c:if>
				<a href="./getChapters?base64Url=${chapterBase64Url }" target="_blank">章节列表</a>
				<c:if test="${empty chapterDetail.next }">
					<a class="btn btn-link" href="javascript:alert('哎呀，已经是最后一章了！');"><span id="next"  >下一章(-&gt;)</span></a>
				</c:if>
				<c:if test="${not empty chapterDetail.next }">
					<a class="btn btn-link" href="./getChapterDetail?url=${chapterDetail.next }&chapterBase64Url=${chapterBase64Url}"><span id="next"  >下一章(-&gt;)</span></a>
				</c:if>
			</c:if>
		</div>
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="http://182.254.145.242/ifengxue/res/js/1.11.3jquery.min.js"></script>
    <script src="http://182.254.145.242/ifengxue/res/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	<script src="http://182.254.145.242/ifengxue/res/js/base64.js"></script>
	<script>
		$(function() {
			$(document).keydown(function(e) {
				if (e.keyCode == 37) {//<-
					$("#prev").click();
				} else if (e.keyCode == 39) {//->
					$("#next").click();
				}
			})
		})
	</script>
</body>
</html>