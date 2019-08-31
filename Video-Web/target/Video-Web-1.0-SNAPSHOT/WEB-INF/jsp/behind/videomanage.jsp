<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
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
        function showAddPage() {
            location.href = "${pageContext.request.contextPath}/video/addVideo.action";
        }

        $(function () {
            $("#btn").click(function () {
                if (deleteNum > 0) {

                    Confirm.show('溫馨提示', '您確定要刪除这' + deleteNum + '条记录嗎？', {
                        'Delete': {
                            'primary': true,
                            'callback': function () {
                                //不是ajax，模拟提交
                                $("#form2").submit();
                                //如果是一个正常表单的提交，按钮必须是type=submit,并且必须在form表单里面
                            }
                        }
                    });

                } else {
                    alert("您暂未选择任何数据，请选择您要删除的数据！");
                }

            });

        });


        var deleteNum = 0;

            function selectAll(obj) {
            //dom  jquery
            var value = obj.checked;
            //alert(value);
            var arr = document.getElementsByName("ids");
            for (var i = 0; i < arr.length; i++) {
                arr[i].checked = value;
            }
            if (value) {
                deleteNum = arr.length;
            } else {
                deleteNum = 0;
            }

            $("#delNum").text(deleteNum);

        }

        function selectOne(obj) {
            if (obj.checked) {
                deleteNum += 1;
            } else {
                deleteNum -= 1;
            }

            if (deleteNum == 0) {
                document.getElementById("checkAllId").checked = false;
            }

            var arr = document.getElementsByName("ids");
            if (deleteNum == arr.length) {
                document.getElementById("checkAllId").checked = true;
            }

            $("#delNum").text(deleteNum);
        }

        //解决选择下拉框内容到输入框内容的问题
        function showName(obj, id, type) {
            var name = $(obj).text();

            if (type == 1) {
                $("#speakerName").html(name + "<span class='caret'></span>");
                $("#speakerId").val(id);
            } else {
                $("#courseName").html(name + "<span class='caret'></span>");
                $("#courseId").val(id);
            }
        }
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


        <div class="collapse navbar-collapse"
             id="bs-example-navbar-collapse-9">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">视频管理</a></li>
                <li><a
                        href="${pageContext.request.contextPath }/teachermanage">主讲人管理</a></li>
                <li><a
                        href="${pageContext.request.contextPath }/coursemanage">课程管理</a></li>

            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">admin</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;&nbsp;退出</a></li>
            </ul>

        </div>

    </div>

</nav>
<div class="jumbotron" style="padding-top: 10px; padding-bottom: 25px">
    <div class="container">
        <h2>视频管理</h2>
    </div>
</div>

<div class="container ">
    <div class="row">
        <div class="col-md-6 ">
            <button type="button" class="btn btn-primary active"><a href="${pageContext.request.contextPath}/addvideo">添加</a>
            </button>

            <button id="btn" type="button" class="btn btn-primary active">
                批量删除 <span class="badge" id="delNum">0</span>
            </button>
        </div>

        <div class="col-md-6 " style="margin-bottom: 20px">

            <form class="form-inline navbar-right" action="${pageContext.request.contextPath}/videomanage"
                  style="margin-right: 10px" method="post">
                <div class="form-group">

                    <input type="text" name="title" class="form-control" id="exampleInputEmail3"
                           placeholder="标题">
                </div>

                <div class="btn-group">
                    <button type="button" id="speakerName"
                            class="btn btn-primary dropdown-toggle"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        请选择老师<span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <c:forEach items="${list}" var="speaker">
                            <li value='${speaker.id}'><a href="#"
                                                         onclick="showName(this,'${speaker.id}',1)">${speaker.speakerName}</a>
                            </li>
                        </c:forEach>
                    </ul>
                    <input type="hidden" name="speakerId" id="speakerId" value="0"/>
                </div>

                <div class="btn-group">
                    <button type="button" id="courseName"
                            class="btn btn-primary dropdown-toggle"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        请选择课程<span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <c:forEach items="${course}" var="course">
                            <li value="${course.id}"><a href="#"
                                                        onclick="showName(this,${course.id},2)">${course.courseTitle}</a>
                            </li>
                        </c:forEach>
                    </ul>
                    <input type="hidden" name="courseId" id="courseId" value="0"/>
                </div>
                <button type="submit" class="btn btn-info">查&nbsp;询</button>
            </form>
        </div>
    </div>
</div>

<div class="container">

    <form id="form2" action="delBatchVideos" method="post">
        <table class="table table-bordered table-hover table-striped"
               style="text-align: center; table-layout: fixed;">
            <thead>
            <tr>
                <th style="text-align: center"><input type="checkbox" onclick="selectAll(this)" id="checkAllId"/></th>
                <th style="text-align: center">序号</th>
                <th style="text-align: center; width: 16%;">名称</th>
                <th style="text-align: center;  width: 30%;">介绍</th>
                <th style="text-align: center">讲师</th>
                <th style="text-align: center">时长</th>
                <th style="text-align: center">播放次数</th>

                <th style="text-align: center">编辑</th>
                <th style="text-align: center">删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageInfo.list}" var="video" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="ids" value="${video.id}"
                               onclick="selectOne(this)"/></td>
                    <td>${s.count}</td>
                    <td>${video.title}</td>
                    <td style="padding-top: 7px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${video.detail}</td>
                    <td>${video.speakerName}</td>
                    <td>${video.showTime}</td>
                    <td>${video.playNum}</td>
                    <td><a href="${pageContext.request.contextPath}/edit?id=${video.id}"><span
                            class="glyphicon glyphicon-edit"></span></a>
                    </td>
                    <td><a href="${pageContext.request.contextPath}/delete?id=${video.id}"><span
                            class="glyphicon glyphicon-trash"></span></a></td>
                </tr>

            </c:forEach>


            </tbody>
        </table>
    </form>
</div>

    <div class="container">
    <div class="navbar-right">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="${pageContext.request.contextPath}/videomanage?page=${pageInfo.prePage}&pageSize=${pageInfo.pageSize}"
                       aria-label="Previous">
                        <span aria-hidden="true">上一页</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                    <li>
                        <a href="${pageContext.request.contextPath}/videomanage?page=${pageNum}&pageSize=${pageInfo.pageSize}">${pageNum}</a>
                    </li>
                </c:forEach>


                <li>
                    <a href="${pageContext.request.contextPath}/videomanage?page=${pageInfo.nextPage}&pageSize=${pageInfo.pageSize}"
                       aria-label="Next">
                        <span aria-hidden="true">下一页</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>


<script type="text/javascript">
    $(function () {
        $('[data-toggle="popover"]').popover();
    })
</script>
</body>
</html>
