package org.testing.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/org/testing/features",
        glue = "org.testing.steps",
        plugin = {"pretty", "json:target/cucumber-report.json"},
        monochrome = true
)
public class CucumberTestRunner {
}
