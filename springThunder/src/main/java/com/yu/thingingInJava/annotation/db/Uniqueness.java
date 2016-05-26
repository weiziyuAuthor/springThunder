package com.yu.thingingInJava.annotation.db;


public @interface Uniqueness {
	Constraints constraints() 
		default @Constraints(unique=true);
}
