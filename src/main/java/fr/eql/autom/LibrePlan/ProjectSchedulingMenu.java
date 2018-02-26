package fr.eql.autom.LibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectSchedulingMenu extends ProjectSchedulingPage {
	public ProjectSchedulingMenu(WebDriver driver) {
		super(driver);
	}
	
	
	public PopupTaskPage clickResourcesAllocation(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='"+prefixe()+"a30-a']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='z-menu-popup z-menu-popup-shadow']/ul/li[5]//a"))).click();
		//div[4]/ul/li[5]/div/div/div/a
		return PageFactory.initElements(driver, PopupTaskPage.class);
	
	}
	
	
	

			
		

	
}
