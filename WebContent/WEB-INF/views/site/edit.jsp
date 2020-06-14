<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/edit.css">
  <title>edit Site</title>
</head>
<body>
  <div id="global-container">
    <div id="container">
      <div class="content">
        <header class="header">
          <div class="header__inner">
            <div class="header__title">
              <span class="header__name">Site site</span>
              <div class="header__category">
                <span class="header__category__name">Edit</span>
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
        <div class="flush__error">
            <c:if test="${errors !=null}">
                入力内容にエラーがあります。<br/>
                <c:forEach var="error" items="${errors}">
            ・       <c:out value="${error}" /><br />
                </c:forEach>
            </c:if>
        </div>
        <section class="edit-content">
          <div class="edit">
            <div class="edit-title">
              <h1 class="edit-title__item">Edit site</h1>
            </div>
            <form method="POST" action="<c:url value='/site/update'/>">
              <div class="edit-menu">
                <div class="edit-menu__item">
                  <label for="name">サイト名</label>
                  <input type="text" name="name" value="${edit_site.name}" >
                </div>
                <div class="edit-menu__item">
                  <label for="url">サイトURL</label>
                <input type="url" name="url" value="${edit_site.url}">
                </div>
                <div class="edit-menu__color">
                <input type="hidden" name="_token" value="${_token}" />
                <div class="edit-menu__btn">
                  <button type="submit">変更する</button>
                </div>
              </div>
              </div>
            </form>
            <div class="edit-menu__btn">
              <button id="destroy">削除する</button>
            </div>
            <form method="POST"action="<c:url value='/site/destroy'/>" name="destroyform">
              <input type="hidden" name="_token" value="${_token}">
              <input type="hidden" name="id" value="${edit_site.id}">
            </form>
          </div>
        </section>
      </div>
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
              <a href="<c:url value='/mysite'/>" class="sub-title">My Site</a>
            </li>
            <li class="menu-title__item">
              <a href="<c:url value='/follow/index'/>" class="sub-title">Follow</a>
            </li>

          </ul>
        </li>
      </ul>
    </nav>
  </div>
  <script type="text/javascript" src='<c:url value="/scripts/destroy.js"/>'></script>
  <script type="text/javascript" src='<c:url value="/scripts/category-menu.js"/>'></script>
</body>
</html>