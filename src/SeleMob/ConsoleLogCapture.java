package SeleMob;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConsoleLogCapture {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("p [routerlink='/products']")).click();
		driver.findElement(By.cssSelector(".row:last-child .mx-auto ul div:first-child li a")).click();
		driver.findElement(By.cssSelector("button:first-child")).click();
		driver.findElement(By.cssSelector(".nav-item:last-child")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
	LogEntries enteries =	driver.manage().logs().get(LogType.BROWSER);
		
	List<LogEntry> logs =enteries.getAll();
	//for loop za savaki loop stora u e po jedan log 
	for (LogEntry e :logs )
	{
		
		System.out.println(e.getMessage());
	}
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
