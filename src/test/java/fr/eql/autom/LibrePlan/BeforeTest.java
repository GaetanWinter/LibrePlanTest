package fr.eql.autom.LibrePlan;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BeforeTest {
	WebDriver driver;
	String driverSQL = "org.postgresql.Driver";
	String jdbcURL = "jdbc:postgresql://localhost/libreplan";
	String user = "libreplan";
	String password = "libreplan";
	
	@Before
	public void setup() {
		
		//Choix du navigateur à utiliser pour les tests
		System.setProperty("navigateur", "chrome");
		
		///Set Up du navigateur
		String nav = System.getProperty("navigateur");
		
		//nav = "chrome";				
		if(nav.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:/projet3/webdriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		//nav = "internet explorer";				
		if(nav.equals("ie")) {
			System.setProperty("webdriver.ie.driver","C:/projet3/webdriver/IEDriverServer.exe");
		    driver = new InternetExplorerDriver();
		}
		
		if(nav.equals("firefox")) {
			//Sélection de firefox comme navigateur	

			System.setProperty("webdriver.gecko.driver", "C:/projet3/webdriver/geckodriver.exe");	
			FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
			options.addPreference("browser.tabs.remote.autostart", false);
			driver = new FirefoxDriver(options);
		}
		

		driver.get("http://localhost:8084/libreplan/common/layout/login.zul");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

}
