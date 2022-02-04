package com.touristmgntapp.dao;


import java.sql.SQLException;
import java.util.List;

import com.touristmgntapp.model.PackageModeClass;

public interface PackageModeDaoInterface {


	public boolean insertPackage(PackageModeClass Packages) throws ClassNotFoundException, SQLException;
	public List<PackageModeClass> getAllPackage() throws ClassNotFoundException, SQLException;
	public List<PackageModeClass> getAllAdminPackage() throws ClassNotFoundException, SQLException;
	public PackageModeClass getPackageByNo(String PackageName) throws ClassNotFoundException, SQLException;
	public boolean updatePackage(PackageModeClass packages) throws ClassNotFoundException, SQLException;
	public boolean deletePackage(String location) throws ClassNotFoundException, SQLException;
	public PackageModeClass getSinglePackage(String location);
	
}
