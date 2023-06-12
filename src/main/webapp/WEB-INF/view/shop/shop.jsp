<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 17/03/2023
  Time: 11:07 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
<%--    <link rel="stylesheet" href="../../css/index.css">--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .nav-item {
            margin-right: 40px;
        }
        footer {
            margin-top: 100px;
            height: 420px;
            background-color: #f3f6fa;
        }
        .diachi li {
            font-size: 16px;
            color: #1c1c1c;
            line-height: 37px;
            list-style: none;
        }
        .footer__about h5 {
            color: #1c1c1c;
            font-weight: 700;
            margin-bottom: 10px;
        }
        .footer__about ul {
            width: 50%;
            float: left;
        }
        .footer__about ul li {
            list-style: none;
            line-height: 37px;
        }
        .footer__about ul li a {
            color: #1c1c1c;
            font-size: 16px;
            line-height: 32px;
            text-decoration: none;
        }
        .footer__email h5 {
            color: #1c1c1c;
            font-weight: 700;
            margin-bottom: 10px;
        }
        .footer__email p {
            font-size: 16px;
            color: #1c1c1c;
            margin-bottom: 30px;
        }
        .footer__email .form {
            margin-bottom: 30px;
            display: flex;
        }
        .footer__email .form input {
            width: 70%;
            font-size: 16px;
            padding-left: 20px;
            color: #1c1c1c;
            height: 55px;
            border: 1px solid #ededed;
            font-family: inherit;
        }
        .form > .btn {
            width: 35%;
            font-size: 16px;
            color: black;
            font-weight: 800;
            text-transform: uppercase;
            display: inline-block;
            padding: 13px 15px 12px;
            background: #7fad39;
            border: none;
            border-radius: 0%;
        }
        .footer__email .logo a {
            display: inline-block;
            height: 41px;
            width: 41px;
            font-size: 16px;
            color: #404040;
            border: 1px solid #ededed;
            border-radius: 50%;
            line-height: 38px;
            text-align: center;
            background: #ffffff;
            -webkit-transition: all, 0.3s;
            -moz-transition: all, 0.3s;
            -ms-transition: all, 0.3s;
            -o-transition: all, 0.3s;
            transition: all, 0.3s;
            margin-right: 10px;
        }
        .footer__email .logo a:hover {
            background-color: #7fad39;
            color: white;
        }
        .footer__about > h5 {
            margin-left: 30px;
        }
        .foo {
            padding-top: 85px;
        }
        .anh {
            padding-left: 30px;
        }
        .nav-item a {
            font-weight: 500;
        }
        .nav-item a:hover {
            color: #51a37d;
        }
        .li li {
            list-style: none;
        }
        .align-items-center a {
            font-size: 17px;
        }
        .align-items-center i:hover {
            color: #51a37d;
        }
        .footer__about li a:hover {
            color: #51a37d;
        }
        .card-title a {
            text-decoration: none;
            color: black;
        }
        .btn-outline-success {
            margin: 6px 78px;
        }
        .card-title a:hover {
            color: #468d71;
            font-weight: 600;
        }
        hr {
            background-color: gray;
            height: 3px;
            font-weight: 400;
            border: 0;
        }
        .btn-outline-success {
            margin: 0 10px;
        }
        .card-body > .btn-outline-success {
            margin: 6px 60px;
        }
        #dropdownMenuButton {
            width: 250px;
            background-color: #7fad39;
        }
        .dropdown-menu {
            width: 245px;
        }
        .dropdown-menu > li > a:hover {
            background-color: #7fad39;
            color: white;
        }
        .list-group-light a:hover {
            background-color: #7fad39;
            color: white;
        }
        .titleContact {
            color: gray;
        }
        .ndContact {
            font-weight: 500;
        }
        .loiTxt {
            color: red;
            font-size: 15px;
            font-style: italic;
        }
        .txtTheLoai {
            margin: 0;
            font-size: 14px;
            font-style: italic;
            color: orange;
        }
        /*.noidung {*/
        /*    margin-left: 15px;*/
        /*}*/
        /*.date {*/
        /*    margin: 0;*/
        /*    font-size: 14px;*/
        /*    font-style: italic;*/
        /*    color: orange;*/
        /*}*/
        /*.txtGia {*/
        /*    font-size: 23px;*/
        /*    color: red;*/
        /*    font-weight: 400;*/
        /*    margin-left: 15px;*/
        /*}*/
        /*.khuyenmai {*/
        /*    margin-left: 20px;*/
        /*    font-size: 15px;*/
        /*    font-style: italic;*/
        /*    border: 1px solid yellow;*/
        /*    padding: 10px;*/
        /*    border-radius: 10px;*/
        /*}*/
        .khuyenmai > b {
            font-size: 16px;
        }
        /*.txtSoluong {*/
        /*    margin-top: 15px;*/
        /*    font-size: 15px;*/
        /*}*/
        .txtSoluong > span {
            color: #4e76b5;
        }

        .table-info > td {
            padding-top: 40px;
            font-size: 20px;
        }

        .card-text{
            color: coral;
            font-weight: 400;
        }
    </style>
