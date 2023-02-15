package SeleMob;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.Request;
import org.openqa.selenium.devtools.v107.network.model.Response;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkLogActivityCentar72 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devT = driver.getDevTools();
		
		devT.createSession();
		
		devT.send(Network.enable(Optional.empty(),Optional.empty(), Optional.empty()));
		
		/*maxTotalBufferSize integer Buffer size in bytes to use when preserving network payloads (XHRs, etc). EXPERIMENTAL
maxResourceBufferSize integer Per-resource buffer size in bytes to use when preserving network payloads (XHRs, etc). EXPERIMENTAL
maxPostDataSize integer Longest post body size (in bytes) that would be included in requestWillBeSent notification
		 * */
		devT.addListener(Network.requestWillBeSent(), request ->
		
		{
			Request req = request.getRequest();
			//System.out.println(req.getUrl());
			//System.out.println(req.getHeaders());
			
			
		});
		
		
		devT.addListener(Network.responseReceived(), response ->
		{
			
			Response res =  response.getResponse();
			if(res.getStatus().toString().startsWith("4")) {
				System.out.println(res.getUrl() + "is failing with status code" + res.getStatus() );
			}
			//System.out.println(res.getUrl());
			//System.out.println(res.getStatus());
		});
		
		
		driver.manage().window().maximize();
		driver.get("http://centar72.ba/zenica");
		driver.findElement(By.cssSelector(".sadrzaj a")).click();
		driver.findElement(By.cssSelector("input[name='field_ime_prijava[und][0][value]']")).sendKeys("MaJaSam");
		//driver.findElement(By.cssSelector("div[id='edit-actions']")).click();
		
		
		
		
		// TODO Auto-generated method stub

	}

}
