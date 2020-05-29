<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <div id="youtube">
            <iframe width="560" height="315" src="https://www.youtube.com/embed/Ca6pjR2TLns?start=1029"
            allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
            </iframe>
        </div>
        <div class="content">
            <div class="top_message">
                <p>金本 理久</p>
            </div>
            <div>
                <c:forEach var="musicSite" items="${musicSites}">
                    <div class="site_object">
                        <p><c:out value="${musicSite.name}"/></p>
                        <a href="${musicSite.url}">サイトに飛ぶ</a>
                    </div>
                </c:forEach>
            </div>
            <div class="add-site-wrapper">
                <div class="add-site-content">
                    <a href="<c:url value='/site/new'/>">サイトを追加</a>
                </div>
            </div>
        </div>
    </c:param>
</c:import>