<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<label for="name">名前</label>
<input type="text" name="name" >
<label for="adress">アドレス</label>
<input type="email" name="adress" >
<label for="password">パスワード</label>
<input type="password" name="password" >
<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録する</button>