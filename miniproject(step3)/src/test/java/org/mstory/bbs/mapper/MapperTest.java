package org.mstory.bbs.mapper;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mstory.bbs.mapper.BbsMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/**/*-context.xml"})
public class MapperTest {

	static Logger logger = Logger.getLogger(MapperTest.class);
	
	@Inject
	BbsMapper mapper;

	@Test
	public void testMapper() {
		logger.info(mapper);
		logger.info(mapper.getBookTest());
	}
}
