<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
          <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@500&display=swap" rel="stylesheet">
          <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
          <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
          <title>Document</title>
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
                  <li>
                    <button class="acount-menu__btn">
                      <i class="material-icons icon">person</i>
                    </button>
                  </li>
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

        <div class="movie-wrapper">

          <div class="movie">
            <iframe width="560" height="315" src="https://www.youtube.com/embed/Ca6pjR2TLns?start=1029"
                allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen class="youtube">
            </iframe>
          </div>
        </div>

        <section class="site-content">
          <div class="allsite">
            <div class="allsite__site">
              <div class="allsite__site__create ">
                <a href="<c:url value='/toppage/site/new'/>" class="create"></a>
                <p>サイト追加</p>
              </div>
            </div>
            <c:forEach var="musicSite" items="${musicSites}">
                <div class="allsite__site">
                  <div class="allsite__site__item">
                    <div class="allsite__site__item__link ">
                      <a href="${musicSite.url}" class="link"></a>
                      <p><c:out value="${musicSite.name}"/></p>
                    </div>
                    <div class="allsite__site__item__name">
                      <a href="${musicSite.url}"><c:out value="${musicSite.name}"/></a>
                    </div>
                  </div>
                </div>
            </c:forEach>
          </div>
        </section>

    </div>
    <nav class="category-menu">
      <ul class="category-menu__main">
        <li class="category-menu__item">
          <span class="main-title">Login</span>
          <ul class="menu-title">
            <li class="menu-title__item">
              <a href="<c:url value='/login'/>" class="sub-title">ログイン</a>
            </li>
            <li class="menu-title__item">
              <a href="<c:url value='/toppage/membernew'/>" class="sub-title">新規登録</a>
            </li>
          </ul>
        </li>
        <li class="category-menu__item">
          <span class="main-title">Category</span>
          <ul class="menu-title">
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
