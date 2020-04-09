package com.savingspare.pages;

import org.openqa.selenium.By;

public interface PaymentConfirmationPage  extends SavingSparePage{
	
	By Paymentresultlabel=By.xpath("//h2[text()='Payment Result']");
	By LinktoHomePage=By.xpath("//img[@class='d-block mx-auto mb-4']");
	
	void verifyPaymentConfirmation();

	void navigateToHomePage();
	

}
