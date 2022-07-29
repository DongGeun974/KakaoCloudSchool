/**
 * 
 */
 
 function goToNewPost(){
	window.location.href = "http://localhost:8080/board/post/newPost.html"
}

function goToPost(postNum, viewer){
	window.location.href = "http://localhost:8080/board/post?"+"postNum="+postNum+"&viewer="+viewer;
}

function goToLike(user, author, postNum, like, viewer){
	if (user == author)
	{
		alert("작성자는 자신의 글에 좋아요 못해요")
	}else
	{
		window.location.href = "http://localhost:8080/board/like?"+"postNum="+postNum+"&like="+like+"&viewer="+viewer;
	}
}

function goToEditPost(user, author, postNum){
	if (user == author)
	{
		window.location.href = "http://localhost:8080/board/edit?"+"postNum="+postNum;
	}else
	{
		alert("게시물 작성자가 아니에요")
	}
}

function goToDeletePost(e, postNum, author, user){
	e.stopPropagation();
	if (user == author)
	{
		window.location.href = "http://localhost:8080/board/deletePost?"+"postNum="+postNum;
	}else
	{
		alert("게시물 작성자가 아니에요")
	}
}

function goToDeleteComment(commentNum, postNum, author, user){
	if (user == author)
	{
		window.location.href = "http://localhost:8080/board/deleteComment?"+"commentNum="+commentNum+"&postNum=" + postNum;
	}else
	{
		alert("댓글 작성자가 아니에요")
	}
}