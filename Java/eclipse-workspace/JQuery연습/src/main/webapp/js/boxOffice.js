/*
 
 function getData(){
	// 서버 프로그램을 호출해서 결과 받아옴
	// 비동기
	// AJAX 이용
	let today =  $("#searchDate").val()
	today = today.replace(/-/g, '')
	
	$.ajax({
		async:true,
		url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
		type:'GET',
		data:{
			key : 'fba851033a2514be7b6784b968bae1d1',
			targetDt : today 
		},
		timeout:3000,
		dataType : 'json',
		success : function(result){
			// result는 서버가 전달해 준 json에 대한 javascript 객체
			console.log(result)
			let movieName = result['boxOfficeResult']['dailyBoxOfficeList'][0]['movieNm']
			//alert(movieName)
			*/
			
			/*<tr>
              <td>1,001</td>
              <td>random</td>
              <td>data</td>
              <td>placeholder</td>
              <td>text</td>
            </tr>*/
            
            /*
			let tr = $("<tr></tr>")
			let orderTd = $("<td></td>").text(result['boxOfficeResult']['dailyBoxOfficeList'][0]['rank']);
			tr.append(orderTd)
			let postTd = $("<td></td>");
			tr.append(postTd)
			let titleTd = $("<td></td>").text(result['boxOfficeResult']['dailyBoxOfficeList'][0]['movieNm']);
			tr.append(titleTd)
			let actorTd = $("<td></td>");
			tr.append(actorTd)
			let deleteTd = $("<td></td>");
			tr.append(deleteTd)
			
			$("tbody").empty();
			$("tbody").append(tr);
			
		},
		error : function(){
			alert("실패")
		}
	})
	
}



*/
 
function getData(){
	let today = $('#searchDate').val()
	today = today.replace(/-/g, '')
	
	$.ajax({
		async:true,
		url:'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
		type:'get',
		data:{
			key:'6d6c704bf1644a65a891bd41b69afe8f',
			targetDt: today
		},
		timeout:3000,
		dataType:'json',
		success:function(result){
			$('tbody').empty()
			
			let movieList = result['boxOfficeResult']['dailyBoxOfficeList']
			
			for (let i = 0; i<movieList.length; i++){
				let tr = $("<tr></tr>")
				
				let orderTd = $("<td></td>").text(movieList[i]['rank']);  
				tr.append(orderTd)
				
				let posterTd = $("<td></td>");
				let posterImg = $("<img />");
				$.ajax({
					url:"https://dapi.kakao.com/v2/search/image",
					type:'get',
					data:{
						query:movieList[i]["movieNm"]
					},
					headers:{
						Authorization: 'KakaoAK c5f509547ebddb71b44b308f3ddf39ed'
					},
					dataType : 'json',
					success:function (imgResult){
						posterImg.attr('src', imgResult.documents[0].thumbnail_url);
					},
					error:function(){
						alert("이미지 검색 실패");
					}
				})
				posterTd.append(posterImg)
				tr.append(posterTd)
				
				let titleTd = $("<td></td>").text(movieList[i]['movieNm']);
				tr.append(titleTd)
				
				let actorTd = $("<td></td>")
				tr.append(actorTd)
				
				let deleteTd = $('<td></td>')
				tr.append(deleteTd)
				
				$('tbody').append(tr);
			}
		},
		error : function(){
			alert('서버가 이상해요')
		}
	})
}

