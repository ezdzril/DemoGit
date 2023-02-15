package SeleMob;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import org.openqa.selenium.devtools.v109.network.Network;
import org.openqa.selenium.devtools.v109.network.model.ConnectionType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkSpeed {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devT = driver.getDevTools();
		
		devT.createSession();
		
		devT.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devT.send(Network.emulateNetworkConditions(false, 3000, 20000, 10000, Optional.of(ConnectionType.ETHERNET)));
		
		//devT.send(Network.emulateNetworkConditions(true, 3000, 20000, 10000, Optional.of(ConnectionType.ETHERNET)));
		devT.addListener(Network.loadingFailed(), loadingFaild ->
		{
			
			System.out.println(loadingFaild.getErrorText());
			System.out.println(loadingFaild.getTimestamp());
		});
		
		long startTime = System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".jumbotron button")).click();
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime-startTime); //15064 sa networkom usporenja  //1867 bez nettwok usporenja
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
