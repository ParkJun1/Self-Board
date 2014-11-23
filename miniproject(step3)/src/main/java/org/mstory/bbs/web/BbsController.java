package org.mstory.bbs.web;

import java.util.List;

import javax.inject.Inject;

import org.mstory.bbs.common.Criteria;
import org.mstory.bbs.service.BbsService;
import org.mstory.bbs.vo.BbsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("BbsController")
@RequestMapping("/bbs/*")
public class BbsController {
	
	private static Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	@Inject
	BbsService bbsService;	
								 
	@RequestMapping("/doA")
	public void doA() {
		logger.info("doA.................");
		System.out.println("doA..............");
	}
	
	@RequestMapping(value="/bbsList", method=RequestMethod.GET)
	public String getBbsList(@RequestParam(value="page", required=false, defaultValue="1") int page,
							Criteria cri, Model model) throws Exception {
		
		System.out.println("getBbsList()...............start");
		
		System.out.println(page);
/*		Criteria cri = new Criteria(page);
		
		cri.setType(type);
		cri.setKeyword(keyword);*/
/*		if(page != 1) {
			cri.setPage(page);
		}*/
		
		System.out.println(cri.getPage());
		
		System.out.println("»ý¼ºµÈ Criteria : " + cri);
		
		List<BbsVO> list = null;
		
		if(cri.getKeyword() != null && cri.getKeyword().length() > 0 && cri.getType() != null) {
			cri.parseType(cri.getType(), cri.getKeyword());			
			list = bbsService.getBbsSearchList(cri);
		} else {
			list = bbsService.getBbsList(cri);
		}
		
		cri.setTotal(list.get(0).getCnt());
				
		model.addAttribute("bbsList", list);
		model.addAttribute("cri", cri);
		
		System.out.println("getBbsList()...............end");
		return "bbs/bbsList";
	}
	
	@RequestMapping(value="/bbsAdd", method=RequestMethod.GET)
	public String bbsAdd() throws Exception {
		System.out.println("bbsAdd().............");
		return "bbs/bbsAdd";
	}
	
	@RequestMapping(value="/bbsAddAction", method=RequestMethod.POST)
	public String bbsAddAction(@ModelAttribute("bbsVO") BbsVO bbsVO) throws Exception {
		System.out.println("bbsAddAction().......");
		
		if(bbsVO.getFileList().length != 0) {
			bbsVO.setIsFile("T");
		}
		System.out.println(bbsVO);
		bbsService.insertBbs(bbsVO);	
		
		return "redirect:/bbs/bbsList";
	}
	
	@RequestMapping(value="/bbsRead", method=RequestMethod.GET)
	public String bbsRead(@RequestParam("bno") Integer bno, Model model) throws Exception {
		System.out.println("bbsRead()............");
		model.addAttribute("bbs", bbsService.getBbs(bno));
		return "bbs/bbsRead";
	}
	
	@RequestMapping(value="/bbsUpdate", method=RequestMethod.GET)
	public String bbsUpdate(@RequestParam("bno") Integer bno, Model model) throws Exception {
		System.out.println("bbsUpdate()..........");
		model.addAttribute("bbs", bbsService.getUpdateBbs(bno));
		return "bbs/bbsUpdate";
	}
	
	@RequestMapping(value="/bbsUpdateAction", method=RequestMethod.POST)
	public String bbsUpdateAction(@ModelAttribute("bbsVO") BbsVO bbsVO) throws Exception {
		System.out.println("bbsUpdateAction()........");
		bbsService.updateBbs(bbsVO);
		return "redirect:/bbs/bbsList";
	}
	
	@RequestMapping(value="/bbsDelete", method=RequestMethod.GET)
	public String bbsDelete(@RequestParam("bno") Integer bno) throws Exception {
		System.out.println("bbsDelete()............");
		bbsService.deleteBbs(bno);
		return "redirect:/bbs/bbsList";
	}
}
