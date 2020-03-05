package WEBDRIVER_BASICS;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class date_picker_redbus_excel {
	public String getexcel() {
		File f=new File("C:\\Users\\BLTuser.BLT0191\\software\\demo2.xlsx");
		String g= null;
		
		
		try {
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet("Sheet1");
			XSSFRow row = sh.getRow(0);
			XSSFCell cell = row.getCell(0);
						
			
			  g = cell.getStringCellValue();
			 
			
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return g;
		}
		
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver_v79.exe");
		WebDriver dr = new ChromeDriver();
		dr.get("https://www.redbus.in/?gclid=EAIaIQobChMItc3h5rL25wIVhhiPCh2awwcEEAAYASAAEgKnifD_BwE");		
		
		try {
			Thread.sleep(5000);
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	
		
		
		

		date_picker_redbus_excel v=new date_picker_redbus_excel();
		String exp_data=v.getexcel();
		System.out.println(exp_data);
		int l=exp_data.length();
		String d=exp_data.substring(1, l=l-1);
		System.out.println(d);
		
		
        String[] arrOfStr = d.split("-", 3); 
  
        for (String a : arrOfStr) 
            System.out.println(a); 
        
          String exp_date=arrOfStr[0];
          String exp_month=arrOfStr[1];
          String exp_year=arrOfStr[2];
          String p=exp_month+" ";
          String q=p+exp_year;
          
          dr.findElement(By.xpath("//div[@class='fl search-box date-box gtm-onwardCalendar']")).click();
      	String act_year=dr.findElement(By.xpath("//div[@class='rb-calendar']/table/tbody/tr[1]/td[2]")).getText();
      	
      	while(!act_year.equals(q))      	{
      		dr.findElement(By.xpath("//div[@class='rb-calendar']/table/tbody/tr[1]/td[3]")).click();
      		act_year=dr.findElement(By.xpath("//div[@class='rb-calendar']/table/tbody/tr[1]/td[2]")).getText();


      	}
      	
      	List <WebElement> rb=dr.findElements(By.xpath("//table[@class='rb-monthTable first last']//child::td"));
      	
      	for(WebElement el:rb)
      	{
      		String date=el.getText();
      		if(exp_date.equals(date))
      		{
      			el.click();
      		}


	}
	

}}
