var userManager = function(){
	var _gridManager;
	var _userData = {};
	var gridWidth = $(window).width();
	var gridHeight = $(window).height();
	var qh = $("#queryHead").height();
	
	var _setUserData = function(selectRow, operation) {
		_userData.userId = selectRow.userId;
		_userData.userName = selectRow.userName;
		_userData.userAccount = selectRow.userAccount;
		_userData.userMobile = selectRow.userMobile;
		_userData.userStatus = selectRow.userStatus;
		_userData.userEmail = selectRow.userEmail;
		_userData.createDate = selectRow.createDate;
		_userData.operation = operation;
	};
	
	var _getUserData = function() {
		return _userData;
	}
	
	var _itemClick = function(action) {
		var selectRow = _gridManager.getSelectedRows();
		if ("add" == action) {
			_userData.operation = action;
			var obj = {width: 470,height: 300,url:ctp+"/common/addEditUserPage",isResize: false, modal: false,title: "新增修改用户"};
			$.ligerDialog.open(obj);
		} else if ("modify" == action) {
			if (selectRow == null) {
				$.ligerDialog.warn("请选择要修改的记录");
				return;
			} else if (selectRow.length > 1) {
				$.ligerDialog.warn("只能选择一条记录进行修改！");
				return;
			} else {
				_setUserData(selectRow[0], action);
			}
			var obj = {width: 470,height: 300,url:ctp+"/common/addEditUserPage",isResize: false, modal: false,title: "新增修改用户"};
			$.ligerDialog.open(obj);
		} else if ("delete" == action) {
			if (selectRow == null) {
				$.ligerDialog.warn("请选择要删除的记录");
				return;
			} else if (confirm("是否确认删除所选记录？")){
				var url = ctp + "/common/deleteUser";
				var ids = [];
				$.each(selectRow,function(index, val){
					ids.push(this.userId);
				});
				
				var processBar = $.ligerDialog.waitting("正在处理,请稍等...");
				Common.postNotObj(url, {userId: ids}, function(backdata) {
					processBar.close();
					if (backdata.code == '1000') {
						$.ligerDialog.success(backdata.message, "提示", function(){
							userManager.loadData();
							parent.main.reloadMenu();
						});
					} else if (backdata.code == '1001') {
						$.ligerDialog.error(backdata.message);
					}
				});
			}
		}
	};
	
	var _statusSel = [{value:"10", text:"正常"}, {value:"11", text:"冻结"}, {value:"12", text:"注销"}];
	var _initGrid = function() {
		_gridManager = $("#maingrid").ligerGrid({
			checkbox: true,
			toolbar: {
				items:[{text: '增加', click: function(){_itemClick("add")}, icon: 'add'},
				       {line:true },
				       {text: '修改', click: function(){_itemClick("modify")}, icon: 'modify'},
				       {line:true },
				       {text: '删除', click: function(){_itemClick("delete")}, icon: 'delete'},
				]
			},
			columns: [
				{display: "用户名称", name: "userName", width: 150, align: "left"},
				{display: "用户账号", name: "userAccount", width: 150, align: "left"},
				{display: "用户状态", name: "userStatus", width: 150, align: "left",
					editor: { type: 'select', data: _statusSel, valueColumnName: 'value' },
					  render: function(item) {
						  for (var i = 0; i < _statusSel.length; i++) {
							  if (_statusSel[i].value == item.userStatus)
								  return _statusSel[i].text;
						  }
					  }},
				{display: "用户手机", name: "userMobile", width: 150, align: "left"},
				{display: "用户邮箱", name: "userEmail", width: 150, align: "left"},
				{display: "创建日期", name: "createDate", width: 200, align: "left"},
				{name: "userId", hide: true}
			],
			width: "100%",
			height: "100%",
			rowHeight: 22,
			pageSize: 30
		});
	};
	
	var _loadGridData = function() {
		var formObj = new liger.get("queryForm");
		var datas = formObj.getData();
		$.extend(datas, {"pageNum":_gridManager.options.page, "pageSize":_gridManager.options.pageSize});
		var url = ctp + "/common/getUsers";
		Common.post(url, datas, function(backdata) {
			if (backdata) {
				_gridManager.loadData({Rows: backdata.Rows, Total: backdata.Total});
			}
		});
	};
	
	var _initForm = function() {
		$("#queryForm").ligerForm({
			inputWidth: 140, labelWidth: 60, space: 25,
			fields: [
			  {display: "用户名称", name: "userName", newline: false, type: "text"},
			  {display: "用户账号", name: "userAccount", newline: false, type: "text"},
			  {display: "用户状态", name: "userStatus", newline: false, type: "select", comboboxName: "userStatus", editor: {data: _statusSel}, options: {valueField: "value"}}
			]
		});
	}
	
	return {
		initPage: function() {
			_initForm();
			_initGrid();
			$("#search").click(_loadGridData);
		},
		getUserData: function() {
			return _getUserData();
		},
		loadData: function() {
			_loadGridData();
		}
	};
}();