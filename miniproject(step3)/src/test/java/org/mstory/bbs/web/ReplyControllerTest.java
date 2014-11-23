package org.mstory.bbs.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;

public class ReplyControllerTest extends ControllerTest {
	
	@Test
	public void test3() throws Exception {
		logger.info(this.mockMvc.toString());
		
		//perform�޼ҵ���� �������ְ� import static�� ���!
		//builder pattern���� ���!
		MvcResult result =
				mockMvc.perform(get("/reply/list")).andExpect(status().isOk()).andReturn(); 
		
		logger.info(result.getModelAndView().getViewName());
	}
	
	@Test
	public void test2() throws Exception {
		logger.info(this.mockMvc.toString());
		
		//perform�޼ҵ���� �������ְ� import static�� ���!
		//builder pattern���� ���!
		MvcResult result =
				mockMvc.perform(post("/reply/update")).andExpect(status().isOk()).andReturn(); 
		
		logger.info(result.getModelAndView().getViewName());
	}
	
	@Test
	public void test1() throws Exception {
		logger.info(this.mockMvc.toString());
		
		//perform�޼ҵ���� �������ְ� import static�� ���!
		//builder pattern���� ���!
		MvcResult result =
				mockMvc.perform(get("/reply/delete")).andExpect(status().isOk()).andReturn(); 
		
		logger.info(result.getModelAndView().getViewName());
	}
}
