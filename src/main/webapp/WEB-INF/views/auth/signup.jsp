<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>

    <div class="container">
        <h2>회원가입</h2>
        <form id="signupForm">
            <label for="username">이름:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">비밀번호:</label>
            <input type="password" id="password" name="password" required>

            <label for="email">이메일:</label>
            <input type="email" id="email" name="email" required>

            <button type="button" id="signupButton">가입</button>
        </form>

        <div id="result"></div>
    </div>

    <script>
        $(document).ready(function () {
            $("#signupButton").click(function () {
                signUp();
            });
        });

       function signUp() {
           let url = "/auth/signup.process";

           let memberDto = {
               memberName: $("#username").val(),
               memberPw: $("#password").val(),
               memberEmail: $("#email").val()
           };

           $.ajax({
               type: "POST",
               url: url,
               contentType: "application/json",
               data: JSON.stringify(memberDto),
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
