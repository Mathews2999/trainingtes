package com.itlearn.testcases;

import org.testng.annotations.Test;

import com.itlearn.pages.LoginPage;
import com.itlearn.pages.BaseTest;
public class LoginTest extends BaseTest {

	@Test
	void verifylogin()
	{
		LoginPage lp= new LoginPage(driver);
		String username= "Demo12";
		String password= "Test123456$";
		lp.loginportal(username, password);
				
		
	}
	
	
}
