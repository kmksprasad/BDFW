package com.savingspare.pages;

import org.openqa.selenium.By;

public interface TransactionPage extends SavingSparePage {
	
	By MobileNumber= By.id("MobileNumber");
	By ServiceProvider_dropDown=By.id("ServiceProvider");
	By RechargeAmount=By.id("RechargeAmount");
	By Proceed_Button=By.id("GOTOpAYMNETpAGE");

	
	void enterTransactionDetails();

	void completesTheTransaction();

	void verifiesTheSavingDetails();
	
	PaymentPage getPaymentPage();
}
