<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet"href="${pageContext.request.contextPath}/css/reset.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet"href="${pageContext.request.contextPath}/css/mysite.css">
  <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@500&display=swap" rel="stylesheet">
  <title>My Site</title>
</head>
<body>
  <div id="global-container">
    <div id="container">
      <header class="header">
        <div class="header__inner">
          <div class="header__title">
            <span class="header__name">Site site</span>
            <div class="header__category">
              <span class="header__category__name">My Site</span>
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
      <div class="mysite-title">
        <c:choose>
            <c:when test="${haserror}">
                <p>まだサイトを追加していません。追加してみましょう！<a href="<c:url value='/site/new'/>">こちらから</a></p>
            </c:when>
            <c:otherwise>
                <h1 class="mysite-title__item">My site</h1>
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
                     <form method="GET" action="<c:url value='/site/edit'/>" class="edit-btn">
                        <input type="hidden" name="id" value="${musicSite.id}">
                        <button>
                            edit
                        </button>
                     </form>
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
          <span class="main-title">Account</span>
          <ul class="menu-title">
            <li class="menu-title__item">
              <a href="<c:url value='/logout'/>" class="sub-title">ログアウト</a>
            </li>
          </ul>
        </li>
        <li class="category-menu__item">
          <span class="main-title">Category</span>
          <ul class="menu-title">
            <li class="menu-title__item">
              <a href="<c:url value='/member/index'/>" class="sub-title">Home</a>
            </li>
            <li class="menu-title__item">
              <a href="<c:url value='/follow/index'/>" class="sub-title">Follow</a>
            </li>
          </ul>
        </li>
      </ul>
    </nav>
  </div>

  <script type="text/javascript" src='<c:url value="/scripts/category-menu.js"/>'></script>
</body>
</html>