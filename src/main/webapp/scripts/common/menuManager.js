var menuManager = function(){
	
	var _initLayout = function() {
		$("#menuLayout").ligerLayout({leftWidth:300});
	};
	
	var _treeHandle = function(trees){
		var treeStr = "";
		$.each(trees, function(index, value) {
			treeStr += "<li><span onclick=''>" + this.name + "</span>";
			if (this.childrens.length > 0) {
				treeStr += "<ul>";
				treeStr += treeHandle(this.childrens);
				treeStr += "</ul>";
			}
			treeStr += "</li>";
		});
		return treeStr;
	};
	
	var _initLeftTree = function() {
		var url = ctp + "/common/getUserMenus";
		Common.post(url, {}, function(backdata) {
			if (typeof backdata.data != "undefined" && backdata.data.length > 0) {
				$("#leftTree").ligerTree({checkbox:false});
			}
		});
	};
	
	return {
		initPage : function() {
			_initLayout();
		}
	};
}();