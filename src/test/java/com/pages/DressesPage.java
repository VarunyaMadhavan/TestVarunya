package com.pages;

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


public class DressesPage {
	DressesPageObjects DressesPage;
	BasePage bp;
	
	
	
	public DressesPage() {
		DressesPage = new DressesPageObjects();
		bp = new BasePage();

	}
	
	@Test
	public void Tabdisplay() {
				Assert.assertTrue(DressesPage.dresssestabdisplay().isEnabled());
				DressesPage.dresssestabdisplay().click();

	}


	@Test

	public void Tabnavigation() {
		
		Assert.assertEquals(DressesPage.Tabnaviagetd().getText(), "DRESSES ");

	}
	@Test

	public void dropdwonselect() {
		DressesPage.dresssestabdisplay().click();
		bp.selectFromDropDown(DressesPage.drpdownselect(), "price:asc");
	}

	@Test

	public void verifybuttons() {
		List<String> actualValue_Addtocart = DressesPage.addtocartverify();
		List<String> actualValue_moreButton = DressesPage.morebuttonverify();

		String expectedvalue_AddtoCart = "Add to cart";
		String expectedvalue_morebutton = "View";

		for (int i = 0; i < actualValue_Addtocart.size(); i++) {

			Assert.assertTrue(actualValue_Addtocart.get(i).contains(expectedvalue_AddtoCart));
		}

		for (int i = 0; i < actualValue_moreButton.size(); i++) {

			Assert.assertTrue(actualValue_moreButton.get(i).contains(expectedvalue_morebutton));
		}
	}

	
	
	@Test
	
	public void verifyactualPricefloat() throws InterruptedException
	{   double[] presentstringDouble = new double [DressesPage.ActualPriceinString().length];
		
		for(int i =1;i<DressesPage.ActualPriceinString().length;i++)
			
		{   
			Assert.assertTrue(presentstringDouble[i-1]<presentstringDouble[i]);
			
		}		
		
		
	}
	@Test
	public void verifyproductAddedtocart()
	{
	  DressesPage.clickonAddToCart();
	//Assert.assertEquals(DressesPage.clickonAddToCart(),DressesPage.AddtocartProductTiltle());
	  
	 // DressesPage.proceedtocheckout().click();
	 
		DressesPage.Addtocartclose().click();
	
	}
	
	
	/*@AfterClass
	

	public void Tabdisplayafter() {
				Assert.assertTrue(DressesPage.dresssestabdisplay().isEnabled());
				DressesPage.dresssestabdisplay().click();

	}

*/	
	

}
