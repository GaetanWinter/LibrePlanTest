package fr.eql.autom.LibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProjectsListPage extends PlanPage {
	
	public ProjectsListPage(WebDriver driver) {
		super(driver);
	}
	


	public ProjectDetailsPage selectionProject(String nomProjet){
		driver.findElement(By.xpath(".//span[text()='"+nomProjet+"']")).click();
		return PageFactory.initElements(driver, ProjectDetailsPage.class);
	}
	
	

	
}
