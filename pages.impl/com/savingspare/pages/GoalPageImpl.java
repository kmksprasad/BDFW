package com.savingspare.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;

public class GoalPageImpl  extends SavingSparePageImpl    implements GoalPage{
	
	WebDriver driver;

	public GoalPageImpl(WebDriver driver) {
		this.driver=driver;
	}

	@Override
	public void setGoal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAGoal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAGoal(DataTable dataTable) {
		
		
		List<List<String>> data = dataTable.raw();
		System.out.println(data.get(1).get(0));
		System.out.println(data.get(1).get(1));
		
		driver.findElement(GOALNAME).sendKeys("Buy an Anniversary Gift");
		driver.findElement(GOALDATE).sendKeys(data.get(1).get(1));
		driver.findElement(GOALAMOUNT).sendKeys(data.get(1).get(2));
		Select select= new Select(driver.findElement(GOALTYPE_SELECT));
		select.selectByVisibleText(data.get(1).get(0));
		driver.findElement(GOALPERCENTAGE).sendKeys("10%");
		driver.findElement(SAVEGOAL_BUTTON).click();
			
		
	}

	@Override
	public void VerifySavings() {
		// TODO Auto-generated method stub
		
	}

}
