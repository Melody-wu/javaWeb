<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div id="main">
    <div class="container main-bar">
        <h1>话题管理</h1>
        <table class="table table-bordered">
            <tr>
                <th>编号</th>
                <th>名称</th>
                <th>url</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
         
            <form id="ajaxForm">
                <tr>
                    <td></td>
                    <td><input type="text" name="name"></td>
                    <td><input name="url"></td>
                    <td></td>
                    <td>
                        <button type="button" onclick="myAjaxForm({url : '<c:url value="/admin/topic"/>'})">new</button>
                    </td>
                </tr>
                <div id="formAlert" class="alert alert-danger hidden" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <span id="formAlertText"></span>
                </div>
            </form>
        </table>
    </div>
</div>
</body>
</html>
