var promotionList = function() {
	var mainGrid = $("#maingrid");
	var gridWidth = $(window).width();
	var gridHeight = $(window).height();
	var qh = $("#queryHead").height();
	var gridColumns = [
	  {display:'信息标题', name:'descTitle', align:'left', width:100, minWidth:60},
	  {display:'信息类目', name:'categoryName', align:'left', width:100, minWidth:60},
	  {display:'信息来源', name:'descSource', align:'left', width:100, minWidth:60},
	  {display:'是否有效', name:'descValid', align:'left', width:100, minWidth:60},
	  {display:'创建日期', name:'createDate', align:'left', width:100, minWidth:60}
	];
	
	var initGrid = function() {alert(gridHeight+":"+qh);
		mainGrid.ligerGrid({
			columns:gridColumns,
			checkbox: true,
			pageSize:30,
			width: gridWidth - 5,
			height: gridHeight - qh - 47
		});
	};
	
	return {
		onload:function(){
			initGrid();
			$("#pageloading").hide();
		}
	};
}();