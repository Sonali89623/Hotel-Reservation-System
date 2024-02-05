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
@WebServlet("/listReservation")
public class ListReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ListReservation() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOService dao=new DAOServiceImpl();
	dao.connectDB();
	ResultSet resultSet = dao.getAllReservation();
	request.setAttribute("result", resultSet);
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/listReservation.jsp");
	rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
