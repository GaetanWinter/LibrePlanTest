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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;


//Cas de test Pro_TA_02 : Ajouter des tâches à un projet
public class ProTa02 {

	WebDriver driver;
	String driverSQL = "org.postgresql.Driver";
	String jdbcURL = "jdbc:postgresql://localhost/libreplan";
	String user = "libreplan";
	String password = "libreplan";

	

	@Before
	public void setup() throws SQLException, Exception{

		//Initialisation du navigateur sur l'addresse appropriée
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/libreplan/common/layout/login.zul");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Insertion d'un jeu de données data 
		/*
		IDatabaseTester databaseTester = new JdbcDatabaseTester(driverSQL,jdbcURL, user, password);
		IDataSet dataSet = databaseTester.getConnection().createDataSet();
		databaseTester.setSetUpOperation(DatabaseOperation.INSERT);
		IDataSet dataInsert = new FlatXmlDataSetBuilder().build(new File("src/test/dataProjet.xml"));
		databaseTester.setDataSet(dataInsert);
		databaseTester.onSetup();
				
		//Vérification de l'insertion
		ITable table2 = dataSet.getTable("order_element");
		IDataSet expected2 = new FlatXmlDataSetBuilder().build(new File("src/test/dataProjet.xml"));
		ITable expectedTable2 = expected2.getTable("order_element");
				
		Assertion.assertEquals(expectedTable2, table2);
		*/
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
		
		//5- Création d'une nouvelle tâche
		project.addTask("task1", "5");
		Thread.sleep(1000);
		
		//6- Création de plusieurs nouvelles tâches
		project.addTask("task2", "5");
		Thread.sleep(1000);
		project.addTask("task3", "5");
		Thread.sleep(1000);
		project.addTask("task4", "5");
		Thread.sleep(1000);
		
		//7- Modification de l'ordre de la première tâche vers le bas
		project.orderTaskDown("task1");
		Thread.sleep(1000);
		
		//8- Modification de l'ordre de la troisième tâche vers le haut
		project.orderTaskUp("task3");
		
		//9- Remplissage des champs des tâches
		project.setCodeTask1("T1");
		project.setCodeTask2("T2");
		project.setCodeTask3("T3");
		project.setCodeTask4("T4");
		project.setDateTask1("5/2/17");
		Thread.sleep(1000);
		project.setDateTask2("5/6/17");
		Thread.sleep(1000);
		project.setDeadline1("5/1/17");
		Thread.sleep(1000);
		project.setDeadline2("5/3/17");
		project.clickSave();
		project.clickOkPopup();
		Thread.sleep(1000);
		
		//10- Redirection vers la page de visualisation du planning
		project.clickProjectScheduling();
		
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
