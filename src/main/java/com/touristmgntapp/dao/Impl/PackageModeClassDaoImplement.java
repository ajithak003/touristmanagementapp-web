package com.touristmgntapp.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.touristmgntapp.dao.PackageModeDaoInterface;
import com.touristmgntapp.model.PackageModeClass;
import com.touristmgntapp.util.ConnectionUtil;

public class PackageModeClassDaoImplement implements PackageModeDaoInterface {

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
			ConnectionUtil.close(pstmt, con);
		}
		return pstmtvalue > 0;

	}

	@Override
	public boolean updatePackage(PackageModeClass packages) {
		Connection con = null;
		int update = 0;
		String query = "update package_modes set package_name=?,package_price_1n=?,season=?,protocols=?,description=?,status=?,image=? where package_id=?";
		PreparedStatement pstmt = null;

		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, packages.getName());
			pstmt.setDouble(2, packages.getPriceOneDays());
			pstmt.setString(3, packages.getSeason());
			pstmt.setString(4, packages.getProtocols());
			pstmt.setString(5, packages.getDescription());
			pstmt.setString(6, packages.getStatus());
			pstmt.setString(7, packages.getImage());
			pstmt.setInt(8, packages.getPackageId());

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
	public List<PackageModeClass> getAllPackage() {

		List<PackageModeClass> packageList = new ArrayList<>();
		Connection con = null;
		String query = "select package_id,package_name,package_price_1n,season,protocols,description,status,image from package_modes where status=?";

		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
            pstmt.setString(1,active);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				PackageModeClass packages = new PackageModeClass(rs.getInt("package_id"), rs.getString("package_name"),
						rs.getDouble("package_price_1n"), rs.getString("season"), rs.getString("protocols"),
						rs.getString("description"), rs.getString("status"), rs.getString("image"));
				packageList.add(packages);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con);
		}

		return packageList;

	}

	@Override
	public PackageModeClass getPackageByNo(String PackageName) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PackageModeClass packageById = null;

		String query = "select package_id,package_name,package_price_1n,season,protocols,description,status,image from package_modes where package_name=?";
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, PackageName);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				packageById = new PackageModeClass(rs.getInt("package_id"), rs.getString("package_name"),
						rs.getDouble("package_price_1n"), rs.getString("season"), rs.getString("protocols"),
						rs.getString("description"), rs.getString("status"), rs.getString("image"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con);
		}
		return packageById;
	}

	@Override
	public boolean deletePackage(String location) {

		Connection con = null;
		PreparedStatement pstmt = null;
		int del = 0;
		String query = "update package_modes set status=? where package_name=?";

		try {

			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "inactive");
			pstmt.setString(2, location);

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
	public PackageModeClass getSinglePackage(String location) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PackageModeClass packages = null;

		String query = "select package_id,package_name,package_price_1n,season,protocols,description,status,image from package_modes where package_name=?";
		try {

			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, location);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				packages = new PackageModeClass(rs.getInt("package_id"), rs.getString("package_name"),
						rs.getDouble("package_price_1n"), rs.getString("season"), rs.getString("protocols"),
						rs.getString("description"), rs.getString("status"), rs.getString("image"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con);
		}
		return packages;
	}

	@Override
	public List<PackageModeClass> getAllAdminPackage() {

		List<PackageModeClass> packageList = new ArrayList<>();
		Connection con = null;
		String query = "select package_id,package_name,package_price_1n,season,protocols,description,status,image from package_modes";

		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				PackageModeClass packages = new PackageModeClass(rs.getInt("package_id"), rs.getString("package_name"),
						rs.getDouble("package_price_1n"), rs.getString("season"), rs.getString("protocols"),
						rs.getString("description"), rs.getString("status"), rs.getString("image"));
				packageList.add(packages);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(pstmt, con);
		}

		return packageList;

	}

	
}
