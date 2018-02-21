package fr.eql.autom.LibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupTaskPage {
protected final WebDriver driver;
	
	public PopupTaskPage(WebDriver driver){
		super();
		this.driver = driver;
	}

	public void selectAllocations(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[5]/div[3]/div/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[2]/fieldset/div/table/tbody/tr/td/table/tbody/tr/td[1]/span/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[3]/span/i/i"))).click();
		
		
	}
	
		public void selectAllocation(){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[6]/div/table/tbody/tr/td/table/tbody/tr/td/div/div[3]/table/tbody[2]/tr[2]/td[1]/div"))).click();
		}
		
		public void addAllocation(){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='Add']"))).click();
			//div[5]/div[3]/div/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[2]/fieldset/div/table/tbody/tr/td/table/tbody/tr/td[3]/span/table/tbody/tr[2]/td[2]]
			
		}
		
		public ProjectSchedulingPage validateAllocation(){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[5]/div[3]/div/div/div/table[2]/tbody/tr/td/table/tbody/tr/td[1]/span/table/tbody/tr[2]/td[2]"))).click();
			return PageFactory.initElements(driver, ProjectSchedulingPage.class);
		}
}
