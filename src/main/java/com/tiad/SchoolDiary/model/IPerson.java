/**
 * 
 */
package com.tiad.SchoolDiary.model;

/**
 * @author tiad
 *
 */
public interface IPerson {
	IName getName();
	IPerson getParent(boolean mother) throws Exception;
}
