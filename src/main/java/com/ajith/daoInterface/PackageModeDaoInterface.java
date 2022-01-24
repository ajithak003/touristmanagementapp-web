package com.ajith.daoInterface;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ajith.model.PackageModeClass;

public interface PackageModeDaoInterface {


	public boolean insertPackage(PackageModeClass Packages) throws ClassNotFoundException, SQLException;
	public List<PackageModeClass> getAllPackage() throws ClassNotFoundException, SQLException;
	public PackageModeClass getPackageByNo(String PackageName) throws ClassNotFoundException, SQLException;
	public boolean updatePackage(PackageModeClass packages) throws ClassNotFoundException, SQLException;
	public boolean deletePackage(String location) throws ClassNotFoundException, SQLException;
	public PackageModeClass getSinglePackage(String location);
	
}
