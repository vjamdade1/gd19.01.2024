package com.traval.qa.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.traval.qa.base.TestBaseGD;
import com.traval.qa.confiq.ConfigureProperties;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchHotels extends TestBaseGD 

{
	
	public String HomePageDate;
	public String CheckINHome;
	public String CheckOutHome;
	public String HomePageLocation;
	public String HomePageAdultcount;
	public String HomePageChildcount;
	public String AdultcountHome;
	public String ChildcountHome;

	public String SearchpageChild;
	public String SearchpageDate;
	public String SearchpageAdults;
	public String SearchpageLocation;
	
	public String EditSearchpageChild;
	public String EditSearchpageChildCount;
	public String EditSearchpageDate;
	public String EditedCheckInSearch;
	public String EditedCheckOutSearch;
	public String EditSearchpageAdults;
	public String EditSearchpageAdultsCount;
	public String EditSearchpageLocation;
	public String SelectedHotelNameInSearchPage;
	
	public String HotelPageadult;
	public String HotelPagechild;
	public String HotelpageDatedate;
	public String HotelpageLocation;
	public String SelectedHotelNameHotelPage;
	
	public String EditHotelPageadult;
	public String EditHotelPageadultCount;
	public String EditHotelPagechild;
	public String EditHotelPagechildCount;
	public String EditHotelpageDatedate;
	public String EditedCheckInHotel;
	public String EditedCheckOutHotel;
	public String EditHotelpageLocation;
	public String EditChilpageAgeSecond;
	

	public String CheckoutPageadult;
	public String CheckoutPagechild;
	public String CheckINpageDatedate;
	public String CheckOutpageDatedate;
	
	
	public String SuceesMassage;

	@FindBy(xpath = ("//div[@class='cky-consent-bar']"))
	WebElement policy;

	@FindBy(xpath = ("//button[@data-cky-tag=\"accept-button\"]"))
	WebElement Acceptpolicybutton;

	// To Enter Address
	@FindBy(xpath = ("//input[@id='cityTypeAhead']"))
	
	WebElement EnterAddress;

//To Enter searched result address
	@FindBy(xpath = ("//div[@id='suggestResult1']"))
	WebElement EntersearcheResult;

//To open the date calendar
	@FindBy(id = ("checkinForm"))
	WebElement EnterDate;

//To Enter first date
	@FindBy(xpath = ("(//td[contains(text(),'19')])[2]"))
	WebElement EnterFirstDate;

//To Enter first date
	@FindBy(xpath = ("(//td[@class='available'][normalize-space()='21'])[1]"))
	WebElement EnterSecondDate;

//To increase Adult first count
	@FindBy(xpath = ("//div[@id='numAdultsPlus']//i[@role='presentation']"))
	WebElement PlusAdultcount;

//To increase Child count
	@FindBy(xpath = ("//div[@id='numChildrenPlus']//i[@role='presentation']"))
	WebElement PlusChildcount;

//Click on search in home page
	@FindBy(xpath = ("//span[@id='searchButtonText']"))
	WebElement SearchBtn;

//Click on search in listing page
	@FindBy(xpath=("//div[@id='searchButtonText']"))
	WebElement SearchBtninListing;
		
	
//Click book first hotel in searched
	@FindBy(xpath = ("//*[@data-rank=\"0\"]"))
    WebElement ClickFirstHotel;

//click on book
	@FindBy(id=("bookButton2"))
	WebElement BookFirstHotel;
	////button[@id='bookButton1']

//Personal Details fields
	@FindBy(xpath = ("//input[@id='firstName']"))
	WebElement FirstName;

	@FindBy(xpath = ("//input[@id='lastName']"))
	WebElement LastName;

	@FindBy(xpath = ("//input[@id='phoneNumber']"))
	WebElement PhoneNumber;

	@FindBy(xpath = ("//input[@id='emailAddress']"))
	WebElement EmailAddress;

//payment page details
	@FindBy(xpath = ("//input[@id='firstNamePayment']"))
	WebElement FirstNamePayment;

	@FindBy(xpath = ("//input[@id='creditCardNumber']"))
	WebElement CreditCardNumber;

	@FindBy(xpath = ("//input[@id='expirationMonth']"))
	WebElement ExpirationMonth;

	@FindBy(xpath = ("//input[@id='expirationYear']"))
	WebElement ExpirationYear;

	@FindBy(xpath = ("//input[@id='securityCode']"))
	WebElement SecurityCode;

//For  billing address details	
	@FindBy(id = ("countrySelect"))
	WebElement countrySelect;

	@FindBy(xpath = ("//*[@id=\"countrySelect\"]/option[2]"))
	WebElement countrySelectfromlist;

	@FindBy(id = ("billingAddress1"))
	WebElement BillingAddress1;

	@FindBy(id = ("billingAddress2"))
	WebElement billingAddress2;

	@FindBy(id = ("billingCity"))
	WebElement billingCity;

	@FindBy(id = ("provinceSelect"))
	WebElement provinceSelect;

	@FindBy(xpath = ("//*[@id=\"provinceSelect\"]/option[3]"))
	WebElement provinceSelectfromlist;

	@FindBy(id = ("postalCode"))
	WebElement PostalCode;

	@FindBy(xpath = ("//*[@id=\"bookbutton\"]"))
	WebElement FinalBookingButton;

	public SearchHotels() 
	{

		PageFactory.initElements(driver, this);
		// he this keyword can be used to refer current class instance variable.
		
	}

	// Actions on page
	public String ValidateHomeTitle() throws Exception

	{

		return driver.getTitle();
	}

	public void acceptpolicy() 
	{
		// https://www.seleniumeasy.com/selenium-tutorials/waits-and-timeout-selenium-4
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for an element to be present and visible privacy policy
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cky-consent-bar']")));
	}
	
	public void policybuttonclick()
	{
		Acceptpolicybutton.click();
	}


	public void AddingRequirment(String ad) throws Exception 
	{
		// Enter the address and store
		EnterAddress.sendKeys(ad);
		Thread.sleep(2000);
		EntersearcheResult.click();
		Thread.sleep(1000);
		
		// Enter the date and store
		EnterDate.click();
		Thread.sleep(1000);
		EnterFirstDate.click();
		EnterSecondDate.click();
		
		// Add the adult count and get text
		PlusAdultcount.click();
		Thread.sleep(500);
	
		// Add the child count and get text
		PlusChildcount.click();
		Thread.sleep(500);	
	}
	public void storeHomePageDetails() throws Exception 
	{
		
 		HomePageDate = driver.findElement(By.xpath("(//input[@id='checkinForm'])[1]")).getAttribute("value");
 		System.out.println("Entered Date" + "=" + HomePageDate);
 		//Taken from Hidden
 		CheckINHome=driver.findElement(By.xpath("//input[@id='checkin']")).getAttribute("Value");
 		System.out.println("Check In Date in HomePage" + "="+CheckINHome);
 		//Taken from Hidden
 		CheckOutHome=driver.findElement(By.xpath("//input[@id='checkout']")).getAttribute("Value");
 		System.out.println("Check Out Date in HomePage" + "="+CheckOutHome);
 		
 		//taken from Hidden
 		HomePageLocation = driver.findElement(By.xpath("//input[@id='locationID']")).getAttribute("value");	
 		System.out.println("Entered Location Id" + "=" + HomePageLocation);
 		
		WebElement textElementadult = driver.findElement(By.xpath("//div[@id='numAdultsDisplay']"));
		HomePageAdultcount = textElementadult.getText();
		Thread.sleep(500);
		String inputString =HomePageAdultcount;
		String[] parts = inputString.split(" ", 2);
		AdultcountHome = parts[0];
		System.out.println("Home page Adult count"+"="+AdultcountHome);
		 Thread.sleep(500);
		System.out.println("Entered Adults count " + "=" + HomePageAdultcount);
		WebElement textElementChild = driver.findElement(By.xpath("//div[@id='numChildrenDisplay']"));
		HomePageChildcount = textElementChild.getText();
		System.out.println("Entered Child count " + "=" + HomePageChildcount);
		Thread.sleep(500);
		String inputString1 =HomePageChildcount;
		String[] parts1 = inputString1.split(" ", 2);
		ChildcountHome = parts1[0];
		System.out.println("Home page Child count"+"="+ChildcountHome);
		Thread.sleep(500);
	}
	
     public void HomePageserchClick() 
     {
    	
		// After filling click on search
		SearchBtn.click();
	 }

// This is for Storelisting page only
    public void StoreListingPagesDetails() throws Exception
                 
	{

		Thread.sleep(2000);
		
		// Storedate
		SearchpageDate = driver.findElement(By.xpath("(//input[@id='checkinInput'])[1]")).getAttribute("value");
		System.out.println("Search page date" +"="+SearchpageDate);
		Thread.sleep(1000);
		// Store Location from Hidden
		SearchpageLocation = driver.findElement(By.xpath("//input[@id='locationID']")).getAttribute("value");
		System.out.println("Search Page location Id " +"="+ SearchpageLocation);
		Thread.sleep(1000);
		// storeadult
		SearchpageAdults = driver.findElement(By.xpath("//div[@id='numAdultsDisplay']")).getText();
		System.out.println("Search page Adult" +"="+SearchpageAdults);
		Thread.sleep(500);
		// Storechild
		SearchpageChild = driver.findElement(By.xpath("//div[@id='numChildrenDisplay']")).getText();
		System.out.println("Search page Child" +"="+SearchpageChild);
	}
	
	public void EditListingPagesLocation() throws Exception
	{
		driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).clear();
		driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).sendKeys("Florida");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='suggestResult1']")).click();
		EditSearchpageLocation= driver.findElement(By.xpath("//input[@id='cityTypeAhead']")).getAttribute("value");		
	}
	public void EditListingPagesDate() throws Exception
	{
		driver.findElement(By.id("checkinInput")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@class='available'][normalize-space()='21']")).click();
		driver.findElement(By.xpath("(//td[contains(text(),'22')])[2]")).click();
		Thread.sleep(1000);
		EditSearchpageDate= driver.findElement(By.id("checkinInput")).getAttribute("value");
		EditedCheckInSearch= driver.findElement(By.xpath("//input[@id='checkin']")).getAttribute("Value");
		System.out.println("Update Check In date in listing Page" + "="+EditedCheckInSearch);
		EditedCheckOutSearch=driver.findElement(By.xpath("//input[@id='checkout']")).getAttribute("Value");
		System.out.println("Update Check Out date in listing Page" + "="+EditedCheckOutSearch);
		
	}
	public void EditListingPagesAdult() throws Exception
	{
		driver.findElement(By.xpath("//div[@id='numAdultsMinus']//i[@class='bi bi-dash-square']")).click();
		Thread.sleep(1000);
		EditSearchpageAdults= driver.findElement(By.xpath("//div[@id='numAdultsDisplay']")).getText();
		Thread.sleep(500);
		 String inputString4 =EditSearchpageAdults;
		 String[] parts = inputString4.split(" ", 2);
		 EditSearchpageAdultsCount = parts[0];
		 System.out.println("Search(Edited) page Adult count"+"="+EditSearchpageAdultsCount);
		 Thread.sleep(500);
	}
	public void EditListingPagesChild() throws Exception
	{
		driver.findElement(By.xpath("//div[@id='numChildrenPlus']//i[@class='bi bi-plus-square']")).click();
		Thread.sleep(1000);
		EditSearchpageChild= driver.findElement(By.xpath("//div[@id='numChildrenDisplay']")).getText();
		Thread.sleep(500);
		String inputString3 =EditSearchpageChild;
		String[] parts = inputString3.split(" ", 2);
		EditSearchpageChildCount = parts[0];
		System.out.println("Search(Edited) page child count"+"="+EditSearchpageChildCount);
		Thread.sleep(500);
		WebElement Age=driver.findElement(By.xpath("//select[@id='childAge2']"));
		Age.click();
		Age.sendKeys(Keys.ARROW_DOWN);
		Age.sendKeys(Keys.ENTER);
		EditChilpageAgeSecond= driver.findElement(By.xpath("//select[@id='childAge2']")).getAttribute("value");
		
	}
	//After Edit Click on the Search to refresh
	public void ClickOnSearchListingpage() 
	{
		SearchBtninListing.click();
	}
	
	//Click on First Search Hotel
	public void Clickhotel()
	{
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		// Wait for an element to be present and invisible
		WebElement loadingImage = driver.findElement(By.xpath("(//img[@alt='loading image'])[1]"));
		wait1.until(ExpectedConditions.invisibilityOf(loadingImage));
		//Store Hotel Name-
		SelectedHotelNameInSearchPage=driver.findElement(By.className("srHotelName")).getText();
		System.out.println("Selected Hotel Is"+"="+SelectedHotelNameInSearchPage);
		
		ClickFirstHotel.click();
	}

