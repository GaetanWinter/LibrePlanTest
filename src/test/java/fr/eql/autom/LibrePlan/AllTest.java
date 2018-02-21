package fr.eql.autom.LibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;



import java.util.concurrent.TimeUnit;

//import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AllTest {
	
WebDriver driver;
	

	@Before
	public void setup(){		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/libreplan/common/layout/login.zul");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}	
	
	@Test
	public void test() throws InterruptedException{
		
		LogPage log = PageFactory.initElements(driver, LogPage.class);
		ProjectsPlanningPage plan = log.connexion("admin", "admin");
		//plan.projectAdd.click();
		ProjectsListPage projects = plan.clickProjectslist();
		//ResourcesLoadPage resource = projects.clickResourcesLoad();
		//ProjectsPlanningPage plan2 = resource.clickProjectsPlanning();
		//ProjectsListPage projects2 = plan2.clickProjectslist();
		//ProjectDetailsPage project = projects.selectionProject("aze");
		PopupProjectAdd projectAdd = projects.clickProjectAdd();
		Thread.sleep(500);
		ProjectDetailsPage project = projectAdd.setProject("PROJET_TEST1", "PRJTST001", "May 3, 2017", "May 13, 2017");
		project.clickCancel();
		project.clickCancelNo();
		project.clickCancel();
		ProjectsPlanningPage projects2 = project.clickCancelYes();
		
		
		
		
		//ProjectSchedulingPage schedule = project.clickProjectScheduling();
		//schedule.clickResourcesLoad();
		//schedule.clickSave();
		//schedule.clickCancel();
		/*ProjectSchedulingMenu scheduleMenu = schedule.rightClickProjectslist();
		PopupTaskPage task = scheduleMenu.clickResourcesAllocation();
		task.selectAllocations();
		task.selectAllocation();
		Thread.sleep(500);
		task.addAllocation();
		task.validateAllocation();
		*/
		/*
		project.addTask("task1", "5");
		Thread.sleep(500);
		project.addTask("task2", "5");
		Thread.sleep(500);
		project.addTask("task3", "5");
		Thread.sleep(500);
		project.addTask("task4", "5");
		Thread.sleep(500);
		project.orderTaskDown("task1");
		Thread.sleep(500);
		project.orderTaskUp("task3");
		//schedule.menuDeroulantVue("Month");
		Thread.sleep(500);
		project.setDateTask1("5/2/17");
		Thread.sleep(500);
		project.setDateTask2("5/5/17");
		Thread.sleep(500);
		project.setDeadline1("4/31/17");
		Thread.sleep(500);
		project.setDeadline2("5/2/17");
		project.clickSave();
		project.clickOkPopup();
		*/
	}
	
	//@After
	//public void teardown(){
	//wd.close();
	//}
}