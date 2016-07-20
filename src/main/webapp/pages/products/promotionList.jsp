<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/pages/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>产品信息查询列表</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ include file="/pages/common/baseFile.jsp"%>
  
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/Aqua/css/ligerui-all.css" />
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/Gray/css/all.css" />
  <link rel="stylesheet" href="${ctp}/styles/common/common.css" />
</head>

<body style="overflow:hidden;">
  <!-- 查询条件 -->
  <div class="panel">
    <div class="panel-title"><span>查询条件</span></div>
    <div class="panel-content"></div>
  </div>
  <!-- 查询结果
  <div class="paner">
    <div class="panel-title"></div>
    <div class="panel-content"></div>
  </div> -->
  <div class="l-loading" style="display:block" id="pageloading"></div>
  <div class="l-clear"></div>
  <div id="maingrid"></div>
  <div style="display:none;"></div>
</body>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/core/base.js"></script>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/plugins/ligerGrid.js"></script>
<script type="text/javascript" src="${ctp}/scripts/products/promotionList.js"></script>
<script type="text/javascript">
	promotionList.onload();
</script>
</html>