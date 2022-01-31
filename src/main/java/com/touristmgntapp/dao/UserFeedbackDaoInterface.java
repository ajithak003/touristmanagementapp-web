package com.touristmgntapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.touristmgntapp.models.BookingClass;
import com.touristmgntapp.models.UserFeedbackClass;

public interface UserFeedbackDaoInterface {
	
	public boolean insertFeedback(UserFeedbackClass Feedback) throws ClassNotFoundException, SQLException;
    public List<UserFeedbackClass> getAllFeedback() throws ClassNotFoundException, SQLException;
    public boolean endDateCheck(BookingClass booking);
    public UserFeedbackClass getAllFeedbackratingS(String location) throws ClassNotFoundException, SQLException ;
	
}
