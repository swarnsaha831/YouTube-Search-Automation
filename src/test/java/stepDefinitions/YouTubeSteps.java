package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Scanner;

public class YouTubeSteps {
	
	WebDriver driver;
	Scanner sc = new Scanner(System.in);
	String input;
	String finalInput;

	@Given("User opens chrome")
	public void user_opens_chrome() throws InterruptedException {
		System.out.println();
		System.out.println("Hello, please enter a YouTube search of your choice:");
		input = sc.nextLine();
		finalInput = input.replace(" ", "+");
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://www.google.com/search");
	    Thread.sleep(1750);
	}

	@Given("User is redirected to YouTube")
	public void user_is_redirected_to_you_tube() throws InterruptedException {
		driver.get("https://www.youtube.com");
	    Thread.sleep(1750);
	}

	@When("User enters the search in the search bar")
	public void user_enters_the_search_in_the_search_bar() throws InterruptedException {
		driver.findElement(By.xpath("//*[@name='search_query']")).sendKeys(input);
		Thread.sleep(1750);
	}

	@When("User clicks the search button")
	public void user_clicks_the_search_button() {
		driver.findElement(By.xpath("//*[@id='search-icon-legacy']")).click();
	}

	@Then("User is directed to all videos")
	public void user_is_directed_to_all_videos() throws InterruptedException {
		String expectedUrl = "https://www.youtube.com/results?search_query=" + finalInput; 
	    String actualUrl = driver.getCurrentUrl();
	    Assert.assertEquals(actualUrl, expectedUrl, "User is not on the expected login page URL.");
	    Thread.sleep(10000);
	    driver.quit();
	}
	
}
