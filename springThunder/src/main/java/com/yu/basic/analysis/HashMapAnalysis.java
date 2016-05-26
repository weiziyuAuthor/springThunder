package com.yu.basic.analysis;

/**
 * for detail info , see YDNote
 * @author ziyu.wei
 *
 * 2015年8月12日 下午3:03:19
 */
public class HashMapAnalysis {

	public static void main(String[] args) {
//		Map map = new HashMap();
//		System.out.println(map.put("a", "1"));
//		System.out.println(map.put("a", "2"));
		
//	    static int indexFor(int h, int length) {
//	        return h & (length-1);
//	    }
		
		int n = 6;
		
		String string = String.valueOf(n);
		
		int length = 5;
		for (int i=0; i<20; i++) {
			System.out.println((i & (length-1)));
		}
	}
}
