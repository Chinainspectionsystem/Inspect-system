package com.iss.pojo;

public class InspectRecord {
	private String username;
	private String teaching_id;
	private String course_id;
	private String teacher_id;
	private String department_id;
	private String teaching_time;
	private String inspection_time;
	private String inspection_place;
	private int num_absent;
	private int num_sleep;
	private int num_phone;
	private double teacherscore1;
	private double teacherscore2;
	private double studentscore1;
	private double studentscore2;
	private double totalscore;
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getTeaching_time() {
		return teaching_time;
	}
	public void setTeaching_time(String teaching_time) {
		this.teaching_time = teaching_time;
	}
	public String getInspection_time() {
		return inspection_time;
	}
	public void setInspection_time(String inspection_time) {
		this.inspection_time = inspection_time;
	}
	public String getInspection_place() {
		return inspection_place;
	}
	public void setInspection_place(String inspection_place) {
		this.inspection_place = inspection_place;
	}
	public int getNum_absent() {
		return num_absent;
	}
	public void setNum_absent(int num_absent) {
		this.num_absent = num_absent;
	}
	public int getNum_sleep() {
		return num_sleep;
	}
	public void setNum_sleep(int num_sleep) {
		this.num_sleep = num_sleep;
	}
	public int getNum_phone() {
		return num_phone;
	}
	public void setNum_phone(int num_phone) {
		this.num_phone = num_phone;
	}
	public double getTeacherscore1() {
		return teacherscore1;
	}
	public void setTeacherscore1(double teacherscore1) {
		this.teacherscore1 = teacherscore1;
	}
	public double getTeacherscore2() {
		return teacherscore2;
	}
	public void setTeacherscore2(double teacherscore2) {
		this.teacherscore2 = teacherscore2;
	}
	public double getStudentscore1() {
		return studentscore1;
	}
	public void setStudentscore1(double studentscore1) {
		this.studentscore1 = studentscore1;
	}
	public double getStudentscore2() {
		return studentscore2;
	}
	public void setStudentscore2(double studentscore2) {
		this.studentscore2 = studentscore2;
	}
	public double getTotalscore() {
		return totalscore;
	}
	public void setTotalscore(double totalscore) {
		this.totalscore = totalscore;
	}
	public String getInspect_remark() {
		return inspect_remark;
	}
	public void setInspect_remark(String inspect_remark) {
		this.inspect_remark = inspect_remark;
	}
	private String inspect_remark;
}
