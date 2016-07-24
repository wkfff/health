var Common = function() {
	return {
		getFormData: function(containerObj) {
			var childrens = containerObj.children();
			var objStr = "";
			$.each(childrens, function(){
				if ($(this).is(":text") || $(this).is(":password") || $(this).is("textarea")
						|| ($(this).is(":hidden") && $(this).is("input"))) {
					objStr += "\"" + $(this).attr("id") + "\":\"" + $(this).val() + "\",";
				} else if ($(this).is("select")) {
					objStr += "\"" + $(this).attr("id") + "\":\"" + $(this).find("option:selected").val() + "\",";
					objStr += "\"" + $(this).attr("id") + "Text\":\"" + $(this).find("option:selected").text() + "\",";
				}
			});
			var radios = containerObj.find("input:radio:checked");
			$.each(radios, function(){
				objStr += "\"" + $(this).attr("id") + "\":\"" + $(this).val() + "\",";
			});
			var checkboxs = containerObj.find("input:checkbox");
			var ckArray = new Array();
			$.each(checkboxs, function(){
				var ckId = $(this).attr("id");
				if ($.inArray(ckId, ckArray) == -1) {
					ckArray.push(ckId);
					var checkVal = "";
					$("input[name='"+ckId+"']:checked").each(function(){
						checkVal += $(this).val() + ",";
					});
					if (checkVal != "")
						objStr += "\"" + ckId + "\":\"" + checkVal.substring(0, checkVal.length - 1) + "\",";
					else
						objStr += "\"" + ckId + "\":\"\",";
				}
			});
			if (objStr != "") {
				objStr = "{" + objStr.substring(0, objStr.length - 1) + "}";
				return jQuery.parseJSON(objStr);
			} else
				return null;
		},
		fieldValidate: function(containerObj) {
			
		},
		getSysEnume: function(fn) {
			var data;
			$.ajax({
				type: "GET",
				dataType: "json",
				contentType: "application/json; charset=utf-8",
				url: ctp + "/common/getSysEnume",
				async: false,
				data: "",
				success: function(backdata) {
					data = backdata.data;
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					
				}
			});
			return data;
		},
		post: function(url, params, fn) {
			$.ajax({
				type: "POST",
				dataType: "json",
				contentType: "application/json; charset=utf-8",
				url: url,
				data: JSON.stringify(params),
				success: function(backdata) {
					if (typeof fn == "function")
						fn(backdata);
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					
				}
			});
		}
	};
}();