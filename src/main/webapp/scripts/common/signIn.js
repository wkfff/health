var SignIn = function(){
	return {
		submit:function(){
			var formObj = $("#loginForm");
			var datas = Common.getFormData(formObj);
			var url = ctp + "/signin/doSignIn";
			Common.post(url, datas, function(data) {
				if (1000 == data.code)
					alert("操作成功！");
				else
					alert(data.message);
			});
		}
	};
}();