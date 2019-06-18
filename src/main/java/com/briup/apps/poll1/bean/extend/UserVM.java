/**
 * 
 */
package com.briup.apps.poll1.bean.extend;

import com.briup.apps.poll1.bean.Grade;

/**
 @author： fu    @time：2018年6月26日 下午8:40:59 
 @说明： 一份耕耘，一份收获
**/
public class UserVM {

	private Long id;
	private String name;
	private String gender;
	private String birth;
	private String hiredate;
	private String type;
	private Grade grade;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	
}
