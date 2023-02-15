package SeleMob;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.fetch.Fetch;
import org.openqa.selenium.devtools.v107.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v107.network.model.ErrorReason;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkFailRequest {

	public static void main(String[] args)   {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		DevTools devT = driver.getDevTools();

		devT.createSession();
		// java.util.Optional<java.lang.String> urlPattern
		Optional<List<RequestPattern>> patterns = Optional
				.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty())));
		devT.send(Fetch.enable(patterns, Optional.empty()));

		devT.addListener(Fetch.requestPaused(), request -> {
			devT.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
		});

		

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".jumbotron button")).click();
		
		
		// TODO Auto-generated method stub

	}

}
