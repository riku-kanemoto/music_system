<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<label for="name">サイト名</label>
<input type="text" name="name">
<label for="url">サイトURL</label>
<input type="url" name="url" >
<label for="color">背景色</label>
<input type="radio" name="back_color" value=1>Red
<input type="radio" name="back_color" value=2>Blue
<input type="radio" name="back_color" value=3>Yellow
<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿する</button>
