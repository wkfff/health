jQuery(document).ready(function() {
    $('#loginBtn').click(function(){
        SignIn.submit();
    });
    $('.page-container form .username, .page-container form .password').keyup(function(){
        $(this).parent().find('.error').fadeOut('fast');
    });
    
});
var SignIn = function(){
	var _doLogin = function() {
		var formObj = $("#loginForm");
		var datas = Common.getFormData(formObj);
		var url = ctp + "/signin/doSignIn";
		Common.post(url, datas, function(data) {
			console.info(data.message);
			if ('1000' == data.code) {
				window.location.href = ctp + '/common/main';
			} else {
				$("#errorText").text(data.message);
	            $('.error').fadeOut('fast', function(){
	                $(this).css('top', '27px');
	            });
	            $('.error').fadeIn('fast', function(){
	                $('#userAccount').focus();
	            });
			}
		});
	};
	
	var _keydownEvent = function() {
		var e = window.event || arguments.callee.caller.arguments[0];
		if (e && e.keyCode == 13) {
			_doLogin();
		}
	};
	
	return {
		submit:function(){
			_doLogin();
		}
	};
}();