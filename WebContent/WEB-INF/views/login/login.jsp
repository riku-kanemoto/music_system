<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@500&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
  <title>Login</title>
</head>
<body>
  <div class="content">
    <header class="header">
      <div class="header__title">
        <span class="header__name">Site site</span>
        <div class="header__category">
          <span>Login</span>
        </div>
      </div>
    </header>
    <div class="flush__error">
      <span>アドレスかパスワードが間違っています。</span>
    </div>
    <section id="login-content">
      <div class="login-title">
        <h1 class="login-title__item">Login</h1>
      </div>
      <form method="POST" action="<c:url value="/login"/>">
        <div class="login-menu">
          <div class="login-menu__item">
            <label for="adress">メールアドレス</label>
            <input type="email" name="adress" value="${adress}">
          </div>
          <div class="login-menu__item">
            <label for="password">パスワード</label>
            <input type="password" name="password">
            <input type="hidden" name="_token" value="${_token}">
          </div>
          <div class="login-menu__btn">
            <button type="submit">ログイン</button>
          </div>
        </div>
      </form>
      <div class="new-acount">
        <p>アカウントをお持ちでない方は<a href="<c:url value='/member/mew'/>">こちらから</a></p>
      </div>
    </section>
  </div>
</body>
</html>