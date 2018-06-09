package com.pages;

	import java.util.ArrayList;
	import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.FindBys;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class DressesPageObjects extends BasePage {
		
		@FindBy(xpath = "(//li//a[@title = 'Dresses'])[2]")
		private WebElement DressTab;

		
		@FindBy(xpath = "//*[@class = 'cat-name']")
		private WebElement Tabs;
		//header_logo
		@FindBy(id = "header_logo")
		private WebElement homeicon;

		@FindBy(id = "selectProductSort")
		private WebElement dropdwn;
		
		@FindBy(className = "icon-ok")
		private WebElement AddtoCartSucess;
		
		@FindBy(xpath = "//*[@title = 'Close window']")
		private WebElement AddtoCartClosebutton;
		
		@FindBy(xpath = "//div[@class='right-block']//a[@class= 'product-name']")
		private WebElement productname;
		
		@FindBy(xpath ="//div[@class='button-container']//*[@title='Proceed to checkout']//*[@class='icon-chevron-right right']")
		private WebElement Checkoutbutton;
		

		
		@FindBys(@FindBy(xpath = "//div[@class ='product-container']//*[@title='Add to cart']"))
		private List<WebElement> addtocart;
		////div[@class ='product-container']//div[@class ='right-block' ][1]
		@FindBy(xpath = "//div[@class ='product-container']")
		private List<WebElement> product;
		
		

		@FindBy(id = "layer_cart_product_title")
		private WebElement addtocartproducttile;


		@FindBys(@FindBy(xpath = "//div[@class ='product-container']//div[@class ='right-block' ]//*[@title= 'View']"))
		private List<WebElement> morebutton;
		
		@FindBys(@FindBy(xpath = "//div[@class ='product-container']//div[@class ='right-block' ]//*[@class='price product-price']"))
		private List<WebElement> currentprice;

		public DressesPageObjects() {
			PageFactory.initElements(driver, this);
		}

		

		public WebElement dresssestabdisplay() {

			return DressTab;
		}

		public WebElement Tabnaviagetd() {
			return Tabs;
		}

		public WebElement drpdownselect() {
			return dropdwn;
		}
		
		public WebElement addtocartbutton() {
			return addtocart.get(0);
		}


		public List<String> addtocartverify() {
			ArrayList<String> list = new ArrayList<String>();

			String actual = null;
			for (int i = 0; i < addtocart.size(); i++) {
				actual = addtocart.get(i).getAttribute("title");
				list.add(i, actual);

			}
			return list;
		}

		public List<String> morebuttonverify() {
			ArrayList<String> list = new ArrayList<String>();

			String actual = null;
			for (int i = 0; i < morebutton.size(); i++) {
				actual = morebutton.get(i).getAttribute("title");
				list.add(i, actual);

			}
			return list;
		}

		
		/*public WebElement Addtocart() {
			Webelement addtocart1 = 

			return addtocart;

		}*/
		
		public WebElement product() {

			return product.get(0);

		}
		
		public double[] ActualPriceinString() throws InterruptedException
		{
			ArrayList<String> list = new ArrayList<String>();
			String presentprice = null;
			Thread.sleep(2000);
			for (int i = 0; i < currentprice.size(); i++) 
		  {
			  presentprice = currentprice.get(i).getText();
			  
			  presentprice = presentprice.replace('$', '0');
			  //presentprice = presentprice.trim();
			  list.add(i, presentprice);
			
		  }
			
			System.out.println("Before Conversion " +list);
List<String> PresentvalueString = list;
			double[] presentstringDouble = new double[list.size()];
			
			
			for (int i = 0; i < PresentvalueString.size(); i++)
			{
				presentstringDouble[i]= Double.parseDouble(PresentvalueString.get(i));
				System.out.println(presentstringDouble[i]);
			
			}
					
	return presentstringDouble;
		}
		
		
		public  String clickonAddToCart() {
			
			int i = 0;
			
			String ActualProductName = productname.getAttribute("title");
			//product().click();
			
		
			Actions action = new Actions (driver);
			action.moveToElement(product()).perform();
		    addtocartbutton().click();
		      return ActualProductName;
		
		
		
		}
		
		public  String AddtocartProductTiltle() {
			
	 	
		return addtocartproducttile.getAttribute("title");
		}
		
		public  WebElement Addtocartclose()
		{
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title = 'Blouse']//img[@class = 'img-responsive']")));	
							
				return AddtoCartClosebutton;
			}
		public WebElement clickonproceedTocheckButton()
		{
			return Checkoutbutton;
		}
		
	}


