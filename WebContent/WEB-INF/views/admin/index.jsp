<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>管理</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
    </head>
    <body>
        <h2>登録者　一覧</h2>
        <table id="member_list">
            <tbody>
                <tr>
                    <th>氏名</th>
                    <th>アドレス</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="member" items="${members}" >
                    <tr>
                        <td><c:out value="${member.name}"/></td>
                        <td><c:out value="${member.adress}"/></td>
                        <td>
                            <c:choose>
                                <c:when test="${member.delete_flag ==1}">
                                    （削除済み）
                                </c:when>
                                <c:otherwise>
                                    詳細をみる
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>