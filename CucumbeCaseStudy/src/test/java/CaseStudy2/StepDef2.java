package CaseStudy2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDef2 {
	WebDriver driver;
	List<WebElement> links;
	int linkscount;
	
	@Given("^open online testmeapp$")
	public void open_online_testmeapp() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
		driver.manage().window().maximize();
		Thread.sleep(10000);
	   driver.findElement(By.linkText("SignIn")).click();
	}

	@When("^lalitha gives valid username and valid password \"([^\"]*)\" \"([^\"]*)\"$")
	public void lalitha_gives_valid_username_and_valid_password(String arg1, String arg2) throws Throwable {

	   driver.findElement(By.id("userName")).sendKeys(arg1);
	   driver.findElement(By.id("password")).sendKeys(arg2);
	   driver.findElement(By.name("Login")).click();
	}

	@Then("^he is able to see his name and title is home page$")
	public void he_is_able_to_see_his_name_and_title_is_home_page() throws Throwable {
	String act=driver.findElement(By.cssSelector("ul.nav")).getText();
	        String exp="Hi, Lalitha SignOut";
	        Assert.assertEquals(exp,act);
	        Assert.assertEquals(driver.getTitle(),"Home");
	        System.out.println("Test is passed");
	        driver.findElement(By.linkText("SignOut")).click();
	        driver.close();
	}
}