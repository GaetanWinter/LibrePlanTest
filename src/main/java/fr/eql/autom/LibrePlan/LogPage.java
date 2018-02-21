package fr.eql.autom.LibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LogPage {

	protected final WebDriver driver;
	
	public LogPage(WebDriver driver){
		super();
		this.driver = driver;
	}
	
	@FindBy(how=How.ID, using="textfield")
	public WebElement username;
	
	@FindBy(how=How.ID, using="textfield2")
	public WebElement password;
	
	@FindBy(how=How.ID, using="button")
	public WebElement btnLogin;

	public ProjectsPlanningPage connexion(String nom, String mdp){
	username.clear();
	username.sendKeys(nom);
	password.clear();
	password.sendKeys(mdp);
	btnLogin.click();
	return PageFactory.initElements(driver, ProjectsPlanningPage.class);
	}

}
