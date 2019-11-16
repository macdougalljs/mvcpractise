package ca.sheridancollege.model;

import ca.sheridancollege.controller.DataAccess;

public class Model {

	DataAccess db = null;
	
	public Model() {
		db = new DataAccess(); // create a new instance
		db.connect(); // connect to the database in the Constructor
	}
	
	public String returnImage() {
		
		int x = (int)(Math.random() *6);
		return "images/"+ x + ".jpg";
		
		// insert code to return a random image
	}
	
	public void LogAccess(String ip) {
		// this will call the insertRow method of DataAccess
		db.insertRow(ip);
		
	}
}
