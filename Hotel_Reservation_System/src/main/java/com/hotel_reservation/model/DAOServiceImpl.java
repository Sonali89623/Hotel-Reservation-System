package com.hotel_reservation.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {
		private Connection con;
		private Statement stmnt;
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb","root","Sonali1234#");
			stmnt=con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean verifyCredentials(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
			if (result.next()) {
				return true;
			} else {
				return false;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveReservation(String id,String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into reservation values('"+id+"','"+name+"','"+city+"','"+email+"','"+mobile+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ResultSet getAllReservation() {
		try {
			ResultSet result = stmnt.executeQuery("select * from reservation");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteRes(String email) {
		try {
			stmnt.executeUpdate("delete from reservation where email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateRes(String email, String mobile) {
		try {
			stmnt.executeUpdate("update reservation set mobile='"+mobile+"'where email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
