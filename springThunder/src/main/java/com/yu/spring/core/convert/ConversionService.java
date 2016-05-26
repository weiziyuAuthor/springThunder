package com.yu.spring.core.convert;

import org.springframework.core.convert.TypeDescriptor;

public interface ConversionService {
	
	boolean canConvert(Class<?> sourceType, Class<?> targetType);
	
	boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType);
	
	<T> T canConvert(Object source, Class<T> targetType);
	
	Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType);
}
