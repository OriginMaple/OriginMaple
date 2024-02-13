<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registerPage</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <style>
        .form-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 10px; /* 요소들 사이의 간격 */
        }

        .form-item {
            width: 50%; /* 폼 요소들의 너비를 50%로 설정 */
        }

        /* 너비가 작은 화면(모바일 등)에서는 너비를 90%로 조정 */
        @media (max-width: 600px) {
            .form-item {
                width: 90%;
            }
        }
    </style><!-- abcd -->
</head>
<body>
    <h1 style="text-align:center;">registerPage</h1>

    <div class="form-container">
        <input type='text' id='title' class="form-item" placeholder='제목을 입력해 주세요.'/>
        <textarea id='content' class="form-item" rows="10" placeholder='내용을 입력해 주세요.'></textarea>
        <input type="file" id="uploadFile" class="form-item">
        <input type="submit" value="등록" class="form-item">
    </div>
</body>
</html>
