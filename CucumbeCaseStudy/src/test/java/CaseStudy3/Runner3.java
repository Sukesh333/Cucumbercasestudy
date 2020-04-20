package CaseStudy3;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@tag3",plugin= {"json:target/report3.json"})
public class Runner3 {

}
