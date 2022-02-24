package Mindtree.seleniumProject;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class milestone {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.indiabookstore.net/"); 
		driver.manage().window().maximize(); 
		System.out.println(driver.getTitle());
		
		
		
		WebElement search= driver.findElement(By.id("searchBox")); 
		search.sendKeys("Selenium",Keys.ENTER);
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		WebElement book=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src=\"https://m.media-amazon.com/images/I/51Oa0cZRm6L._SL160_.jpg\"]")));
		book.click();
		
		
		WebElement val = driver.findElement(By.xpath("//div[@class=\"isbnContainer\"]"));
		String value1 = val.getText();
		System.out.println(value1);
		
		WebElement direct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://www.indiabookstore.net/redirect?url=https%3A%2F%2Fwww.amazon.in%2Fdp%2F1849515743%3Ftag%3Dindi08-21%26linkCode%3Dosi%26th%3D1%26psc%3D1&source=buyLinkModal&name=Amazon&ibsId=9781849515740&urlDisplay=https%3A%2F%2Fwww.amazon.in%2Fdp%2F1849515743%3Ftag%3Dindi08-21%26linkCode%3Dosi%26th%3D1%26psc%3D1&sellingPrice=2519&storeId=17&isbn13=9781849515740&rank=1&minPrice=1019&storesCount=3&searchId=\']")));
		direct.click();
        
		
		ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles()); 
		driver.switchTo().window(tabs.get(1));
		
		WebElement isbn=driver.findElement(By.xpath("//*[@id=\"detailBullets_feature_div\"]/ul/li[5]/span/span[2]"));
		String isbn1=isbn.getText();
		System.out.println(isbn1);
		
		if(isbn1.indexOf(value1)!=-1)
		{
			System.out.println("Book Available"); 
			} 
		else
		{ 
			System.out.println("Not Available"); 
			} 

		//span[@class="a-size-base a-color-price a-color-price"]
		WebElement p1=driver.findElement(By.xpath("//span[@class=\"a-size-base a-color-price a-color-price\"]"));
		String s1=p1.getText();
		System.out.println(s1);
		
		WebElement p2=driver.findElement(By.xpath("//span[@id=\"price\"]"));
		String s2=p2.getText();
		System.out.println(s2);

		if(s2.indexOf(s1)!=-1)
		{
			System.out.println("Matched"); 
			} 
		else
		{ 
			System.out.println("Not Matched"); 
			} 
		
		
		driver.quit();
		
	}

}
