package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateEdureka {
	
	public static WebDriver driver;

	@SuppressWarnings("deprecation")
	@Test(priority = 0)
	public void EdurekaProfile() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.edureka.co/");
		driver.manage().window().maximize();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[4]/span")).click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.id("si_popup_email")));
		// Thread.sleep(2000);
		actions.click();
		actions.sendKeys("sanjinanowshin82@gmail.com");
		Thread.sleep(2000);
		actions.build().perform();

		actions.moveToElement(driver.findElement(By.id("si_popup_passwd")));
		// Thread.sleep(2000);
		actions.click();
		actions.sendKeys("Moon1234");
		Thread.sleep(2000);
		actions.build().perform();

		actions.moveToElement(
				driver.findElement(By.xpath("//*[@id=\"new_sign_up_optim\"]/div/div/div[2]/div[3]/form/button")));
		Thread.sleep(2000);
		actions.click();
		// Thread.sleep(2000);
		actions.build().perform();

		driver.findElement(By.xpath("//a[@class='dropdown-toggle trackButton']//img[@class='img30']")).click();
		driver.findElement(By.linkText("My Profile")).click();
		Thread.sleep(2000);

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.findElement(By.xpath("//a[@id='personal_details']")).click();
		driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("Sanjina");
		Thread.sleep(1000);
		System.out.println("done");

		driver.navigate().to("https://learning.edureka.co/my-profile");
		String title = driver.getTitle();
		System.out.println(title);

		driver.findElement(By.linkText("Career Services")).click();
		driver.findElement(By.xpath("//*[@id=\"career_interest\"]")).click();
		driver.navigate().to("https://learning.edureka.co/onboarding/careerinterests");

		Select dropdownCurrentJob = new Select(driver.findElement(By.name("interestedJob")));
		dropdownCurrentJob.selectByVisibleText("Software Testing");

		Select dropdownEmployeeType = new Select(driver.findElement(By.name("elementType")));
		dropdownEmployeeType.selectByVisibleText("Both");

		Select dropdownCTC = new Select(driver.findElement(By.name("lastDrawnSalaryUS")));
		dropdownCTC.selectByVisibleText("$125K-$150k");
		

		driver.findElement(By.xpath(
				"//*[@id=\"onboarding\"]/div/div[1]/div[2]/div[2]/app-onboarding-career-interests/accordion/accordion-group/div/div[2]/div/form/div[3]/div/div/button"))
				.click();
		driver.findElement(By.xpath(
				"//*[@id=\"onboarding\"]/div/div[1]/div[2]/div[2]/app-onboarding-career-interests/accordion/accordion-group/div/div[2]/div/form/div[3]/div/div/ul/perfect-scrollbar/div/div[1]/li[7]"))
				.click();

		driver.findElement(By.name("currentCity")).sendKeys("Dhaka");
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

		driver.navigate().to("https://learning.edureka.co/my-profile");

		driver.findElement(By.xpath("//button[@class='dropdown-toggle']//img[@class='user_image']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();

		System.out.println("check");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


}
