package com.rapa.control.guestbook;

import java.util.ArrayList;
import java.util.List;


public class GuestbookDAO {
	List<GuestbookDTO> list = new ArrayList<GuestbookDTO>();

	public GuestbookDAO() {
		super();
		for (int i=1; i<=20; i++)
		{
			list.add(new GuestbookDTO(i, "제목"+i, "내용"+i, "작성자"+i, "2022-06-24"));
		}
		
	}
			
	List<GuestbookDTO> getList()
	{
		return list;
	}
	
	GuestbookDTO getView(int id)
	{
		return list.get(id);
	}
	
	void insert(GuestbookDTO dto)
	{
		dto.setId(list.size()+1);
		list.add(dto);
	}
	
}
