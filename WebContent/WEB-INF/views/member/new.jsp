<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
  <title>Create</title>
</head>
<body>
  <div class="content">
    <header class="header">
      <div class="header__title">
        <span class="header__name">Site site</span>
        <div class="header__category">
          <span>Create</span>
        </div>
      </div>
    </header>
    <div class="flush__error">
      <c:if test="${errors !=null}">
        入力内容にエラーがあります。<br/>
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>
      </c:if>
    </div>
    <section id="login-content">
      <div class="login-title">
        <h1 class="login-title__item">Create</h1>
      </div>
      <form method="POST" action="<c:url value='/toppage/member/create'/>">
        <div class="login-menu">
          <div class="login-menu__item">
            <label for="name">名前</label>
            <input type="text" name="name" value="${name}">
          </div>
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
    </section>
  </div>
</body>
</html>