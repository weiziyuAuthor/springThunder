package com.yu.spring.good.clazz;

public class ConstantException extends IllegalArgumentException {

	public ConstantException(String className, String field, String message) {
		super("field '" + field + "' message " + message + " in class " + className);
	}

	public ConstantException(String className, String namePrefix, Object value) {
		super("No '" + namePrefix + "' field with value '" + value + "' found in class [" + className + "]");
	}
}
