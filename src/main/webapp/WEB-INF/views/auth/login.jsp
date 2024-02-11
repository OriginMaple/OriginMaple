<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta name="referrer" content="no-referrer-when-downgrade" />
    <title>Title</title>
</head>
<body>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
 <div class="container">
        <main class="loginMain">
            <!-- 로그인 섹션 -->
            <section class="login">
                <!-- 로그인 박스 -->
                <article class="login__form__container">
                    <!-- 로그인 폼 -->
                    <div class="login__form">

                        <!-- 로그인 인풋 -->
                        <div class="login__input" action="/login" method="POST">
                            <input type="text" name="username" id="username" placeholder="이메일" required="required"/>
                            <input type="password" name="password" id="password" placeholder="비밀번호" required="required"/>
                            <!-- 버튼에 ID 추가 -->
                            <button id = "loginButton">로그인</button>
                        </div>
                        <!-- 로그인 인풋 end -->

                        <!-- 또는 -->
                        <div class="login__horizon">
                            <!-- ID 중복 사용 해결 -->
                            <div class="br"></div>
                            <div class="or">또는</div>
                            <div class="br"></div>
                        </div>
                        <!-- 또는 end -->

                        <!-- Oauth 소셜로그인 -->
                        <div class="login__facebook">
                            <!-- onclick 수정 -->
                            <button onclick="location.href='/oauth2/authorization/facebook'">
                                <!-- 클래스 수정 -->
                                <i class="fab fa-facebook-square"></i>
                                <span>Facebook으로 로그인</span>
                            </button>
                        </div>
                        <!-- Oauth 소셜로그인 end -->
                    </div>

                    <!-- 계정이 없으신가요? -->
                    <div class="login__register">
                        <span>계정이 없으신가요?</span>
                        <a href="/auth/signup">가입하기</a>
                    </div>
                    <!-- 계정이 없으신가요? end -->
                </article>
            </section>
        </main>
    </div>

    <script>
            $(document).ready(function () {
                $("#loginButton").click(function () {
                    login();
                });
            });

           function login() {
               let url = "/login";
               $.ajax({
                   type: "POST",
                   url: url,
                   data: {
                            username : $("#username").val(),
                            password : $("#password").val()
                         },
                   success: function (response) {
                       alert("성공");
                       $("#result").html(response.message);
                       window.location.href = "/";
                   },
                   error: function (xhr, textStatus, errorThrown) {
                       console.error("에러:", textStatus, errorThrown);
                   }
               });
            }
         </script>


</body>
</html>
