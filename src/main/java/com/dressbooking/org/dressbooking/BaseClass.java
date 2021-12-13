package com.dressbooking.org.dressbooking;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.lang.StackWalker.Option;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.utils.FileUtil;

public class BaseClass {

	public static WebDriver driver;

	// 1. browserConfig
	// --> string

	public static WebDriver browserlaunch(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Dell\\eclipse-workspace\\dress\\Driver1\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Dell\\eclipse-workspace\\com.adactinhotel.org\\Driver\\chromedriver.exe");
			driver = new FirefoxDriver();

		} else {
			System.out.println("Invalid Value");
		}

		driver.manage().window().maximize();

		return driver;

	}

	// 2.Close

	public static void close() {

		driver.close();

	}

	// 3.Quit

	public static void quit() {

		driver.quit();

	}

	// 4.NavigateTo
	// --> string

	public static void navigateTo(String url) {

		driver.navigate().to(url);

	}

	// 5.NavigateBack

	public static void navigateBack() {

		driver.navigate().back();

	}

	// 6.NavigateForward

	public static void navigateForward() {

		driver.navigate().forward();
	}

	// 7.NavigateRefresh

	public static void navigateRefresh() {

		driver.navigate().refresh();

	}

	// 8.Get
	// String

	public static void getURL(String url) {

		driver.get(url);

	}

	// 9.Alert

	public static void alertAccept() {

		driver.switchTo().alert().accept();

	}

	public static void alertDismiss() {

		driver.switchTo().alert().dismiss();

	}

	public static void alertGetText(String str) throws Throwable {

		Alert promt = driver.switchTo().alert();
		String text = promt.getText();
		System.out.println(text);
		Thread.sleep(3000);
		promt.sendKeys(str);
		promt.accept();

	}

	// 10.Action

	// --> movetoelement

	public static void moveMouseTo(WebElement Element) {

		Actions act = new Actions(driver);
		act.moveToElement(Element).build().perform();

	}

	// --> clickOnMouse

	public static void clickOnMouse(WebElement Element) {

		Actions act = new Actions(driver);
		act.click(Element).build().perform();

	}
	
	public static void Mousehover(WebElement Mousehover_ele, List<WebElement> ele, String selected_from_lists) {
		Actions act = new Actions(driver);

		act.moveToElement(Mousehover_ele).build().perform();

		List<WebElement> li = ele;
		for (int i = 0; i < li.size(); i++) {
			WebElement li_ele = li.get(i);
			String text = li_ele.getText();

			if (text.equalsIgnoreCase(selected_from_lists)) {
				li_ele.click();

			}
		}
	}


	// --> rightClick

	public static void rightClick(WebElement Element) {

		Actions act = new Actions(driver);
		act.contextClick(Element).build().perform();

	}

	// 11.Frames

	public static void frame() {

		driver.switchTo().frame(0);

	}

	// --> defaultFrame

	public static void defaultFrame() {

		driver.switchTo().defaultContent();

	}

	// 12.Robot
	// WebElement String

	public static void keyboardAction(WebElement element, String option) throws Throwable {

		Robot r = new Robot();

		if (option.equalsIgnoreCase("down")) {

			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);

		} else if (option.equalsIgnoreCase("up")) {

			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);

		} else if (option.equalsIgnoreCase("enter")) {

			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);

		}

	}



}
