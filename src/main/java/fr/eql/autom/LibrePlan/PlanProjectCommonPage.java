package fr.eql.autom.LibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlanProjectCommonPage extends HeaderPage {
	
	public PlanProjectCommonPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy (how=How.XPATH, using="//td[.='Resources Load']")
	public WebElement resourcesLoad;
	
		public ResourcesLoadPage clickResourcesLoad(){
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("z-modal-mask")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='Resources Load']"))).click();
			//this.projectsPlanning.click();
			return PageFactory.initElements(driver, ResourcesLoadPage.class);
	}
		
}
