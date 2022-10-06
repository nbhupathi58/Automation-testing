package selenium;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://divyanshu-softsuave.github.io/Test/demo.html");
		String s=driver.getWindowHandle();
		
		//switching to interview page from new tab
		driver.findElement(By.id("opentab")).click();
		Set<String> handles=driver.getWindowHandles();
		System.out.println("all window handles: "+handles+"\ninterview webpage: "+s);
		for(String handle:handles) {
			if (handle.equals(s)) driver.switchTo().window(handle);
		}
		Thread.sleep(2000);
		
		//switching to interview page from new window
		driver.findElement(By.id("openwindow")).click();
		handles.clear();
		handles=driver.getWindowHandles();
		System.out.println("all window handles: "+handles);
		Thread.sleep(2000);
		for(String handle:handles) {
			if (handle.equals(s)) driver.switchTo().window(handle);
		}
		Thread.sleep(2000);
		
		//ending webdriver session
		driver.quit();
	}

}
