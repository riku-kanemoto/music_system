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
                <p>登録してサイトを追加しよう！</p>
            </div>
            <div>
                <div class="site_object">
                    <a>そのサイトに飛ぶ</a>
                </div>
            </div>
        </div>
    </c:param>
</c:import>