<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>my music 情報</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <body>
        <div id=wrapper>
            <header id="header">
             <h1>SITE Site</h1>
             <p>ログイン</p>
             <p>新規登録</p>
            </header>
            <div id="content">
                ${param.content}
            </div>
            <div class="add-site-wrapper">
                <div class="add-site-content">
                    <a href="<c:url value='/site/new'/>">サイトを追加</a>
                </div>
            </div>
            <footer id="footer">
                riku kanemoto
            </footer>
        </div>
    </body>
</html>