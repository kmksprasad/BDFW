package com.savingspare.pages;

import org.openqa.selenium.By;

public interface PaymentPage extends SavingSparePage {
	
	By cardnumber=By.id("CardNumber");
	By cardType=By.id("CardType");
	By pin=By.id("CardPin");
	By cardcvv=By.id("CVVNumber");
	By paymentProceedButton=By.xpath("//a[contains(text(),'payment')]");
	
	void enterPaymentDetails();
	PaymentConfirmationPage getPaymentConfirmationPage();

}
