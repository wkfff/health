<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/pages/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>产品文章信息添加修改</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ include file="/pages/common/baseFile.jsp"%>
  
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/Aqua/css/ligerui-all.css" />
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/Tab/css/form.css" />
  <link rel="stylesheet" href="${ctp}/styles/common/common.css" />
  <link rel="stylesheet" href="${ctp}/styles/common/gh-buttons.css" />
</head>

<body style="overflow:hidden;">
  <div id="queryHead" class="panel">
    <div class="panel-title">
      <span>基本信息</span>
      <div class="panel-button">
        <a id="submitBtn" href="javascript:void(0);" class="button icon approve">提交</a>
      </div>
    </div>
    <div class="panel-content">
      <form id="dataForm"></form>
    </div>
  </div>
</body>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/core/base.js"></script>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/ligerui.min.js"></script>
<script type="text/javascript" src="${ctp}/scripts/kindeditor/kindeditor-min.js"></script>
<script type="text/javascript" src="${ctp}/scripts/kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript" src="${ctp}/scripts/products/addModiPage.js"></script>
<script type="text/javascript">
	var userAccount = '${empty userAccount?"":userAccount}';
	var descInfo = ${descInfo == null?"{}":descInfo};
	addModiPage.onload({formData: descInfo});
</script>
</html>