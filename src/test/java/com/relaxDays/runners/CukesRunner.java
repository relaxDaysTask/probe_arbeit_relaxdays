package com.relaxDays.runners;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json","html:target/html-report"},
        features = "src/test/resources/features",
        glue = "com/relaxDays/stepDefinitions",
        tags = "@wip"
)

public class CukesRunner {
}
