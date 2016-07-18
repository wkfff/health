<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/pages/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>产品信息查询列表</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ include file="/pages/common/baseFile.jsp"%>
  
  <link type="text/css" href="${ctp}/scripts/ligerUI/skins/Aqua/css/ligerui-all.css" />
  <link type="text/css" href="${ctp}/scripts/ligerUI/skins/ligerui-all.css" />
  <link type="text/css" href="${ctp}/scripts/ligerUI/skins/Gray/css/all.css" />
</head>

<body>
  <div class="l-loading" style="display:block" id="pageloading"></div>
  <div class="l-clear"></div>
  <div id="maingrid"></div>
  <div style="display:none;"></div>
</body>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/core/base.js"></script>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/plugins/ligerGrid.js"></script>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/plugins/ligerToolBar.js"></script>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/plugins/ligerResizable.js"></script>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/plugins/ligerCheckBox.js"></script>
<script type="text/javascript" src="${ctp}/scripts/products/promotionList.js"></script>
<script type="text/javascript">
	productIntroduces.onload();
</script>
</html>