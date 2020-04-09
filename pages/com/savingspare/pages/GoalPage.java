package com.savingspare.pages;

import org.openqa.selenium.By;

import cucumber.api.DataTable;

public interface GoalPage extends SavingSparePage {
	
	By GOALNAME=By.id("GoalName");
	By GOALDATE=By.id("GoalDate");
	By GOALAMOUNT=By.id("GoalAmount");
	By GOALTYPE_SELECT=By.id("GoalType");
	By GOALPERCENTAGE=By.id("username");
	By SAVEGOAL_BUTTON=By.xpath("//*[contains(text(),'Save the goal')]");
			

	void setGoal();

	void addAGoal();

	void addAGoal(DataTable dataTable);

	void VerifySavings();

}
