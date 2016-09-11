var descInfoList = function() {
	var mainGrid = $("#maingrid");
	var gridWidth = $(window).width();
	var gridHeight = $(window).height();
	var qh = $("#queryHead").height();
	
	var comboBoxData;
	var resultGrid;
	
	var getGridColumns = function() {
		return [
		      {display:'主键', name:'descId', align:'left', width:100, hide: true},
		  	  {display:'信息标题', name:'descTitle', align:'left', width:300},
			  {display:'信息类目', name:'descCategory', align:'left', width:120,
				  editor: { type: 'select', data: comboBoxData.desc_category, valueColumnName: 'value' },
				  render: function(item) {
					  var category = comboBoxData.desc_category;
					  for (var i = 0; i < category.length; i++) {
						  if (category[i].value == item.descCategory)
							  return category[i].text;
					  }
				  }},
			  {display:'信息来源', name:'descSource', align:'left', width:150,
				  editor: { type: 'select', data: comboBoxData.desc_source, valueColumnName: 'value' },
				  render: function(item) {
					  var source = comboBoxData.desc_source;
					  for (var i = 0; i < source.length; i++) {
						  if (source[i].value == item.descSource)
							  return source[i].text;
					  }
				  }
			  },
			  {display:'信息状态', name:'descStatus', align:'left', width:120,
				  editor: { type: 'select', data: comboBoxData.desc_status, valueColumnName: 'value' },
				  render: function(item) {
					  var status = comboBoxData.desc_status;
					  for (var i = 0; i < status.length; i++) {
						  if (status[i].value == item.descStatus)
							  return status[i].text;
					  }
				  }},
			  {display:'创建日期', name:'createDate', align:'left', width:150}
			];
	}
	
	var initForm = function() {
		$("#queryForm").ligerForm({
			inputWidth: 170, labelWidth: 90, space: 40,
			fields: [
			  {display: "信息标题", name: "descTitle", newline: false, type: "text"},
			  {display: "信息状态", name: "descStatus", newline: false, type: "select", comboboxName: "descStatus", editor: {data: comboBoxData.desc_status}, options: {valueField: "value"}},
			  {display: "信息类目", name: "descCategory", newline: false, type: "select", comboboxName: "descCategory", editor: {data: comboBoxData.desc_category}, options: {valueField: "value"}},
			  {display: "创建开始日期", name: "createBeginDate", newline: true, type: "date"},
			  {display: "创建结束日期", name: "createEndDate", newline: false, type: "date"}
			]
		});
	}
	
	var initGrid = function() {
		resultGrid = mainGrid.ligerGrid({
			columns: getGridColumns(),
			checkbox: true,
			url: ctp + "/product/descList",
			contentType: "application/json",
			delayLoad: true,
			pageSize:30,
			width: gridWidth - 5,
			height: gridHeight - qh - 38 - 10
		});
	};
	
	var loadGridData = function() {
		var formObj = new liger.get("queryForm");
		var datas = formObj.getData();
		$.extend(datas, {"page":resultGrid.options.page, "pageSize":resultGrid.options.pageSize});
		resultGrid.loadServerData(datas);
	};
	
	var eventRegister = function() {
		$("#search").click(loadGridData);
		$("#addBtn").click(function(){
			var url = ctp + "/product/desc/addModiPage";
			window.open(url, "addModiPage", "height=500,width=900,top=100,left=200,resizable=no,location=no");
		});
		$("#editBtn").click(function(){
			var rows = resultGrid.getSelectedRows();
			if (rows.length == 0) {
				$.ligerDialog.alert('请选择一条记录', '提示', 'none');
			} else if (rows.length > 1){
				$.ligerDialog.alert('只能选择一条记录', '提示', 'none');
			} else if (rows.length == 1) {
				var descId = rows[0].descId;
				var url = ctp + "/product/desc/addModiPage?descId=" + descId;
				window.open(url, "addModiPage", "height=500,width=900,top=100,left=200,resizable=no,location=no");
			}
		});
		$("#delBtn").click(function(){
			var rows = resultGrid.getSelectedRows();
			if (rows.length == 0) {
				$.ligerDialog.alert('请选择一条记录', '提示', 'none');
			} else {
				$.ligerDialog.confirm('确定删除选择的记录吗？', function(status){
					if (status) {
						var ids = [];
						$.each(rows, function(index, item){
							ids.push(item.descId);
						});
						var url = ctp + "/product/deleteProductDesc";
						var processBar = $.ligerDialog.waitting("数据处理中...");
						Common.post(url, ids, function(backdata){
							processBar.close();
							if (backdata.code == '1000') {
								loadGridData();
								$.ligerDialog.success(backdata.message);
							} else if (backdata.code == '1001') {
								$.ligerDialog.error(backdata.message);
							}
						});
					}
				});
			}
		});
		$("#publishBtn").click(function(){
			var rows = resultGrid.getSelectedRows();
			if (rows.length == 0) {
				$.ligerDialog.alert('请选择一条记录', '提示', 'none');
			} else {
				$.ligerDialog.confirm('确定发布选择的记录吗？', function(status){
					if (status) {
						var ids = [];
						$.each(rows, function(index, item){
							if (item.descStatus == '10')
								ids.push(item.descId);
						});
						if (ids.length == 0) {
							$.ligerDialog.warn("请选择状态为'未发布'的记录");
							return;
						}
						var url = ctp + "/product/updateDescStatus";
						var processBar = $.ligerDialog.waitting("数据处理中...");
						Common.post(url, {descIds: ids, descStatus: '11'}, function(backdata){
							processBar.close();
							if (backdata.code == '1000') {
								loadGridData();
								$.ligerDialog.success(backdata.message);
							} else if (backdata.code == '1001') {
								$.ligerDialog.error(backdata.message);
							}
						});
					}
				});
			}
		});
		$("#disPublishBtn").click(function(){
			var rows = resultGrid.getSelectedRows();
			if (rows.length == 0) {
				$.ligerDialog.alert('请选择一条记录', '提示', 'none');
			} else {
				$.ligerDialog.confirm('确定取消发布选择的记录吗？', function(status){
					if (status) {
						var ids = [];
						$.each(rows, function(index, item){
							if (item.descStatus != '10')
								ids.push(item.descId);
						});
						if (ids.length == 0) {
							$.ligerDialog.warn("请选择状态为'已发布'的记录");
							return;
						}
						var url = ctp + "/product/updateDescStatus";
						var processBar = $.ligerDialog.waitting("数据处理中...");
						Common.post(url, {descIds: ids, descStatus: '10'}, function(backdata){
							processBar.close();
							if (backdata.code == '1000') {
								loadGridData();
								$.ligerDialog.success(backdata.message);
							} else if (backdata.code == '1001') {
								$.ligerDialog.error(backdata.message);
							}
						});
					}
				});
			}
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