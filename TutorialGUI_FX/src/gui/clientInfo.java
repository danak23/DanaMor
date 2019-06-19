package gui;

import java.util.ArrayList;

public class clientInfo {

	String userId;
	String cityName;
	String mapPrice;
	String purchase_type;
	String purchase_date;
	public clientInfo(String userId, String cityName, String mapPrice, String purchase_type, String purchase_date) 
	{
		ArrayList<String> info=QueryControl.purchaseHistory(QueryControl.getCustomerId());
		int i=0;
		this.userId = info.get(i++);
		this.cityName = info.get(i++);
		this.mapPrice = info.get(i++);
		this.purchase_type = info.get(i++);
		this.purchase_date = info.get(i++);
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getMapPrice() {
		return mapPrice;
	}
	public void setMapPrice(String mapPrice) {
		this.mapPrice = mapPrice;
	}
	public String getPurchase_type() {
		return purchase_type;
	}
	public void setPurchase_type(String purchase_type) {
		this.purchase_type = purchase_type;
	}
	public String getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}
	
	
}
