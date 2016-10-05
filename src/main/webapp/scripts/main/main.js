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
	
	var initMenus = function() {
		var url = ctp + "/common/getUserMenus";
		Common.post(url, {}, function(data) {
			alert(JSON.stringify(data));
		});
	}
	
	return {
		init : function() {
			initMenus();
		}
	}
}();