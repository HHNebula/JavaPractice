package com.information.main;

import com.information.controller.HospitalInfoController;

public class Main {
	
	public static void main(String[] args) {
		
		HospitalInfoController hospitalInfoController = new HospitalInfoController();
		hospitalInfoController.inputData();
		hospitalInfoController.printHospital();
		
	}

}
