package com.westwing.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utility.base.WrapperFunctions;
import com.westwing.locators.WestWingHomePage;
import com.westwing.pageFunctions.WestWingHomePageFunctions;
import com.westwing.pageFunctions.WestWingLoginFormPageFunctions;

public class SearchTest extends WestWingHomePageFunctions {

	WestWingHomePageFunctions homePageFunctions = new WestWingHomePageFunctions();
	WestWingLoginFormPageFunctions loginPageFunctions = new WestWingLoginFormPageFunctions();

	public SearchTest() {
		super();
	}

	@BeforeTest(alwaysRun = true)
	@Parameters("browser")// This is not used as of now and can be used to read browser type from testng.xml
	public void setUp(@Optional String browser) {

		initialization(prop.getProperty("browser"), "chrome");
		SearchTest searchPageTest = new SearchTest();
	}

	@Test
	public void verifySearchedItemAddToWishList() {

		SoftAssert softAssert = new SoftAssert();
		String searchText = "möbel";
		String suggestion = "Möbel";
		int count = 1;

		homePageFunctions.clickOnAcceptCookie();

		homePageFunctions.enterSearchText(searchText);
		homePageFunctions.selectSuggestion(suggestion);
		softAssert.assertEquals(homePageFunctions.verifySearchResult(suggestion), true);

		homePageFunctions.addToWishList(1);

		loginPageFunctions.navigateToLoginPageFromRegisterPage();
		loginPageFunctions.login();

		softAssert.assertEquals(homePageFunctions.getwishListCounter(), count);
		homePageFunctions.deleteFromWishList();
		
		//This assert will work only if there are no products present
		softAssert.assertEquals(WestWingHomePage.emptyWishListMessage.isDisplayed(), true);

		softAssert.assertAll();

	}

	@AfterTest(alwaysRun = true)
	public void tearDown() {
		WrapperFunctions.closeBrowser(driver);
		WrapperFunctions.driverQuit(driver);

	}

}
