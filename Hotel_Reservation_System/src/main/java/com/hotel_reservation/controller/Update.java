package com.hotel_reservation.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel_reservation.model.DAOService;
import com.hotel_reservation.model.DAOServiceImpl;
@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Update() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		DAOService dao=new DAOServiceImpl();
		dao.connectDB();
		dao.updateRes(email,mobile);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/updateReservation.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
