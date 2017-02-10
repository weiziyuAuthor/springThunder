package com.yu.experience.td;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author weizy
 *
 * 2017年2月10日    下午2:24:43
 * 
 * 建议内部throw,不打印日志，防止日志泛滥
 */
public class ExceptionTestMain {

	private static Logger logger = LoggerFactory
			.getLogger(ExceptionTestMain.class);
	
  public static void main(String[] args) {
    try {
      ExceptionTestBizz.test();
    } catch (ExceptionTest e) {
//      e.printStackTrace();
    	System.out.println("------");
    	logger.error("caller find error", e);
    	
    }
  }

}
