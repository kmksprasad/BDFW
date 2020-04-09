package com.savingspare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TransactionPageImpl extends SavingSparePageImpl implements TransactionPage{
	
	WebDriver driver;

	public TransactionPageImpl(WebDriver driver) {
		this.driver =driver;
	}

	@Override
	public void enterTransactionDetails() {
		driver.findElement(MobileNumber).sendKeys("2341231231");
		Select sel = new Select(driver.findElement(ServiceProvider_dropDown));
		sel.selectByIndex(1);
		driver.findElement(RechargeAmount).sendKeys("100");
		
	
		
	}

	@Override
	public void completesTheTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verifiesTheSavingDetails() {
		driver.findElement(Proceed_Button).click();
		
	}

	@Override
	public PaymentPage getPaymentPage() {
		return new PaymentPageImpl(driver);
	}

}
