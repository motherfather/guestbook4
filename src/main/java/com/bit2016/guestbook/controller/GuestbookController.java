package com.bit2016.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2016.guestbook.dao.GuestBookDao;
import com.bit2016.guestbook.vo.GuestBookVo;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestBookDao guestBookDao;
	
	@RequestMapping("")
	public String list(Model model) {
		List<GuestBookVo> list = guestBookDao.getList();
		model.addAttribute("list", list);
		return "/WEB-INF/views/list.jsp";
	}
	
//	@RequestMapping(value="/deleteform/{no}")
//	public String deletefrom(@PathVariable("no") int no, Model model) {
//		model.addAttribute("no", no);
//		return "/WEB-INF/views/deleteform.jsp";
//	}
	
//	@RequestMapping("/deleteform")
//	public String deletefrom(@RequestParam("no") int no, Model model) {
//		model.addAttribute("no", no);
//		return "/WEB-INF/views/deleteform.jsp";
//	}
	
	@RequestMapping(value="/deleteform", method=RequestMethod.POST)
	public String deletefrom(@RequestParam("no") int no, Model model) {
		model.addAttribute("no", no);
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute GuestBookVo vo) {
		guestBookDao.delete(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute GuestBookVo vo) {
		guestBookDao.insert(vo);
		return "redirect:/";
	}
}
