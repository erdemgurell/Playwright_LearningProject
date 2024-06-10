package LambdaTest.day4;

import GWD.GWD;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ScreenshotCaret;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Screenshots extends GWD {

    @Test
    public void test() {
        // Navigate to the specified URL
        page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");

        // Create a new instance of ScreenshotOptions
        Page.ScreenshotOptions screenshotOptions = new Page.ScreenshotOptions();

        // Take a screenshot of the entire page and save it to a file
        page.screenshot(screenshotOptions.setPath(Paths.get("./snaps/scr.png")));

        // Take a screenshot of the full page and save it to a file
        page.screenshot(screenshotOptions.setFullPage(true)
                .setPath(Paths.get("./snaps/fullPage.jpg")));

        // Create a Locator for the "Book a Demo" button
        Locator bookBtn = page.locator("//button[text()='Book a Demo']");

        // Take a screenshot of the Locator and save it to a file
        bookBtn.screenshot(new Locator.ScreenshotOptions()
                .setPath(Paths.get("./snaps/locator.png")));

        // Create a Locator for the header element
        Locator header = page.locator("#header");
        // Take a screenshot of the header element and save it to a file
        header.screenshot(new Locator.ScreenshotOptions()
                .setPath(Paths.get("./snaps/header.png")));


        // Create a Locator for the input element
        Locator input = page.locator("input#user-message");
        // Scroll the input element into view if it's not visible
        input.scrollIntoViewIfNeeded();

//        input.type("Something");
//        page.screenshot(screenshotOptions
//                .setPath(Paths.get("./snaps/input.png"))
//                .setFullPage(false)
//                .setMask(List.of(input)));


        // Click the input element
        input.click();
        // Take a screenshot of the input element with the caret hidden and save it to a file
        page.screenshot(new Page.ScreenshotOptions().setCaret(ScreenshotCaret.HIDE)
                .setPath(Paths.get("./snaps/caretHIDE.png")));
        // Take a screenshot of the input element with the caret in its initial state and save it to a file
        page.screenshot(new Page.ScreenshotOptions().setCaret(ScreenshotCaret.INITIAL)
                .setPath(Paths.get("./snaps/caretINIT.png")));



    }


}
