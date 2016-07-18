jQuery(document).ready(function() {
    $('#loginBtn').click(function(){
        var username = $('#userAccount').val();
        var password = $('#userPassword').val();
        if(username == '') {
            $('.error').fadeOut('fast', function(){
                $(this).css('top', '27px');
            });
            $('.error').fadeIn('fast', function(){
                $('#userAccount').focus();
            });
            return false;
        }
        if(password == '') {
            $('.error').fadeOut('fast', function(){
                $(this).css('top', '96px');
            });
            $('.error').fadeIn('fast', function(){
            	$('#userPassword').focus();
            });
            return false;
        }
        
    });
    $('.page-container form .username, .page-container form .password').keyup(function(){
        $(this).parent().find('.error').fadeOut('fast');
    });
    
});
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