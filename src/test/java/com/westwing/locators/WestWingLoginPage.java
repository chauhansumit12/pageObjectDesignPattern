package com.westwing.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.base.TestBase;

public class WestWingLoginPage extends TestBase {

	public WestWingLoginPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//head")
	protected static WebElement page;

	@FindBy(xpath = "//input[@name='email']")
	protected static WebElement emailInputBox;

	@FindBy(xpath = "//input[@name='password']")
	protected static WebElement passwordInputBox;

	@FindBy(xpath = "//input[@type='checkbox']")
	protected static WebElement checkBoxTC;

	@FindBy(xpath = "//button[@type='submit']")
	protected static WebElement submitButton;

	@FindBy(xpath = "//button[contains(text(),'Hier einloggen')]")
	protected static WebElement loginLink;

	@FindBy(xpath = "//*[contains(text(),'Neukunde?')]")
	protected static WebElement loginRegsiterFormTitle;

	@FindBy(xpath = "//p[contains(text(),'Bereits registriert?')]")
	protected static WebElement loginFormTitle;

}
