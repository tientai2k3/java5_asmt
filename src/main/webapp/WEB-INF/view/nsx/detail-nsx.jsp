<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <h1><center>QUẢN LÝ DÒNG SẢN PHẨM</center></h1>
    <form:form action="/admin/nsx/update/${nsx.id}" method="post"
    modelAttribute="data">
        <div class="row mb-3">
            <label  class="col-sm-2 col-form-label">Mã</label>
            <div class="col-sm-10">
                <form:input  class="form-control" value="${nsx.ma}" path="ma" />
                <form:errors path="ma"/>
            </div>
        </div>
        <div class="row mb-3">
            <label  class="col-sm-2 col-form-label">Tên</label>
            <div class="col-sm-10">
                <form:input  class="form-control" value="${nsx.ten}" path="ten" />
                <form:errors path="ma"/>
            </div>
        </div>
        <div>
            <button type="submit" class="btn btn-success">Update</button>
        </div>
    </form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>