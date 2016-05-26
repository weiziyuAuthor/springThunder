//package com.yu.basic.daily;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.Enumeration;
//import java.util.Properties;
//
//import org.springframework.core.convert.support.DefaultConversionService;
//import org.springframework.core.convert.support.GenericConversionService;
//import org.springframework.core.io.support.PropertiesLoaderUtils;
//import org.springframework.util.ClassUtils;
//import org.springframework.util.StopWatch;
//
//import com.sinoiov.pltp.api.find.vehicle.Main1;
//
//public class StopWatch_PropertyLoaderUtils {
//
//	public static void testPerformance1() {
//		GenericConversionService conversionService = new DefaultConversionService();
//		StopWatch watch = new StopWatch("integer->string conversionPerformance");
//		watch.start("convert 4,000,000 with conversion service");
//		for (int i = 0; i < 4000000; i++) {
//			conversionService.convert(3, String.class);
//		}
//		watch.stop();
//		watch.start("convert 4,000,000 manually");
//		for (int i = 0; i < 40000; i++) {
//			new Integer(3).toString();
//		}
//		watch.stop();
//		
//		watch.start("my test");
//		for (int i = 0; i < 100000000; i++) {
//			new Integer(3).toString();
//		}
//		watch.stop();
//		
//		System.out.println(watch.prettyPrint());
//	}
//
//	public static void main(String[] args) {
////		testPerformance1();
//		
//		try {
//			
//			Enumeration urls = ClassUtils.getDefaultClassLoader().getResources("");
//			
////			URL urls = Main.class.getClassLoader().getResource("log4j.xml");
//			
//			Properties prop = PropertiesLoaderUtils.loadAllProperties("log4j.xml");
////			System.out.println(prop.get("accessAppender"));
////			Properties prop = PropertiesLoaderUtils.loadAllProperties("log4j.properties");
////			System.out.println(prop.getProperty("key"));
//			
//			
//			Properties props = new Properties();
//			props.load(StopWatch_PropertyLoaderUtils.class.getResourceAsStream("log4j.properties"));
//			System.out.println(props.getProperty("key"));
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}
