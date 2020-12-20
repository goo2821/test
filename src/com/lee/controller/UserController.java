package com.lee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lee.dao.UserDao;
import com.lee.model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        this.userDao = new UserDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userIDStr = request.getParameter("userid");
		System.out.println("uestID: " + userIDStr);
		
		int userid = Integer.parseInt(userIDStr);
		
		try {
			User user = this.userDao.getUserById(userid);
			System.out.println(user);
		} catch(NullPointerException e) {
			System.out.println("null");
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
  	    String member_id = request.getParameter("member_id");
        String member_pw = request.getParameter("member_pw");
        String member_name = request.getParameter("member_name");
        String member_age = request.getParameter("member_age");
        String member_gender = request.getParameter("member_gender");
        String member_email = request.getParameter("member_email");
        
        User user = new User();
        user.setId(member_id);
        user.setPassword(member_pw);
        user.setName(member_name);
        user.setAge(Integer.parseInt(member_age));
        user.setSex(member_gender);
        user.setEmail(member_email);
        
        UserDao dao = new UserDao();
        
        dao.addUser(user);
        
        System.out.println(user.toString());
        
        response.sendRedirect("/shopping/home.jsp");
	}

}
