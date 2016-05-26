package com.yu.jvm;

/**
 * 虚拟机栈和本地方法栈溢出
 * 
 * Result:
 * 		单线程环境下，无论是由于栈帧太大还是虚拟机栈容量太小，当内存无法分配的时候，虚拟机抛出的都是
 * StackOverflowError
 * 
 * 		如果测试时不限于单线程，通过不断建立线程的方式倒是可以产生内存溢出异常。如代码 JavaVMStackOOM,
 * 但是这样产生的内存溢出异常与栈空间时候足够大并不存在任何联系。在这种情况下，为每个线程的栈分配的内存
 * 越大，反而越容易产生内存溢出异常
 * 
 * 		原因不难理解，OS分配给每个进程的内存是有限的，譬如32位的Windows限制是2G。虚拟机提供了参数来
 * 控制Java堆和方法区的这两部分内存的最大值。剩余的内存为2G(操作系统限制)减去Xmx(最大堆容量)，再减去
 * MaxPermSize(最大方法区容量)，程序计数器消耗内存很小，可以忽略掉。如果虚拟机程序本身耗费的内存不
 * 计算在内，剩下的内容就由虚拟机栈和本地方法栈“瓜分”了。每个线程分配到的栈容量越大，可以建立的线程
 * 数量自然就越少，建立线程时就越容易把剩下的内存耗尽。
 * 
 * 		如果是建立多线程导致的内存溢出，在不减少线程数量或者更换64位虚拟机的情况下，就只能通过减少最大堆
 * 和减少栈容量来换取更多的线程。如果没有这方面的处理经验，这种通过“减少内存”的手段来解决内存的方式会比较
 * 难以想到
 * 
 * VM Args: -Xss128k
 * 
 * @author ziyu.wei
 * 
 * 2015年8月1日 上午11:02:10
 */
public class JavaVMStackSOF {
	
	private int stackLength = 1;
	
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable{
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length: " + oom.stackLength);
			throw e;
		}
	}

}
