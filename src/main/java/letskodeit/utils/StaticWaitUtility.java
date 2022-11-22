package letskodeit.utils;


import letskodeit.base.lestkodeitConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class StaticWaitUtility {
  //This is for creating re-usable methods for different static waits
  public WebDriver driver;

	public StaticWaitUtility(WebDriver driver) {
		this.driver = driver;
	}

	public static Logger log = LogManager.getLogger(StaticWaitUtility.class);
//#1.small wait
	public void staticSmallWait()
	{
		try
		{
			Thread.sleep(lestkodeitConstants.STATIC_SMALL_WAIT);
			log.info("static small wait is implemented");
		}
		catch(Exception ex)
		{
			log.debug("Exception at static small wait is implemented"+ex);
		}
	}
	
	//#2.medium wait
		public void staticMediumWait()
		{
			try
			{
				Thread.sleep(lestkodeitConstants.STATIC_MEDIUM_WAIT);
				log.info("static medium wait is implemented");
			}
			catch(Exception ex)
			{
				log.debug("static medium wait is implemented"+ex);
			}
		}
		//#3.long wait
		public void statilongWait()
		{
			try
			{
				Thread.sleep(lestkodeitConstants.STATIC_LONG_WAIT);
				log.info("static long wait is implemented");
			}
			catch(Exception ex)
			{
				log.debug("Exception at static long wait is implemented"+ex);
			}
		}
		//#3.long wait
				public void staticSecWait()
				{
					try
					{
						Thread.sleep(lestkodeitConstants.STATIC_SEC_WAIT);
						log.info("static sec wait is implemented");
					}
					catch(Exception ex)
					{
						log.debug("Exception at static sec wait is implemented"+ex);
					}
				}
		
}