// This is for Hotel page page only
	public void checkrequirmentmatchinhotelPage() throws Exception

	{
		HotelpageDatedate = driver.findElement(By.cssSelector("#travelDates")).getAttribute("value");
		System.out.println("Output Date on Hotel book page" + "=" + HotelpageDatedate);
		// StoreAdult
		HotelPageadult = driver.findElement(By.xpath("//div[@id='numAdultsDisplay']")).getText();
		System.out.println("Output Adult on Hotel book page" + "=" + HotelPageadult);
		// StoreChil HotelPagechild=
		HotelPagechild=driver.findElement(By.xpath("//div[@id='numChildrenDisplay']")).getText();
		System.out.println("Output page hotel count " + "=" + HotelPagechild);
		//To Store the Hotel Name-
		SelectedHotelNameHotelPage=driver.findElement(By.cssSelector("div[id='sticyHeaderHotelHeadline'] h1")).getText();
		System.out.println("Hotel Page Name is" +"="+SelectedHotelNameHotelPage );
		
	}
	public void WaitInHotelPage() throws InterruptedException
	{
		WebDriverWait wait21 = new WebDriverWait(driver, Duration.ofSeconds(20));
		// Wait for an element to be present and visible
		wait21.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt=\"Primary image\"]")));////img[@alt='Primary image']
		
	}
	
	public void WaitUntilRateChange() throws InterruptedException
	{
		//div[@id='targetDiv']
		WebDriverWait wait23 = new WebDriverWait(driver, Duration.ofSeconds(20));
		// Wait for an element to be present and visible
		wait23.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='licencePlacePrice']")));////img[@alt='Primary image']
		
		
	}
	//
	public void EditHotelPagesNewDate() throws Exception //need to change
	{
		driver.findElement(By.cssSelector("#travelDates")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@class='available'][normalize-space()='26']")).click();
		driver.findElement(By.xpath("//td[@class='available'][normalize-space()='28']")).click();
		Thread.sleep(500);
		EditHotelpageDatedate= driver.findElement(By.xpath("//*[@id=\"travelDates\"]")).getAttribute("value");
		System.out.println("Edit hotel page date is "+ EditHotelpageDatedate);
		EditedCheckInHotel= driver.findElement(By.xpath("//input[@id='checkin']")).getAttribute("Value");
		System.out.println("Updated CheckIn date in Hotel Page"+"="+EditedCheckInHotel);
		EditedCheckOutHotel=driver.findElement(By.xpath("//input[@id='checkout']")).getAttribute("Value");
		System.out.println("Updated Check Out date in Hotel Page"+"="+EditedCheckOutHotel);
		
		
	}
	public void EditHotelPagesNewAdult() throws Exception //need to change
	{
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@id='numAdultsMinus']//i[@class='bi bi-dash-square']")).click();
		Thread.sleep(500);
		EditHotelPageadult= driver.findElement(By.xpath("//div[@id='numAdultsDisplay']")).getText();
		String inputString5 =EditHotelPageadult;
		String[] parts = inputString5.split(" ", 2);
		EditHotelPageadultCount = parts[0];
		System.out.println("Hotel(Edited) page adult count"+"="+EditHotelPageadultCount);
		System.out.println("Edit hotel page Adult is "+ EditHotelPageadult);
	}
	public void EditHotelNewPagesChild() throws Exception // need to change
	{
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@id='numChildrenMinus']//i[@class='bi bi-dash-square']")).click();
		Thread.sleep(500);
		EditHotelPagechild= driver.findElement(By.xpath("//div[@id='numChildrenDisplay']")).getText();
		String inputString6 =EditHotelPagechild;
		String[] parts = inputString6.split(" ", 2);
		EditHotelPagechildCount = parts[0];
		System.out.println("Hotel(Edited) page adult count"+"="+EditHotelPagechildCount);
		
		
		
		System.out.println("Edit hotel page child is "+ EditHotelPagechild);
	}	
		
		
