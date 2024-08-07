package com.touristmgntapp.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.touristmgntapp.dao.UserFeedbackDaoInterface;
import com.touristmgntapp.model.UserFeedbackClass;
import com.touristmgntapp.util.ConnectionUtil;

public class RatingDaoImplement implements UserFeedbackDaoInterface {

	@Override
	public boolean insertFeedback(UserFeedbackClass Feedbacks) throws ClassNotFoundException, SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;
		String commit = "commit";
		String query = "insert into users_feedback(user_id,booking_id,package_id,user_name,package_name,rating,describtion) values(?,?,?,?,?,?,?)";

		try {
			con = ConnectionUtil.getDBConnect();

			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, Feedbacks.getUserId());
			pstmt.setInt(2, Feedbacks.getBookingId());
			pstmt.setInt(3, Feedbacks.getPackageId());
			pstmt.setString(4, Feedbacks.getUserName());
			pstmt.setString(5, Feedbacks.getPackageName());
			pstmt.setFloat(6, Feedbacks.getRating());
			pstmt.setString(7, Feedbacks.getDescribtion());

			pstmtvalue = pstmt.executeUpdate();

			pstmt.executeQuery(commit);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con);
		}
		return pstmtvalue > 0;

	}

	@Override
	public List<UserFeedbackClass> getAllFeedback() throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserFeedbackClass rating = null;

		List<UserFeedbackClass> ratings = new ArrayList<>();

		String query = "select feedback_id,user_name,package_name,rating,describtion from users_feedback order by feedback_id desc";

		try {
			con = ConnectionUtil.getDBConnect();

			pstmt = con.prepareStatement(query);

			 rs = pstmt.executeQuery();

			while (rs.next()) {
				rating = new UserFeedbackClass(rs.getInt("feedback_id"), 0, 0, 0, rs.getString("user_name"),rs.getString("package_name"), rs.getFloat("rating"), rs.getString("describtion"));
				ratings.add(rating);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con, rs);
		}

		return ratings;

	}

	public boolean endDateCheck(LocalDate endDate, int bookingId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "select user_id from booking_details where booking_id=? and SYSDATE>=?";

		boolean flag = false;

		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bookingId);
			pstmt.setDate(2, java.sql.Date.valueOf(endDate));
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			ConnectionUtil.close(pstmt, con);
		}

		return flag;
	}

	public UserFeedbackClass getAllFeedbackratingS(String location) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserFeedbackClass rating = null;

		String query = "select package_name, avg(rating)as rating  from users_feedback where package_name=? group by package_name";

		try {
			con = ConnectionUtil.getDBConnect();

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, location);

			 rs = pstmt.executeQuery();

			while (rs.next()) {
				rating = new UserFeedbackClass(0, 0, 0, 0, "", rs.getString("package_name"), rs.getFloat("rating"), "");

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con, rs);
		}
		return rating;

	}

}
