package fr.eql.autom.LibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderPage {

protected final WebDriver driver;
	
	public HeaderPage(WebDriver driver){
	super();
	this.driver = driver;
	}
	
	@FindBy(how=How.XPATH, using="//td[@class='z-menu-inner-m']/div/button")
	WebElement resourcesHeader;
	
	@FindBy(how=How.XPATH, using="div[@class='z-menu-item-cm']/a")
	WebElement resourcesWorkersHeader;
	
	public void ResourcesWorkersHeader(){
		Actions mouseHover = new Actions(driver);
		mouseHover.moveToElement(resourcesHeader).moveToElement(resourcesWorkersHeader).click().build().perform();
	}
	
	public String prefixe(){
		WebElement bouton = driver.findElement(By.xpath("//body/div"));
		String idBouton = bouton.getAttribute("id");
		String prefix = idBouton.substring(0, 4);
		return prefix;
	}

}
