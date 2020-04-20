package CaseStudy3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class StepDef3 {
	WebDriver driver;
	List<WebElement> links;
	int linkscount;

	@Given("^open online testmeapp and login$")
	public void open_online_testmeapp_and_login() throws Throwable {
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

	@When("^enter the item \"([^\"]*)\" and click on findDetails$")
	public void enter_the_item_and_click_on_findDetails(String arg1) throws Throwable {
		driver.findElement(By.id("myInput")).sendKeys(arg1);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(10000);
	}

	@When("^he is able to see his product$")
	public void he_is_able_to_see_his_product() throws Throwable {
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Search"));
	}

	@Then("^click on cart$")
	public void click_on_cart() throws Throwable {
		driver.findElement(By.linkText("Add to cart")).click();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();

	}

	@Then("^Select bank and enter bank details$")
	public void select_bank_and_enter_bank_details() throws Throwable {
		driver.findElement(By.xpath("//a[@href=\"checkout.htm\"]")).click();
		driver.findElement(By.xpath("//textarea[@id=\"add1\"]")).clear();
		driver.findElement(By.xpath("//textarea[@id=\"add1\"]")).sendKeys("hyderabd");
		driver.findElement(By.xpath("//input[@value=\"Proceed to Pay\"]")).click();
		System.out.println("Payment is done");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^click on payment$")
	public void click_on_payment() throws Throwable {
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div/label")).click();
		driver.findElement(By.xpath("//a[@onclick=\"radioValue()\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("123457");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Pass@457");
		driver.findElement(By.xpath("//input[@value=\"LOGIN\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input"))
				.sendKeys("Trans@457");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		WebElement expected = driver.findElement(By.xpath("html/body/b/section/div/div/div/div[2]/p"));
		Assert.assertEquals("Your order has been confirmed", expected.getText());
		Assert.assertEquals(true, true);
		driver.close();

	}

}
