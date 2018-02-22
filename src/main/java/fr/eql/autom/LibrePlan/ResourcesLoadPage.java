package fr.eql.autom.LibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResourcesLoadPage extends ProjectPage {
	public ResourcesLoadPage(WebDriver driver) {
		super(driver);
	}
	
	
	public PopupTaskPage selectResource(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[contains(text(),' ')]/ancestor::div[1]/preceding-sibling::span"))).click();
		return PageFactory.initElements(driver, PopupTaskPage.class);
		
	
	}
}
