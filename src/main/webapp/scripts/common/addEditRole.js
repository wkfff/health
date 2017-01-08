var addEditRole = function(){
	var _roleForm;
	
	var _initRoleForm = function() {
		var parentData = parent.roleManager.getRoleData();
		_roleForm = $("#dataForm").ligerForm({
			labelWidth: 60, space: 25, validate : true,
			fields: [
			  {name: "roleId", type: "hidden" },
			  {display: "角色名称", name: "roleName", newline: true, type: "text", width: 200, validate: {required: true, maxlength:32}},
			  {display: "角色编码", name: "roleCode", newline: true, type: "text", width: 200, validate: {maxlength:12}},
			  {display: "角色描述", name: "roleDesc", newline: true, type: "textarea", width: 200, validate: {maxlength:300}}
			]
		});
		_roleForm.setData(parentData);
	};
	
	var _eventRegister = function() {
		$("#submitBtn").click(function(){
			if (_roleForm.valid()) {
				var formData = _roleForm.getData();
				var url = ctp + "/common/saveRole";
				var processBar = $.ligerDialog.waitting("数据正在保存中,请稍等...");
				Common.post(url, formData, function(backdata) {
					processBar.close();
					if (backdata.code == '1000') {
						$.ligerDialog.success(backdata.message, "提示", function(){
							parent.roleManager.loadData();
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
			_initRoleForm();
			_eventRegister();
		}
	};
}();