package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;
public class BaseHRMClass {

  public static Properties prop;
	public static WebDriver driver;
	
	
	//  Constructor of class
	public BaseHRMClass()   {       //FileInputStream is a class which is used to which have methods to read data from any file
		try {
			  prop = new Properties();
			FileInputStream file=new FileInputStream("C:\\Users\\nikun\\OneDrive\\Desktop\\Eclipse IDE\\HRmanagement\\src\\test\\java\\environmentvariables\\Config.properties");
		prop.load(file);
		
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException a) {
			a.printStackTrace();
			}
		
		}
		
		public static void initiate() throws InterruptedException {
			// if browser=chrome webdriver.chrome.driver
			//elseif(browser=firefox)
			//webdriver.gecko.driver
 String browsername= prop.getProperty("browser");
		Thread.sleep(2000);
		if (browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","geckodriver.exe");
			
			driver=new FirefoxDriver();
			driver.get("https://www.google.com/");
			 if (browsername.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver","chrome.exe");
				driver=new ChromeDriver();
				
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS); // instead of passing hard coded values
		driver.manage().timeouts().implicitlyWait(TimeUtils.timepage, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));}
		
}
			
	public static void screenshots(String Filename) {
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(file, new File("C:\\Users\\nikun\\OneDrive\\Desktop\\Eclipse IDE\\HRmanagement\\src\\test\\java\\screenshots\\Screenshots"+Filename+".jpg"));
	}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	

	
		
	}}
	
	
	

