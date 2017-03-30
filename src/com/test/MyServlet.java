package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.exp.MarksNotDefined;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");

		Marks marks = getMarks(request);
		Student student = getStudent(request);
		student.setMarks(marks);
		Result result = null;
		String buttonType = request.getParameter("action");
		if(buttonType.equals("Next")) {
			response.sendRedirect("/P/html/submit_test.html");
		} else {

			try {
				result = new Result(student.getStId(), student.getName(), student.getCumulativeGrade());
			} catch (MarksNotDefined mnd) {
				System.out.println(mnd.getMessage());
			}
			
			out.println("<p>Mr./Miss : " + result.getStName() + "<br/>"
					+ "You have obtained " + result.getCgpa() + "<br/>" +
					"Your grade is : " + result.getGrade());
		}	
	}

	private Student getStudent(HttpServletRequest request) {
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String dept = request.getParameter("dept");
		String studentId = request.getParameter("st_id");
		return new Student(firstName + " " + lastName, dept, studentId);
	}

	private Marks getMarks(HttpServletRequest request) {
		double banglaMarks = Double.parseDouble(request.getParameter("bangla"));
		double englishMarks = Double.parseDouble(request.getParameter("english"));
		double mathMarks = Double.parseDouble(request.getParameter("math"));
		double scMarks = Double.parseDouble(request.getParameter("science"));
		double soScMarks = Double.parseDouble(request.getParameter("so_science"));
		
		return new Marks(banglaMarks,englishMarks, mathMarks, scMarks, soScMarks);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
