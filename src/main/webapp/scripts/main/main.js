$(function(){
	$("#side_switch").click(function(){
		$(".left").hide();
		$("#main").contents().find(".right_body").css('margin-left',0);
		$(this).hide();
		$("#side_switchl").show();
	});
	$("#side_switchl").click(function(){
		$(".left").show();
		$("#main").contents().find(".right_body").css('margin-left',200);
		$(this).hide();
		$("#side_switch").show();
	});
	main.init();
});

var main = function(){
	
	var tabObj;
	
	var treeHandle = function(trees){
		var treeStr = "";
		$.each(trees, function(index, value) {
			treeStr += "<li><a href='javascript:void(0);'>" + this.name + "</a>";
			if (this.childrens.length > 0) {
				treeStr += "<ul class='submenu'>";
				treeStr += treeHandle(this.childrens);
				treeStr += "</ul>";
			}
			treeStr += "</li>";
		});
		return treeStr;
	};
	
	var initMenus = function() {
		var url = ctp + "/common/getUserMenus";
		Common.post(url, {}, function(backdata) {
			if (typeof backdata.data != "undefined" && backdata.data.length > 0) {
				$("#menu-list").html(treeHandle(backdata.data));
				jQuery("#jquery-accordion-menu").jqueryAccordionMenu();
			}
		});
	};
	
	var initTabs = function() {
		var tabHeight = $(window).height()-98-44;
		tabObj = $("#main").ligerTab();
		tabObj.setHeight(tabHeight);
	};
	
	var menuClick = function(obj) {
		var options = {tabid:obj.tabId, text:obj.tabName, url:obj.tabUrl};
		tabObj.addTabItem(options);
	};
	
	return {
		init : function() {
			initMenus();
			initTabs();
		},
		menuNav : function() {
			menuClick();
		}
	}
}();