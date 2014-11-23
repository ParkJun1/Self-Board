package org.mstory.bbs.tx;

import static org.junit.Assert.fail;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mstory.bbs.service.BbsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class TransactionTest {

	@Inject
	BbsService service;
	
	@Test
	public void testInsert() throws Exception{
		
		String codeValue = "판호형";
		String strValue = "판호형"; 
		
		service.tranTest(codeValue, strValue);
		
	}
	
}
