package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;

public class LoginTest extends BaseHRMClass {
	
	PomLogin Log;
	public LoginTest() {
		
	super();	// initialize config.properties
	}
	
	@BeforeMethod
	public void initsetup() throws InterruptedException {
		initiate();    // read all the data and pass it into the method 
		screenshots("Login");
		 Log= new PomLogin();
	}
	
	@Test (priority=1)
	public void Title() throws Exception {
Thread.sleep(2000);
	String actual=	Log.verify();
	System.out.println(actual);  // if you want to see  actual title 
	
		Assert.assertEquals(actual, "OrangeHRM");

		}
	@DataProvider
	public Object[][]Details(){
		Object result [][]=ExcelSheet.readdata("Sheet1");
		return result;
	}
@Test (priority=2, dataProvider="Details")
	public void Login(String name,String password) {
		Log.typeusername(name);
		Log.typepassword(password);
	   //   Log.clickbutton();
		
	}
	
	@AfterMethod
	public void close() {
	driver.close();
	
	
}}
