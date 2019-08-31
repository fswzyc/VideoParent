<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="p" uri="http://fsw.com/common/" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/confirm.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse" style="margin-bottom:0px">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-9" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">视频管理系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath }/videomanage">视频管理</a></li>
                <li><a href="${pageContext.request.contextPath }/teachermanage">主讲人管理</a></li>
                <li class="active"><a href="#p">课程管理</a></li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">admin</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;&nbsp;退出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="jumbotron" style="padding-top:20px; padding-bottom:26px">
    <div class="container">
        <h2>课程管理</h2>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-6">
            <button type="button" class="btn btn-info"><a href="${pageContext.request.contextPath}/addcourse">添加</a></button>
        </div>

    </div>
</div>


<div class="container" style="margin-top:20px">
    <table class="table table-striped table-bordered table-hover" style="text-align:center; table-layout: fixed;">

        <thead>
        <tr>
            <th style="text-align:center">序号</th>
            <th style="text-align:center">标题</th>
            <th style="text-align:center; width: 30%;">简介</th>
            <th style="text-align:center">编辑</th>
            <th style="text-align:center">删除</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.rows}" var="course" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${course.courseTitle}</td>
                <td style="padding-top: 7px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${course.courseDesc}</td>
                <td><a href="${pageContext.request.contextPath}/updateCourse?id=${course.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                <td><a href="${pageContext.request.contextPath}/deleteCourse?id=${course.id}"><span class="glyphicon glyphicon-trash"></span></a></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<div class="container">
    <div class="navbar-right" style="padding-right: 17px">
        <p:page url="${pageContext.request.contextPath}/coursemanage"></p:page>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        $('[data-toggle="popover"]').popover();
    })
</script>
</body>
</html>