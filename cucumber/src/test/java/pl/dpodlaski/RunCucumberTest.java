package pl.dpodlaski;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, tags = "@ToTest", features = "src/test/resources")
public class RunCucumberTest {

}
