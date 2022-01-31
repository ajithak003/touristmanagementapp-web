package com.touristmgntapp.daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.touristmgntapp.dao.PackageModeDaoInterface;
import com.touristmgntapp.models.PackageModeClass;
import com.touristmgntapp.util.ConnectionUtil;


public class PackageModeClassDaoImplement implements PackageModeDaoInterface{

	static String commit = "commit";
	static String active = "active";
	@Override
	public boolean insertPackage(PackageModeClass Packages) {
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;
		String insert = "insert into package_modes(package_name,package_price_1n,season,protocols,description,image) values(?,?,?,?,?,?)";
		
		try {
			con = ConnectionUtil.getDBConnect();
			
			pstmt = con.prepareStatement(insert);
           
			pstmt.setString(1, Packages.getName());
			pstmt.setDouble(2, Packages.getPriceOneDays());
			pstmt.setString(3, Packages.getSeason());
			pstmt.setString(4, Packages.getProtocols());
			pstmt.setString(5, Packages.getDescription());
			pstmt.setString(6, Packages.getImage());
			
			pstmtvalue = pstmt.executeUpdate();
			
			pstmt.executeQuery(commit);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return pstmtvalue > 0;
		
	}
	
	@Override
	public boolean updatePackage(PackageModeClass packages) {
		Connection con = null;
		int update=0;
		String query = "update package_modes set package_name=?,package_price_1n=?,season=?,protocols=?,description=?, image=? where package_id=?";
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, packages.getName());
			pstmt.setDouble(2, packages.getPriceOneDays());
			pstmt.setString(3, packages.getSeason());
			pstmt.setString(4, packages.getProtocols());
			pstmt.setString(5, packages.getDescription());
			pstmt.setString(6, packages.getImage());
			pstmt.setInt(7, packages.getPackageId());
			
		    update = pstmt.executeUpdate();
			 pstmt.executeQuery(commit);
			 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
			
		}
           return update>0;
	
	}


	@Override
	public List<PackageModeClass> getAllPackage()  {
		
		List<PackageModeClass> packageList = new ArrayList<PackageModeClass>();
		Connection con = null;
		String query = "select package_id,package_name,package_price_1n,season,protocols,description,status,image from package_modes where status=?";
		
		PreparedStatement pstmt = null;
		try {
		con=ConnectionUtil.getDBConnect();
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, active);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			PackageModeClass packages = new  PackageModeClass(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(8));
			packageList.add(packages);
		}
		
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		
		return packageList;
		
	}

	@Override
	public PackageModeClass getPackageByNo(String PackageName) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PackageModeClass packageById=null;
		
		String query ="select package_id,package_name,package_price_1n,season,protocols,description,status,image from package_modes where package_name=?";
		try {
		 con = ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);
		 pstmt.setString(1, PackageName);
		 
		 ResultSet rs = pstmt.executeQuery();
		
		 
		 if (rs.next()) {

			 packageById=new  PackageModeClass(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(8));
			}} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				ConnectionUtil.closePreparedStatement(pstmt, con);
			}
		 return packageById;
	}

	
	@Override
	public boolean deletePackage(String location) {

		Connection con = null;
		PreparedStatement pstmt =null;
		int del=0;
		String query = "update package_modes set status=? where package_name=?";
		
		try {
			
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
           
            pstmt.setString(1, "inactive");
            pstmt.setString(2,location);
			
            del = pstmt.executeUpdate();
            pstmt.executeUpdate(commit);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return del>0;

		
	}

	
	
	@Override
	public PackageModeClass getSinglePackage(String location) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PackageModeClass packages=null;
		
		
		
		String query ="select package_id,package_name,package_price_1n,season,protocols,description,status,image from package_modes "
				+ "where package_name=? and status=?";
		try {
			
		 con = ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);
		 pstmt.setString(1, location);
		 pstmt.setString(2, active);
		 
		 ResultSet rs = pstmt.executeQuery();
		
		 
		 if (rs.next()) {

			 packages=new  PackageModeClass(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(8));

		 }} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				ConnectionUtil.closePreparedStatement(pstmt, con);
			}
		 return packages;
	}
	
	
	
	
}