var addModiPage = function(){
	
	var comboBoxData;
	
	var initTextArea = function() {
		var textArea = "<textarea name='descDetail' style='width:880px;height:370px;visibility:hidden;'></textarea>";
		$("#dataForm").append(textArea);
		var editor;
		KindEditor.ready(function(K) {
			editor = K.create('textarea[name="descDetail"]', {
				resizeType : 0,
				allowPreviewEmoticons : false,
				allowImageUpload : false,
				items : [
					'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
					'insertunorderedlist', '|', 'emoticons', 'image', 'link']
			});
		});
	}
	
	var initForm = function() {
		$("#dataForm").ligerForm({
			inputWidth: 170, labelWidth: 90, space: 40,
			fields: [
			  {display: "信息标题", name: "descTitle", newline: false, type: "text", width: 470},
			  {display: "信息来源", name: "descSource", newline: true, type: "select", comboboxName: "descSource", editor: {data: comboBoxData.desc_source}},
			  {display: "信息类目", name: "descCategory", newline: false, type: "select", comboboxName: "descCategory", editor: {data: comboBoxData.desc_category}}
			]
		});
	}
	
	return {
		onload: function(){
			comboBoxData = Common.getSysEnume();
			initForm();
			initTextArea();
		}
	}
}();