package com.savingspare.pages;

import org.openqa.selenium.WebDriver;

public class PaymentConfirmationPageImpl extends SavingSparePageImpl implements PaymentConfirmationPage {
	WebDriver driver;

	public PaymentConfirmationPageImpl(WebDriver driver) {
		this.driver=driver;
		}

	@Override
	public void verifyPaymentConfirmation() {
		driver.findElement(Paymentresultlabel);
		
	}

	@Override
	public void navigateToHomePage() {
		driver.findElement(LinktoHomePage).click();
		
	}

}
