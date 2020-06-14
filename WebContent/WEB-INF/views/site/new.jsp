<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/create.css">
  <title>Create Site</title>
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
      <p>${make_acount}</p>
      <c:if test="${errors !=null}">
        入力内容にエラーがあります。<br/>
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>
      </c:if>
    </div>
    <section class="create-content">
      <div class="create">
        <div class="create-title">
          <h1 class="create-title__item">Create site</h1>
        </div>
        <form method="POST" action="<c:url value='/site/create'/>">
          <div class="create-menu">
            <div class="create-menu__item">
              <label for="name">サイト名</label>
              <input type="text" name="name" value="${musicSite.name}">
            </div>
            <div class="create-menu__item">
              <label for="url">サイトURL</label>
            <input type="url" name="url" value="${musicSite.url}">
            </div>
            <input type="hidden" name="_token" value="${_token}">
            <div class="create-menu__btn">
              <button type="submit">投稿する</button>
            </div>
          </div>
        </form>
      </div>
    </section>
  </div>
</body>
</html>