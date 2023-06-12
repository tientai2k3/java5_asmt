<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 14/03/2023
  Time: 3:31 CH
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
<div class="container-fluid h-custom">
    <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-md-9 col-lg-6 col-xl-5">
            <img
                    src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                    class="img-fluid"
                    alt="Sample image"
            />
        </div>
        <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
            <form:form action="/dang-ki" method="POST" modelAttribute="data">
                <div class="divider d-flex align-items-center my-4">
                    <h4 class="text-center fw-bold mx-3 mb-0">Đăng kí</h4>
                </div>

                <div class="form-outline mb-3">
                    <form:input path="ten"
                            class="form-control form-control-lg"
                            placeholder="Họ tên"
                    />
                    <div class="alert alert-warning" role="alert">
                        <form:errors path="ten"/>
                    </div>
                    <%--                    <p>${txtUser}</p>--%>
                </div>
                <div class="form-outline mb-3">
                    <label>Giới tính</label>
                    <form:radiobutton path="gioiTinh" value="nam" class="form-check-input"/>Nam
                    <form:radiobutton path="gioiTinh" value="nu" class="form-check-input"/>Nữ
                        <%--                    <p>${txtUser}</p>--%>
                </div>

                <div class="form-outline mb-3">
                    <form:input type="date" path="ngaySinh"
                                class="form-control form-control-lg"
                                placeholder="Ngày sinh"
                    />
                    <div class="alert alert-warning" role="alert">
                        <form:errors path="ngaySinh"/>
                    </div>
                        <%--                    <p>${txtUser}</p>--%>
                </div>
                <div class="form-outline mb-3">
                    <form:input path="diaChi"
                                class="form-control form-control-lg"
                                placeholder="Địa chỉ"
                    />
                    <div class="alert alert-warning" role="alert">
                        <form:errors path="diaChi"/>
                    </div>
                        <%--                    <p>${txtUser}</p>--%>
                </div>
                <div class="form-outline mb-3">
                    <form:input path="sdt" type="number"
                                class="form-control form-control-lg"
                                placeholder="Số điện thoại"
                    />
                    <div class="alert alert-warning" role="alert">
                        <form:errors path="sdt"/>
                    </div>
                        <%--                    <p>${txtUser}</p>--%>
                </div>
                <div class="form-outline mb-3">
                    <form:input path="email"
                                class="form-control form-control-lg"
                                placeholder="Email"
                    />
                    <div class="alert alert-warning" role="alert">
                        <form:errors path="email"/>
                    </div>
                        <%--                    <p>${txtUser}</p>--%>
                </div>
                <!-- Password input -->
                <div class="form-outline mb-3">
                    <form:input path="matKhau"
                            type="password"
                            id="form3Example4"
                            class="form-control form-control-lg"
                            placeholder="Mật khẩu"
                    />
                    <div class="alert alert-warning" role="alert">
                        <form:errors path="matKhau"/>
                    </div>
                    <%--                    <p>${txtPass}</p>--%>
                </div>
                <div class="text-center text-lg-start mt-4 pt-2">
                    <button
                            type="submit"
                            class="btn btn-primary btn-lg"
                    >
                        Register
                    </button>
                    <p class="small fw-bold mt-2 pt-1 mb-0">
                        Do you already have an account ?
                        <a href="/login" class="link-danger">Login</a>
                    </p>
                </div>
            </form:form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
