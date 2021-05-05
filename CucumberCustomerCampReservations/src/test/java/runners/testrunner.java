package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;*/

@RunWith(Cucumber.class) 
@CucumberOptions(
		features = "./Features/Login.feature",
		//	format ={"pretty", "html:target/cucumber"},
		glue = {"stepdefs"},
		tags = "@test1"
		)

		
public class testrunner {
	
}
