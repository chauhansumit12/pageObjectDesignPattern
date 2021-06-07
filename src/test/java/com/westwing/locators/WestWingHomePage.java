package com.westwing.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.base.TestBase;

public class WestWingHomePage extends TestBase {

	public WestWingHomePage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//title")
	protected static WebElement title;

	@FindBy(xpath = "//*[local-name()='svg' and @data-testid='header-search-icon']")
	protected static WebElement searchIcon;

	@FindBy(xpath = "//input[@type='search' or @placeholder='Product Search...']")
	protected static WebElement searchInputBox;

	// public static WebElement
	// searchInputBox2=driver.findElement(By.xpath("//input[@type='search' and
	// @placeholder='Product Search...']"));

	@FindBy(xpath = "//div[@class='banner-actions-container']/button[@id='onetrust-accept-btn-handler']")
	protected static WebElement acceptCookieButton;

	@FindBy(xpath = "//div[@data-testid='suggestions']//header[text()='Kategorien']/../nav//strong[text()='Möbe']//..")
	protected static WebElement selectingCategoryP2;

	@FindBy(xpath = "//div[@data-testid='suggestions']//header[text()='Kategorien']")
	protected static WebElement selectingCategoryP;

	@FindBy(xpath = "//div[@data-testid='plp-products-grid']")
	protected static WebElement searchResultParentWE;

	protected static WebElement getSearchedProductList(String product) {
		WebElement productListWebElement = driver.findElement(
				By.xpath("//h1[text()='" + product + "']/ancestor::main//div[@data-testid='plp-products-grid']"));

		return productListWebElement;
	}

	protected static WebElement getSuggestionElement(String suggestion) {

		WebElement suggestionWebElement = driver
				.findElement(By.xpath("//div[@data-testid='suggestions']//strong[text()='" + suggestion + "']/.."));
		return suggestionWebElement;
	}

	protected static WebElement getRequestedProduct(int productNumber) {
		WebElement productFromSearchList = searchResultParentWE
				.findElement(By.xpath("//div[@data-testid='generic-product'][" + productNumber + "]"));
		return productFromSearchList;
	}

	protected static WebElement getRequestedProductWishListIcon(int itemNumber) {
		WebElement wishListIcon = searchResultParentWE.findElement(By
				.xpath("//div[@data-testid='generic-product'][" + itemNumber + "]//div[@data-testid='wishlist-icon']"));
		return wishListIcon;

	}

	@FindBy(xpath = "//span[@data-testid='wishlist-counter']")
	protected static WebElement wishlistCounter;

	@FindBy(xpath = "//button[@data-testid='login-button']")
	protected static WebElement lnButton;

	@FindBy(xpath = "//button[@data-identifier='LOGIN_AND_REGISTER']")
	protected static WebElement crossButton;

	@FindBy(xpath = "//div[@data-testid='wishlist-bubble']")
	protected static WebElement wishList;

	protected static WebElement getProductTobeDeleted(int itemNumber) {
		return driver.findElement(By.xpath("//div[contains(@class,'wishlistContainer_detail')]//ul//li[" + itemNumber
				+ "]//button[contains(@class,'qaBlockListProduct__delete')]"));

	}

	@FindBy(xpath = "//div[@class='wishlistNoProducts__info']//*[text()=' ist momentan leer']")
	protected static WebElement emptyWishListMessage;

}