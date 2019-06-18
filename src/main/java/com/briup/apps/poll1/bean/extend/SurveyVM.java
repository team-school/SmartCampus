/**
 * 
 */
package com.briup.apps.poll1.bean.extend;

import com.briup.apps.poll1.bean.Course;
import com.briup.apps.poll1.bean.User;

/**
 @author： fu    @time：2018年6月29日 上午9:10:12 
 @说明： 一份耕耘，一份收获
**/
public class SurveyVM {
private Long id;
private Double average;
private String status;
private String code;
private String surveydate;
private Course course;
private ClazzVM clazzVM;
private User teacher;
private QuestionnaireVM questionnaireVM;

public Double getAverage() {
	return average;
}
public void setAverage(Double average) {
	this.average = average;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getSurveydate() {
	return surveydate;
}
public void setSurveydate(String surveydate) {
	this.surveydate = surveydate;
}
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
public ClazzVM getClazzVM() {
	return clazzVM;
}
public void setClazzVM(ClazzVM clazzVM) {
	this.clazzVM = clazzVM;
}
public User getTeacher() {
	return teacher;
}
public void setTeacher(User teacher) {
	this.teacher = teacher;
}
public QuestionnaireVM getQuestionnaireVM() {
	return questionnaireVM;
}
public void setQuestionnaireVM(QuestionnaireVM questionnaireVM) {
	this.questionnaireVM = questionnaireVM;
}
}
