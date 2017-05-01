(function( $ ){
  
  $.fn.animateProgress = function(progress, callback) {    
    return this.each(function() {
      $(this).animate({
        width: progress+'%'
      });
    });
  };
})( jQuery );

$(function() {
  $('#progress_bar .ui-progress').animateProgress(73);
  
});