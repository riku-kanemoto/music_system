<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet"href="${pageContext.request.contextPath}/css/reset.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet"href="${pageContext.request.contextPath}/css/favolite.css">
  <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@500&display=swap" rel="stylesheet">
  <title>Favolite</title>
</head>
<body>
  <div id="global-container">
    <div id="container">
      <header class="header">
        <div class="header__inner">
          <div class="header__title">
            <span class="header__name">Site site</span>
            <div class="header__category">
              <span class="header__category__name">Music</span>
            </div>
          </div>
          <div class="header__menu">
            <div class="acount">
              <ul class="acount-menu">
                <!-- <li>
                  <button class="acount-menu__btn">
                    <i class="material-icons icon">person</i>
                  </button>
                </li> -->
                <!-- <div id="login">
                  <nav class="login-menu">
                    <ul class="login-menu__main">
                      <li class="login-menu__item">
                        <a href="#">ログイン</a>
                      </li>
                      <li class="login-menu__item">
                        <a href="#">新規登録</a>
                      </li>
                    </ul>
                  </nav>
                </div>   -->
              </ul>
            </div>
            <div class="category">
              <button class="category__btn">
                  <span></span>
                  <span></span>
                  <span></span>
              </button>
            </div>
          </div>
        </div>
      </header>
      <div class="favolite-title">

        <c:choose>
            <c:when test="${haserror}">
                <p class="favolite-title__coment">お気に入りが追加されていません。</p>
            </c:when>
            <c:otherwise>
                <h1 class="favolite-title__item">お気に入り</h1>
            </c:otherwise>
        </c:choose>

      </div>
        <section class="site-content">
          <div class="allsite">
            <div class="allsite__site">
              <div class="allsite__site__create ">
                <a href="<c:url value='/site/new'/>" class="create"></a>
                <p>サイト追加</p>
              </div>
            </div>
            <c:forEach var="musicSite" items="${musicSites}">
                <div class="allsite__site">
                  <div class="allsite__site__item">
                    <div class="allsite__site__item__link ">
                      <a href="${musicSite.url}" class="link"></a>
                      <p>${musicSite.name}</p>
                    </div>
                    <div class="allsite__site__item__name">
                      <a href="${musicSite.url}">${musicSite.name}</a>
                    </div>
                    <form method="POST" action="<c:url value='/destroy/favolite?id=${musicSite.id}'/>">
                      <input type="hidden" name="_token" value="${_token}"/>
                      <button class="favolite-btn">
                        <span class="material-icons"id="favorite">
                          favorite
                        </span>
                      </button>
                    </form>
                  </div>
                </div>
            </c:forEach>
          </div>
        </section>
    </div>
    <nav class="category-menu">
      <ul class="category-menu__main">
        <li class="category-menu__item">
          <span class="main-title">Account</span>
          <ul class="menu-title">
            <li class="menu-title__item">
              <a href="#" class="sub-title">ログアウト</a>
            </li>
          </ul>
        </li>
        <li class="category-menu__item">
          <span class="main-title">Category</span>
          <ul class="menu-title">
            <li class="menu-title__item">
              <a href="<c:url value='/mysite'/>" class="sub-title">my Site</a>
            </li>
            <li class="menu-title__item">
              <a href="#" class="sub-title">Music</a>
            </li>
            <li class="menu-title__item">
              <a href="#" class="sub-title">IT</a>
            </li>
          </ul>
        </li>
      </ul>
    </nav>
  </div>

  <script type="text/javascript" src='<c:url value="/scripts/category-menu.js"/>'></script>
</body>
</html>