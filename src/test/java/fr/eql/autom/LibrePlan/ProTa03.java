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


//Cas de test Pro_TA_03 : Allouer une ressource à un projet
public class ProTa03 {

	WebDriver driver;
	String driverSQL = "org.postgresql.Driver";
	String jdbcURL = "jdbc:postgresql://localhost/libreplan";
	String user = "libreplan";
	String password = "libreplan";

	

	@Before
	public void setup() throws SQLException, Exception{

		//Set Up du navigateur
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
		driver.get("http://localhost:8084/libreplan/common/layout/login.zul");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}	
	
	
	
//Corps du test de création de projet
	@Test
	public void test() throws InterruptedException {
		
		//1- Création de la page de connexion
		LogPage log = PageFactory.initElements(driver, LogPage.class);
		//1- Redirection vers la page d'accueuil grâce à la méthode de connexion issue de la page-objet correspondante avec les identifiants admin.
		ProjectsPlanningPage plan = log.connexion("admin", "admin");
		
		//2- Redirection vers la liste des planning via un click sur l'onglet correspondant.
		ProjectsListPage list = plan.clickProjectslist();
		Thread.sleep(1000);
		
		//3- Accès à la page édition du projet
		ProjectDetailsPage project = list.selectionProject("PROJET_TEST1");
		
		//4- Redirection vers la page de visualisation du planning
		ProjectSchedulingPage schedule = project.clickProjectScheduling();
		
		//5- Click droit sur le rectangle bleue symbolisant la durée d'une tâche
		ProjectSchedulingMenu scheduleMenu = schedule.rightClickProjectslist();
		
		//6 Choix du sous-menu d'allocation de ressources
		PopupTaskPage task = scheduleMenu.clickResourcesAllocation();
		
		//7- Affichage de la liste des ressources
		task.selectAllocations();
		
		//8- Sélection des ressources
		task.selectAllocation();
		Thread.sleep(500);
		
		//9- Ajout de la ressource
		task.addAllocation();
		
		//10- Validation de l'ajout de la ressource
		ProjectSchedulingPage schedule2 = task.validateAllocation();
		Thread.sleep(500);
		
		//11- Click sur l'onglet de chargement des ressources
		ResourcesLoadPage resources = schedule2.clickResourcesLoad();
		
		//12- Click sur l'icône à gauche de la ressource afin de dérouler sa tâche d'affectation
		resources.selectResource();
		
		//13- Click à nouveau sur l'icône à gauche de la ressource afin de cacher sa tâche d'affectation
		resources.selectResource();
		
		//14- Click sur la disquette
		resources.clickSave();
	}

	
	
	
	
	//Réinitialisation de la base de données
	/*
	@After
	public void teardown() throws SQLException, Exception{
	
		IDatabaseTester tester = new JdbcDatabaseTester(driverSQL,jdbcURL, user, password);
		IDataSet dataSet = tester.getConnection().createDataSet();
		
		//Vérification de l'insertion
		IDatabaseTester tester = new JdbcDatabaseTester(driverSQL,jdbcURL, user, password);
		IDataSet dataSet = tester.getConnection().createDataSet();
		ITable table = dataSet.getTable("order_element");
		
		IDataSet expected2 = new FlatXmlDataSetBuilder().build(new File("src/test/dataProjet.xml"));
		ITable expectedTable2 = expected2.getTable("order_element");
		
		Assertion.assertEquals(expectedTable2, table);
		
		//Suppresion des données insérées
	
		IDataSet dataSet2 =new FlatXmlDataSetBuilder().build(new File("src/test/dataTask.xml"));
		tester.setTearDownOperation(DatabaseOperation.DELETE);
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
