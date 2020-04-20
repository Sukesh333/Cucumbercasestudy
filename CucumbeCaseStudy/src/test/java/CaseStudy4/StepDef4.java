package CaseStudy4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDef4 {
	WebDriver driver;
	List<WebElement> links;
	int linkscount;

	@Given("^Logininto TestMeapp$")
	public void logininto_TestMeapp() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.findElement(By.linkText("SignIn")).click();
		driver.findElement(By.id("userName")).sendKeys("Lalitha");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();

	}

	@Then("^he is search for a product like headphones$")
	public void he_is_search_for_a_product_like_headphones() throws Throwable {

		driver.findElement(By.id("myInput")).sendKeys("Headphone");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	@Then("^Try to proceed to payment without adding any item in the cart$")
	public void try_to_proceed_to_payment_without_adding_any_item_in_the_cart() throws Throwable {
		links = driver.findElements(By.tagName("a"));
		linkscount = links.size();
		System.out.println(linkscount);
		for (int i = 0; i < linkscount; i++) {
			System.out.println(links.get(i).getText());
		}
	}

	@When("^TestMe does not display the icon$")
	public void testme_does_not_display_the_icon() throws Throwable {
		Assert.assertFalse(links.contains("Add to Cart"));
		System.out.println("Test is pass");

	}

}

