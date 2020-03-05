package WEBDRIVER_BASICS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Date_picker {

	public static void main(String[] args) {

	System.setProperty("webdriver.chrome.driver", "chromedriver_v79.exe");
	WebDriver dr = new ChromeDriver();
	dr.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
	String exp_year= "May 2020";
	String exp_date="15";
	dr.findElement(By.xpath("//input[@id='datepicker']")).click();
	String act_year=dr.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
	
	while(!exp_year.equals(act_year))
	{
		dr.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		act_year=dr.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();


	}
	
	List <WebElement> rb=dr.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//child::td"));
	
	for(WebElement ele:rb)
	{
		String date=ele.getText();
		if(exp_date.equals(date))
		{
			ele.click();
		}
	}
	


		

	}

}
