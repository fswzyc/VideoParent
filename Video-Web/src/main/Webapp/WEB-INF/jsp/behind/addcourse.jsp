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
            src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/confirm.js"></script>

    <script type="text/javascript">
        //解决选择下拉框内容到输入框内容的问题
        // js 函数
        function showTitle(obj, id) {
            var name = $(obj).text();

            $("#subjectName").val(name);
            $("#subjectId").val(id)

        }
        $(function () {
            var speakerId = '${course.subjectId}';

            $("#selectCourse li").each(function () {

                if ($(this).val() == speakerId) {
                    $("#subjectName").val($(this).text());
                }
            });
        });
    </script>

</head>
<body>


<nav class="navbar navbar-inverse" style="margin-bottom: 0px">
    <div class="container">

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
                <li><a href="${pageContext.request.contextPath }/teachermanage">主讲人管理</a></li>
                <li class="active"><a href="${pageContext.request.contextPath }/coursemanage">课程管理</a></li>

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
        <c:if test="${empty course.id}">
            <h2>添加课程</h2>
        </c:if>
        <c:if test="${not empty course.id}">
            <h2>修改课程</h2>
        </c:if>
    </div>
</div>
<div class="container">
    <form class="form-horizontal" action="${pageContext.request.contextPath}/saveCourse" method="post">
        <c:if test="${not empty course.id}">
            <input type="hidden" name="id" value="${course.id}">
        </c:if>

        <div class="form-group ">
            <label for="inputEmail3" class="col-md-2 control-label">所属学科</label>
            <div class="col-md-1">
                <div class="btn-group">

                    <button class="btn btn-default dropdown-toggle" type="button"
                    data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false">
                    下拉菜单 &nbsp;<span class="caret"></span>
                    </button>
                    <ul id="selectCourse" class="dropdown-menu" aria-labelledby="dropdownMenu1">
                        <c:forEach items="${subjectList}" var="subject">
                            <li value="${subject.id}"><a href="#" onclick="showTitle(this,${subject.id})"> ${subject.subjectName}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="col-md-9">
                <c:if test="${empty course.subjectId}">
                    <input type="hidden" class="form-control" id="subjectId" name="subjectId" value="0">
                </c:if>
                <c:if test="${not empty course.subjectId}">
                    <input type="hidden" class="form-control" id="subjectId" name="subjectId" value="${course.subjectId}">
                </c:if>
                <input type="text" class="form-control" disabled id="subjectName"  placeholder="">
            </div>
        </div>


        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">标题</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="" name="courseTitle"
                       value="${course.courseTitle}"
                       placeholder="课程标题">
            </div>
        </div>


        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">简介</label>
            <div class="col-sm-10">
                <textarea rows="3" cols="130" name="courseDesc">${course.courseDesc}</textarea>

            </div>

        </div>
        <div class="col-sm-10" style="margin-left: 180px">

            <input class="btn btn-default" type="submit" value="保&nbsp;存">
        </div>


    </form>

</div>



</body>
</html>