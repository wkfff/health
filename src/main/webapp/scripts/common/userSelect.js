var userSelect = function(){
	var _gridManager;
	
	var _itemClick = function() {
		var selectRow = _gridManager.getSelectedRows();
		if (selectRow.length > 0) {
			var userId = "";
			for (var i = 0; i < selectRow.length; i++) {
				if (i > 0)
					userId += ",";
				userId += selectRow[i].userId;
			}
			var param = {roleId: roleId, userId: userId};
			var url = ctp+"/permission/addRoleUser";
			Common.post(url, param, function(backdata) {
				if (backdata.code == '1000') {
					$.ligerDialog.success(backdata.message, "提示", function(){
						parent.roleAuthorize.loadRoleUser();
						parent.$.ligerDialog.close();
					});
				} else if (backdata.code == '1001') {
					$.ligerDialog.error(backdata.message);
				}
			});
		}
	};
	
	var _statusSel = [{value:"10", text:"正常"}, {value:"11", text:"冻结"}, {value:"12", text:"注销"}];
	var _initGrid = function() {
		_gridManager = $("#maingrid").ligerGrid({
			checkbox: true,
			toolbar: {
				items:[{text: '添加', click: function(){_itemClick()}, icon: 'add'}
				]
			},
			columns: [
				{display: "用户名称", name: "userName", width: 100, align: "left"},
				{display: "用户账号", name: "userAccount", width: 100},
				{display: "用户状态", name: "userStatus", width: 100,
					editor: { type: 'select', data: _statusSel, valueColumnName: 'value' },
					  render: function(item) {
						  for (var i = 0; i < _statusSel.length; i++) {
							  if (_statusSel[i].value == item.userStatus)
								  return _statusSel[i].text;
						  }
					  }},
				{display: "用户手机", name: "userMobile", width: 100},
				{display: "用户邮箱", name: "userEmail", width: 100},
				{display: "创建日期", name: "createDate", width: 100},
				{name: "userId", width: 100, hide: true}
			],
			height: "99%",
			pageSize: 30
		});
		_loadGridData();
	};
	
	var _loadGridData = function() {
		var datas = {userName: $("#userName").val(),"pageNum":_gridManager.options.page, "pageSize":_gridManager.options.pageSize};
		var url = ctp + "/common/getUsers";
		Common.post(url, datas, function(backdata) {
			if (backdata) {
				_gridManager.loadData({Rows: backdata.Rows, Total: backdata.Total});
			}
		});
	};
	
	return {
		initPage: function() {
			_initGrid();
			$("#search").click(_loadGridData);
		}
	};
}();