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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


//Cas de test Pro_TA_03 : Allouer une ressource à un projet
public class ProTa03Test extends BeforeTest {

//Corps du test de création de projet
	@Test
	public void test() throws InterruptedException {
		
		//1- Création de la page de connexion
		LogPage log = PageFactory.initElements(driver, LogPage.class);
		//1- Redirection vers la page d'accueuil grâce à la méthode de connexion issue de la page-objet correspondante avec les identifiants admin.
		ProjectsPlanningPage plan = log.connexion("admin", "admin");
		
		// Création d'une resource
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(".//table[@class='z-menu-body']//button[contains(text(),'Resources')]"));
		action.moveToElement(we).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath(".//a[@class='z-menu-item-cnt'][@href='/libreplan/resources/worker/worker.zul']"))).click().build().perform();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//div[@class='clickable-rows z-grid']/following-sibling::span[@class='create-button global-action z-button']/table/tbody/tr[2]/td[text()='Create']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//div[@class='z-fieldset-cnt']/div/div[@class='z-grid-body']/table/tbody[2]/tr[2]//input")).sendKeys("Henry");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//div[@class='z-fieldset-cnt']/div/div[@class='z-grid-body']/table/tbody[2]/tr[4]/td[2]/div/input")).sendKeys("Ford");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//div[@class='z-grid-body']/table/tbody[2]/tr[5]//input")).sendKeys("00001");
		Thread.sleep(1000);	
		driver.findElement(By.xpath(".//td[text()='Save']"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//a[@href='/libreplan/']")).click();
		Thread.sleep(2000);
		
		//2- Redirection vers la liste des planning via un click sur l'onglet correspondant.
		ProjectsListPage list = plan.clickProjectslist();
		Thread.sleep(1000);
		
		//3- Accès à la page édition du projet
		ProjectDetailsPage project = list.selectionProject("PROJET_TEST1");
		Thread.sleep(1000);
		
		//4- Redirection vers la page de visualisation du planning
		ProjectSchedulingPage schedule = project.clickProjectScheduling();
		Thread.sleep(1000);
		
		//5- Click droit sur le rectangle bleue symbolisant la durée d'une tâche
		ProjectSchedulingMenu scheduleMenu = schedule.rightClickProjectslist();
		Thread.sleep(1000);
		
		//6 Choix du sous-menu d'allocation de ressources
		PopupTaskPage task = scheduleMenu.clickResourcesAllocation();
		Thread.sleep(1000);
		
		//7- Affichage de la liste des ressources
		task.selectAllocations();
		Thread.sleep(1000);
		
		//8- Sélection des ressources
		task.selectAllocation();
		Thread.sleep(1000);
		
		//9- Ajout de la ressource
		task.addAllocation();
		Thread.sleep(1000);
		
		//10- Validation de l'ajout de la ressource
		ProjectSchedulingPage schedule2 = task.validateAllocation();
		Thread.sleep(1000);
		
		//11- Click sur l'onglet de chargement des ressources
		ResourcesLoadPage resources = schedule2.clickResourcesLoad();
		Thread.sleep(1000);
		
		//12- Click sur l'icône à gauche de la ressource afin de dérouler sa tâche d'affectation
		resources.selectResource();
		Thread.sleep(1000);
		
		//13- Click à nouveau sur l'icône à gauche de la ressource afin de cacher sa tâche d'affectation
		resources.selectResource();
		Thread.sleep(1000);
		//14- Click sur la disquette
		resources.clickSave();
		Thread.sleep(1000);
	}

	
	
	
	
	//Réinitialisation de la base de données
	@After
	public void teardown() throws SQLException, Exception{
		driver.close();
//		IDatabaseTester tester = new JdbcDatabaseTester(driverSQL,jdbcURL, user, password);
//		IDataSet dataSet = tester.getConnection().createDataSet();
//		
//		//Vérification de l'insertion
//		IDatabaseTester tester = new JdbcDatabaseTester(driverSQL,jdbcURL, user, password);
//		IDataSet dataSet = tester.getConnection().createDataSet();
//		ITable table = dataSet.getTable("order_element");
//		
//		IDataSet expected2 = new FlatXmlDataSetBuilder().build(new File("src/test/dataProjet.xml"));
//		ITable expectedTable2 = expected2.getTable("order_element");
//		
//		Assertion.assertEquals(expectedTable2, table);
//		
//		//Suppresion des données insérées
//	
//		IDataSet dataSet2 =new FlatXmlDataSetBuilder().build(new File("src/test/dataTask.xml"));
//		tester.setTearDownOperation(DatabaseOperation.DELETE);
//		tester.setDataSet(dataSet2);
//		tester.onTearDown();
//		
//		//Vérification de la suppresion
//		ITable table = dataSet.getTable("order_element");
//		IDataSet expected = new FlatXmlDataSetBuilder().build(new File("src/test/dataEmpty.xml"));
//		ITable expectedTable = expected.getTable("order_element");
//		
//		Assertion.assertEquals(expectedTable, table);
	}
}
