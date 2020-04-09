package com.savingspare;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestEnvironmnet {
	
	
private Scenario scenario;
private WebDriver driver;
private Properties prop;



public TestEnvironmnet(Properties properties) {
	this.prop=properties;
}




public WebDriver getdriver()
{
	String browserName=this.prop.getProperty("browser.name");
	 //System.setProperty("webdriver.chrome.driver", "C:/Users/km002/Desktop/SeleniumPractice/drivers/chromedriver_win32/chromedriver.exe");
	if(browserName.equals("chrome"))
	{
	System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver/chromedriver.exe");
	  this.driver= new ChromeDriver();
	  this.driver.manage().window().maximize();
	} else if(browserName.equals("iPhone"))
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "iPHone");
		cap.setCapability("udid", "5f3ff287d240");
		cap.setCapability("platformName", "iOS");
		cap.setCapability("platformVersion", "11.0");
		cap.setCapability("appPackage", "com.savingusingSphare");
		cap.setCapability("appActivity", "com.savingusingSpahre.Main");
		cap.setCapability("noReset", "true");
		//cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\km002\\Desktop\\SeleniumPractice\\drivers\\selendroid-test-app-0.17.0.apk");
		try {
			driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
				//AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
		
	
	return this.driver;
}
/*@After
public void takescreenshot(Scenario scenario)
{
	System.out.println("after after");
	try {
		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");
	} catch (Exception e) {
		scenario.write("Unable to take screenshot<br/>");
	}
}*/


public void setScenario (Scenario scenario)
{
	this.scenario=scenario;
}
public Scenario getScenario ()
{
	return scenario;

}

}
