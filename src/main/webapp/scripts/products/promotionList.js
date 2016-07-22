var promotionList = function() {
	var mainGrid = $("#maingrid");
	var gridWidth = $(window).width();
	var gridHeight = $(window).height();
	var qh = $("#queryHead").height();
	
	var comboBoxData;
	
	var gridColumns = [
	  {display:'信息标题', name:'descTitle', align:'left', width:100, minWidth:60},
	  {display:'信息类目', name:'categoryCode', align:'left', width:100, minWidth:60},
	  {display:'信息来源', name:'descSource', align:'left', width:100, minWidth:60},
	  {display:'信息状态', name:'descStatus', align:'left', width:100, minWidth:60},
	  {display:'创建日期', name:'createDate', align:'left', width:100, minWidth:60}
	];
	
	var initForm = function() {
		$("#queryForm").ligerForm({
			inputWidth: 170, labelWidth: 90, space: 40,
			fields: [
			  {display: "信息标题", name: "descTitle", newline: false, type: "text"},
			  {display: "信息状态", name: "descStatus", newline: false, type: "select", comboboxName: "descStatus", editor: {data: comboBoxData.desc_status}},
			  {display: "信息类目", name: "descCategory", newline: false, type: "select", comboboxName: "descCategory", editor: {data: comboBoxData.desc_category}},
			  {display: "创建开始日期", name: "createBeginDate", newline: true, type: "date"},
			  {display: "创建结束日期", name: "createEndDate", newline: false, type: "date"}
			]
		});
	}
	
	var initGrid = function() {
		mainGrid.ligerGrid({
			columns:gridColumns,
			checkbox: true,
			pageSize:30,
			width: gridWidth - 5,
			height: gridHeight - qh - 35 - 10
		});
	};
	
	return {
		onload: function(){
			$("#pageloading").hide();
			comboBoxData = Common.getSysEnume();
			initForm();
			initGrid();
		},
		query: function() {
			
		},
		addData: function() {
			
		},
		editData: function() {
			
		},
		deleteData: function() {
			
		}
	};
}();