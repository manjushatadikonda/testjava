package formnJson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.ous.jtoml.ParseException;

public class formjson {
	WebDriver driver=null;
	
	@BeforeClass
	public void launchurl()
	{
	WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	        driver.get("http://assignmentbucket123.s3-website.us-east-2.amazonaws.com/");
	}

	@Test(priority=0)
	public void formfilling() throws org.json.simple.parser.ParseException 
	{
		JSONParser jsonParser = new JSONParser();
        
        try {
        FileReader reader = new FileReader("C:\\Users\\saite\\eclipse-workspace\\app\\src\\test\\java\\formnJson\\user.json");
        
           
            Object obj = jsonParser.parse(reader);
         
            JSONObject eobj = (JSONObject) obj;
	WebElement FirstName=driver.findElement(By.xpath("//input[@name='firstname']"));
	FirstName.sendKeys(eobj.get("Firstname").toString());


	WebElement MiddleName=driver.findElement(By.xpath("//input[@name='middlename']"));
	MiddleName.sendKeys(eobj.get("Middlename").toString());

	
	WebElement LastName=driver.findElement(By.xpath("//input[@name='lastname']"));
	LastName.sendKeys(eobj.get("Lastname").toString());

	
	Select Course=new Select(driver.findElement(By.xpath("/html/body/form/select")));
	 Course.selectByVisibleText(eobj.get("Course").toString());
	 
	String Gender="(//input[@name='"+eobj.get("Gender").toString()+"'])";
	WebElement Gender1=driver.findElement(By.xpath(Gender));
	Gender1.click();

	WebElement Phone=driver.findElement(By.xpath("//input[@name='phone']"));
	 Phone.sendKeys(eobj.get("Phone").toString());
	 
	
	WebElement Address=driver.findElement(By.xpath("/html/body/form/textarea"));
	Address.sendKeys(eobj.get("Address").toString());

	
	WebElement Email =driver.findElement(By.xpath("//input[@name='email']"));
	Email.sendKeys(eobj.get("Email").toString());


	WebElement Pass=driver.findElement(By.xpath("//input[@name='pass']"));
	Pass.sendKeys(eobj.get("Password").toString());

	
	WebElement Repass=driver.findElement(By.xpath("//input[@name='repass']"));
	   Repass.sendKeys(eobj.get("Retypepassword").toString());
	}
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();  
	}
	}
	@Test(priority=1)
	   public void clicksubmit()
	   {
	WebElement submit=driver.findElement(By.xpath("/html/body/form/a/input"));
	   submit.click();
	   Assert.assertEquals(driver.getTitle(),"Title");
	   }



	}



