package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RootController {
	
	@RequestMapping("/index")
	public String index(){
		
		return "index";
		//�信 ���� ������ ��ȯ�������
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(MultipartFile file){
		
		//if(file!=null)
		return "1";
		/*else if(file==null)
			return "0";*/
	}
	
}
