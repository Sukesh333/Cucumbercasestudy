package CaseStudy4;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@tag4",plugin= {"json:target/report4.json"})
public class Runner4 {

}