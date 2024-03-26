package com.itlearn.testcases;




import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.DashBoardPage;
import com.itlearn.pages.LoginPage;
import com.itlearn.utility.ReadExcelFile;

public class DashBoardTest extends BaseTest {


	String fileName=System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";

	@Test(priority =1)
	public void VerifyLogin() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		String username= ReadExcelFile.getCellValue(fileName, "LoginData", 1, 0);
		String password= ReadExcelFile.getCellValue(fileName, "LoginData", 1, 1);
		System.out.println(username+" "+password);
		lp.loginportal(username, password);
		
		if((username.equals("Demo12")) && (password.equals("Test123456$")))
		{
			System.out.println("Test Passed");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority =2)
	public void fetchDashboardText() throws IOException
	{
		DashBoardPage dp=new DashBoardPage(driver);
		String as=ReadExcelFile.getCellValue(fileName, "dash", 0, 0);
		System.out.println("This is excel data "+as);
		dp.dashboardportal(ReadExcelFile.getCellValue(fileName, "dash", 0, 0));
		dp.dashboardclick();

	}
	

}

