<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<label for="name">サイト名</label>
<input type="text" name="name">
<label for="url">サイトURL</label>
<input type="text" name="url" >
<label for="imag">画像</label>
<input type="file" name="imag">
<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿する</button>
