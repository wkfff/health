var roleAuthorize = function(){
	var _roleGrid;
	var _roleUserGrid;
	var _menuGrid;
	var tabObj;
	var _roleId;
	
	var _initLayout = function() {
		$("#page_layout").ligerLayout({leftWidth: 300, allowLeftResize: false, allowLeftCollapse: false});
		$("#roleName").ligerTextBox({label:"角色名称", width:120});
		$(".l-layout-header").remove();
		$("#query br").remove();
	};
	
	var _initRoleTree = function() {
		_roleGrid = $("#rolegrid").ligerGrid({
			columns: [
				{display: "角色名称", name: "roleName", width: "100%", align: "left"},
				{name: "roleId", hide: true}
			],
			onSelectRow: _selectRow,
			width: "100%",
			height: "100%",
			pageSize: 30
		});
		_loadRoleData();
	};
	
	var _loadRoleData = function() {
		var data = {roleName:$("#roleName").val(), "pageNum":_roleGrid.options.page, "pageSize":_roleGrid.options.pageSize};
		var url = ctp + "/common/getRoles";
		Common.post(url, data, function(backdata) {
			if (backdata) {
				_roleGrid.loadData({Rows: backdata.Rows, Total: backdata.Total});
			}
		});
	};
	
	var _eventRegister = function() {
		$("#searchBtn").click(function(){
			_loadRoleData();
		});
	};
	
	var _selectRow = function(rowData) {
		_roleId = rowData.roleId;
		_loadRoleUser();

		_loadRolePrivilege();
		/**
		var gridData = _menuGrid.getData();
		if (gridData && _rolePrivilege) {
			$.each(gridData, function(gridIndex, menuObj) {
				var _this = this;
				$.each(_rolePrivilege, function(privilegeIndex, privilegeObj) {console.log(_this.id+"=="+this.accessCode+" is "+(_this.id == this.accessCode));
					if (_this.id == this.accessCode) {
						_menuGrid.select(_this);
					}
				});
			});
		}
		**/
	};
	
	var _loadRoleUser = function() {
		var data = {roleId:_roleId, "pageNum":_roleUserGrid.options.page, "pageSize":_roleUserGrid.options.pageSize};
		var url = ctp + "/permission/getRoleUser";
		Common.post(url, data, function(backdata) {
			if (backdata) {
				_roleUserGrid.loadData({Rows: backdata.data.list, Total: backdata.data.total});
			}
		});
	};
	
	var _initTabs = function() {
		tabObj = $("#authorizeTabs").ligerTab();
		_initRoleUser();
	};
	
	var _itemClick = function(operation) {
		if ("add" == operation) {
			if (!_roleId) {
				$.ligerDialog.warn("请选择角色！");
				return;
			}
			var option = {width: 600, height: 400, url: ctp+"/common/userSelectPage/"+_roleId, showMax: false, showToggle: false, showMin: false, isResize: false, modal: false, title: "人员选择"};
			$.ligerDialog.open(option);
		} else if ("delete" == operation) {
			var selectRow = _roleUserGrid.getSelectedRows();
			if (selectRow.length > 0 && confirm("是否确认删除所选数据？")) {
				var ids = [];
				$.each(selectRow, function(index, obj){
					ids.push(obj.userId);
				});
				var param = {roleId:_roleId, userId:ids.toString()};
				var url = ctp + "/permission/delRoleUser";
				var processBar = $.ligerDialog.waitting("数据正在删除中,请稍等...");
				Common.post(url, param, function(backdata) {
					processBar.close();
					if (backdata.code == '1000') {
						$.ligerDialog.success(backdata.message, "提示", function(){
							_loadRoleUser();
						});
					} else if (backdata.code == '1001') {
						$.ligerDialog.error(backdata.message);
					}
				});
			}
		}
	};
	
	var _initRoleUser = function() {
		_roleUserGrid = $("#usergrid").ligerGrid({
			checkbox: true,
			toolbar: {
				items:[{text: '增加', click: function(){_itemClick("add")}, icon: 'add'},
				       {line:true },
				       {text: '删除', click: function(){_itemClick("delete")}, icon: 'delete'}
				]
			},
			columns: [
				{display: "用户名称", name: "userName", width: 150, align: "left"},
				{name: "userId", hide: true, width: 150}
			],
			width: "100%",
			height: "100%",
			pageSize: 30
		});
	};
	
	var _loadRolePrivilege = function() {
		if (_roleId) {
			var url = ctp + "/permission/getRolePrivilege";
			Common.postNotObj(url, {roleId:_roleId}, function(backdata) {
				if (backdata.data) {
					var rolePrivilege = backdata.data;
					var gridData = _menuGrid.getData();
					if (gridData && rolePrivilege.length > 0) {
						$.each(gridData, function(gridIndex, menuObj) {
							_menuGrid.unselect(gridIndex);
							var _this = this;
							$.each(rolePrivilege, function(privilegeIndex, privilegeObj) {
								if (_this.id == this.accessCode) {
									_menuGrid.select(gridIndex);
									return false;
								}
							});
						});
					} else if (gridData && rolePrivilege <= 0) {
						$.each(gridData, function(gridIndex, menuObj) {
							_menuGrid.unselect(gridIndex);
						})
					}
				}
			});
		}
	}
	
	var _saveMenuPermission = function() {
		if (!_roleId) {
			$.ligerDialog.warn("请选择角色！");
			return;
		}
		var checkRows = _menuGrid.getSelecteds();
		var menuIds = [];
		$.each(checkRows,function(index, obj) {
			if ($.inArray(this.id, menuIds) < 0)
				menuIds.push(this.id);
		});
		var url = ctp + "/permission/savePrivilege";
		var processBar = $.ligerDialog.waitting("数据正在保存中,请稍等...");
		var param = {privilegeMaster:"11", masterCode:_roleId, privilegeAccess:"10", accessCode:menuIds.toString()};
		Common.post(url, param, function(backdata) {
			processBar.close();
			if (backdata.code == '1000') {
				$.ligerDialog.success(backdata.message, "提示");
			} else if (backdata.code == '1001') {
				$.ligerDialog.error(backdata.message);
			}
		});
	};
	
	var _treeDataProcess = function(trees) {
		var datas = [];
		$.each(trees, function(index, obj) {
			var data = {};
			data.id = this.id;
			data.name = this.name;
			data.parentId = this.parentId;
			data.parentName = this.parentName;
			data.status = this.status;
			data.order = this.order;
			data.url = this.url;
			if (this.children.length > 0) {
				data.children = _treeDataProcess(this.children);
			}
			datas.push(data);
		});
		return datas;
	};
	
	var _statusSel = [{value:"10", text:"可用"}, {value:"11", text:"不可用"}];
	var _initMenuGrid = function() {
		_menuGrid = $("#menugrid").ligerGrid({
			checkbox: true,
			toolbar: {
				items:[{text: '保存', click: function(){_saveMenuPermission()}, icon: 'add'}
				]
			},
			columns: [
				{display: "菜单名称", name: "name", id: "id1", width: 200, align: "left", isSort: false},
				{display: "父级菜单", name: "parentName", width: 100, align: "left", isSort: false},
				{display: "菜单状态", name: "status", width: 100, align: "left", isSort: false,
					editor: { type: 'select', data: _statusSel, valueColumnName: 'value' },
					  render: function(item) {
						  for (var i = 0; i < _statusSel.length; i++) {
							  if (_statusSel[i].value == item.status)
								  return _statusSel[i].text;
						  }
					  }},
				{display: "链接地址", name: "url", width: 200, align: "left", isSort: false},
				{name: "id", hide: true},
				{name: "parentId", hide: true},
				{name: "order", hide: true}
			],
			onCheckRow:_menuCheckRow,
			usePager: false,
			width: "100%",
			height: "99%",
			tree: {columnId: "id1"}
		});
		_loadMenuData();
	};
	
	var _menuCheckRow = function(checked,data,rowid,rowdata) {
		var parentRow = _menuGrid.getParent(rowdata);
		var selected = _menuGrid.isSelected(parentRow);
		if (parentRow != null && !selected) {
			_menuGrid.select(parentRow);
		}
	};
	
	var _loadMenuData = function() {
		var url = ctp + "/permission/getAllMenus";
		Common.post(url, {}, function(backdata) {
			if (backdata.data) {
				_menuGrid.loadData({Rows: _treeDataProcess(backdata.data)});
			}
		});
	};
	
	return {
		initPage : function() {
			_initLayout();
			_initRoleTree();
			_initMenuGrid();
			_eventRegister();
			_initTabs();
		},
		loadRoleUser : function() {
			_loadRoleUser();
		}
	};
}();