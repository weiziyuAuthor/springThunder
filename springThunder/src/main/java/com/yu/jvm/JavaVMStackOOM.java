package com.yu.jvm;

/**
 * 由于在Windows平台的虚拟机中， Java的线程是映射到OS的内核线程上的，因此下述代码的执行有
 * 较大的风险，可能会导致OS假死
 * @author ziyu.wei
 * 
 * 2015年8月1日 下午1:36:38
 */
public class JavaVMStackOOM {
	
	private void dontStop() {
		while(true) {
			
		}
	}
	
	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}
	
	public static void main() throws Throwable {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
