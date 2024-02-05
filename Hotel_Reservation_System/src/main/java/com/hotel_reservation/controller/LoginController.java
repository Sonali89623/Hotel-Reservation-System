package com.hotel_reservation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel_reservation.model.DAOService;
import com.hotel_reservation.model.DAOServiceImpl;
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	DAOService dao=new DAOServiceImpl();
	dao.connectDB();
	boolean status = dao.verifyCredentials(email, password);
	if (status==true) {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/NewReservation.jsp");
		rd.forward(request, response);
	} else {
		request.setAttribute("msg", "Invalid Credentials!!");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	}

}
