package SeleMob;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.fetch.Fetch;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {
		
		

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devT = driver.getDevTools();
		
		devT.createSession();
		
		devT.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		devT.addListener(Fetch.requestPaused(), request ->
		{
			
			if(request.getRequest().getUrl().contains("=sheety"))
			{
				String MockUrl =request.getRequest().getUrl().replace("=sheety", "=BadGuy");
				System.out.println(MockUrl);
				devT.send(Fetch.continueRequest(request.getRequestId(), Optional.of(MockUrl), Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));	
				}
			else 
			{
				devT.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));	
				
			}
		});
		
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".jumbotron button")).click();
		
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		
		
		//(request.getRequestId(),Optional.of(MockUrl), Optional.of(request.getRequest().getMethod()), Optional.empty(),Optional.empty());

		
		
		
		
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
