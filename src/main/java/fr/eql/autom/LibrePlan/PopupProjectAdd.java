package fr.eql.autom.LibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupProjectAdd {
	
protected final WebDriver driver;
	
	public PopupProjectAdd(WebDriver driver){
		super();
		this.driver = driver;
	}
	
	@FindBy(how=How.XPATH, using="//div[4]/div[3]/div/div/div/div/div[3]/table/tbody[2]/tr[1]/td[2]/div/input")
	public WebElement projectNameSpace;
	
	@FindBy(how=How.XPATH, using="/div/div/div[3]/ta//div[4]/div[3]/div/div/div/div/div[3]/table/tbody[2]/tr[3]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td[1]/input")
	public WebElement projectCodeSpace;
	
	@FindBy(how=How.XPATH, using="//div[4]/div[3]/div/div/div/div/div[3]/table/tbody[2]/tr[4]/td[2]/div/i/input")
	public WebElement projectDateBegin;
	
	@FindBy(how=How.XPATH, using="//div[4]/div[3]/div/div/div/div/div[3]/table/tbody[2]/tr[5]/td[2]/div/i/input")
	public WebElement projectDateEnd;
	
	@FindBy(how=How.XPATH, using="//div[4]/div[3]/div/div/div/div/div[3]/table/tbody[2]/tr[3]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td[3]/span/input")
	public WebElement checkBoxCode;
	
	@FindBy(how=How.XPATH, using="//td[.='Accept']")
	public WebElement accept;
	
	public String prefixe(){
		WebElement bouton = driver.findElement(By.xpath("//body/div"));
		String idBouton = bouton.getAttribute("id");
		String prefix = idBouton.substring(0, 4);
		return prefix;
	}
	
	
	public ProjectDetailsPage setProject(String projectName, String projectCode, String dateBegin, String dateEnd) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='"+prefixe()+"p7']"))).sendKeys(projectName);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='z-window-modal z-window-modal-shadow']/div[3]//div[@class='z-grid-body']/table/tbody[2]/tr[1]/td[2]/div/input"))).sendKeys(projectName);

		//projectNameSpace.sendKeys(projectName);
		//checkBoxCode.click();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='"+prefixe()+"48-real']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='z-window-modal z-window-modal-shadow']/div[3]//div[@class='z-grid-body']/table/tbody[2]/tr[3]/td[2]//span/input"))).click();

		//projectCodeSpace.sendKeys(projectCode);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='"+prefixe()+"38']"))).clear();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='"+prefixe()+"38']"))).sendKeys(projectCode);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='z-window-modal z-window-modal-shadow']/div[3]//div[@class='z-grid-body']/table/tbody[2]/tr[3]/td[2]//tbody/tr/td/input"))).clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='z-window-modal z-window-modal-shadow']/div[3]//div[@class='z-grid-body']/table/tbody[2]/tr[3]/td[2]//tbody/tr/td/input"))).sendKeys(projectCode);
		//projectDateBegin.sendKeys(dateBegin);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='"+prefixe()+"k9-real']"))).clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='z-window-modal z-window-modal-shadow']/div[3]//div[@class='z-grid-body']/table/tbody[2]/tr[4]/td[2]/div/i/input"))).clear();

		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='z-window-modal z-window-modal-shadow']/div[3]//div[@class='z-grid-body']/table/tbody[2]/tr[4]/td[2]/div/i/input"))).sendKeys(dateBegin);
		//projectDateEnd.sendKeys(dateEnd);
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='z-window-modal z-window-modal-shadow']/div[3]//div[@class='z-grid-body']/table/tbody[2]/tr[5]/td[2]/div/i/input"))).sendKeys(dateEnd);
		accept.click();
		return PageFactory.initElements(driver, ProjectDetailsPage.class);
		
	}
	
}
