package com.ajith.model;

import java.util.Objects;

public class PackageModeClass {
	
	private int packageId;
	private String name;
	private double priceOneDays;
	private String season;
	private String protocols;
	private String description;
	private String image;
	public PackageModeClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public PackageModeClass(String name, double priceOneDays, String season, String protocols, String description) {
		super();
		this.name = name;
		this.priceOneDays = priceOneDays;
		this.season = season;
		this.protocols = protocols;
		this.description = description;
	}



	public PackageModeClass(String name, double priceOneDays, String season, String protocols, String description,
			String image) {
		super();
		this.name = name;
		this.priceOneDays = priceOneDays;
		this.season = season;
		this.protocols = protocols;
		this.description = description;
		this.image = image;
	}
	public PackageModeClass(int packageId, String name, double priceOneDays, String season, String protocols,
			String description, String image) {
		super();
		this.packageId = packageId;
		this.name = name;
		this.priceOneDays = priceOneDays;
		this.season = season;
		this.protocols = protocols;
		this.description = description;
		this.image = image;
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPriceOneDays() {
		return priceOneDays;
	}
	public void setPriceOneDays(double priceOneDays) {
		this.priceOneDays = priceOneDays;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getProtocols() {
		return protocols;
	}
	public void setProtocols(String protocols) {
		this.protocols = protocols;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "PackageModeClass [packageId=" + packageId + ", name=" + name + ", priceOneDays=" + priceOneDays
				+ ", season=" + season + ", protocols=" + protocols + ", description=" + description + ", image="
				+ image + "]";
	}
	
	
}