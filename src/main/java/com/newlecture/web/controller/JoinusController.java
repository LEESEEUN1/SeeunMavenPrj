package com.newlecture.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.data.dao.MemberDao;
import com.newlecture.web.data.dao.MemberRoleDao;
import com.newlecture.web.data.dao.NoticeDao;
import com.newlecture.web.data.entity.Member;

@Controller
//���� ��Ʈ�ѷ��� �ϴ� �۾�
@RequestMapping("/joinus/*")
public class JoinusController {
	@Autowired
	private MemberRoleDao memberRoleDao;
	
	/*@Autowired
	private MemberDao memberDao;*/
	
	@RequestMapping("join")
	public String join(){
		return "joinus.join";	
	}
	
	@RequestMapping("login")
	public String login(
			/*@RequestParam("id") String id,
			@RequestParam("pwd") String pwd*/
			){	
		return "joinus.login";
	}
	
	@RequestMapping("mypage")
	//mypage url�� �α����� ����� ������ �� �ִ�
	public String mypage(Principal principal){
		
		String memberId=principal.getName();
		
		String role="ROLE_TEACHER"/*memberRoleDao.getDefaultRoleById(memberId)*/;
		
		if(role.equals("ROLE_ADMIN"))
			return "redirect:../admin/index";
		
		else if(role.equals("ROLE_TEACHER"))
			return "redirect:../teacher/index";
		
		else
			return "redirect:../student/index";
			
	}
	
	

}
