package fr.eql.autom.LibrePlan;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectDetailsPage extends ProjectPage {
	public ProjectDetailsPage(WebDriver driver) {
		super(driver);
	}

	
	
	public void addTask(String task, String hours) {
//	driver.findElement(By.xpath("//div[1]/div/div[1]/div[2]/div/div/div/div[2]/div/div/span/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div[1]/div/span/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td[5]/input")).sendKeys(task);
	driver.findElement(By.xpath(".//span[text()='New task']/ancestor::td[1]/following-sibling::td[2]/input")).sendKeys(task);
	driver.findElement(By.xpath(".//span[text()='Hours']/ancestor::td[1]/following-sibling::td[2]/input")).sendKeys(hours);
	driver.findElement(By.xpath(".//span[text()='Hours']/ancestor::td[1]/following-sibling::td[4]//td[text()='Add']")).click();
	}
	
	public void orderTaskDown(String task) {
		driver.findElement(By.xpath(".//tbody[@class='z-treechildren']/tr[1]/td[1]")).click();
		driver.findElement(By.xpath(".//img[@src='/libreplan/common/img/ico_bajar1.png']")).click();
		
		}
	
	public void orderTaskUp(String task) {
		driver.findElement(By.xpath(".//tbody[@class='z-treechildren']/tr[3]/td[1]")).click();
		driver.findElement(By.xpath(".//img[@src='/libreplan/common/img/ico_subir1.png']")).click();
	}
	
	/*public CharSequence[] changeDate(String todayDate, int daysPlus){
		DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/DD/YY");
		DateTime datetime = formatter.parseDateTime(todayDate);
		 return datetime.plusDays(daysPlus);
		 
	}
	*/
	
	public  void setDateTask1(String date){
		driver.findElement(By.xpath("//div[1]/div[1]/div/div[2]/div/div/div/div[2]/div/div/span/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div[1]/div/span/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td/div/div[3]/table/tbody[2]/tr[3]/td[6]/div/table/tbody/tr/td/table/tbody/tr/td/input")).sendKeys(date);
		
		
	}
	
	public  void setDateTask2(String date){
		driver.findElement(By.xpath("//div[1]/div[1]/div/div[2]/div/div/div/div[2]/div/div/span/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div[1]/div/span/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td/div/div[3]/table/tbody[2]/tr[1]/td[6]/div/table/tbody/tr/td/table/tbody/tr/td/input")).sendKeys(date);
		
	}
	
	public  void setDeadline1(String date){
		driver.findElement(By.xpath("//div[1]/div[1]/div/div[2]/div/div/div/div[2]/div/div/span/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div[1]/div/span/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td/div/div[3]/table/tbody[2]/tr[2]/td[7]/div/table/tbody/tr/td/table/tbody/tr/td/input")).sendKeys(date);
		
		
	}
	
	public  void setDeadline2(String date){
		driver.findElement(By.xpath("//div[1]/div[1]/div/div[2]/div/div/div/div[2]/div/div/span/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div[1]/div/span/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td/div/div[3]/table/tbody[2]/tr[4]/td[7]/div/table/tbody/tr/td/table/tbody/tr/td/input")).sendKeys(date);
		
	}	
	
	public  void setCodeTask1(String code){
		driver.findElement(By.xpath("//input[@id='"+prefixe()+"4i']")).sendKeys(code);
				//div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div/span/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div[1]/div/span/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td/div/div[3]/table/tbody[2]/tr[3]/td[2]/div/input
	}
	
	public  void setCodeTask2(String code){
		driver.findElement(By.xpath("//input[@id='"+prefixe()+"28']")).sendKeys(code);
		//div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div/span/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div[1]/div/span/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td/div/div[3]/table/tbody[2]/tr[2]/td[2]/div/input
	}
	
	public  void setCodeTask3(String code){
		driver.findElement(By.xpath("//input[@id='"+prefixe()+"k7']")).sendKeys(code);
		//div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div/span/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div[1]/div/span/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td/div/div[3]/table/tbody[2]/tr/td[2]/div/input
	}
	
	public  void setCodeTask4(String code){
		driver.findElement(By.xpath("//input[@id='"+prefixe()+"0k']")).sendKeys(code);
		//div[1]/div/div[2]/div[2]/div/div/div/div[2]/div/div/span/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div[1]/div/span/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td/div/div[3]/table/tbody[2]/tr[4]/td[2]/div/input
	}
}
