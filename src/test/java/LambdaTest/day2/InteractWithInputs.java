package LambdaTest.day2;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InteractWithInputs {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(300));

        Page page = browser.newPage();
        page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        page.locator("input[id=\"user-message\"]").fill("Hey Tester");
        page.locator("id=showInput").click();

        // textContent() = getText() in selenium
        String message = page.locator("#message").textContent();

        assertThat(page.locator("#message")).hasText("Hey Tester");


        // type vs fill
        page.navigate("https://www.lambdatest.com/selenium-playground/generate-file-to-download-demo");

        // it will type one by one
        page.locator("#textbox").type("Nigeria yorkshire sagem cosmetic photos " +
                "indicates helpful, plastics. ");

        // clear and inject the value directly
        page.locator("#textbox").fill("Nigeria yorkshire sagem cosmetic photos " +
                "indicates helpful, plastics. ");

        page.navigate("https://letcode.in/edit");

        // Returns the value for the matching <input> or <textarea> or <select> element.
        String txt = page.locator("#getMe").inputValue();
        System.out.println("txt = " + txt);

        String placeholderVal = page.locator("#fullName").getAttribute("placeholder");
        System.out.println("placeholderVal = " + placeholderVal);


        Locator fullNameLocator = page.locator("#fullName");

        // Assertion for placeholder value
        assertThat(fullNameLocator).hasAttribute("placeholder","Enter first & last name");

        page.locator("#clearMe").clear();


        page.navigate("https://www.lambdatest.com/selenium-playground/checkbox-demo");
        Locator isAgeCheckbox = page.locator("#isAgeSelected");

        assertThat(isAgeCheckbox).not().isChecked();

        // for clicking checkboxes but type of the locator should be "checkbox"
        isAgeCheckbox.check();
        assertThat(isAgeCheckbox).isChecked();

        playwright.close();

    }
}
