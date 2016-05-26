package com.yu.spring.good.clazz;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Constants {
	
	private final String className;
	
	private final Map<String, Object> fieldCache = new HashMap<String, Object>();
	
	public Constants(Class<?> clazz) {
		this.className = clazz.getName();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (ReflectionUtils.isPublicStaticFinal(field)) {
				try {
					this.fieldCache.put(field.getName(), field.get(null));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public final String getClassName() {
		return this.className;
	}
	
	public final int getSize() {
		return this.fieldCache.size();
	}

	public Map<String, Object> getFieldCache() {
		return fieldCache;
	}

	public Object asObject(String code) {
		String codeToUse = code.toLowerCase(Locale.ENGLISH);
		Object val = this.fieldCache.get(codeToUse);
		if (val == null) {
			throw new ConstantException(this.className, codeToUse, "not found");
		}
		return val;
	}
	
	public Number asNumber(String code) {
		Object obj = asObject(code);
		if (!(obj instanceof Number)) {
			throw new ConstantException(this.className, code, "not a number");
		}
		return (Number)obj;
	}
	
	public String asString(String code) {
		return asObject(code).toString();
	}
	
	public Set<String> getNames(String namePrefix) {
		String prefixToUse = namePrefix != null ? namePrefix.toUpperCase(Locale.ENGLISH) : "";
		Set<String> names = new HashSet<String>();
		//good
		for (String code : this.fieldCache.keySet()) {
			if (code.startsWith(prefixToUse)) {
				names.add(code);
			}
		}
		return names;
	}
	
	//good without return String
	public String toCode(Object value, String prefixName) throws ConstantException{
		String prefixToUse = prefixName != null ? prefixName.toUpperCase(Locale.ENGLISH) : "";
		for (Map.Entry<String, Object> entry : this.fieldCache.entrySet()) {
			if (entry.getKey().startsWith(prefixName) && entry.getValue().equals(value)) {
				return entry.getKey();
			}
		}
		throw new ConstantException(this.className, prefixToUse, value);
	}
	
}
