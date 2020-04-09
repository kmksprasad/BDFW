package com.savingspare.pages;

import java.util.spi.CalendarDataProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PaymentPageImpl extends SavingSparePageImpl implements PaymentPage {
	WebDriver driver;

	public PaymentPageImpl(WebDriver driver) {
		this.driver=driver;
	}

	@Override
	public void enterPaymentDetails() {
		driver.findElement(cardnumber).sendKeys("1231313213");
		Select sel= new Select(driver.findElement(cardType));
		sel.selectByIndex(1);		
		driver.findElement(pin).sendKeys("1231");
		driver.findElement(cardcvv).sendKeys("121");
		driver.findElement(paymentProceedButton).click();
		
		
	}

	@Override
	public PaymentConfirmationPage getPaymentConfirmationPage() {
		 return new PaymentConfirmationPageImpl(driver);
	}

}
