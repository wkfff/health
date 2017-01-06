<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/pages/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>新增修改用户</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ include file="/pages/common/baseFile.jsp"%>
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/Aqua/css/ligerui-all.css" />
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/Gray/css/all.css" />
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/Tab/css/form.css" />
  <link rel="stylesheet" href="${ctp}/styles/common/common.css" />
  <link rel="stylesheet" href="${ctp}/styles/common/gh-buttons.css" />
</head>

<body style="overflow:hidden;">
  <div style="text-align:center;">
    <div style="width: 300px; margin: 0 auto;"><form id="dataForm"></form></div>
    <a id="submitBtn" href="javascript:void(0);" class="button icon approve">提交</a>
  </div>
</body>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/core/base.js"></script>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/ligerui.min.js"></script>
<script type="text/javascript" src="${ctp}/scripts/jquery-validation/jquery.validate.min.js"></script>
<script type="text/javascript" src="${ctp}/scripts/jquery-validation/messages_cn.js"></script>
<script type="text/javascript" src="${ctp}/scripts/common/addEditUser.js"></script>
<script type="text/javascript">
	$(function() {
		addEditUser.initPage();
	});
</script>
</html>