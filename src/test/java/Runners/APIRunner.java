package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features/",
        glue = "APISteps",
        dryRun = false,
        tags = "@API",
        monochrome = true,
        plugin = {"pretty"}




)
public class APIRunner {
}
