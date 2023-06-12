<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <h1>
        <center>QUẢN LÝ LOẠI SẢN PHẨM</center>
    </h1>
    <form:form action="/admin/loaisp/add" method="post"
    modelAttribute="data">
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Mã</label>
            <div class="col-sm-10">
                <form:input path="ma" class="form-control"/>
                <form:errors  path="ma" />
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Tên</label>
            <div class="col-sm-10">
                <form:input path="ten" class="form-control"/>
                <form:errors path="ten" />
            </div>
        </div>
        <div>
            <button type="submit" class="btn btn-success">Add</button>
        </div>
    </form:form>
    <br>
    <c:if test="${ds.isEmpty()}">
        <h3>Không có dữ liệu</h3>
    </c:if>
    <c:if test="${not ds.isEmpty()}">
    <p>Tìm thấy ${ds.getTotalElements()} loại sản phẩm</p>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>
            <th scope="col" colspan="2">Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ds.getContent()}" var="ms" varStatus="a">
            <tr>
                <th scope="row">${a.index+1}</th>
                <th>${ms.ma}</th>
                <td>${ms.ten}</td>
                <td><a class="btn btn-info" href="/admin/loaisp/detail/${ms.id}">Edit</a></td>
                <td><a class="btn btn-info" href="/admin/loaisp/delete/${ms.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <center>
        <c:if test="${ds.getNumber() gt 0}">
        <a href="?page=${ds.getNumber()}" class="btn btn-success">Previous</a>
        </c:if>
        <h4>${ds.getNumber()+1}/${ds.getTotalPages()}</h4>
        <c:if test="${ds.getNumber() lt ds.getTotalPages()-1}">
            <a href="?page=${ds.getNumber()+2}" class="btn btn-success">Next</a>
        </c:if>
        </center>
</c:if>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>