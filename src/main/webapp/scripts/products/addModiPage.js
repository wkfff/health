var addModiPage = function(){
	//产品信息文章上传的图片初始标识为'productDescImg'
	var comboBoxData;
	
	var formObj;
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
	
	var eventRegister = function() {
		$("#submitBtn").click(function(){
			addModiPage.submitData();
		});
	}
	
	return {
		onload: function() {
			eventRegister();
			comboBoxData = Common.getSysEnume();
			initForm();
			initTextArea();
		},
		submitData: function() {
			var url = ctp + "/product/saveProductDesc";
			var formData = formObj.getData();
			var editorVal = kindEditor.html();
			Common.post(url, $.extend({descDetail: editorVal}, formData), function(backdata) {
				
			});
		}
	}
}();