//Click on Book Hotel for normal flow		
	public void Bookhotel() 
	{
		//WebElement Ratechange= driver.findElement(By.xpath(AdultcountHome))
	
		BookFirstHotel.click();
	}
	public void Bookhotel2() 
	{
	
		driver.findElement(By.id("bookButton1")).click();
	}	
	
		
//To verify requirement Match or not in checkout page
	public void DetailsRequirmentInCheckoutPage() 
	{
		WebElement Check_In= driver.findElement(By.cssSelector(".float-left.bookingDetailData.mr-3"));
		CheckINpageDatedate=Check_In.getText();	
		System.out.println("Check In date is "+"="+CheckINpageDatedate);
		
		WebElement Chech_Out=driver.findElement(By.cssSelector("div[class='row ml-0 pl-0'] div div[class='float-left bookingDetailData']"));
		CheckOutpageDatedate=Chech_Out.getText();
		System.out.println("Check In date is"+"="+CheckOutpageDatedate);
		
		
		WebElement Adult_Count= driver.findElement(By.cssSelector("div[class='row ml-0'] div:nth-child(2)"));
		CheckoutPageadult=Adult_Count.getText();
		System.out.println("Adult count is "+"="+CheckoutPageadult);
		
		WebElement Child_Count= driver.findElement(By.xpath("//*[@id=\"bookingDetailsContainer\"]/div[3]/div[4]"));
		CheckoutPagechild=Child_Count.getText();
		System.out.println("Child count is "+"="+CheckoutPagechild);		
	}	

