var roleManager = function(){
	var _gridManager;
	var _roleData = {};
	var gridWidth = $(window).width();
	var gridHeight = $(window).height();
	var qh = $("#queryHead").height();
	
	var _setRoleData = function(selectRow, operation) {
		_roleData.roleId = selectRow.roleId;
		_roleData.roleName = selectRow.roleName;
		_roleData.roleDesc = selectRow.roleDesc;
		_roleData.roleCode = selectRow.roleCode;
		_roleData.createDate = selectRow.createDate;
		_roleData.operation = operation;
	};
	
	var _getRoleData = function() {
		return _roleData;
	}
	
	var _itemClick = function(action) {
		var selectRow = _gridManager.getSelectedRows();
		if ("add" == action) {
			_roleData = {};
			_roleData.operation = action;
			var obj = {width: 470,height: 300,url:ctp+"/common/addEditRolePage",isResize: false, modal: false,title: "新增修改角色"};
			$.ligerDialog.open(obj);
		} else if ("modify" == action) {
			if (selectRow == null) {
				$.ligerDialog.warn("请选择要修改的记录");
				return;
			} else if (selectRow.length > 1) {
				$.ligerDialog.warn("只能选择一条记录进行修改！");
				return;
			} else {
				_setRoleData(selectRow[0], action);
			}
			var obj = {width: 470,height: 300,url:ctp+"/common/addEditRolePage",isResize: false, modal: false,title: "新增修改角色"};
			$.ligerDialog.open(obj);
		} else if ("delete" == action) {
			if (selectRow == null) {
				$.ligerDialog.warn("请选择要删除的记录");
				return;
			} else if (confirm("是否确认删除所选记录？")){
				var url = ctp + "/common/deleteRole";
				var ids = [];
				$.each(selectRow,function(index, val){
					ids.push(this.roleId);
				});
				
				var processBar = $.ligerDialog.waitting("正在处理,请稍等...");
				Common.postNotObj(url, {roleId: ids}, function(backdata) {
					processBar.close();
					if (backdata.code == '1000') {
						$.ligerDialog.success(backdata.message, "提示", function(){
							roleManager.loadData();
						});
					} else if (backdata.code == '1001') {
						$.ligerDialog.error(backdata.message);
					}
				});
			}
		} else if ("authorization" == action) {
			var codeStr = Base64.encode("roleAuthorize,角色授权,"+ctp+"/common/roleAuthorizePage");
			parent.main.menuNav(codeStr);
		}
	};
	
	var _initGrid = function() {
		_gridManager = $("#maingrid").ligerGrid({
			checkbox: true,
			toolbar: {
				items:[{text: '增加', click: function(){_itemClick("add")}, icon: 'add'},
				       {line:true },
				       {text: '修改', click: function(){_itemClick("modify")}, icon: 'modify'},
				       {line:true },
				       {text: '删除', click: function(){_itemClick("delete")}, icon: 'delete'},
				       {line:true },
				       {text: '授权', click: function(){_itemClick("authorization")}, icon: 'role'}
				]
			},
			columns: [
				{display: "角色名称", name: "roleName", width: 150, align: "left"},
				{display: "角色编码", name: "roleCode", width: 150, align: "left"},
				{display: "角色描述", name: "roleDesc", width: 150, align: "left"},
				{display: "创建日期", name: "createDate", width: 200, align: "left"},
				{name: "roleId", hide: true}
			],
			width: "100%",
			height: "100%",
			pageSize: 30
		});
		_loadGridData();
	};
	
	var _loadGridData = function() {
		var formObj = new liger.get("queryForm");
		var datas = formObj.getData();
		$.extend(datas, {"pageNum":_gridManager.options.page, "pageSize":_gridManager.options.pageSize});
		var url = ctp + "/common/getRoles";
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
			  {display: "角色名称", name: "roleName", newline: false, type: "text"}
			]
		});
	}
	
	return {
		initPage: function() {
			_initForm();
			_initGrid();
			$("#search").click(_loadGridData);
		},
		getRoleData: function() {
			return _getRoleData();
		},
		loadData: function() {
			_loadGridData();
		}
	};
}();