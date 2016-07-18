<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/pages/common/common.jsp"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>登录</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ include file="/pages/common/baseFile.jsp"%>
  
  <link rel="stylesheet" href="${ctp}/styles/common/reset.css">
  <link rel="stylesheet" href="${ctp}/styles/common/supersized.css">
  <link rel="stylesheet" href="${ctp}/styles/common/style.css">
</head>
  
<body>
  <div class="page-container">
    <h1>用户登录</h1>
    <form id="loginForm" method="post">
    <input type="text" id="userAccount" name="userAccount" class="username" placeholder="用户名">
    <input type="password" id="userPassword" name="userPassword" class="password" placeholder="密码">
    </form>
    <button type="button">登录</button>
  </div>
</body>
<script type="text/javascript" src="${ctp}/scripts/common/signIn.js"></script>
</html>