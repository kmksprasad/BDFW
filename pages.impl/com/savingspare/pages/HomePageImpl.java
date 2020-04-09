package com.savingspare.pages;

import org.openqa.selenium.WebDriver;

public class HomePageImpl extends SavingSparePageImpl implements HomePage {
	
	WebDriver driver;

	public HomePageImpl(WebDriver driver) {
		this.driver=driver;
	}

	@Override
	public void navigateToGoalPage() {
		driver.findElement(SAVINGBUCKET_LINK).click();
		
		//driver.findElement(GOALPAGEICON).click();*/
		
	}

	@Override
	public GoalPage getGoalPage() {
		 
		return new GoalPageImpl(driver);
	}

	@Override
	public void startsTransaction(String transactionType) {
		if(transactionType.contains("recharge"))
		{
			driver.findElement(Recharges).click();
		}
		if(transactionType.contains("passbook"))
		{
			driver.findElement(Passbook).click();
		}
	}

	@Override
	public TransactionPage getTransactionPage() {
		
		return new TransactionPageImpl(driver);
	}

	@Override
	public void loginToApplication() {
		driver.findElement(username).sendKeys("H2Hire@g.com");
		driver.findElement(password).sendKeys("*****");
		driver.findElement(LoginButton).click();
		
	}

	@Override
	public void navigateTopassBook() {
		driver.findElement(passbook_LINK).click();
		driver.findElement(DigibankLink).click();
	}

}
