package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.BasePage;
import com.pages.HomePageObjects;

public class HomePageTests {
	HomePageObjects homePage;
	BasePage bp;
	
	int random = new Random().nextInt(5000000);

	public HomePageTests() {
		homePage = new HomePageObjects();
		bp = new BasePage();

	}

	@Test
	public void Tabdisplay() {
		Assert.assertTrue(homePage.womentabdisplay().isEnabled());
		Assert.assertTrue(homePage.tshirttabdisplay().isEnabled());
		Assert.assertTrue(homePage.dresssestabdisplay().isEnabled());
		homePage.womentabdisplay().click();

	}

	@Test

	public void Tabnavigation() {
		Assert.assertEquals(homePage.Tabnaviagetd().getText(), "WOMEN ");
		homePage.tshirttabdisplay().click();
		Assert.assertEquals(homePage.Tabnaviagetd().getText(), "T-SHIRTS ");
		homePage.dresssestabdisplay().click();
		Assert.assertEquals(homePage.Tabnaviagetd().getText(), "DRESSES ");

	}

	
	@Test
	public void verifysubsmsg()

	{
		bp.setText(homePage.newsletterText(), "xxzxx1"+random+"@gmail.com");
		homePage.submitNewsletter().click();
		Assert.assertTrue(bp.isElementVisible(homePage.subscriptionmsgdisplay()));

	}
	

}


