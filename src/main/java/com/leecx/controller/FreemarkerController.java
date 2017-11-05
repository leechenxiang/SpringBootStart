package com.leecx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreemarkerController {

	@RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("name", "itzixi");
        return "index";
    }
	
	@RequestMapping("center")
    public String center() {
        return "center/center";
    }

}