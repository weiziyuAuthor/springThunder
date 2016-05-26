package com.yu.jvm;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;

/**
 * JVM监测
 * 		可以通过此api访问到运行中的jvm的类加载的信息、jit编译器的信息、内存分配的情况、线程的相关信息以及运行jvm的操作系统的信息。
 * java.lang.management包中提供了9个接口来访问这些信息，使用ManagementFactory的静态get方法可以获得相应接口的实例，
 * 可以通过这些实例来获取你需要的相关信息。
 * @author ziyu.wei
 *
 * 2015年8月12日 下午4:51:03
 */
public class JVMMonitor {

	public static void main(String[] args) {
		ClassLoadingMXBean bean = ManagementFactory.getClassLoadingMXBean();
		System.out.println(bean.getLoadedClassCount());
	}

}
