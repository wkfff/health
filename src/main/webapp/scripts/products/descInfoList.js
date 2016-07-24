var descInfoList = function() {
	var mainGrid = $("#maingrid");
	var gridWidth = $(window).width();
	var gridHeight = $(window).height();
	var qh = $("#queryHead").height();
	
	var comboBoxData;
	var resultGrid;
	
	var gridColumns = [
	  {display:'信息标题', name:'descTitle', align:'left', width:100, minWidth:60},
	  {display:'信息类目', name:'descCategory', align:'left', width:100, minWidth:60},
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
		resultGrid = mainGrid.ligerGrid({
			columns:gridColumns,
			checkbox: true,
			url: ctp + "/product/descList",
			contentType: "application/json",
			delayLoad: true,
			pageSize:30,
			width: gridWidth - 5,
			height: gridHeight - qh - 35 - 10
		});
	};
	
	var eventRegister = function() {
		$("#search").click(function(){
			var formObj = new liger.get("queryForm");
			var datas = formObj.getData();
			$.extend(datas, {"page":resultGrid.options.page, "pageSize":resultGrid.options.pageSize});
			resultGrid.loadServerData(datas);
		});
		$("#addBtn").click(function(){
			
		});
		$("#editBtn").click(function(){
			
		});
		$("#delBtn").click(function(){
			
		});
	};
	
	return {
		onload: function(){
			$("#pageloading").hide();
			eventRegister();
			comboBoxData = Common.getSysEnume();
			initForm();
			initGrid();
		}
	};
}();