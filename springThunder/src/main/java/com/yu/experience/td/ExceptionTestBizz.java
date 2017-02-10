package com.yu.experience.td;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionTestBizz {

	private static Logger logger = LoggerFactory
			.getLogger(ExceptionTestBizz.class);

	public static void test() throws ExceptionTest {
		try {
			String string = "";
			int i = 1 / 0;
		} catch (Exception e) {
//			logger.error("ExceptionTestBizz error occurs", e);
//			throw e;

			 throw new ExceptionTest("inner find error", e);
		}
	}
}
