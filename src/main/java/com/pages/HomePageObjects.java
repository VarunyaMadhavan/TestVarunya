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

	public class HomePageObjects extends BasePage {
		@FindBy(xpath = "//li//a[@title = 'Women']")
		private WebElement womentab;

		@FindBy(xpath = "(//li//a[@title = 'Dresses'])[2]")
		private WebElement DressTab;

		@FindBy(xpath = "(//li//a[@title = 'T-shirts'])[2]")
		private WebElement TshirtTab;

		@FindBy(xpath = "//*[@class = 'cat-name']")
		private WebElement Tabs;
		//header_logo
		@FindBy(id = "header_logo")
		private WebElement homeicon;

		@FindBy(id = "selectProductSort")
		private WebElement dropdwn;
		

		@FindBy(id = "newsletter-input")
		private WebElement newsletter;
		//// button[@name='submitNewsletter']

		@FindBy(xpath = "//button[@name='submitNewsletter']")
		private WebElement Submitnewsltr;

		@FindBy(xpath = "//*[@class = 'alert alert-success']")
		private WebElement Subscriptionmsg;

		@FindBys(@FindBy(xpath = "//div[@class ='product-container']//*[@title='Add to cart']"))
		private List<WebElement> addtocart;
		////div[@class ='product-container']//div[@class ='right-block' ][1]
		@FindBy(xpath = "//div[@class ='product-container']")
		private List<WebElement> product;


		@FindBys(@FindBy(xpath = "//div[@class ='product-container']//div[@class ='right-block' ]//*[@title= 'View']"))
		private List<WebElement> morebutton;
		
		////div[@class ='product-container']//div[@class ='right-block' ]//*[@class="price product-price"]
		@FindBys(@FindBy(xpath = "//div[@class ='product-container']//div[@class ='right-block' ]//*[@class='price product-price']"))
		private List<WebElement> currentprice;

		public HomePageObjects() {
			PageFactory.initElements(driver, this);
		}

		public WebElement womentabdisplay() {
			womentab.click();
			return womentab;
		}

		public WebElement tshirttabdisplay() {

			return TshirtTab;
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

		public WebElement newsletterText() {

			return newsletter;
		}

		public WebElement submitNewsletter() {
			return Submitnewsltr;

		}
		
		public WebElement homebutton() {
			return homeicon;

		}

		/*public WebElement Addtocart() {
			Webelement addtocart1 = 

			return addtocart;

		}*/
		public WebElement subscriptionmsgdisplay() {

			return Subscriptionmsg;

		}
		//addtocartFirst
		public WebElement product() {

			return product.get(0);

		}
		
		public List<String> ActualPriceinString()
		{
			ArrayList<String> list = new ArrayList<String>();
			String presentprice = null;
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class ='product-container']//*[@title='Add to cart']")));
			
			
		  for (int i = 0; i < currentprice.size(); i++) 
		  {
			  presentprice = currentprice.get(i).getText();
			  System.out.println(presentprice);
			  presentprice.replace("$","");	
			         list.add(i, presentprice);
							
		  
		  }
		  
	return list;
		}
	}


