package org.mstory.bbs.web;

import java.util.List;

import javax.inject.Inject;

import org.mstory.bbs.service.ReplyServiceImple;
import org.mstory.bbs.vo.ReplyVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("ReplyController")
@RequestMapping("/reply/*")
public class ReplyController {

	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Inject
	private ReplyServiceImple service;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String reList(Integer bno, Model model) throws Exception {
		System.out.println("reList()...................");
		model.addAttribute("reList", service.getReplyList(bno));		
		return "reply/reList";
	}
	
	//Jason//////////////////////////////////////////////////////////////////
	@RequestMapping(value="/json", method=RequestMethod.GET)
	public @ResponseBody List<ReplyVO> reJson(Integer bno, Model model) throws Exception {
		
		System.out.println("reJson()................." + bno);
		
		return service.getReplyList(bno);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String reAdd(@ModelAttribute ReplyVO reVO) throws Exception {
		System.out.println("reAdd().................");
		service.insertReply(reVO);
		return "redirect:/bbs/bbsList";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String reUpdate(@ModelAttribute ReplyVO reVO) throws Exception {
		System.out.println("reUpdate()..............");
		System.out.println("수정 할 ReplyVO : " + reVO);
		service.updateReply(reVO);
		return "redirect:/bbs/bbsList";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String reDelete(Integer rno) throws Exception {
		System.out.println("reDelete().............." + rno);
		
		service.deleteReply(rno);
		return "redirect:/bbs/bbsList";
	}
			
}
