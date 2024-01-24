<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <div class="container">
        <main class="loginMain">
            <!-- 로그인 섹션 -->
            <section class="login">
                <!-- 로그인 박스 -->
                <article class="login__form__container">
                    <!-- 로그인 폼 -->
                    <div class="login__form">

                        <!-- 로그인 인풋 -->
                        <form class="login__input" action="/auth/login.process" method="POST">
                            <input type="text" name="username" id="username" placeholder="이메일" required="required" value="test@test.com"/>
                            <input type="password" name="password" id="password" placeholder="비밀번호" required="required" value="123"/>
                            <!-- 버튼에 ID 추가 -->
                            <button>로그인</button>
                        </form>
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
</body>
</html>
