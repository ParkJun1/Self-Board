package org.mstory.bbs.service;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mstory.bbs.service.BbsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/**/*-context.xml"})
public class ServiceTest {

	private static Logger logger = LoggerFactory.getLogger(ServiceTest.class);
	
	@Resource(name="BbsService")
	//@Inject
	BbsService service;
	
	@Test
	public void test() {
		service.getTest();
	}
}
