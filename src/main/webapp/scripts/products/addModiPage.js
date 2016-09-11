var addModiPage = function(){
	//产品信息文章上传的图片初始标识为'productDescImg'
	var comboBoxData;
	
	var formObj;
	var pageData;
	var kindEditor;
	
	var initTextArea = function() {
		var textArea = "<textarea name='descDetail' style='width:880px;height:370px;visibility:hidden;'></textarea>";
		$("#dataForm").append(textArea);
		KindEditor.ready(function(K) {
			kindEditor = K.create('textarea[name="descDetail"]', {
				resizeType : 0,
				uploadJson : ctp + '/common/imgUpload',
				uploadPath : 'Q3XLUky4lBkEfKUIuCkMqol+9YRjTN8TMYc9PBgtGso=',
				busiId: 'productDescImg_' + userAccount,
				allowFileManager : true,
				items : [
					'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
					'insertunorderedlist', '|', 'emoticons', 'image', 'link']
			});
			//初始化值
			if (typeof pageData.formData.descDetail != 'undefined')
				kindEditor.html(pageData.formData.descDetail);
		});
	}
	
	var initForm = function() {
		formObj = $("#dataForm").ligerForm({
			inputWidth: 170, labelWidth: 90, space: 40,
			fields: [
			  {display: "信息标题", name: "descTitle", newline: false, type: "text", width: 470},
			  {display: "信息来源", name: "descSource", newline: true, type: "select", comboboxName: "descSource", editor: {data: comboBoxData.desc_source}, options: {valueField: "value"}},
			  {display: "信息类目", name: "descCategory", newline: false, type: "select", comboboxName: "descCategory", editor: {data: comboBoxData.desc_category}, options: {valueField: "value"}}
			]
		});
	}
	
	var initFormData = function() {
		formObj.setData(pageData.formData);
	}
	
	var eventRegister = function() {
		$("#submitBtn").click(function(){
			addModiPage.submitData();
		});
	}
	
	return {
		onload: function(initPageObj) {
			pageData = $.extend({}, initPageObj);
			eventRegister();
			comboBoxData = Common.getSysEnume();
			initForm();
			initTextArea();
			initFormData();
		},
		submitData: function() {
			var url = ctp + "/product/saveProductDesc";
			var formData = formObj.getData();
			var editorVal = kindEditor.html();
			var descId = "";
			if (typeof pageData.formData.descId != 'undefined')
				descId = pageData.formData.descId;
			var processBar = $.ligerDialog.waitting("数据正在保存中,请稍等...");
			Common.post(url, $.extend({descId: descId, descDetail: editorVal}, formData), function(backdata) {
				processBar.close();
				if (backdata.code == '1000') {
					$.ligerDialog.success(backdata.message);
					window.close();
				} else if (backdata.code == '1001') {
					$.ligerDialog.error(backdata.message);
				}
			});
		}
	}
}();