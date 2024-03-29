package Irctc;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ChildClass extends BaseClass{
	
	@Test(priority =1)
	public void openPage() throws InterruptedException{
		driver.get(" https://www.irctc.co.in/nget/train-search ");
		Thread.sleep(100);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(100);
	}
	@Test(priority =2)
	public void windowHandling() throws InterruptedException {
		driver.findElement(By.xpath("//a[@aria-label='Menu BUSES. Website will be opened in new tab']")).click();
		driver.findElement(By.xpath("//a[@aria-label='Menu Flight. Website will be opened in new tab']")).click();
		Thread.sleep(100);
		Set<String> wHandles= driver.getWindowHandles();
		List<String> newWindow = new ArrayList<String>(wHandles);
		WebDriver window2 = driver.switchTo().window(newWindow.get(2));
		//System.out.println("Title:-" +window2.getTitle());
		String Title = driver.getTitle();
		Assert.assertEquals(Title,"IRCTC Bus - Online Bus Ticket Booking | Bus Reservation");
		WebDriver window1 = driver.switchTo().window(newWindow.get(1));
		System.out.println("Title:-" +window1.getTitle());
		String Title1 = driver.getTitle();
		Assert.assertEquals(Title1,"Air Ticket Booking | Book Flight Tickets | Cheap Air Fare - IRCTC Air");
		driver.switchTo().window(newWindow.get(0));
		}
	@Test(priority =3)
	public void findTrain() {
		try {
		driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("PUNE JN - PUNE");
		
		driver.findElement(By.xpath("//input[@class='ng-tns-c58-9 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']")).sendKeys("SURAT - ST");
		
		driver.findElement(By.xpath("//button[@label='Find Trains']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//span[@class='ui-button-text ui-clickable']")).click();
		}catch(Exception e) {
			System.out.println("In Catch " +e.getMessage());
			System.out.println("cause is "+e.getCause());
			e.printStackTrace();
		}
		}

}
