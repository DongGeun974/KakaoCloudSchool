package org.mvc.member;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@RequestMapping("/member/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping("/member/loginPro")
	public String loginPro(MemberDTO dto, Model model, String id, String pw, HttpServletRequest requset) {
		
		model.addAttribute("count", 100);
		model.addAttribute("msg", "hello world");
		model.addAttribute("time", new Date());
		
		model.addAttribute("dto", dto);
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		model.addAttribute("list", list);
		
		return "member/loginPro";
	}
}
