package com.touristmgntapp.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.touristmgntapp.model.UserFeedbackClass;

public interface UserFeedbackDaoInterface {
	
	public boolean insertFeedback(UserFeedbackClass Feedback) throws ClassNotFoundException, SQLException;
    public List<UserFeedbackClass> getAllFeedback() throws ClassNotFoundException, SQLException;
    public boolean endDateCheck(LocalDate endDate, int bookingId);
    public UserFeedbackClass getAllFeedbackratingS(String location) throws ClassNotFoundException, SQLException ;
	
}