//Fill the Details and Final Booking	
	public void FinaliBookingAddingPersonalDetails() throws Exception
	{
		Thread.sleep(1000);
		FirstName.sendKeys(ConfigureProperties.firstName1);
		LastName.sendKeys(ConfigureProperties.LastName1);
		PhoneNumber.sendKeys(ConfigureProperties.Phone_Number1);
		EmailAddress.sendKeys(ConfigureProperties.EmailID1);
		FirstNamePayment.sendKeys(ConfigureProperties.firstName1);
		CreditCardNumber.sendKeys(ConfigureProperties.Credit_Card_Number1);
		ExpirationMonth.sendKeys(ConfigureProperties.Month1);
		ExpirationYear.sendKeys(ConfigureProperties.Year1);
		SecurityCode.sendKeys(ConfigureProperties.Security_Code1);
		countrySelect.click();
		countrySelectfromlist.click();
		BillingAddress1.sendKeys(ConfigureProperties.Address_11);
		billingAddress2.sendKeys(ConfigureProperties.Address_22);
		billingCity.sendKeys(ConfigureProperties.City1);
		provinceSelect.click();
		provinceSelect.sendKeys(Keys.ARROW_DOWN);
		provinceSelect.sendKeys(Keys.ENTER);
		PostalCode.sendKeys(ConfigureProperties.Postal_Code1);
	}
	
		public void FinalBookingClick()
		{
		FinalBookingButton.click();

	    }
		public void SucessMassageTitle() 
		{
			SuceesMassage=driver.findElement(By.cssSelector("div[class='alert alert-success m-0']")).getText();
			System.out.println(SuceesMassage);
			
		}

}
