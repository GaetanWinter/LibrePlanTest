package fr.eql.autom.LibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectPage extends PlanProjectCommonPage {
	public ProjectPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (how=How.XPATH, using="//td[.='Project Scheduling']")
	public WebElement projectScheduling;
	
	@FindBy (how=How.XPATH, using="//td[.='OK']")
	public WebElement boutonOK;
	

	
	public ProjectSchedulingPage clickProjectScheduling(){
		this.projectScheduling.click();
		return PageFactory.initElements(driver, ProjectSchedulingPage.class);
	}
	
	public ResourcesLoadPage clickResourcesLoad(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement resources = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='Resources Load']")));
		resources.click();
		return PageFactory.initElements(driver, ResourcesLoadPage.class);
	}
	
	public void clickSave(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/libreplan/common/img/ico_save.png']"))).click();
	}
	
	public void clickCancel(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='"+prefixe()+"s40-box']/tbody/tr[2]/td[2]/img"))).click();
	}
	
	public ProjectsPlanningPage clickCancelYes(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='OK']"))).click();
		return PageFactory.initElements(driver, ProjectsPlanningPage.class);
	}
	
	public void clickCancelNo(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='"+prefixe()+"z4-box']/tbody/tr[2]/td[2]"))).click();
	}
	

	
	public String prefixeBis(){
		WebElement bouton = driver.findElement(By.xpath("//body/div"));
		String idBouton = bouton.getAttribute("id");
		String prefix = idBouton.substring(0, 4);
		return prefix;
	}
	
	public void clickOkPopup(){
		this.boutonOK.click();
	}
	
}
