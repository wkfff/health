var menuManager = function(){
	var _treeGridManager;
	var _menuData = {};
	
	var _treeDataProcess = function(trees) {
		var datas = [];
		$.each(trees, function(index, value) {
			var data = {};
			data.id = this.id;
			data.name = this.name;
			data.text = this.name;
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
	
	var _setMenuData = function(selectRow, operation) {
		_menuData.menuId = selectRow.id;
		_menuData.name = selectRow.name;
		_menuData.parentId = selectRow.parentId;
		_menuData.parentName = selectRow.parentName;
		_menuData.resourceStatus = selectRow.status;
		_menuData.resourceOrder = selectRow.order;
		_menuData.url = selectRow.url;
		_menuData.operation = operation;
	};
	
	var _getMenuData = function() {
		return _menuData;
	}
	
	var _menuItemClick = function(action) {
		var selectRow = _treeGridManager.getSelectedRow();
		if ("add" == action) {
			if (selectRow != null) {
				_menuData.menuId = "";
				_menuData.parentId = selectRow.id;
				_menuData.parentName = selectRow.name;
				_menuData.menuType = "11";
			}
			_menuData.operation = action;
			var obj = {width: 470,height: 300,url:ctp+"/common/addEditMenuPage",isResize: false, modal: false,title: "新增修改菜单"};
			$.ligerDialog.open(obj);
		} else if ("modify" == action) {
			if (selectRow == null) {
				$.ligerDialog.warn("请选择要修改的记录");
				return;
			} else {
				_setMenuData(selectRow, action);
				if (selectRow.parentId == "-1")
					_menuData.menuType = "10";
				else
					_menuData.menuType = "11";
			}
			var obj = {width: 470,height: 300,url:ctp+"/common/addEditMenuPage",isResize: false, modal: false,title: "新增修改菜单"};
			$.ligerDialog.open(obj);
		} else if ("delete" == action) {
			if (selectRow == null) {
				$.ligerDialog.warn("请选择要删除的记录");
				return;
			} else {
				var url = ctp + "/common/deleteMenu";
				var processBar = $.ligerDialog.waitting("正在处理,请稍等...");
				Common.postNotObj(url, {resourceId: selectRow.id}, function(backdata) {
					processBar.close();
					if (backdata.code == '1000') {
						$.ligerDialog.success(backdata.message, "提示", function(){
							menuManager.loadData();
							parent.main.reloadMenu();
						});
					} else if (backdata.code == '1001') {
						$.ligerDialog.error(backdata.message);
					}
				});
			}
		}
	};
	
	var _statusSel = [{value:"10", text:"可用"}, {value:"11", text:"不可用"}];
	var _initTreeGrid = function() {
		_treeGridManager = $("#mainGrid").ligerGrid({
			toolbar: {
				items:[{text: '增加', click: function(){_menuItemClick("add")}, icon: 'add'},
				       {line:true },
				       {text: '修改', click: function(){_menuItemClick("modify")}, icon: 'modify'},
				       {line:true },
				       {text: '删除', click: function(){_menuItemClick("delete")}, icon: 'delete'},
				]
			},
			columns: [
				{display: "菜单名称", name: "name", id: "id1", width: 250, align: "left"},
				{display: "父级菜单", name: "parentName", width: 250, align: "left"},
				{display: "菜单状态", name: "status", width: 250, align: "left",
					editor: { type: 'select', data: _statusSel, valueColumnName: 'value' },
					  render: function(item) {
						  for (var i = 0; i < _statusSel.length; i++) {
							  if (_statusSel[i].value == item.status)
								  return _statusSel[i].text;
						  }
					  }},
				{display: "链接地址", name: "url", width: 300, align: "left"},
				{name: "id", hide: true},
				{name: "parentId", hide: true},
				{name: "order", hide: true}
			],
			usePager: false,
			width: "100%",
			height: "100%",
			alternatingRow: false,
			tree: {columnId: "id1"}
		});
	};
	
	var _loadTreeGridData = function() {
		var url = ctp + "/common/getUserMenus";
		Common.post(url, {}, function(backdata) {
			if (backdata.data) {
				_treeGridManager.loadData({Rows: _treeDataProcess(backdata.data)});
			}
		});
	};
	
	return {
		initPage: function() {
			_initTreeGrid();
			_loadTreeGridData();
		},
		getMenuData: function() {
			return _getMenuData();
		},
		loadData: function() {
			_loadTreeGridData();
		}
	};
}();