var promotionList = function() {
	var mainGrid = $("#maingrid");
	var gridColumns = [
	  {display:'信息标题', name:'descTitle', align:'left', width:100, minWidth:60},
	  {display:'信息类目', name:'categoryName', align:'left', width:100, minWidth:60},
	  {display:'信息来源', name:'descSource', align:'left', width:100, minWidth:60},
	  {display:'是否有效', name:'descValid', align:'left', width:100, minWidth:60},
	  {display:'创建日期', name:'createDate', align:'left', width:100, minWidth:60}
	];
	
	var initGrid = function() {
		mainGrid.ligerGrid({
			columns:gridColumns,
			rownumbers:true,
			pageSize:30,
			width: '100%',
			height:300
		});
	};
	
	return {
		onload:function(){
			initGrid();
			$("#pageloading").hide();
		}
	};
}();