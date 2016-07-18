<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/pages/common/common.jsp"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>登录</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ include file="/pages/common/baseFile.jsp"%>
  
  <link type="text/css" href="${ctp}/styles/common/reset.css">
  <link type="text/css" href="${ctp}/styles/common/supersized.css">
  <link type="text/css" href="${ctp}/styles/common/style.css">
</head>
  
<body>
  <div class="page-container">
    <h1>用户登录</h1>
    <form id="loginForm" method="post">
    <input type="text" id="userAccount" name="userAccount" class="username" placeholder="用户名">
    <input type="password" id="userPassword" name="userPassword" class="password" placeholder="密码">
    <button type="button" id="loginBtn">登录</button>
    <div class="error"><span>+</span></div>
    </form>
  </div>
</body>
<script type="text/javascript" src="${ctp}/scripts/common/supersized.3.2.7.min.js"></script>
<script type="text/javascript" src="${ctp}/scripts/common/supersized-init.js"></script>
<script type="text/javascript" src="${ctp}/scripts/common/signIn.js"></script>
</html>