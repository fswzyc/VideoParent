<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>商品管理</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/confirm.js"></script>

    <script type="text/javascript">
        function showName(obj, id, type) {
            if (type == 1) {
                var name = $(obj).text();
                $("#speakerName").val(name);
                $("#speakerId").val(id)
            } else {
                var name = $(obj).text();
                $("#courseTitle").val(name);
                $("#courseId").val(id)
            }
        }

        $(function () {
            var speakerId = '${video.spearkerId}';
            $("#selectSpeaker li").each(function () {

                if ($(this).val() == speakerId) {
                    $("#speakerName").val($(this).text());
                }
            });

            var courseId = '${video.courseId}';
            $("#selectCourse li").each(function () {

                if ($(this).val() == courseId) {
                    $("#courseTitle").val($(this).text());
                }
            });


        });
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

        <div class="collapse navbar-collapse"
             id="bs-example-navbar-collapse-9">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath }/videomanage"> 视频管理</a></li>
                <li><a href="${pageContext.request.contextPath}/teachermanage">主讲人管理</a></li>
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
        <c:if test="${empty video.id}">
            <h2>添加视频信息</h2>
        </c:if>
        <c:if test="${not empty video.id}">
            <h2>修改视频信息</h2>
        </c:if>
    </div>
</div>
<div class="container">
    <form class="form-horizontal" action="${pageContext.request.contextPath}/saveVideo" method="post">

        <c:if test="${not empty video.id}">
            <input type="hidden" name="id" value="${video.id}">
        </c:if>

        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="title" value="${video.title}"
                       placeholder="视频名称">
            </div>
        </div>

        <div class="form-group ">
            <label for="inputEmail3" class="col-md-2 control-label">教师名字</label>
            <div class="col-md-1">
                <div class="btn-group">

                    <button class="btn btn-default dropdown-toggle" type="button"
                            data-toggle="dropdown" aria-haspopup="true"
                            aria-expanded="false">
                        下拉菜单&nbsp; <span class="caret"></span>
                    </button>
                    <ul id="selectSpeaker" class="dropdown-menu" aria-labelledby="dropdownMenu1">
                        <c:forEach items="${speakerList}" var="speaker">
                            <li value='${speaker.id}'><a href="#"
                                                         onclick="showName(this,${speaker.id},1)"> ${speaker.speakerName}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="col-md-9">
                <c:if test="${not empty video.spearkerId}">
                    <input type="hidden" class="form-control" id="speakerId" name="spearkerId" value="${video.spearkerId}">
                </c:if>
                <c:if test="${empty video.spearkerId}">
                    <input type="hidden" class="form-control" id="speakerId" name="spearkerId" value="0">
                </c:if>

                <input type="text" class="form-control"  disabled id="speakerName">
            </div>
        </div>


        <div class="form-group ">
            <label for="inputEmail3" class="col-md-2 control-label">所属课程</label>
            <div class="col-md-1">
                <div class="btn-group">

                    <button class="btn btn-default dropdown-toggle" type="button"
                            data-toggle="dropdown" aria-haspopup="true"
                            aria-expanded="false">
                        下拉菜单 &nbsp; <span class="caret"></span>
                    </button>
                    <ul id="selectCourse" class="dropdown-menu" aria-labelledby="dropdownMenu1">
                        <c:forEach items="${courseList}" var="course">
                            <li value="${course.id}"><a href="#"
                                                        onclick="showName(this,${course.id},2)">${course.courseTitle}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="col-md-9">
                <c:if test="${not empty video.courseId}">
                    <input type="hidden" class="form-control" id="courseId" name="courseId" value="${video.courseId}">
                </c:if>
                <c:if test="${empty video.courseId}">
                    <input type="hidden" class="form-control" id="courseId" name="courseId" value="0">
                </c:if>

                <input type="text" class="form-control" disabled id="courseTitle" value="">
            </div>
        </div>

        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">时长</label>
            <div class="col-sm-10">
                <c:if test="${empty video.time}">
                    <input type="text" class="form-control" id="inputEmail3" name="time"
                           value="0" placeholder="精确到毫秒（正整数）">
                </c:if>
                <c:if test="${not empty video.time}">
                    <input type="text" class="form-control" id="inputEmail3" name="time"
                           value="${video.time}" placeholder="精确到毫秒（正整数）">
                </c:if>

            </div>
        </div>

        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">封面图片地址</label>
            <div class="col-sm-10">
                <input type="url" class="form-control" id="" name="imageUrl"
                       value="${video.imageUrl}"
                       placeholder="具体的url">
            </div>
        </div>


        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">视频播放地址</label>
            <div class="col-sm-10">
                <input type="url" class="form-control" id="" name="videoUrl"
                       value="${video.videoUrl}"
                       placeholder="具体的url">
            </div>
        </div>

        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">备注</label>
            <div class="col-sm-10">
                <textarea rows="3" cols="130" name="detail">${video.detail}</textarea>

            </div>

        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">保存</button>
            </div>
        </div>
    </form>

</div>

<script type="text/javascript">
    $(function () {
        $('[data-toggle="popover"]').popover();
    })
</script>

</body>
</html>