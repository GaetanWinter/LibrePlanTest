package fr.eql.autom.LibrePlan;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;


//Cas de test Pro_TA_01 : Créer un projet
public class ProTa01 {

	WebDriver driver;
	String driverSQL = "org.postgresql.Driver";
	String jdbcURL = "jdbc:postgresql://localhost/libreplan";
	String user = "libreplan";
	String password = "libreplan";

	
//Initialisation du navigateur sur l'addresse appropriée
	@Before
	public void setup(){


		
		///Set Up du navigateur
		String nav = System.getProperty("navigateur");
		WebDriver driver = null;
		
		//nav = "chrome";				
		if(nav.equals("chrome")) {
		    driver = new ChromeDriver();
		}
		
		//nav = "internet explorer";				
		if(nav.equals("ie")) {
		    driver = new InternetExplorerDriver();
		}
		
		if(nav.equals("firefox")) {
			//Sélection de firefox comme navigateur	

			System.setProperty("webdriver.gecko.driver", "C:\\projet3\\webdriver\\geckodriver.exe");	
			FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
			options.addPreference("browser.tabs.remote.autostart", false);
			driver = new FirefoxDriver(options);
		}
		driver.get("http://localhost:8080/libreplan/common/layout/login.zul");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}	
	
//Corps du test de création de projet
	@Test
	public void test() throws InterruptedException {
		//1- Création de la page de connexion
		LogPage log = PageFactory.initElements(driver, LogPage.class);
		//1- Redirection vers la page d'accueuil grâce à la méthode de connexion issue de la page-objet correspondante avec les identifiants admin.
		ProjectsPlanningPage plan = log.connexion("admin", "admin");
		Thread.sleep(500);
		//2- Click sur le bouton d'ajout de projet et redirection sur le popup de l'ajout de projet.
		PopupProjectAdd projectAdd = plan.clickProjectAdd();
		//3- Complétion du formulaire d'ajout de projet, validation et redirection sur la page des détails du projet.
		ProjectDetailsPage project = projectAdd.setProject("PROJET_TEST1", "PRJTST001", "May 8, 2017", "May 18, 2017");
		
		//7- Click sur l'icône d'annulation d'édition ( flèche verte en haut à gauche).
		project.clickCancel();
		//8- Annulation de l'annulation d'édition
		project.clickCancelNo();
		//9- Click sur l'icône d'annulation d'édition ( flèche verte en haut à gauche).
		project.clickCancel();
		//10- Validation de l'annulation d'édition
		ProjectsPlanningPage projects2 = project.clickCancelYes();
		
		
	}
	/*
	//Réinitialisation de la base de données
	@After
	public void teardown() throws SQLException, Exception{
		IDatabaseTester tester = new JdbcDatabaseTester(driverSQL,jdbcURL, user, password);
		IDataSet dataSet = tester.getConnection().createDataSet();
		
		//Vérification de l'insertion

		ITable table = dataSet.getTable("order_element");
		
		IDataSet expected2 = new FlatXmlDataSetBuilder().build(new File("src/test/dataProjet.xml"));
		ITable expectedTable2 = expected2.getTable("order_element");
		Assertion.assertEquals(expectedTable2, table);
		
		//Suppresion des données insérées
	
		IDataSet dataSet2 =new FlatXmlDataSetBuilder().build(new File("src/test/dataDelete.xml"));
		tester.setTearDownOperation(DatabaseOperation.DELETE_ALL);
		tester.setDataSet(dataSet2);
		tester.onTearDown();
		
		//Vérification de la suppresion
		ITable table = dataSet.getTable("order_element");
		IDataSet expected = new FlatXmlDataSetBuilder().build(new File("src/test/dataEmpty.xml"));
		ITable expectedTable = expected.getTable("order_element");
		
		Assertion.assertEquals(expectedTable, table);
	}
	*/
}
