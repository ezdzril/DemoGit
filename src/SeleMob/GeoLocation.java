package SeleMob;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeoLocation {

	public static void main(String[] args) throws InterruptedException {

		// https://chromedevtools.github.io/devtools-protocol/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// 40 18
		// Emulation.setGeolocationOverride
		DevTools devT = driver.getDevTools();
		devT.createSession();

		Map<String, Object> GeoMap = new HashMap<String, Object>();
		GeoMap.put("latitude", 60.1011);
		GeoMap.put("longitude", 24.5618);
		GeoMap.put("accuracy", 6);
		/*
		 * latitude number
		 * 
		 * longitude number
		 * 
		 * accuracy number
		 * 
		 */

		// LC20lb

		driver.executeCdpCommand("Emulation.setGeolocationOverride", GeoMap);
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
		// driver.findElement(By.xpath("//h3[contains(text(),'Netflix Bosnia &
		// Herzegovina - Watch TV Shows Onli')]")).click();
		driver.findElement(By.cssSelector(".LC20lb:first-of-type")).click();
		String tittle = driver.findElement(By.cssSelector("h1[data-uia='hero-title']")).getText();

		System.out.println(tittle);

		// TODO Auto-generated method stub

	}

}
