<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/pages/common/common.jsp"%>
<!DOCTYPE html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ include file="/pages/common/baseFile.jsp"%>
  <link type="text/css" rel="stylesheet" href="${ctp}/styles/wechat/main.css">
  <link type="text/css" rel="stylesheet" href="${ctp}/styles/wechat/ui.progress-bar.css">
<title></title>
</head>
<body>
  <div id="header">
      <div id="leftBtn">&lt;</div>
      <div id="title" class="title-center"><span>一元购</span></div>
      <div id="rightBtn">&gt;</div>
  </div>
  <div id="content">
      <div class="goods-list">
          <div class="goods-img"><img src="${ctp}/images/wechat/qingzhi.png"></div>
          <div class="goods-info">
              <div class="info-line"><span>第 </span><b style="color: #ff2f0f;">0001</b><span> 期</span></div>
              <div class="info-line"><span><b>三里人家大麦若叶粉(青汁)</b></span></div>
              <div class="info-line"><span>数量：1盒</span></div>
              <div class="info-line"><span>价格：</span><span style="color: #ff2f0f;">¥138</span></div>
              <div id="processContent" class="info-line" style="clear: both;">
                  <div id="progress_bar" class="ui-progress-bar"><div class="ui-progress"></div></div>
                  <div style="float: left;"><span style="font-size: 12px; color: #ff2f0f; display: block; text-align: center;">100</span><span style="font-size: 12px;">参与人数</span></div>
                  <div style="float: right;"><span style="font-size: 12px; color: #ff2f0f; display: block; text-align: center;">38</span><span style="font-size: 12px;">剩余人数</span></div>
              </div>
          </div>
          <div class="goods-btn"><button>一元购</button></div>
      </div>
  </div>
  <div id="footer">
      <div id="oneBtn" class="footer-btn"><span>一元购</span></div>
      <div id="mallBtn" class="footer-btn"><span>商城</span></div>
      <div id="mineBtn" class="footer-btn"><span>我的</span></div>
  </div>
  <script src="${ctp}/scripts/wechat/progress.js"></script>
  <script src="${ctp}/scripts/wechat/shortBuy.js"></script>
  <script>
	$(document).ready(function(){
		shortBuy.initPage();
	});
  </script>
</body>
</html>