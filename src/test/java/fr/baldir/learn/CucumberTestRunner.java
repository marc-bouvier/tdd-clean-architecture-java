package fr.baldir.learn;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = { "html:target/report/cucumber-report.html", "pretty"},
        features = "classpath:features",
        glue = "fr.baldir.learn")
@RunWith( Cucumber.class )
public class CucumberTestRunner {

}
