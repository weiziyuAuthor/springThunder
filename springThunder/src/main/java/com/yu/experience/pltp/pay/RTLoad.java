package com.yu.experience.pltp.pay;

import static java.util.ServiceLoader.load;

interface LoadTest {
	
}

public class RTLoad {

	public static void main(String[] args) {
		load(LoadTest.class).iterator();
	}

}
