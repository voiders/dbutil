package com.voider.dbuitl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * composite key not supported
 * 
 * @author Edgar Xolop
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	/**
	 * default null
	 * @return name of the colum setted
	 */
	String name();
	/**
	 * default null
	 * @return alias of the table, if have it
	 */
	String alias();
	/**
	 * default false
	 * 
	 * if the colun is primary key 
	 * 
	 * @return  true or false
	 */
	boolean primarykey() default false;
	/**
	 * if the column is auto assigned (auto increment)
	 * if you generate the key set true
	 * 
	 * @return   true or false
	 */
	boolean autoassigned() default true;
}
