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
        <center><h3>GIỎ HÀNG</h3></center>
        <br>
        <c:if test="${ds.isEmpty()}">
            <h3>Hiện chưa có sản phẩm nào</h3>
        </c:if>
        <c:if test="${not ds.isEmpty()}">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">STT</th>
                    <th scope="col">Hình ảnh</th>
                    <th scope="col">Mã Sản Phẩm</th>
                    <th scope="col">Tên Sản Phẩm</th>
                    <th scope="col">Đơn giá</th>
                    <th scope="col">Số lượng</th>
<%--                    <th scope="col">Số tiền</th>--%>
                    <th scope="col" colspan="2">Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ds}" var="ghct" varStatus="a">
                    <tr>
                        <form action="/shop-dong-ho/indexGioHangCT/update/${ghct.id}" method="get">
                            <th scope="row">${a.index+1}</th>
                            <td>
                                <img src="../../../img/${ghct.idSanPham.image}" width="100" height="90">
                            </td>
                            <th >${ghct.idSanPham.ma}</th>
                            <td scope="row">${ghct.idSanPham.ten}</td>
                            <td>${ghct.donGia}</td>
                            <td><input type="number" value="${ghct.soLuong}" name="sl"></td>
<%--                            <td>${ghct.soLuong * (int) ghct.donGia}</td>--%>
                            <td><a class="btn btn-info" onclick="return confirm('Bạn có muốn xóa sản phẩm ?')" href="/shop-dong-ho/indexGioHangCT/detele/${ghct.id}">Delete</a></td>
                            <td><button type="submit" class="btn btn-info"  onclick="return confirm('Bạn có muốn update số lượng sản phẩm')">Update</button></td>
                        </form>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
        <br>
        <br>
        <a href="/shop-dong-ho/create-hoa-don/${gh.id}" class="btn btn-info" >Tạo hóa đơn</a>
        <a style="margin-left: 900px" href="/shop-dong-ho" class="btn btn-info" >Back</a>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</body>
</html>