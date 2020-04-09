package com.savingspare.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.savingspare.MyBrowser;
import com.savingspare.TestEnvironmnet;
import com.savingspare.pages.GoalPage;
import com.savingspare.pages.HomePage;
import com.savingspare.pages.HomePageImpl;
import com.savingspare.pages.PaymentConfirmationPage;
import com.savingspare.pages.PaymentPage;
import com.savingspare.pages.TransactionHistoryPage;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SavingUsingSphareStepDefs {
	
	public WebDriver driver;
	public MyBrowser browser;
	public HomePage homePage;
	public GoalPage goalPage;
	public PaymentPage paymentPage;
	public PaymentConfirmationPage paymentConfirmationPage;
	public TransactionHistoryPage transactionHistoryPage;
	public TestEnvironmnet testEnv;
	public TransactionPage transactionPage;
	public GoalPage goalpage;
	

	//PropertiesFileReader obj;
	
	Properties properties=null;
	
	
	
	
	public SavingUsingSphareStepDefs()
	{
		/*this.obj= new PropertiesFileReader();
		this.properties= this.obj.getProperty();*/
		this.properties=this.getProperty();
		this.testEnv= new TestEnvironmnet(properties);
		this.driver=this.testEnv.getdriver();
						
	}
	
	
	@Given("^open browser and enter url$")
	public void open_browser_and_enter_url() throws Throwable {
		driver.get(properties.getProperty("instance.url"));
		
		homePage= new HomePageImpl(driver);	    
	    
	}
	
	

	@Given("^user launches the saving using spare application$")
	public void user_launches_the_saving_using_spare_application() throws Throwable {
		driver.get(properties.getProperty("instance.url"));
		homePage= new HomePageImpl(driver);	
		homePage.loginToApplication();
		
	    
	}
	@When("^user navigate to goal setting page$")
	public void user_navigate_to_goal_setting_page() throws Throwable {
		homePage.navigateToGoalPage();
		goalPage=homePage.getGoalPage();
		//goalPage.setGoal();
	    
	}

	@Then("^user should be able to add a goal of type$")
	public void user_should_be_able_to_add_a_goal_of_type() throws Throwable {
	    goalPage.addAGoal();
	}
	
	@Then("^user creates the following goal$")
	public void user_creates_the_following_goal(DataTable dataTable) throws Throwable {
	
		goalPage.addAGoal(dataTable);
	    
	}
	
	
	@Given("^user starts \"([^\"]*)\" transaction$")
	public void user_starts_transaction(String transactionType) throws Throwable {
		homePage.startsTransaction(transactionType);
	    
	}

	@Given("^user enters transaction details and submits$")
	public void user_enters_transaction_details_and_submits() throws Throwable {
		transactionPage=homePage.getTransactionPage();
		transactionPage.enterTransactionDetails();		
	    
	}

	@Given("^user verifies the saving details$")
	public void user_verifies_the_saving_details() throws Throwable {
		transactionPage.verifiesTheSavingDetails();
		paymentPage =transactionPage.getPaymentPage();
		System.out.println("paymentPage "+paymentPage);
		
	  
	}

	@Given("^user confirms the payment details$")
	public void user_confirms_the_payment_details() throws Throwable {
		paymentPage.enterPaymentDetails();
		paymentPage.getPaymentConfirmationPage();
		paymentConfirmationPage=paymentPage.getPaymentConfirmationPage();
		paymentConfirmationPage.verifyPaymentConfirmation();
		paymentConfirmationPage.navigateToHomePage();
	   
	}

	@Then("^user verifies the transaction history$")
	public void user_verifies_the_transaction_history() throws Throwable {
		homePage.navigateTopassBook();
		
	    
	}

	@Then("^user verifies the saving bucket$")
	public void user_verifies_the_saving_bucket() throws Throwable {
	    
	}
	@Given("^user verifies the saving details when user opts \"([^\"]*)\" to savig Option$")
	public void user_verifies_the_saving_details_when_user_opts_to_savig_Option(String savingOption) throws Throwable {
		if(savingOption.contains("Yes"))
		{
			transactionPage.verifiesTheSavingDetails();
		}
		paymentPage =transactionPage.getPaymentPage();
	    
	}
	
	
	@Then("^saving bucket bucker transaction \"([^\"]*)\" be updated$")
	public void saving_bucket_bucker_transaction_be_updated(String option) throws Throwable {
		homePage.navigateToGoalPage();
		goalpage=homePage.getGoalPage();
		goalpage.VerifySavings();
	    
	}

	@Given("^user should be able to view  goals listed$")
	public void user_should_be_able_to_view_goals_listed() throws Throwable {
	   
	}

	@When("^Saving bucket reaches one of the goal$")
	public void saving_bucket_reaches_one_of_the_goal() throws Throwable {
	    
	}

	@Then("^user should receive a notification$")
	public void user_should_receive_a_notification() throws Throwable {
	    
	}
	
	@After
	public void takescreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
		try {
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		} catch (Exception e) {
			scenario.write("Unable to take screenshot<br/>");
		}
		}
	}
	
	public Properties getProperty() {
		Properties properties=null;
		FileInputStream fis=null;
		try {
		
		 //fis = new FileInputStream("C:\\Users\\km002\\Desktop\\SeleniumPractice\\DBSAutomationSetUP\\test\\Data\\GlobalProperties.properties");
		 fis = new FileInputStream("Data/GlobalProperties.properties");
			 
			 properties = new Properties();
			properties.load(fis);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		} 

		return properties;
	}
	

}
