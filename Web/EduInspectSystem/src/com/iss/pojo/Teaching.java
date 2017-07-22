package com.iss.pojo;

public class Teaching {
	private String teaching_id;
	private String course_id;
	private String teacher_id;
	private String department_id;
	private String department_name;
	private String teaching_time;
	private String teaching_place;
	private String student_population;
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getTeaching_id() {
		return teaching_id;
	}
	public void setTeaching_id(String teaching_id) {
		this.teaching_id = teaching_id;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getTeaching_time() {
		return teaching_time;
	}
	public void setTeaching_time(String teaching_time) {
		this.teaching_time = teaching_time;
	}
	public String getTeaching_place() {
		return teaching_place;
	}
	public void setTeaching_place(String teaching_place) {
		this.teaching_place = teaching_place;
	}
	public String getStudent_population() {
		return student_population;
	}
	public void setStudent_population(String student_population) {
		this.student_population = student_population;
	}
}
