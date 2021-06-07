package com.westwing.pageFunctions;

import com.utility.base.WrapperFunctions;
import com.westwing.locators.WestWingHomePage;
import com.westwing.locators.WestWingLoginPage;

public class WestWingLoginFormPageFunctions extends WestWingLoginPage {

	public void navigateToLoginPageFromRegisterPage() {

		WrapperFunctions.waitForElementVisibility(WestWingLoginPage.loginRegsiterFormTitle, 3, driver);
		WrapperFunctions.waitForElementVisibility(WestWingLoginPage.loginLink, 3, driver);
		WestWingLoginPage.loginLink.click();
		WrapperFunctions.waitForElementVisibility(WestWingLoginPage.loginFormTitle, 3, driver);

	}

	public void login() {

		WrapperFunctions.waitForElementVisibility(WestWingLoginPage.loginFormTitle, 4, driver);
		WestWingLoginPage.emailInputBox.clear();
		WestWingLoginPage.emailInputBox.sendKeys(prop.getProperty("username"));
		WestWingLoginPage.passwordInputBox.clear();
		WestWingLoginPage.passwordInputBox.sendKeys(prop.getProperty("password"));

		// WestWingLoginPage.checkBoxTC.click();
		WestWingLoginPage.submitButton.click();

	}

	public void dismissOverlay() {

		WestWingLoginPage.page.click();
		/*if (WestWingLoginPage.loginRegsiterFormTitle.isDisplayed() || WestWingLoginPage.loginFormTitle.isDisplayed()) {
			WestWingLoginPage.page.click();
			System.out.println("Overlay Dismissed");
		} else {
			System.out.println("Overlay not present");
		}*/
	}
}
