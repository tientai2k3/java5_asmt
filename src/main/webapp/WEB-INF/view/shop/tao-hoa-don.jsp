<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Purchase</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<h1 style="text-align: center">Hóa Đơn</h1>
    <div class="container">
        <form:form method="POST" action="/shop-dong-ho/xac-nhan/${gh.id}" modelAttribute="hoadon">
            <div class="row mt-4">
                <div class="col-6">
                    <label>Tên người nhận</label>
                    <form:input type="text" class="form-control" path="tenNguoiNhan" />
                    <form:errors path="tenNguoiNhan" cssStyle="color: red"/>
                </div>
                <div class="col-6">
                    <label>Số điện thoại</label>
                    <form:input type="number" class="form-control" path="sdt"/>
                    <form:errors path="sdt" cssStyle="color: red"/>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label>Địa chỉ</label>
                    <form:input type="text" class="form-control" path="diaChi"></form:input>
                    <form:errors path="diaChi" cssStyle="color: red"/>
                </div>


            </div>
            <div class="row mt-4">

                <div class="col-6">
                    <label>Sản phẩm</label>

                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">STT</th>
                            <th scope="col">Hình ảnh</th>
                            <th scope="col">Tên Sản phẩm</th>
                            <th scope="col">Số lượng</th>
                            <th scope="col">Đơn giá</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${ds}" var="ghct" varStatus="stt">
                                <tr>
                                    <td>${stt.index + 1}</td>
                                    <td>
                                        <img src="../../../img/${ghct.idSanPham.image}" width="65" height="75">
                                    </td>
                                    <td scope="row">${ghct.idSanPham.ten}</td>
                                    <td>${ghct.soLuong}</td>
                                    <td>${ghct.donGia}</td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-6">
                    Thành tiền: <div style="color: red;font-size: 30px">${tongTien}</div>
                </div>
            </div>

            <br>
            <div class="buttonAdd">
            <form:button type="submit"
                   class="btn btn-primary btn-info">Thanh Toán</form:button>
            </div>
            <div class="buttonBack col-6" style="text-align: right" >
                <a  href="/shop-dong-ho/indexGioHangCT" class="btn btn-secondary">Back</a>
            </div>
        </form:form>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>