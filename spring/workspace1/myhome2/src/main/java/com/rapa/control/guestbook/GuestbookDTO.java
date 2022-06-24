package com.rapa.control.guestbook;

//데이터베이스가 없으므로 model에서 더미 데이터 생성
//controller를 통해 데이터를 view로 전송
//
//모든 요청은 controller가 받음
//controller가 고객의 요청을 분석해서 model로부터 데이터 가져옴
//request 객체에 저장하고 jsp로 전달
//jsp는 request 객체로부터 값을 읽어서 출력
//
//servlet을 controller로 사용
//요청 : list.jsp, write.jsp, view.jsp
//
//model
//	DTO(Data Transfer Object) - 데이터베이스의 테이블과 1:1 매핑, 필드명이 멤버변수, 조인된 여러 테이블에서는 1:1 매핑이 아님
// DAO(Data Access Object) - 데이터베이스에서 데이터를 읽어오거나 쓰는 일을 하는 클래스

public class GuestbookDTO {
	private int id = 1;
	private int hit = 1;
	private String title="";
	private String contents="";
	private String writer="";
	private String wdate="";
	
	
	// 추가적인 생성자를 만들 생각이 없으면 만들지 않아도 상관 없음
	// 시스템은 생성자를 만들이 않으면 디폴트 생성
	public GuestbookDTO() {
		super();		// 부모 클래스의 생성자 호출
		// TODO Auto-generated constructor stub
	}

	public GuestbookDTO(int id, String title, String contents, String writer, String wdate) {
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.wdate = wdate;
	}

	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id =id; 
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	
	
}
