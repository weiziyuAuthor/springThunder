package com.yu.thread;

/**
 * 
 * @author ziyu.wei
 * 2015��3��26�� ����3:29:58
 * 
 * t.join() //ʹ�����߳� t �ڴ�֮ǰִ����ϡ�
 */
public class JoinTest implements Runnable {

	public static int a = 0;
	@Override
	public void run() {
		for (int i=0; i<5; i++) {
			a = a + 1;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Runnable r = new JoinTest();
		Thread thread = new Thread(r);
		thread.start();
//		thread.join();
		
//		��û�е��� join����
//		�����߳� main����ִ��System.out.println(a);�������ʱ���̻߳�û��������ʼ���У�
//		��������Ϊ��������Դ׼�����С���ΪΪ�̷߳�����Դ��Ҫʱ�䣬��main����ִ����t.start()�������������ִ��System.out.println(a);
//		���ʱ��õ��Ľ����a��û�б� �ı��ֵ0
		System.out.println(a);
	}
}
