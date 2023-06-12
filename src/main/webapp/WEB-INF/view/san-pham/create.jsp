<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/03/2023
  Time: 10:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3><center>ĐỒNG HỒ</center></h3>
    <br>
    <form:form action="/admin/dong-ho/add" method="POST" enctype="multipart/form-data" modelAttribute="data" >
        <div class="row">
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Loại Sản Phẩm</label>
                <form:select class="form-select" aria-label="Default select example" path="loaiSP">
                    <c:forEach items="${dsLoaiSP}" var="lsp">
                        <form:option value="${lsp.id}">${lsp.ten}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Thương hiệu</label>
                <form:select class="form-select" aria-label="Default select example" path="nsx">
                    <c:forEach items="${dsNSX}" var="nsx">
                        <form:option value="${nsx.id}">${nsx.ten}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Mã Sản Phẩm</label>
                <form:input path="ma" class="form-control"/>
                <form:errors  path="ma" />
            </div>
        <br>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Tên Sản Phẩm</label>
                <form:input path="ten" class="form-control"/>
                <form:errors  path="ten" />
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Màu sắc</label>
                <form:select class="form-select" aria-label="Default select example" path="mauSac">
                    <form:option value="bachKim">Bạch Kim</form:option>
                    <form:option value="vang">Vàng</form:option>
                    <form:option value="den">Đen</form:option>
                </form:select>
            </div>
        <br>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Chọn Size(mm)</label>
                <form:select class="form-select" aria-label="Default select example" path="size">
                    <form:option value="38">38mm</form:option>
                    <form:option value="40">40mm</form:option>
                    <form:option value="42">42mm</form:option>
                </form:select>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Năm Bảo Hành</label>
                <form:input path="namBH" class="form-control" type="number"/>
                <form:errors  path="namBH" />
            </div>
        <br>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Mô tả</label>
                <form:textarea path="moTa" class="form-control"/>
                <form:errors  path="moTa" />
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Số lượng tồn</label>
                <form:input path="soLuongTon" class="form-control" type="number"/>
                <form:errors  path="soLuongTon" />
            </div>
        <br>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Đơn giá</label>
                <form:input path="donGia" class="form-control" type="number"/>
                <form:errors  path="donGia" />
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Hình ảnh</label>
                <input type="file" name="image1"  class="form-control" >
            </div>
        </div>
        <br>
        <div>
            <button type="submit"class="btn btn-outline-danger">ADD</button>
        </div>
    </form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
