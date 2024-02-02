<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>header</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" type="text/css" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <!-- jquery -->
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <link href="/css/header.css?after" rel="stylesheet" type="text/css">
    </head>
    <title>header</title>
</head>
    <body>
        <nav class="navbar navbar-light bg-light static-top">
            <div class="container">
                <a class="navbar-brand" href="/">메이플 거래소 이미지</a>
                    <!-- 로그아웃 로그인은 조건부로 랜더링 -->
                    <div class="frame">
                        <button class="custom-btn btn-6"><a href="/auth/signup">회원가입 </a></button>
                        <button class="custom-btn btn-6"><a href="/logout">로그아웃 </a></button>
                        <button class="custom-btn btn-6"><a href="/auth/login">로그인 </a></button>
                    </div>
                 <ul>
                    <li><a href="/">홈</a></li>
                    <li>
                        <a href="#">판매 거래소</a>
                        <div class="submenu">
                            <a href="/board/trade/101">전사</a>
                            <a href="/board/trade/102">도적</a>
                            <a href="/board/trade/103">궁수</a>
                            <a href="/board/trade/104">마법사</a>
                        </div>
                    </li>
                      <li>
                        <a href="#">구매 거래소</a>
                        <div class="submenu">
                            <a href="/board/trade/201">전사</a>
                            <a href="/board/trade/202">도적</a>
                            <a href="/board/trade/203">궁수</a>
                            <a href="/board/trade/204">마법사</a>
                        </div>
                </li>
                    <li>
                        <a href="#">자유게시판</a>
                        <div class="submenu">
                            <a href="#">공지사항</a>
                            <a href="#">자유 토론</a>
                        </div>
                    </li>
                    <li>
                        <a href="#">공략게시판</a>
                        <div class="submenu">
                            <a href="#">직업 공략</a>
                            <a href="#">던전 가이드</a>
                        </div>
                    </li>
                </ul>

            </div>
        </nav>
    </body>
</html>