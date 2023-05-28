<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/03/2023
  Time: 10:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form action="/dong-ho/add" method="POST">
        <div class="row">
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Loại Sản Phẩm</label>
                <select class="form-select" aria-label="Default select example" name="loaiSP">
                    <c:forEach items="${dsLoaiSP}" var="lsp">
                        <option value="${lsp.id}">${lsp.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Thương hiệu</label>
                <select class="form-select" aria-label="Default select example" name="nsx">
                    <c:forEach items="${dsNSX}" var="nsx">
                        <option value="${nsx.id}">${nsx.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Mã Sản Phẩm</label>
                <input type="text" class="form-control" name="ma" >
            </div>
        <br>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Tên Sản Phẩm</label>
                <input type="text" class="form-control" name="ten" >
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Màu sắc</label>
                <select class="form-select" aria-label="Default select example" name="mauSac">
                    <option value="bachKim">Bạch Kim</option>
                    <option value="vang">Vàng</option>
                    <option value="den">Đen</option>
                </select>
            </div>
        <br>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Chọn Size(mm)</label>
                <select class="form-select" aria-label="Default select example" name="size">
                    <option value="38">38mm</option>
                    <option value="40">40mm</option>
                    <option value="42">42mm</option>
                </select>
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Năm Bảo Hành</label>
                <input type="number" class="form-control" name="namBH" >
            </div>
        <br>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Mô tả</label>
                <input type="text" class="form-control" name="moTa" >
            </div>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Số lượng tồn</label>
                <input type="number" class="form-control" name="soLuongTon" >
            </div>
        <br>
            <div class="col-md-6">
                <label for="formGroupExampleInput" class="form-label">Đơn giá</label>
                <input type="number" class="form-control" name="donGia" >
            </div>
        </div>
        <br>
        <div>
            <button type="submit" onclick="return confirm('Bạn chắc chắn muốn thêm chứ?')" class="btn btn-outline-danger">ADD</button>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
