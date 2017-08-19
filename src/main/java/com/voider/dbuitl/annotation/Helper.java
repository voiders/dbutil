package com.voider.dbuitl.annotation;

import java.lang.reflect.InvocationTargetException;
/**
 * 
 * @author Edgar Xolop
 *
 */

public class Helper {
	
	private Helper(){}
	
	public static String getTableName(Class<?> c) {
		String name = null;
		
		Table table = c.getAnnotation(Table.class);
		
		if(table != null){
			name = table.name();
		}
		
		return name;
	}
	public static Object getFieldValue(Object bean,String methodName){
		Object value = null;
			
		try {
			value = bean.getClass().getMethod(methodName).invoke(bean);
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			
		} catch (SecurityException e) {
			e.printStackTrace();
			
		}	
		
		return value;
	}
}