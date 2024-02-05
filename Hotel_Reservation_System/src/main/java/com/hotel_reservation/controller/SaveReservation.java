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
@WebServlet("/saveReservation")
public class SaveReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SaveReservation() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/NewReservation.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String city = request.getParameter("city");
	String email = request.getParameter("email");
	String mobile = request.getParameter("mobile");
	DAOService dao=new DAOServiceImpl();
	dao.connectDB();
	dao.saveReservation(id, name, city, email, mobile);
	request.setAttribute("msg", "Record Saved!!");
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/NewReservation.jsp");
	rd.forward(request, response);
	
	}

}
