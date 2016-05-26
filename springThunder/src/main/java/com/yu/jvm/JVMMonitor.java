package com.yu.jvm;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;

/**
 * JVM���
 * 		����ͨ����api���ʵ������е�jvm������ص���Ϣ��jit����������Ϣ���ڴ�����������̵߳������Ϣ�Լ�����jvm�Ĳ���ϵͳ����Ϣ��
 * java.lang.management�����ṩ��9���ӿ���������Щ��Ϣ��ʹ��ManagementFactory�ľ�̬get�������Ի����Ӧ�ӿڵ�ʵ����
 * ����ͨ����Щʵ������ȡ����Ҫ�������Ϣ��
 * @author ziyu.wei
 *
 * 2015��8��12�� ����4:51:03
 */
public class JVMMonitor {

	public static void main(String[] args) {
		ClassLoadingMXBean bean = ManagementFactory.getClassLoadingMXBean();
		System.out.println(bean.getLoadedClassCount());
	}

}
