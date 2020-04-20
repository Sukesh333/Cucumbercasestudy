package CaseStudy1;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDef1 {
	WebDriver driver;
	List<WebElement> links;
	int linkscount;

	@Given("^user should open signup page$")
	public void user_should_open_signup_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.findElement(By.linkText("SignUp")).click();
	}

	@When("^user enters all details$")
	public void user_enters_all_details() throws Throwable {
		driver.findElement(By.id("userName")).sendKeys("Sukesh");
		driver.findElement(By.id("firstName")).sendKeys("Sai");
		driver.findElement(By.id("lastName")).sendKeys("Sukesh");
		driver.findElement(By.id("password")).sendKeys("1234567890");
		driver.findElement(By.id("pass_confirmation")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		driver.findElement(By.id("emailAddress")).sendKeys("sukesh@gmail.com");
		driver.findElement(By.id("mobileNumber")).sendKeys("9087654321");
		driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
		WebElement month = driver.findElement(By.className("ui-datepicker-month"));
		Select s1 = new Select(month);
		s1.selectByVisibleText("Jan");
		WebElement year = driver.findElement(By.className("ui-datepicker-year"));
		Select s2 = new Select(year);
		s2.selectByVisibleText("1998");
		driver.findElement(By.linkText("3")).click();
		driver.findElement(By.id("address")).sendKeys("Nellore,AndhraPradesh");
		Select sc = new Select(driver.findElement(By.id("securityQuestion")));
		sc.selectByVisibleText("What is your Pet Name?");
		driver.findElement(By.id("answer")).sendKeys("Suke");
	}

	@Then("^click on registaration able to see homepage$")
	public void click_on_registaration_able_to_see_homepage() throws Throwable {
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Login");
		driver.close();
	}
}
