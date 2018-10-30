package testNg_serviceNow;

import java.awt.RenderingHints.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WebAutomation extends BaseClass{
	
@Test(dependsOnMethods="testNg_serviceNow.CreateProblem.createProblem")	
 void checkInWeb() throws InterruptedException
	{
		ChromeDriver driver;
		Action actions;
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		driver.get("https://dev71943.service-now.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Sairam99!");
		driver.findElement(By.id("sysverb_login")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("filter"))));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[@class='sn-widget']/a"))));
		driver.findElement(By.id("filter")).click();
		driver.findElement(By.id("filter")).sendKeys("problem");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(text(),'Known Errors')]/parent::*/parent::*/parent::*/parent::*"))));
		driver.findElement(By.xpath("//div[contains(text(),'Known Errors')]/parent::*/parent::*/parent::*/parent::*/*/ancestor::li/ul/li[4]/div/ul/li/div/a")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Known Errors')]/parent::*/parent::*/parent::*/parent::*/*/ancestor::li/ul/li[4]/div/ul/li/div/a")).click();
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("list_header_search"))));
		//driver.findElement(By.className("list_header_search")).sendKeys(number);
		//driver.findElement(By.id("problem_table_header_search_control")).sendKeys(Keys.ENTER);
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='problem_table']/tbody/tr"));
		List<String> problemNumbers = null;
		for(int i=0;i<rows.size();i++)
		{
			problemNumbers.add(rows.get(i).findElement(By.xpath("/td[3]/a")).getText().trim());
			System.out.println(problemNumbers);
			
		}
		System.out.println(problemNumbers);
		
		
		
		Thread.sleep(30000);
		driver.close();
	}

}
