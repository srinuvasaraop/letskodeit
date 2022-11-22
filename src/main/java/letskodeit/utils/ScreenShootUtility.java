package letskodeit.utils;
import letskodeit.base.lestkodeitConstants;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

public class ScreenShootUtility {

	// #1.Utility for taking screenshot
	public String takesScreeshotForTestCases(WebDriver driver, String methodName) {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		// call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		String path= lestkodeitConstants.TCS_SCREENSHOTS_LOCATION + "\\" + methodName+".png";
		File DestFile = new File(path);
		// Copy file at destination
		try {
			FileHandler.copy(SrcFile, DestFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
}
