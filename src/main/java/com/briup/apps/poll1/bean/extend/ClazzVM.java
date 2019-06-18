/**
 * 
 */
package com.briup.apps.poll1.bean.extend;

import com.briup.apps.poll1.bean.Grade;
import com.briup.apps.poll1.bean.User;

/**
 @author： fu    @time：2018年6月26日 上午9:42:17 
 @说明： 一份耕耘，一份收获
**/
public class ClazzVM {

	private long id;
	private String name;
	private String description;
	private Grade grade;		//班级所属年级
	private User charge;			//班级的班主任老师信息
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public User getCharge() {
		return charge;
	}
	public void setCharge(User charge) {
		this.charge = charge;
	}
	
	
}
