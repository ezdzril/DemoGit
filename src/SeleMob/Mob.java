package SeleMob;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v109.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mob {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devT = driver.getDevTools();
		
		devT.createSession();
		
		///send comands to CDP
		devT.send(Emulation.setDeviceMetricsOverride(600,1000 , 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		
		driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("div ul:nth-child(1) li:nth-child(2)")).click();
		
		Thread.sleep(5000);
		
		driver.close();
		
		//Network.getRequestPostData
		
		Network.getRequestPostData(null);
		
		
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
