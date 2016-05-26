package com.yu.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆溢出
 * 
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 
 * 代码限制Java堆的大小为20M，不可扩展(将堆的最小值参数与最大值参数设置为一样即可避免自动拓展)
 * 通过参数 -XX:HeapDumpOnOutOfMemoryError可以让虚拟机在出现内存溢出异常时Dump出当前的内存堆
 * 转储快照以便事后进行分析
 * 
 * @author ziyu.wei
 * 
 * 2015年8月1日 上午10:44:44
 */
public class HeapOOM {

	static class OOMObject {
		
	}
	
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		
		while (true) {
			list.add(new OOMObject());
		}
	}

}
