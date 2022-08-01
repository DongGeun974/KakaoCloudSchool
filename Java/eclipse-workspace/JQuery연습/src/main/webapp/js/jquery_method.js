/**
 * 
 */
 
 function myFunc(){
	// alert("소리없는아우성")
	$("#myDiv").text($("option:selected").text())
}

function printRegion(){
	// console.log($("[type=checkbox]:checked + span").text())
	// 선택된 checkbox를 개별적으로 처리
	// each() 안에는 콜백함수
	$("[type=checkbox]:checked + span").each(function(idx, item){
		console.log($(item).text())	
	})
}

 function myFunc2(){
	// alert("소리없는아우성")
	// $("#myDiv2").css("color", "red")
	// $("#myDiv2").css("background-color", "yellow")
	
	// $("#myDiv2").addClass("myClass")
	
	// text() : tag 사이의 글자 가져옴
	// $("#myDiv2").text()
	// val() : 사용자 입력 양식 안에 들어있는 값 가져옴
	// $("#myDiv2").val()
	
	// attr() : 속성
	// console.log($("input[type=text]").attr("size"))
	// $("input[type=text]").attr("size", "30")
	
	// each() : 반복 처리할 때 사용
	
	// remove() : 찾은 element 삭제
	// empty() : 찾은 element를 삭제하지 않고, 후손만 삭제 
}

function myFunc3(){
	let li = $("<li></li>").text("강감찬")
	
	// append() : 자식으로 맨 마지막에 붙힘
	// $("ul").append(li)
	
	// prepend() : 자식으로 맨 처음에 붙힘
	
	// after() : 형제로 바로 뒤에 붙힘
	// $("li:eq(2)").after(li);
	
	// before() : 형제로 바로 앞에 붙힘
}

// event 등록
// ready() : event가 있는 event는 로딩되어서 사용할 준비가 끝났을때 발생하는 event
// document ready : 내용이 출력되기 위해 DOM이 생성
/*
$(document).on("ready", function(){
	$("li").on("click", function(){
		// alert("소리없는아우성")
		// this가 event handler에서 사용
		// this는 event source에 대한 문서 객체
		alert($(this).text())
	})
})
 */
 
 /*
 $(document).ready(function(){
	$("li").click(function(){
		alert($(this).text())
	})
})
*/

$(function(){
	$("li").click(function(){
		alert($(this).text())
	})
})