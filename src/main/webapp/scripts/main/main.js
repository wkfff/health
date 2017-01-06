$(function(){
	$("#side_switch").click(function(){
		$(".left").hide();
		$(this).hide();
		$("#side_switchl").show();
	});
	$("#side_switchl").click(function(){
		$(".left").show();
		$(this).hide();
		$("#side_switch").show();
	});
	
	main.init();
});

var main = function(){
	
	var tabObj;
	var allTabs = [];
	
	var treeHandle = function(trees){
		var treeStr = "";
		$.each(trees, function(index, value) {
			treeStr += "<li><a href='javascript:void(0);'";
			if (this.url != null && this.url != "") {
				var codeStr = Base64.encode(this.id+","+this.name+","+ctp+this.url);
				treeStr += " onclick=\"main.menuNav('"+codeStr+"')\">" + this.name + "</a>";
			} else
				treeStr += ">" + this.name + "</a>";
			if (this.children.length > 0) {
				treeStr += "<ul class='submenu'>";
				treeStr += treeHandle(this.children);
				treeStr += "</ul>";
			}
			treeStr += "</li>";
		});
		return treeStr;
	};
	
	var accordionHandle = function(trees) {
		var treeStr = "";
		$.each(trees, function(index, value) {
			treeStr += "<li>";
			if (this.parentId == "-1" && this.children.length > 0) {
				treeStr += "<div class=\"link\">" + this.name + "<i class=\"fa fa-chevron-down\"></i></div>";
				treeStr += "<ul class='submenu'>";
				treeStr += treeHandle(this.children);
				treeStr += "</ul>";
			} else if (this.parentId == "-1" && this.children.length <= 0) {
				treeStr += "<div class=\"link\">" + this.name + "<i class=\"fa fa-chevron-down\"></i></div>";
			} else if (this.url != null && this.url != "") {
				treeStr += "<a href=\"javascript:void(0);\"";
				var codeStr = Base64.encode(this.id+","+this.name+","+ctp+this.url);
				treeStr += " onclick=\"main.menuNav('"+codeStr+"')\">" + this.name + "</a>";
			} else {
				treeStr += "<a href=\"javascript:void(0);\">" + this.name + "</a>";
			}
			treeStr += "</li>";
		});
		return treeStr;
	};
	
	var Accordion = function(el, multiple) {
		this.el = el || {};
		this.multiple = multiple || false;

		var links = this.el.find('.link');
		links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
	}

	Accordion.prototype.dropdown = function(e) {
		var $el = e.data.el;
			$this = $(this),
			$next = $this.next();

		$next.slideToggle();
		$this.parent().toggleClass('open');

		if (!e.data.multiple) {
			$el.find('.submenu').not($next).slideUp().parent().removeClass('open');
		};
	}
	
	var initMenus = function() {
		var url = ctp + "/common/getUserMenus";
		Common.post(url, {}, function(backdata) {
			if (typeof backdata.data != "undefined" && backdata.data.length > 0) {
				$("#menu-list").html(accordionHandle(backdata.data));
				new Accordion($("#menu-list"), false);
			}
		});
	};
	
	var initTabs = function() {
		var tabHeight = $(window).height()-98-44;
		tabObj = $("#main").ligerTab({
			onAfterRemoveTabItem : function(tabid){
				allTabs.splice($.inArray(tabid, allTabs), 1);
			}
		});
		tabObj.setHeight(tabHeight);
	};
	
	var _addTabItem = function(str) {
		var optAry = Base64.decode(str).split(",");
		var options = {tabid:optAry[0], text:optAry[1], url:optAry[2]};
		if (-1 == $.inArray(optAry[0], allTabs)) {
			allTabs.push(optAry[0]);
			tabObj.addTabItem(options);
		} else {
			tabObj.selectTabItem(optAry[0]);
		}
	};
	
	var _doLogout = function() {
		var url = ctp + "/signin/logout";
		$("#form1").attr("action", url);
		$("#form1").submit();
	};
	
	return {
		init:function() {
			$("#main").width($(window).width() - 205);
			initMenus();
			initTabs();
		},
		menuNav:function(str) {
			_addTabItem(str);
		},
		logout:function() {
			_doLogout();
		},
		reloadMenu: function() {
			initMenus();
		}
	}
}();