package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class viralGenerator {
	@RequestMapping("/generator")
	public String generator(@RequestParam(value= "a",required=false) Integer a, @RequestParam(value="b",required=false) Integer b, Model model){
		if(a==null || b==null) {
			a=0;
			b=0;
		}
		
		String kata = "";
		String kata2 = "h";
		
		if(a<2) {
			kata2 = "hm";
		}
		else if(a>=2) {
			for(int i=0;i<a;i++) {
				kata2 += "m";
			}
		}
		
		if(b<2) {
			kata = kata2; 
		}
		else if(b>=2) {
			for (int i=0;i<b;i++) {
				kata += kata2 + " ";
			}
		}
		
		model.addAttribute("angkaA",a);
		model.addAttribute("angkaB",b);
		model.addAttribute("kata",kata);
		
		return "viralGenerator";
	}
}
