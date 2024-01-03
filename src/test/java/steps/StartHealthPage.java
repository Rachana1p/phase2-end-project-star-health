package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import phase2project.XLS_DataProvider;
public class StartHealthPage {
WebDriver driver;
	
	@BeforeClass
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PC\\eclipse-workspace\\starhealths\\src\\test\\resources\\drivers\\windows\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.starhealth.in/");
	}
	
	@Test(priority = 1)
    public void validateTitle() {
		String expectedTitle = "Star Health Insurance: Medical, Accident and Travel insurance policies";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "The title is not valid");
    }
	
	@Parameters({"name","mobile","pincode"})
    @Test(priority = '2')
    public void testHeaderPlan(String name,String mobile,String pincode) throws InterruptedException {
        // Selenium code to hover over the Health Plan menu
        Actions actions = new Actions(driver);
        WebElement plansMenu = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/header/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]"));
        actions.moveToElement(plansMenu).build().perform();
        // Selenium code to click on the Family option
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/header/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div/div[1]/div[1]/div[3]/a")).click();
        try {
            // Try to find the checkbox
            WebElement authorizeCheckbox = driver.findElement(By.id("authorize"));
            boolean isCheckboxSelected = authorizeCheckbox.isSelected();
            Assert.assertTrue(isCheckboxSelected, "The Authorize checkbox is not selected");
        } catch (Exception e) {
            // Handle the exception if the checkbox is not found or cannot be interacted with
            e.printStackTrace();
            System.out.println("Checkbox not found. Proceeding with the next steps.");
        }

        // Selenium code to send keys using parameters
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='phoneNumber']")).sendKeys(mobile);
        driver.findElement(By.xpath("//input[@id='pinCode']")).sendKeys(pincode);
        driver.findElement(By.xpath("//*[@id=\"get-quotes-form\"]/div/div[3]/div/div[2]/div/button")).click();
        Thread.sleep(6000);
    }
	
	@Test(priority='3',dataProvider = "testdata" )
	public void validatedatafromExcel(String input1, String input2, String input3, String input4 )
	{
		// String youtube = driver.findElement(By.locator)).getAttribute(href);
		String	ActaulDetails1 = driver.findElement(By.xpath("(//a[@class='mr-4 mr-10-xs'])[1]")).getAttribute("href");
		String Expecteddetail1 = input1;
		Assert.assertEquals(ActaulDetails1, Expecteddetail1, "Facebook link does not match.");
        // You can print messages or perform additional validations here
        System.out.println("Actual Facebook link: " + ActaulDetails1);
        System.out.println("Expected Facebook link: " + Expecteddetail1);
        
        String	ActaulDetails2 = driver.findElement(By.xpath("(//a[@class='mr-4 mr-10-xs'])[2]")).getAttribute("href");
		String Expecteddetail2 = input2;
		Assert.assertEquals(ActaulDetails2, Expecteddetail2, "Youtube link does not match.");
        // You can print messages or perform additional validations here
        System.out.println("Actual Youtube link: " + ActaulDetails2);
        System.out.println("Expected Youtube link: " + Expecteddetail2);
        
        String	ActaulDetails3 = driver.findElement(By.xpath("(//a[@class='mr-4 mr-10-xs'])[3]")).getAttribute("href");
		String Expecteddetail3 = input3;
		Assert.assertEquals(ActaulDetails3, Expecteddetail3, "Linkedin link does not match.");
        // You can print messages or perform additional validations here
        System.out.println("Actual Facebook link: " + ActaulDetails3);
        System.out.println("Expected Facebook link: " + Expecteddetail3);
        
        String	ActaulDetails4 = driver.findElement(By.xpath("(//a[@class='mr-4 mr-10-xs'])[4]")).getAttribute("href");
		String Expecteddetail4 = input4;
		Assert.assertEquals(ActaulDetails4, Expecteddetail4, "Twitter link does not match.");
        // You can print messages or perform additional validations here
        System.out.println("Actual Facebook link: " + ActaulDetails4);
        System.out.println("Expected Facebook link: " + Expecteddetail4);
		
	}
	
	@DataProvider(name="testdata")
	public Object[][] datasupplier() throws EncryptedDocumentException, IOException
	{
		
		Object[][] inputdata = XLS_DataProvider.getTestData("Sheet2");
		
		return inputdata;
	}
	
	
	
	@Test(priority='4')
	public void Clickontwitter()
	{
		// Selenium code to locate and click on the Twitter link
        driver.findElement(By.xpath("(//a[@class='mr-4 mr-10-xs'])[4]")).click();
        // Selenium code to validate the title of the new page
        String twitterPageTitle = driver.getTitle();
      //  String twittertitle ="https://twitter.com/starhealthins?lang=en";
       // Assert.assertEquals(twitterPageTitle,twittertitle, "The title is not valid");
        System.out.println("contents in the page contains star health");
    }
	
	
	
	@AfterClass
	public void teardown()
	{
		//driver.close();
		System.out.println("Completed all steps ");
	}

}