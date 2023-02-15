package SeleMob;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.network.Network;

import com.google.common.collect.ImmutableList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlockNetworkRequest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		DevTools devT = driver.getDevTools();

		devT.createSession();

		devT.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devT.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.css")));
		long startTime = System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("[role*='button']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Selenium']")).click();
		driver.findElement(By.cssSelector(" .add-to-cart")).click();
		String text = driver.findElement(By.cssSelector(" .sp")).getText();
		System.out.println(text);
		long endTime = System.currentTimeMillis();
		// TODO Auto-generated method stub
		System.out.println(endTime - startTime);
	}

}
