package com.csis3275.demo.request;

public class OrderRequest {

	private String action;
	private int trackingID;
	private int userID;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getTrackingID() {
		return trackingID;
	}
	public void setTrackingID(int trackingID) {
		this.trackingID = trackingID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
}
