package com.ajith.daoInterface;

import java.sql.SQLException;
import java.util.List;

import com.ajith.model.UserClass;

public interface UserDaoInterface {
	
	public boolean insertUser(UserClass user) throws ClassNotFoundException, SQLException;
    public List<UserClass> getAllUser() throws ClassNotFoundException, SQLException;
	public UserClass getUserById(UserClass user) throws ClassNotFoundException, SQLException;
	public boolean updateuser(String name, String email,long mobileNo, String password) throws ClassNotFoundException, SQLException;
	public boolean deleteuser(UserClass user) throws ClassNotFoundException, SQLException;
	public UserClass validateUser(String emailId, String password) throws ClassNotFoundException, SQLException;
	public boolean emailvalid(String emailverifi);
	public long showWalletAmount(UserClass user);
	public boolean addWalletAmount(int userId,long amount);

}
