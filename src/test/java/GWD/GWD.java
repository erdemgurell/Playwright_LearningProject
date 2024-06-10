package GWD;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class GWD {
    public static Page page;
    public static Browser browser;
    public static Playwright playwright;

    @BeforeClass
    public void startDriver(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(800));
        page = browser.newPage();

    }

    @AfterClass
    public void closeDriver(){

        browser.close();
        playwright.close();
    }
}
