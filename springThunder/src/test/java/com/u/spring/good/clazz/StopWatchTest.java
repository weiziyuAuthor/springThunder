//package com.u.spring.good.clazz;
//
//
//public class StopWatchTest {
//	
//	public void testPerformance1() {
//		GenericConversionService conversionService = new DefaultConversionService();
//		StopWatch watch = new StopWatch("integer->string conversionPerformance");
//		watch.start("convert 4,000,000 with conversion service");
//		for (int i = 0; i < 4000000; i++) {
//			conversionService.convert(3, String.class);
//		}
//		watch.stop();
//		watch.start("convert 4,000,000 manually");
//		for (int i = 0; i < 4000000; i++) {
//			new Integer(3).toString();
//		}
//		watch.stop();
//		System.out.println(watch.prettyPrint());
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
