package SeleMob;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CdpCommandTest {

	public static void main(String[] args) throws InterruptedException {
		
		
		//https://chromedevtools.github.io/devtools-protocol/tot/Network/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		
		DevTools devT = driver.getDevTools();
		
		devT.createSession();
		
		Map deviceMataric = new HashMap();
		deviceMataric.put("width",600 );
		deviceMataric.put("height", 1000);
		deviceMataric.put("deviceScaleFactor", 50);
		deviceMataric.put("mobile", true);
		
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMataric);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		
		driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("div ul:nth-child(1) li:nth-child(2)")).click();
		
		Thread.sleep(5000);
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
