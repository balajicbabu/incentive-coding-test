package gamesys.hr.raffle.cucumber.runner;

import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@Cucumber.Options(features = "src/test/resources/gamesys/hr/raffle/cucumber/features", format={"pretty", "html:target/cucumber"}, glue = "gamesys.hr.raffle.cucumber")
public class RunAllTests {

}
