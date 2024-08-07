package com.touristmgntapp.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.touristmgntapp.dao.UserDaoInterface;
import com.touristmgntapp.model.UserClass;
import com.touristmgntapp.util.ConnectionUtil;

public class UserTableDaoImplement implements UserDaoInterface {

	static String commit = "commit";

	@Override
	public boolean insertUser(UserClass user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;

		String query = "insert into user_details(name,email_id,mobile_no,password) values(?,?,?,?)";

		try {
			con = ConnectionUtil.getDBConnect();

			pstmt = con.prepareStatement(query);

			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setLong(3, user.getMboNo());
			pstmt.setString(4, user.getPassword());

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
	public boolean updateuser(String name, String email, long mobileNo, String password) {

		Connection con = null;
		int update = 0;
		String query = "update user_details set name=?,mobile_no=?,password=? where email_id=?";
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);

			UserClass user = new UserClass(name, email, mobileNo, password);
			pstmt.setString(1, user.getName());
			pstmt.setLong(2, user.getMboNo());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getEmail());

			update = pstmt.executeUpdate();
			pstmt.executeQuery(commit);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con);

		}
		return update > 0;
	}

	@Override
	public boolean deleteuser(UserClass user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int del = 0;
		String query = "update user_details set status =? where email_id=?";

		try {

			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "inactive");
			pstmt.setString(2, user.getEmail());

			del = pstmt.executeUpdate();
			pstmt.executeUpdate(commit);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con);
		}
		return del > 0;

	}

	@Override
	public UserClass getUserById(UserClass user) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		UserClass userById = null;
		ResultSet rs=null;
		String query = "select user_id,name,email_id,mobile_no,password,wallet from user_details where email_id=? ";

		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, user.getEmail());

			 rs = pstmt.executeQuery();

			if (rs.next()) {

				userById = new UserClass(rs.getInt("user_id"), rs.getString("name"), rs.getString("email_id"),
						rs.getLong("mobile_no"), rs.getString("password"), rs.getLong("wallet"));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con, rs);
		}
		return userById;

	}

	@Override
	public List<UserClass> getAllUser() {

		List<UserClass> userList = new ArrayList<>();
		Connection con = null;
		String query = "select user_id,name,email_id,mobile_no,password,wallet,register_date,status from user_details order by register_date desc";

		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDBConnect();
			stmt = con.createStatement();

			 rs = stmt.executeQuery(query);

			while (rs.next()) {

				UserClass user = new UserClass(rs.getInt("user_id"), rs.getString("name"), rs.getString("email_id"),rs.getLong("mobile_no"),
					rs.getString("password"), rs.getLong("wallet"),rs.getTimestamp("register_date").toLocalDateTime(), rs.getString("status"));

				userList.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(stmt, con, rs);
		}

		return userList;
	}

	public UserClass validateUser(String emailId, String password) {

		String validateQuery = "select user_id,name,email_id,mobile_no,password,wallet from user_details "
				+ "where email_id=? and password=? and status=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserClass UserClass = null;

		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(validateQuery);

			pstmt.setString(1, emailId);
			pstmt.setString(2, password);
			pstmt.setString(3, "active");

			 rs = pstmt.executeQuery();
			if (rs.next()) {

				UserClass = new UserClass(rs.getInt("user_id"), rs.getString("name"), rs.getString("email_id"),
						rs.getLong("mobile_no"), rs.getString("password"), rs.getLong("wallet"));

			}

		} catch (SQLException e) {
			System.out.println("Statement error");
		} finally {
			ConnectionUtil.close(pstmt, con, rs);
		}

		return UserClass;

	}

	public boolean emailvalid(String emailverifi) {
		Connection con = null;
		ResultSet rs = null;
		String query = "select email_id from user_details where email_id=?";

		boolean flag = true;

		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, emailverifi);

			 rs = pstmt.executeQuery();
			if (rs.next()) {

				flag = false;

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con, rs);
		}

		return flag;
	}

	public long showWalletAmount(UserClass user) {

		Connection con = null;
		ResultSet rs = null;
		long wallet = 0;
		String query = "select wallet from user_details where email_id=?";
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getEmail());

			rs = pstmt.executeQuery();
			if (rs.next()) {

				wallet = rs.getLong("wallet");

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con, rs);
		}
		return wallet;

	}

	public boolean addWalletAmount(int userId, long amount) {

		Connection con = null;
		int wallet = 0;
		String query = "update user_details set wallet=? where user_id=?";
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setLong(1, amount);
			pstmt.setInt(2, userId);

			wallet = pstmt.executeUpdate();
			pstmt.executeQuery(commit);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con);
			
		}
		return wallet > 0;

	}

	public UserClass reRegister(String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserClass user = null;
		String query = "select user_id,name,email_id,mobile_no,password,wallet user_details from  where email_id=?";

		try {

			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, email);

			 rs = pstmt.executeQuery();

			if (rs.next()) {

				user = new UserClass(rs.getInt("user_id"), rs.getString("name"), rs.getString("email_id"),
						rs.getLong("mobile_no"), rs.getString("password"), rs.getLong("wallet"));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con, rs);
		}
		return user;

	}

	public UserClass getSingleUserById(int userId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		UserClass userById = null;

		String query = "select user_id,name,email_id,mobile_no,password,wallet from user_details where user_id=?";

		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, userId);

		    rs = pstmt.executeQuery();

			if (rs.next()) {

				userById = new UserClass(rs.getInt("user_id"), rs.getString("name"), rs.getString("email_id"),
						rs.getLong("mobile_no"), rs.getString("password"), rs.getLong("wallet"));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con, rs);
		}
		return userById;

	}

}
