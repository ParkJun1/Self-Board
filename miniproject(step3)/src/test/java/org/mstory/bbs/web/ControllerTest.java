package org.mstory.bbs.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/**/*-context.xml"})
public class ControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	protected MockMvc mockMvc;
	protected static Logger logger = LoggerFactory.getLogger("ControllerTest");
	
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    //이하는 이 클래스를 상속받아 Controller마다 테스트하는 코드를 작성한다.
    
/*	@Test
	public void test() throws Exception {
		logger.info(this.mockMvc.toString());
		
		//perform메소드까지 선언해주고 import static을 사용!
		//builder pattern으로 사용!
		MvcResult result =
				mockMvc.perform(get("/bbs/doA")).andExpect(status().isOk()).andReturn(); 
		
		logger.info(result.getModelAndView().getViewName());
	}
	
	@Test
	public void test2() throws Exception {
		logger.info(this.mockMvc.toString());
		
		//perform메소드까지 선언해주고 import static을 사용!
		//builder pattern으로 사용!
		MvcResult result =
				mockMvc.perform(post("/reply/update")).andExpect(status().isOk()).andReturn(); 
		
		logger.info(result.getModelAndView().getViewName());
	}*/
}
