package com.westwing.pageFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utility.base.TestBase;
import com.utility.base.WrapperFunctions;
import com.westwing.locators.WestWingHomePage;
import com.westwing.locators.WestWingLoginPage;

public class WestWingHomePageFunctions extends WestWingHomePage {

	WestWingLoginFormPageFunctions loginPageFunction = new WestWingLoginFormPageFunctions();

	public boolean verifyExistence() {

		return WestWingHomePage.searchInputBox.isDisplayed();
	}

	public boolean verifyTitleOfPage(String title) {

		return WestWingHomePage.title.getText().equals(title);
	}

	public void enterSearchText(String S) {

		WestWingHomePage.searchInputBox.sendKeys(S);
		;

	}

	public void clickOnAcceptCookie() {

		if (WestWingHomePage.acceptCookieButton.isDisplayed()) {
			WestWingHomePage.acceptCookieButton.click();

		}
	}

	public void selectSuggestion(String suggestion) {

		if (WestWingHomePage.getSuggestionElement(suggestion).isDisplayed()) {
			WestWingHomePage.getSuggestionElement(suggestion).click();

		} else {
			System.out.println("Element is not visible");
		}

	}

	public boolean verifySearchResult(String suggestion) {

		return WrapperFunctions.isElementPresent(WestWingHomePage.getSearchedProductList(suggestion),
				"Suggestion List");
	}

	public void addToWishList(int itemNumber) {

		dismissOverlay();
		if (WestWingHomePage.getRequestedProductWishListIcon(itemNumber).isDisplayed()) {
			WestWingHomePage.getRequestedProductWishListIcon(itemNumber).click();
			WrapperFunctions.waitForTime(1000);
		} else {
			System.out.println("Element is not visible");
		}

	}

	public int getwishListCounter() {
		int count = Integer.parseInt(WestWingHomePage.wishlistCounter.getText());
		return count;

	}

	public void dismissOverlay() {
//Added logic if overlay is present
		WrapperFunctions.waitForTime(1000);
		if (WrapperFunctions.isElementPresent(WestWingHomePage.lnButton, "overlay")) {
			WestWingHomePage.lnButton.click();
			WestWingHomePage.crossButton.click();
		} else {
			// do nothing
			return;
		}

	}

	public void deleteFromWishList() {

		WestWingHomePage.wishList.click();
		if (getwishListCounter() > 0) {
			WestWingHomePage.getProductTobeDeleted(1).click();
		}
	}

}
