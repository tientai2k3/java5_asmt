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
    <h4><center>DANH SÁCH ĐỒNG HỒ</center></h4>
    <hr>
    <div style="margin-bottom: 20px">
        <a href="/dong-ho/create"class="btn btn-outline-danger">Thêm mới</a>
    </div>
    <form>
        <div>
            <input type="text" class="form-control" placeholder="Tìm kiếm theo tên" name="tenSanPham" value="${param.tenSanPham}" >
        </div>
        <br>
        <div class="row">
            <lable>Tìm kiếm theo Giá</lable>
            <div class="col-md-6">
                <input type="number" class="form-control" placeholder="From" name="min" value="${param.min}" >
            </div>
            <div class="col-md-6">
                <input type="number" class="form-control" placeholder="To" name="max"value="${param.max}" >
            </div>
        </div>

        <div style="margin-top: 20px">
            <button type="submit" class="btn btn-success">Search</button>
        </div>
    </form>
    <c:if test="${ds.isEmpty()}">
        <h3>Không có dữ liệu</h3>
    </c:if>
    <c:if test="${not ds.isEmpty()}">
        <p>Tìm thấy ${ds.getTotalElements()} sản phẩm</p>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Mã Sản Phẩm</th>
                <th scope="col">Tên Sản Phẩm</th>
                <th scope="col">Loại Sản Phẩm</th>
                <th scope="col">Thương hiệu</th>
                <th scope="col">Màu Sắc</th>
                <th scope="col">Size</th>
                <th scope="col">Năm bảo hành</th>
                <th scope="col">Mô tả</th>
                <th scope="col">Số lượng tồn</th>
                <th scope="col">Đơn giá</th>
                <th scope="col" colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ds.getContent()}" var="sp">
                <tr>
                    <th scope="row">${sp.ma}</th>
                    <td>${sp.ten}</td>
                    <td>${sp.loaiSP.ten}</td>
                    <td>${sp.nsx.ten}</td>
                    <td>${sp.mauSac=="bachKim"?"Bạch kim":sp.mauSac=="vang"?"Vàng":"Đen"}</td>
                    <td>${sp.size}mm</td>
                    <td>${sp.namBH}</td>
                    <td>${sp.moTa}</td>
                    <td>${sp.soLuongTon}</td>
                    <td>${sp.donGia}</td>
                    <td><a class="btn btn-info" onclick="return confirm('Bạn có muốn xem chi tiết ?')" href="/dong-ho/detail/${sp.id}">Detail</a></td>
                    <td><a class="btn btn-info"  onclick="return confirm('Bạn chắc chắn xóa chứ ?')" href="/dong-ho/delete/${sp.id}">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-4">
                            <c:if test="${ds.getNumber() gt 0}">
                                <a href="?tenSanPham=${param.tenSanPham}&min=${param.min}&max=${param.max}&page=${ds.getNumber()}" class="btn btn-success">Previous</a>
                            </c:if>
                        </div>
                        <div class="col-md-4">
                            <h4>${ds.getNumber()+1}/${ds.getTotalPages()}</h4>
                        </div>
                        <div class="col-md-4">
                            <c:if test="${ds.getNumber() lt ds.getTotalPages()-1}">
                                <a href="?tenSanPham=${param.tenSanPham}&min=${param.min}&max=${param.max}&page=${ds.getNumber()+2}" class="btn btn-success">Next</a>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="col-md-4"></div>
            </div>
    </c:if>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
