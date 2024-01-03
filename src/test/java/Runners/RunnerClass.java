package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "Steps",
        dryRun = false,
        tags = "@experience",
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json", "rerun:target/failed.txt"}

)

public class RunnerClass {
}
