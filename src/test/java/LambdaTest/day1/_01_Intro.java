package LambdaTest.day1;

import GWD.GWD;
import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class _01_Intro extends GWD {

    @Test
    public void test() {
        page.navigate("https://www.google.com/");
        System.out.println(page.title());
        page.locator("div textarea").fill("playwright");
        page.keyboard().press("Enter");
        page.waitForLoadState();
        System.out.println(page.title());
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));


    }

}
