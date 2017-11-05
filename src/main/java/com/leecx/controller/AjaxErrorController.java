package com.leecx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leecx.pojo.LeeJSONResult;

@Controller
@RequestMapping("err")
public class AjaxErrorController {

	@RequestMapping("/ajaxerror")
	public String ajaxerror() {
		
		return "thymeleaf/ajaxerror";
	}
	
	@RequestMapping("/getAjaxerror")
	@ResponseBody
	public LeeJSONResult getAjaxerror() {
		
		try {
			int a = 1 / 0;
		} catch (Exception e) {
			e.printStackTrace();
			return LeeJSONResult.errorException(e.getMessage());
		}
		
		return LeeJSONResult.ok();
	}

}