package fr.eql.autom.LibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProjectSchedulingPage extends ProjectPage {
	public ProjectSchedulingPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using="//frame[@id='zk_hfr_']")
	public WebElement mainFrame;
	
	@FindBy(how=How.XPATH, using="//frame[@id='simile-ajax-history']")
	public WebElement rightClickFrame;
	
	
	public ProjectSchedulingMenu rightClickProjectslist(){
//		WebElement blueBox = driver.findElement(By.xpath("//div[@id='"+prefixe()+"430']"));
		WebElement blueBox = driver.findElement(By.xpath(".//div[@id='listtasks']/div[1]/div[1]"));

		//div[1]/div/div[5]/div[2]/div/div/div/div[2]/div/div/span/div/div[1]/div/span/div[1]/div[2]/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div/div[1]/div/div/div[1]/div[1]
		Actions action = new Actions(driver).contextClick(blueBox);
		action.build().perform();
		return PageFactory.initElements(driver, ProjectSchedulingMenu.class);
	}
	
	public void menuDeroulantVue(String periode) {
		WebElement menu = driver.findElement(By.xpath(".//option[text()='Year']/ancestor::select"));
				Select select = new Select(menu);
				select.selectByVisibleText(periode);

		
	}
	

	
	
	

			
		

	
}
