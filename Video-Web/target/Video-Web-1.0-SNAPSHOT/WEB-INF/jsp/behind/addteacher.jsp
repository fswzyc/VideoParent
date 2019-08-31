<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title></title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
            rel="stylesheet">
    <script
            src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script
            src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/confirm.js"></script>

    <script type="text/javascript">

    </script>

</head>
<body>


<nav class="navbar navbar-inverse" style="margin-bottom: 0px">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse" data-target="#bs-example-navbar-collapse-9"
                    aria-expanded="false">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">视频管理系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse"
             id="bs-example-navbar-collapse-9">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath }/videomanage"> 视频管理</a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/teachermanage">主讲人管理</a></li>
                <li><a href="${pageContext.request.contextPath }/coursemanage">课程管理</a></li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">admin</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;&nbsp;退出</a></li>
            </ul>
        </div>

    </div>

</nav>

<div class="jumbotron" style="padding-top: 20px; padding-bottom: 26px">
    <div class="container">
        <c:if test="${empty speaker.id}">
             <h2>添加主讲人</h2>
        </c:if>
        <c:if test="${not empty speaker.id}">
            <h2>修改主讲人</h2>
        </c:if>

    </div>
</div>
<div class="container">
    <form class="form-horizontal" action="${pageContext.request.contextPath}/saveSpeaker" method="post">

        <c:if test="${not empty speaker.id}">
            <input type="hidden" name="id" value="${speaker.id}">
        </c:if>

        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="" name="speakerName" value="${speaker.speakerName}"
                       placeholder="主讲人姓名">
            </div>
        </div>

        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">职位</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="" name="speakerJob" value="${speaker.speakerJob}"
                       placeholder="主讲人职位">
            </div>
        </div>

        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">头像地址</label>
            <div class="col-sm-10">
                <input type="url" class="form-control" id="" name="headImgUrl" value="${speaker.headImgUrl}"
                       placeholder="主讲人头像">
            </div>
        </div>

        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">简介</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="" name="speakerDesc" value="${speaker.speakerDesc}"
                       placeholder="主持人简介">
            </div>
        </div>
        <div style="margin-left: 195px">
            <input class="btn btn-default" type="submit"  value="保&nbsp;存">

        </div>

    </form>

</div>



</body>
</html>