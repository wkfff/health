var addEditUser = function(){
	var _userForm;
	
	var _statusSel = [{value:"10", text:"正常"}, {value:"11", text:"冻结"}, {value:"12", text:"注销"}];
	var _initUserForm = function() {
		var parentData = parent.userManager.getUserData();
		_userForm = $("#dataForm").ligerForm({
			labelWidth: 60, space: 25, validate : true,
			fields: [
			  {name: "userId", type: "hidden" },
			  {display: "用户账号", name: "userAccount", newline: true, type: "text", width: 160, validate: {required: true, maxlength:32}},
			  {display: "用户名称", name: "userName", newline: true, type: "text", width: 160, validate: {required: true, maxlength:12}},
			  {display: "用户状态", name: "userStatus", newline: true, type: "select", width: 160, comboboxName: "userStatus", options: {data: _statusSel, valueField: "value"}, validate: {required: true}},
			  {display: "手机号码", name: "userMobile", newline: true, type: "text", width: 160, validate: {maxlength:11}},
			  {display: "用户邮箱", name: "userEmail", newline: true, type: "text", width: 160, validate: {email:true}}
			]
		});
		_userForm.setData(parentData);
	};
	
	var _eventRegister = function() {
		$("#submitBtn").click(function(){
			if (_userForm.valid()) {
				var formData = _userForm.getData();
				var url = ctp + "/common/saveUser";
				var processBar = $.ligerDialog.waitting("数据正在保存中,请稍等...");
				Common.post(url, formData, function(backdata) {
					processBar.close();
					if (backdata.code == '1000') {
						$.ligerDialog.success(backdata.message, "提示", function(){
							parent.userManager.loadData();
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
			_initUserForm();
			_eventRegister();
		}
	};
}();