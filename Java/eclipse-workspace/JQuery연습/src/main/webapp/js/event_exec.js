/**
 * 
 */
 
 $(function(){
	$("li").on('mouseenter', function(){
		$(this).addClass('myStyle')
	})
	
	$("li").on('mouseleave', function(){
		$(this).removeClass('myStyle')
	})
})
 