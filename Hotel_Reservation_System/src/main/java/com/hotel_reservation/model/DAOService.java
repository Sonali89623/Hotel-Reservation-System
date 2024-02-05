package com.hotel_reservation.model;

import java.sql.ResultSet;

public interface DAOService {
	public void connectDB();
	public boolean verifyCredentials(String email,String password);
	public void saveReservation(String id,String name,String city, String email, String mobile);
	public ResultSet getAllReservation();
	public void deleteRes(String email);
	public void updateRes(String email, String mobile);
}
