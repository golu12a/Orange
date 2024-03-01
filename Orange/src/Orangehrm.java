

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Orangehrm {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hp\\OneDrive\\Desktop\\Selenium Java Training\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
        Thread.sleep(2000);
		WebElement Username = driver.findElement(By.xpath("//input[@name='username']"));
		Username.sendKeys("Admin");
		Thread.sleep(2000);
		WebElement Password = driver.findElement(By.xpath("//input[@name='password']"));
		Password.sendKeys("admin123");
		WebElement LogIn = driver.findElement(By.xpath("//button[@type='submit']"));
		LogIn.click();
		System.out.println("Succesfully Logged In");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();
		Thread.sleep(2000);
		List<WebElement> dropdown = driver.findElements(By.xpath("//ul[@class='oxd-dropdown-menu']/li"));
		String expResult = "Logout";
		for(int i =0; i<dropdown.size(); i++) {
			if(dropdown.get(i).getText().equalsIgnoreCase(expResult)) {
				dropdown.get(i).click();
			}
		}
		System.out.println("Successfully Logged Out");
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();

	}

}