</head>
<body>
<div class="container">
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <!-- Container wrapper -->
            <div class="container-fluid">
                <!-- Toggle button -->
                <button
                        class="navbar-toggler"
                        type="button"
                        data-mdb-toggle="collapse"
                        data-mdb-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                >
                    <i class="fas fa-bars"></i>
                </button>

                <!-- Collapsible wrapper -->
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <!-- Navbar brand -->
                    <a class="navbar-brand mt-2 mt-lg-0" href="san-pham/index" style="width: 140px">
                        <img
                                src="https://upload.wikimedia.org/wikipedia/vi/thumb/3/37/Bitis_logo.svg/1200px-Bitis_logo.svg.png"
                                style="max-width: 50%"
                        />
                    </a>
                    <!-- Left links -->
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="#">SHOP</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">THƯƠNG HIỆU</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">LIÊN HỆ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">DỊCH VỤ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">BLOG</a>
                        </li>
<%--                        <li class="nav-item">--%>
<%--                            <a class="nav-link" href="">NHÀ SẢN XUẤT</a>--%>
<%--                        </li>--%>
                    </ul>
                    <!-- Left links -->
                </div>
                <!-- Collapsible wrapper -->

                <!-- Right elements -->
                <div class="d-flex align-items-center">
                    <!-- Icon -->
                    <a class="text-reset me-3" href="/shop-dong-ho/indexGioHangCT">
                        <i class="fa-solid fa-cart-shopping"></i>
                    </a>
                    <div class="li">
                        <li class="nav-item dropdown">
                            <a
                                    class="nav-link dropdown-toggle"
                                    href="#"
                                    role="button"
                                    data-bs-toggle="dropdown"
                                    aria-expanded="false"
                            >
                                Xin chào ${userLogin.ten}
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a class="dropdown-item" href="#">My Order</a>
                                </li>
                                <li>
                                    <a class="dropdown-item">Category</a>
                                </li>
                                <li>
                                    <hr class="dropdown-divider"/>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="/logout">Log out</a>
                                </li>
                            </ul>
                        </li>
                    </div>
                </div>
                <!-- Right elements -->
            </div>
            <!-- Container wrapper -->
        </nav>
    </header>
    <br>
    <div id="carouselExampleIndicators" class="carousel slide">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://donghoduyanh.com/images/slideshow/2023/05/08/compress/sale-thang-5_1683553965.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="https://donghoduyanh.com/images/slideshow/2023/05/16/compress/longines-spirit_1684226563.jpg" class="d-block w-100" alt="...">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
    <br>
    <section>
        <div class="row">
            <div class="col-md-3">

                <h4>QUẢN LÝ</h4>
                <hr>
                <br>
                <div class="list-group">
                    <a class="list-group-item list-group-item-action" href="/admin/nsx">Quản lý Nhà sản xuất</a>
                    <a class="list-group-item list-group-item-action" href="/admin/dongsp">Quản lý
                        dòng sản phẩm</a>
                    <a class="list-group-item list-group-item-action" href="#">Quản lý
                        chức vụ</a>
                    <a class="list-group-item list-group-item-action" href="#">Quản lý
                        Hóa đơn</a>
                    <a class="list-group-item list-group-item-action" href="#">Quản lý
                        Giỏ hàng</a>
                    <a class="list-group-item list-group-item-action" href="#">Quản lý
                        Giỏ hàng chi tiết</a>
                </div>
            </div>
            <div class="col-md-9">
                <h2>ĐỒNG HỒ NAM</h2>
                <hr>
                <div class="row">
                        <form>
                            <div>
                                <input type="text" class="form-control" placeholder="Tìm kiếm theo tên" name="tenSanPham" value="${param.tenSanPham}" >
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <input type="number" class="form-control" placeholder="Tìm Kiếm Theo Giá Từ" name="min" value="${param.min}" >
                                </div>
                                <div class="col-md-6">
                                    <input type="number" class="form-control" placeholder="Đến" name="max"value="${param.max}" >
                                </div>
                            </div>

                            <div style="margin-top: 20px">
                                <button type="submit" class="btn btn-success">Search</button>
                            </div>
                        </form>
                </div>


                <br>
                <c:if test="${not ds.isEmpty()}">
                    <p>Có tất cả ${ds.getTotalElements()} sản phẩm</p>
                    <div class="row">
                        <c:forEach items="${ds.getContent()}" var="sp" varStatus="a">
                        <div class="col-md-4">


                            <div class="card" style="height: 533px;margin-bottom: 15px">

                                <a href="/shop-dong-ho/detail/${sp.id}"><img
                                        src="../../../img/${sp.image}"
                                        class="card-img-top"
                                        alt="..."
                                /></a>
                                <div class="card-body">
                                    <h5 class="card-title">
                                        <a style="text-decoration: none;font-size: 15px" href="/shop-dong-ho/detail/${sp.id}">${sp.ten}</a>
                                    </h5>
                                    <p class="txtTheLoai">Thể loại: ${sp.loaiSP.ten}</p>
                                    <br>
                                    <p class="card-text">${sp.donGia}$</p>
                                    <center>
                                        <a href="/shop-dong-ho/detail/${sp.id}" class="btn btn-outline-success shop"
                                        >MUA NGAY</a>
                                    </center>
                                </div>

                            </div>

                        </div>
                        </c:forEach>
                    </div>

                    <br>
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
                    </div>
                </c:if>
            </div>
        </div>
    </section>
