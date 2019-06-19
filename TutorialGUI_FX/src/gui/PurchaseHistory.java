package gui;

import java.util.ArrayList;

public class PurchaseHistory {
	
	private String City;
	private String PurchaseType;
	private String PurchaseDate;
	
	public PurchaseHistory(ArrayList<String> PurchaseHistory) {
		City = PurchaseHistory.get(0);
		PurchaseType = PurchaseHistory.get(1);
		PurchaseDate =PurchaseHistory.get(2);
	}
	public String getCity() {
		return City;
	}
	public String getPurchaseType() {
		return PurchaseType;
	}
	public String getPurchaseDate() {
		return PurchaseDate;
	}

	

}
