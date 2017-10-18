package com.voider.dbutil.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
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
	 * Getting the name of columns declared
	 * @param c - Class with the Column annotation to get the columns properties
	 * @return Map <String,ColumnObject>
	 */
	public static Map<String, ColumnObject> getListFieldName(Class<?> c) {
		Map<String, ColumnObject> columns;		
		Field fields[] = c.getDeclaredFields();
		
		columns = new HashMap<>();
		
		for(Field f : fields){
			
			columns.put(f.getAnnotation(Column.class).name(),new ColumnObject(f.getAnnotation(Column.class).name(), f.getAnnotation(Column.class).alias(), f.getAnnotation(Column.class).primarykey(), f.getAnnotation(Column.class).autoassigned()));
			
		}
		
		return columns;
	}
	
	public static Map<String, Map<String, ColumnObject>> getTabes(String entityPackage){
		Map<String, Map<String, ColumnObject>> tables;
		 
		tables = new HashMap<>();
		
		Reflections reflections = new Reflections(entityPackage);
		
		Set<Class<?>> talbeAClass = reflections.getTypesAnnotatedWith(Table.class);
		
		for(Class<?> c : talbeAClass){
			tables.put(getTableName(c), getListFieldName(c));
		}
		return tables;
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