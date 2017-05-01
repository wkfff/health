var shortBuy = function() {
    var _width = $(window).width();
    var _height = $(window).height();

    var _setTitleWidth = function() {
        $("#title").css("width", _width - 30 - 30);
    };

    var _setFooterBtnWidth = function() {
        $("#oneBtn").css("width", _width/3);
        $("#mallBtn").css("width", _width/3);
        $("#mineBtn").css("width", _width/3);
    };

    var _setContentHeight = function() {
        $("#content").css("height", _height - 30 - 30);
    }

    var _setGoodsInfoWidth = function() {
        $(".goods-info").css("width", _width - 120 - 100);
        $(".info-line").css("width", _width - 120 - 100);
        $("#processContent").css("width", (_width - 120 - 100)*0.12);
    };

    return {
        initPage : function() {
            _setTitleWidth();
            _setFooterBtnWidth();
            _setContentHeight();
            _setGoodsInfoWidth();
        }
    };
}();