</div>
<br>
<footer>
    <div class="container">
        <div class="row foo">
            <div class="col-lg-4 col-md-6">
                <div class="anh">
                    <img
                            src="https://upload.wikimedia.org/wikipedia/vi/thumb/3/37/Bitis_logo.svg/1200px-Bitis_logo.svg.png"
                            alt=""
                            style="max-width: 30%"
                    />
                </div>
                <ul class="diachi">
                    <li>Address: Hòa Chính-Chương Mỹ-Hà Nội</li>
                    <li>Phone: +84972 758 663</li>
                    <li>Email: taintph26788@fpt.edu.vn</li>
                </ul>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="footer__about">
                    <h5><b>Useful Links</b></h5>
                    <ul>
                        <li><a href="">About Us</a></li>
                        <li><a href="">About Our Shop</a></li>
                        <li><a href="">Secure Shopping</a></li>
                        <li><a href="">Delivery infomation</a></li>
                        <li><a href="">Privacy Policy</a></li>
                        <li><a href="">Our Sitemap</a></li>
                    </ul>
                    <ul>
                        <li><a href="">Who We Are</a></li>
                        <li><a href="">Our Services</a></li>
                        <li><a href="">Projects</a></li>
                        <li><a href="https://zalo.me/0972758663">Contact</a></li>
                        <li><a href="">Innovation</a></li>
                        <li><a href="">Testimonials</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-12">
                <div class="footer__email">
                    <h5><b>Join Our Newsletter Now</b></h5>
                    <p>Get E-mail updates about our latest shop and special offers.</p>
                    <form action="" class="form">
                        <input type="text" placeholder="Enter Your Email"/>
                        <button type="submit" class="btn">SUBSCRIBE</button>
                    </form>
                    <div class="logo">
                        <a href="https://www.facebook.com/nguyentientai.xx/"
                        ><i class="fa-brands fa-facebook-f"></i
                        ></a>
                        <a href="https://www.instagram.com/im_t.tai/"
                        ><i class="fa-brands fa-instagram"></i
                        ></a>
                        <a href="https://zalo.me/0972758663"
                        ><i class="fa-solid fa-phone"></i
                        ></a>
                        <a href="https://www.youtube.com/channel/UCi4rQSq51MIeqtwzbJAaBnA"
                        ><i class="fa-brands fa-youtube"></i
                        ></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
