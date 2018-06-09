package com.pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pages.BasePage;
import com.pages.DressesPageObjects;


public class AddtoCartPage {
	AddtoCartPageObjects AddtoCartpg;
	BasePage bp;
	DressesPageObjects dpobj;
	
	
	public AddtoCartPage() {
		AddtoCartpg = new AddtoCartPageObjects();
		bp = new BasePage();
		dpobj = new DressesPageObjects();
		

	}
	
	@Test
	public void OpenAddtocart() {
		AddtoCartpg.AddtoCarPageOpen().click();			
		Assert.assertTrue(AddtoCartpg.calculatetotalamount().equals(AddtoCartpg.ActualTotalAmount()));
		//Assert.assertTrue(AddtoCartpg.retrieveProductname().equals(dpobj.AddtocartProductTiltle()));
	}
@Test
 public void verifycheckout()
 {
	 dpobj.clickonproceedTocheckButton().click();
	 Assert.assertTrue(AddtoCartpg.verifySigninPage().isEnabled());
 }
	
}
