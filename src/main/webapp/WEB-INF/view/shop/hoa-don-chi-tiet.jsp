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
        <br>
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
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ds}" var="hdct" varStatus="a">
                    <tr>
                            <th scope="row">${a.index+1}</th>
                            <td>
                                <img src="../../../img/${hdct.idSanPham.image}" width="100" height="90">
                            </td>
                            <th >${hdct.idSanPham.ma}</th>
                            <td scope="row">${hdct.idSanPham.ten}</td>
                            <td>${hdct.donGia}</td>
                            <td>${hdct.soLuong}</td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br>
            <div class="col-6">
                Thành tiền:
                <div style="color: red;font-size: 30px"> ${tongTien}</div>
            </div>
        </c:if>
        <br>
        <br>
        <a style="margin-left: 900px" href="/shop-dong-ho/ds-hoa-don" class="btn btn-info" >Back</a>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</body>
</html>