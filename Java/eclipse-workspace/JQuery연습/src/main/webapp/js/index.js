/**
 * 
 */
 
 function myFunc(){
	// 1. 내가 원하는 Element를 찾아서 jQuery 객체로 변환
	// HTML Element를 referencing하는 jQuery객체 생성
	// selector
	
	// 전체 선택자, universial selector
	// $("*").css("color", "red");
	
	// 태그 선택자, tag selector
	// alert($("div").text());
	// $("div").text("깔깔깔");
	
	// 아이디 선택자, ID selector
	// "#"
	// $("#myLi").remove();
	
	// 클래스 선택자, class selector
	// "."
	// $(".haha").css("background-color", "yellow");
	
	// block-level, inline element
	
	// 구조 선택자
	// ">"(자식 선택자), " "(후손 선택자)
	// $("div li").css("color", "blue")
	// $("ul.myclass > li").css("color", "blue");
	// "+", 바로 다음에 나오는 형제 히나
	// "~", 다음에 나오는 형제 전부
	// $("#seoul + li").remove()
	
	// 특수 선택자
	// $("ul.myclass > li:first + li").remove()
	// $("ul.myclass > li:nth-child(1)").remove()
	
	// 속성 선택자
	// "[]"
	alert($("[size]").val());
}