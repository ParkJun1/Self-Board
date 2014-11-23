package org.mstory.bbs.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AopLogger {
	
	private static Logger logger = LoggerFactory.getLogger("AopLogger");
	
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Object obj;
		long start = System.currentTimeMillis();
		
		logger.info("log()....................");
		System.out.println("log()....................");
		/*logger.info(joinPoint.getKind());
		logger.info(".........................");
		logger.info(joinPoint.getArgs().toString());
		logger.info(".........................");
		logger.info(joinPoint.getSignature().toString());
		logger.info(".........................");
		logger.info(joinPoint.getTarget().toString());
		logger.info("........................."); */
		obj = joinPoint.proceed();
		logger.info(".........................");
		long end = System.currentTimeMillis();
		logger.info("소요시간 : " + (end-start));
		System.out.println("소요시간 : " + (end-start));
		return obj;
	}
	
	public void log2() {
		logger.info("log2.....................");
		logger.info("............................");
		logger.info("............................");
		logger.info("............................");
		logger.info("............................");
		logger.info("............................");
		logger.info("............................");
		logger.info("............................");
	} //ProceedingJoinPoint占쏙옙 占신곤옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙玖占� pointcut占쏙옙 around占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙?????
}
