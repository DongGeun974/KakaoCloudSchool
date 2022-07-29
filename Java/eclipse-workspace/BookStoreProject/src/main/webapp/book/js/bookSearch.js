/**
 * 
 */
 /**
 * 
 */
 
 function search(){
	let keyword = $("#searchKeyword").val();
	let requestURL = "http://localhost:8080/book/bsearch" + "?keyword=" + keyword;
	window.location.href = requestURL;
}

function deleteBook(isbn){
	let requestURL = "http://localhost:8080/book/bdelete" + "?isbn=" + isbn+"&path="+window.location.href;
	window.location.href = requestURL;
}