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

public class PlanPage extends PlanProjectCommonPage {
	
	public PlanPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (how=How.XPATH, using="//td[@class='z-button-cm']")
	public WebElement projectAdd;
	
	@FindBy (how=How.XPATH, using="//td[.='Projects List']")
	public WebElement projectsList;
	
	@FindBy (how=How.XPATH, using="//td[.='Projects Planning']")
	public WebElement projectsPlanning;
	
	@FindBy (how=How.XPATH, using="//td[.='Resources Load']")
	public WebElement resourcesLoad;
	
	public PopupProjectAdd clickProjectAdd(){
		this.projectAdd.click();
		return PageFactory.initElements(driver, PopupProjectAdd.class);
	}
		
		public ProjectsListPage clickProjectslist(){
			this.projectsList.click();
			return PageFactory.initElements(driver, ProjectsListPage.class);
	}
		
		public ProjectsPlanningPage clickProjectsPlanning(){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='Projects Planning']"))).click();
			//this.projectsPlanning.click();
			return PageFactory.initElements(driver, ProjectsPlanningPage.class);
		}

		public ResourcesLoadPage clickResourcesLoad(){
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='Resources Load']"))).click();
			//this.projectsPlanning.click();
			return PageFactory.initElements(driver, ResourcesLoadPage.class);
	}
		
}
