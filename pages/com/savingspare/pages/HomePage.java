package com.savingspare.pages;

import org.openqa.selenium.By;

public interface HomePage extends SavingSparePage {
	
	By HOMEPAGEICON=By.xpath("//a[contains(text(),'Digi Bank')]");
	By SAVINGBUCKET_LINK=By.xpath("//*[text()='Saving Bucket']");
	By passbook_LINK=By.xpath("//a[text()='Pass Book']");
	By Recharges=By.xpath("//*[text()='Recharges']");
	By BillPayment=By.xpath("//*[text()='Bill Payment']");
	By Passbook=By.xpath("//*[text()='Pass Book']");
	By MENUBUTTON=By.xpath("");
	By GOALPAGEMENU=By.xpath("");
	By username= By.name("username");
	By password= By.name("password");
	By LoginButton=By.xpath("//a[contains(text(),'Login')]");
	By DigibankLink=By.xpath("//a[text()='Digi Bank']");
		
	

	void navigateToGoalPage();

	GoalPage getGoalPage();

	void startsTransaction(String transactionType);

	TransactionPage getTransactionPage();
	
	void loginToApplication();
	void navigateTopassBook();

}
