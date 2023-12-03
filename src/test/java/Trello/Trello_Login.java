package Trello;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Trello_Login 
{
	WebDriver driver;
	@BeforeMethod
	public void Setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://trello.com/en/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.manage().window().maximize();

	}
	@Test
	public void Trello_login() throws InterruptedException 
	{
		
		WebElement email = driver.findElement(By.id("user"));
		email.sendKeys("ankushmhala2@gmail.com");
		Thread.sleep(4000);
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		Thread.sleep(4000);

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Ankush123@");
		Thread.sleep(4000);

		WebElement login_in = driver.findElement(By.xpath("//span[text()='Log in']"));
		login_in.click();	
		Thread.sleep(4000);

		WebElement new_board = driver.findElement(By.xpath("//span[text()='Create new board']"));
		new_board.click();
		Thread.sleep(4000);

		WebElement board_title = driver.findElement(By.xpath("//input[@type='text']"));
		board_title.sendKeys("Ankush_Board");

		WebElement create = driver.findElement(By.xpath("//button[text()='Create']"));
		create.click();
		Thread.sleep(5000);

		WebElement enter_List1 = driver.findElement(By.xpath("//input[@name='name']"));
		enter_List1.sendKeys("List A");
		Thread.sleep(5000);
		WebElement add_list1 = driver.findElement(By.xpath("//input[@value=\"Add list\"]"));
		add_list1.click();	
		WebElement add_card1 = driver.findElement(By.xpath("(//span[text()='Add a card'])[1]"));
		add_card1.click();		
		WebElement card_x= driver.findElement(By.xpath("(//textarea[@class='list-card-composer-textarea js-card-title'])"));
		card_x.sendKeys("x");// x coordinate
		Thread.sleep(4000);	

		WebElement enter_List2 = driver.findElement(By.xpath("//input[@name='name']"));
		enter_List2.sendKeys("List B");
		Thread.sleep(4000);
		WebElement add_list2 = driver.findElement(By.xpath("//input[@value=\"Add list\"]"));
		add_list2.click();	
		WebElement add_card2 = driver.findElement(By.xpath("(//span[text()='Add a card'])[2]"));
		add_card2.click();
		WebElement card_y= driver.findElement(By.xpath("(//textarea[@class='list-card-composer-textarea js-card-title'])"));
		card_y.sendKeys("y");// y coordinate
		Thread.sleep(3000);	

		driver.findElement(By.xpath("//span[contains(@class,'p6o')]")).click();
		Thread.sleep(3000);
		WebElement logout= driver.findElement(By.xpath("//span[text()='Log out']"));
		logout.click();	

	}
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}

}
