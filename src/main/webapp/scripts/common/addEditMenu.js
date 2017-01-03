var addEditMenu = function(){
	var _menuForm;
	
	var _menuTypeSel = [{value:"10", text:"根菜单"}, {value:"11", text:"子菜单"}];
	var _statusSel = [{value:"10", text:"可用"}, {value:"11", text:"不可用"}];
	var _initMenuForm = function() {
		var parentData = parent.menuManager.getMenuData();
		_menuForm = $("#dataForm").ligerForm({
			labelWidth: 70, space: 40, validate : true,
			fields: [
			  {name: "menuId", type: "hidden" },
			  {name: "parentId", type: "hidden" },
			  {display: "菜单类型", name: "menuType", newline: true, type: "select", width: 160, comboboxName: "menuType", options: {data: _menuTypeSel, valueField: "value"}, validate: {required: true}},
			  {display: "上级菜单", name: "parentName", newline: true, type: "text", width: 160},
			  {display: "菜单名称", name: "name", newline: true, type: "text", width: 160, validate: {required: true, maxlength:30}},
			  {display: "菜单状态", name: "resourceStatus", newline: true, type: "select", width: 160, comboboxName: "resourceStatus", options: {data: _statusSel, valueField: "value"}, validate: {required: true}},
			  {display: "序号", name: "resourceOrder", newline: true, type: "digits", width: 160},
			  {display: "链接地址", name: "url", newline: true, type: "text", width: 160}
			]
		});
		_menuForm.setEnabled("parentName",false);
		_menuForm.setData(parentData);
	};
	
	var _eventRegister = function() {
		$("#submitBtn").click(function(){
			if (_menuForm.valid()) {
				var formData = _menuForm.getData();
				if (formData.menuType == "10") {
					formData.parentId = "-1";
					formData.parentName = "";
				}
				var url = ctp + "/common/saveMenu";
				var processBar = $.ligerDialog.waitting("数据正在保存中,请稍等...");
				Common.post(url, $.extend({resourceId: formData.menuId,resourceName: formData.name, resourceType: "10", resourceUrl: formData.url}, formData), function(backdata) {
					processBar.close();
					if (backdata.code == '1000') {
						$.ligerDialog.success(backdata.message, "提示", function(){
							parent.menuManager.loadData();
							parent.parent.main.reloadMenu();
							parent.$.ligerDialog.close();
						});
					} else if (backdata.code == '1001') {
						$.ligerDialog.error(backdata.message);
					}
				});
			}
		});
	};
	
	return {
		initPage: function() {
			_initMenuForm();
			_eventRegister();
		}
	};
}();