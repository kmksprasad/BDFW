import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

//glue={"${basedir}/stepdefs/"},
@CucumberOptions(
		features = "./features",		
		tags ={"@UATTesting"},
		plugin = {"pretty", "html:target/cucumber-htmlreport",
				
					"json:target/cucumber.jason",					
					},
						 monochrome=true)
public class RunCukesTest{
	//"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-extent/report.html"
	private TestNGCucumberRunner testNGCucumberRunner;

	
	//"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-extent"
	
	@BeforeClass(alwaysRun=true)
	public void setUpClass() throws Exception{
		
		testNGCucumberRunner= new TestNGCucumberRunner(this.getClass());
		
			}
	 	@Test(dataProvider = "features")
	    public void feature(CucumberFeatureWrapper cucumberFeature) {
	        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	 		}
	 
	    @DataProvider
	    public Object[][] features() {
	        return testNGCucumberRunner.provideFeatures();
	    	}
	 
	    @AfterClass(alwaysRun = true)
	    public void tearDownClass() throws Exception {
	        testNGCucumberRunner.finish();
	    }

	    
	
}


