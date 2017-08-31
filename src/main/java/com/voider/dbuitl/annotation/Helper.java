package com.voider.dbuitl.annotation;

import java.lang.reflect.InvocationTargetException;
/**
 * 
 * @author Edgar Xolop
 *
 */

public class Helper {
	
	private Helper(){}
	
	/**
	 * Getting the name of table
	 * @param c - Class with the Table annotation to get the table name
	 * @return name of table setted
	 */
	public static String getTableName(Class<?> c) {
		String name = null;
		
		Table table = c.getAnnotation(Table.class);
		
		if(table != null){
			name = table.name();
		}
		
		return name;
	}
	
	/**
	 * Execute the method declared in the bean defined
	 * @param bean - object with getter methods
	 * @param methodName - name of the get method
	 * @return return the value of method registered in param method Name
	 */
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