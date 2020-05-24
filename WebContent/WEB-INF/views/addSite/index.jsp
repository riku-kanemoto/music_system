<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <div>
            <form method="POST" enctype="multipart/form-data" action="<c:url value='/addsite/create'/>">
                 <c:import url="_form.jsp" />
            </form>
        </div>
    </c:param>
</c:import>