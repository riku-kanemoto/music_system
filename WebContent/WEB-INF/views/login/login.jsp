<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${hasError}">
                <div id="flush_error">
                    アドレスかパスワードが間違っています。
                </div>
        </c:if>
        <h2>ログイン</h2>
        <form method="POST" action="<c:url value='/login'/>">
            <label for="adress">メールアドレス</label>
            <input type="email" name="adress" value="${adress}">
            <label for="password">パスワード</label>
            <input type="password" name="password">
            <input type="hidden" name="_token" value="${_token}">
            <button type="submit">ログイン</button>
        </form>
    </c:param>
</c:import>