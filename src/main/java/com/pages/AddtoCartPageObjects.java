package com.pages;

	import java.util.ArrayList;
	import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.FindBys;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//tr[@id ='product_7_34_0_0']//a[contains(text(),"Printed Chiffon Dress")]
	public class AddtoCartPageObjects extends BasePage {
		
		@FindBy(xpath = "//b")
		private WebElement AddtoCartOpenClick;

		@FindBy(xpath = "//table[@id = 'cart_summary']")
		private WebElement table;

       @FindBy(xpath ="//table[@id = 'cart_summary']//tbody//td[2]" )
		private WebElement ProductnameinAddtoCartPage;
       
       @FindBy(id = "total_product")
		private WebElement totalvalue;
       
       @FindBy(id = "total_shipping")
		private WebElement shippingAmount;
       
       
       @FindBy(id = "total_price")
		private WebElement ActualTotalPrice;
       
       @FindBy(id = "//*[contains(text(),' Sign in')]")
		private WebElement SigninTab ;
       
       
		public AddtoCartPageObjects() {
			PageFactory.initElements(driver, this);
			
		}

		public WebElement AddtoCarPageOpen() {
			return AddtoCartOpenClick;
		}

		public String retrieveProductname() {		 

			return ProductnameinAddtoCartPage.getText() ;
	  			
		}
		
		public Double calculatetotalamount()
		{	
			String TotalProductAmount = totalvalue.getText();
			String ShippingAmount = shippingAmount.getText();
			
					
			TotalProductAmount = TotalProductAmount.replace('$', '0');
			ShippingAmount = ShippingAmount.replace('$', '0');
			System.out.println("before conversion " +TotalProductAmount+" shipping "+ShippingAmount);
		Double TotalProductAmountDouble = Double.parseDouble(TotalProductAmount);
		Double ShippingAmountDouble = Double.parseDouble(ShippingAmount);
		
		System.out.println("after conversion " +TotalProductAmountDouble+" shipping "+ShippingAmountDouble);
		
		Double calculatedTotalAmount = TotalProductAmountDouble+ShippingAmountDouble;
		System.out.println("Calculated Amount "+calculatedTotalAmount); 
		return calculatedTotalAmount;
			
		}
		
		public Double ActualTotalAmount() {
			String ActualTotal_Price = ActualTotalPrice.getText();
			ActualTotal_Price = ActualTotal_Price.replace('$', '0');
			Double ActualTotal_PriceDouble = Double.parseDouble(ActualTotal_Price);
			System.out.println("Actual Amount "+ActualTotal_PriceDouble);
			return ActualTotal_PriceDouble;
			
			
		}
    public WebElement verifySigninPage()
    {
    	return SigninTab;
    			
    }
				
		
	}


