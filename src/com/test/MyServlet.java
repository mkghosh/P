package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.exp.MarksNotDefined;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ST_ID_LIST = "stIdList";
       
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
		try {
			result = new Result(student.getStId(), student.getName(), student.getCumulativeGrade());
		} catch (MarksNotDefined mnd) {
			System.out.println(mnd.getMessage());
		}
		String buttonType = request.getParameter("action");
		ArrayList<String> stIdList = null;
		if(buttonType.equals("Next")) {
			HttpSession session = request.getSession(true);
			stIdList = (ArrayList<String>) session.getAttribute(ST_ID_LIST);
			if(stIdList == null) 
				stIdList = new ArrayList<>();
			stIdList.add(result.getStID());
			session.setAttribute(ST_ID_LIST, stIdList);
			session.setAttribute(result.getStID(), result);
			response.sendRedirect("/P/html/submit_test.html");
		} else {
			HttpSession session = request.getSession();
			ArrayList<String> idList = (ArrayList<String>)session.getAttribute(ST_ID_LIST);
			for(int i = 0; i < idList.size(); i++) {
				Result stResult = (Result)session.getAttribute(idList.get(i));
				
				out.println("<p>Mr./Miss : " + stResult.getStName() + "<br/>"
						+ "Your id is : " + stResult.getStID() + "<br/>"
						+ "You have obtained " + stResult.getCgpa() + "<br/>" +
						"Your grade is : " + stResult.getGrade());
			}
			out.println("<p>Mr./Miss : " + result.getStName() + "<br/>"
					+ "Your Id is : " + result.getStID() + "<br/>" 
					+ "You have obtained " + result.getCgpa() + "<br/>" +
					"Your grade is : " + result.getGrade());
		}	
	}

	private Student getStudent(HttpServletRequest request) {
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String dept = request.getParameter("dept");
		String studentId = request.getParameter("st_id");
		return new Student(firstName + " " + lastName, studentId, dept);
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
