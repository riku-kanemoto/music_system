<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet"href="${pageContext.request.contextPath}/css/reset.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet"href="${pageContext.request.contextPath}/css/follow.css">
  <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@500&display=swap" rel="stylesheet">
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
                <span class="header__category__name">Follow</span>
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
        <div class="follow-title">
         <h1 class="follow-title__item">フォロー</h1>
         <div class="flush_error">
            ${error}
         </div>
        </div>
        <section class="follow-content">
          <div class="follow">
          <c:forEach var="follow_member" items="${follow_members}">
            <div class="follow__account">
              <div class="follow__account__item">
                <div class="follow__account__item__link ">
                  <a href="<c:url value='/member/show?id=${follow_member.id}'/>" class="link"></a>
                  <p>${follow_member.name}</p>
                </div>
                <div class="follow__account__item__name">
                  <a href="<c:url value='/member/show?id=${follow_member.id}'/>">${follow_member.name}</a>
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
              <a href="<c:url value='/mysite'/>" class="sub-title">My Site</a>
            </li>

          </ul>
        </li>
      </ul>
    </nav>
  </div>

   <script type="text/javascript" src='<c:url value="/scripts/category-menu.js"/>'></script>
</body>
</html>