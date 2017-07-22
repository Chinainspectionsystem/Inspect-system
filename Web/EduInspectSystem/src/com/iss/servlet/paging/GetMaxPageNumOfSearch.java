package com.iss.servlet.paging;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iss.pojo.ClassInfo;
import com.iss.pojo.CourseInfo;
import com.iss.pojo.DepartmentInfo;
import com.iss.pojo.JobTitleInfo;
import com.iss.pojo.StudentInfo;
import com.iss.pojo.TeacherInfo;
import com.iss.service.IGetMaxPageNumService;
import com.iss.service.Impl.GetMaxPageNumServiceImpl;

/**
 * Servlet implementation class GetMaxPageNumOfSearch
 */
@WebServlet("/servlet/GetMaxPageNumOfSearch")
public class GetMaxPageNumOfSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		double count = 0.0;
		String flag = request.getParameter("flag");

		if (flag.equals("teacher")) {
			// sql = "select count(*) 'count' from tb_teacher where teacher_id = ? or
			// department_id = ? or teacher_name = ? or gender = ? or jobtitle_id = ? or
			// teacher_inspector = ?";
			TeacherInfo teacherInfo = new TeacherInfo();
			teacherInfo.setTeacher_id(request.getParameter("teacher_id"));
			teacherInfo.setDepartment_id(request.getParameter("department_id"));
			teacherInfo.setTeacher_name(request.getParameter("teacher_name"));
			teacherInfo.setGender(request.getParameter("gender"));
			teacherInfo.setJobtitle_id(request.getParameter("jobtitle_id"));
			teacherInfo.setTeacher_inspector(request.getParameter("teacher_inspector"));
			IGetMaxPageNumService getMaxPageNumService = new GetMaxPageNumServiceImpl();
			List<Map<String, Object>> list = getMaxPageNumService.getMaxPageNumOfSearchTeacher(teacherInfo);
			count = Double.parseDouble(list.get(0).get("count").toString());
		}
		if (flag.equals("course")) {
			// sql = "select count(*) 'count' from tb_course where course_id = ? or
			// course_name = ? or department_id = ? or course_hour = ? or course_credit =
			// ?";
			CourseInfo courseInfo = new CourseInfo();
			courseInfo.setCourse_id(request.getParameter("course_id"));
			courseInfo.setCourse_name(request.getParameter("course_name"));
			courseInfo.setDepartment_id(request.getParameter("department_id"));
			courseInfo.setCourse_hour(request.getParameter("course_hour"));
			courseInfo.setCourse_credit(request.getParameter("course_credit"));
			IGetMaxPageNumService getMaxPageNumService = new GetMaxPageNumServiceImpl();
			List<Map<String, Object>> list = getMaxPageNumService.getMaxPageNumOfSeacherCourse(courseInfo);
			count = Double.parseDouble(list.get(0).get("count").toString());
		}
		if (flag.equals("student")) {
			// sql = "select count(*) 'count' from tb_student where student_id = ? or
			// student_name = ? or department_id = ? or class_name = ? or gender = ?";
			StudentInfo studentInfo = new StudentInfo();
			studentInfo.setStudent_id(request.getParameter("student_id"));
			studentInfo.setStudent_name(request.getParameter("student_name"));
			studentInfo.setDepartment_id(request.getParameter("department_id"));
			studentInfo.setClass_name(request.getParameter("class_name"));
			studentInfo.setGender(request.getParameter("gender"));
			IGetMaxPageNumService getMaxPageNumService = new GetMaxPageNumServiceImpl();
			List<Map<String, Object>> list = getMaxPageNumService.getMaxPageNumOfSearchStudent(studentInfo);
			count = Double.parseDouble(list.get(0).get("count").toString());
		}
		if (flag.equals("department")) {
			// sql = "select count(*) 'count' from tb_department where department_id = ? or
			// department_name = ? or department_head = ?";
			DepartmentInfo departmentInfo = new DepartmentInfo();
			departmentInfo.setDepartment_id(request.getParameter("department_id"));
			departmentInfo.setDepartment_name(request.getParameter("department_name"));
			departmentInfo.setDepartment_head(request.getParameter("department_head"));
			IGetMaxPageNumService getMaxPageNumService = new GetMaxPageNumServiceImpl();
			List<Map<String, Object>> list = getMaxPageNumService.getMaxPageNumOfSearchDepartment(departmentInfo);
			count = Double.parseDouble(list.get(0).get("count").toString());
		}
		if (flag.equals("jobtitle")) {
			// sql = "select count(*) 'count' from tb_jobtitle where jobtitle_id = ? or
			// jobtitle_name = ?";
			JobTitleInfo jobTitleInfo = new JobTitleInfo();
			jobTitleInfo.setJobtitle_id(request.getParameter("jobtitle_id"));
			jobTitleInfo.setJobtitle_name(request.getParameter("jobtitle_name"));
			IGetMaxPageNumService getMaxPageNumService = new GetMaxPageNumServiceImpl();
			List<Map<String, Object>> list = getMaxPageNumService.getMaxPageNumOfSearchJobTitle(jobTitleInfo);
			count = Double.parseDouble(list.get(0).get("count").toString());
		}
		if (flag.equals("classes")) {
			// sql = "select count(*) 'count' from tb_classes where class_name = ? or
			// class_grade = ? or teacher_id = ?";
			ClassInfo classInfo = new ClassInfo();
			classInfo.setClass_name(request.getParameter(" class_name"));
			classInfo.setClass_grade(request.getParameter("class_grade"));
			classInfo.setTeacher_id(request.getParameter("teacher_id"));
			IGetMaxPageNumService getMaxPageNumService = new GetMaxPageNumServiceImpl();
			List<Map<String, Object>> list = getMaxPageNumService.getMaxPageNumOfSeacherClass(classInfo);
			count = Double.parseDouble(list.get(0).get("count").toString());
		}

		double pagesize = (double) Integer.parseInt(request.getParameter("pagesize"));
		int result = (int) Math.ceil(count / pagesize);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

}
