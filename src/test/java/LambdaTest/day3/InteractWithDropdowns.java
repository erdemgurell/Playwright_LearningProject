package LambdaTest.day3;

import GWD.GWD;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.Test;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class InteractWithDropdowns extends GWD {
    /**
     * This test class contains methods to interact with dropdowns on a webpage.
     */
    @Test
    public void test() {
        // URLs for the dropdown demos
        String selectURL = "https://www.lambdatest.com/selenium-playground/select-dropdown-demo";
        String jqueryURL = "https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo";

        // Navigate to the select dropdown demo page
        page.navigate(selectURL);

        // Locate the select dropdown and the selected value element
        Locator dayLocator = page.locator("select#select-demo");
        Locator selectedVal = page.locator("p.selected-value");

        // SELECT Elements

        // Select an option by its value
        dayLocator.selectOption("Friday");
        // Verify that the selected value is correct
        assertThat(selectedVal).containsText("Friday");

        // Select an option by its label
        dayLocator.selectOption(new SelectOption().setValue("Monday"));
        // Verify that the selected value is correct
        assertThat(selectedVal).containsText("Monday");
        System.out.println("selectedVal = " + selectedVal.textContent());

        // Select an option by its index
        dayLocator.selectOption(new SelectOption().setIndex(4));
        // Verify that the selected value is correct
        assertThat(selectedVal).containsText("Wednesday");

        // Select multiple options
        Locator states = page.locator("select[name='States']");
        states.selectOption(new String[]{"New Jersey", "Texas"});

        // Get all the options and print them
        Locator options = states.locator("option");
        List<String> allInnerText = options.allInnerTexts();
        allInnerText.forEach(System.out::println);

        // Print the count of options
        System.out.println("options.count() = " + options.count());

        // Navigate to the jQuery dropdown demo page
        page.navigate(jqueryURL);

        // Locate the country dropdown and click on it
        Locator country = page.locator("span.select2-container").first();
        country.click();

        // Locate the Japan option in the dropdown and click on it
        Locator list = page.locator("span.select2-results ul li",
                // find the locator that has text Japan
                new Page.LocatorOptions().setHasText("Japan"));
        list.click();

        // Select an option from the files dropdown
        Locator files = page.locator("select[name='files']");
        files.selectOption("Ruby");
    }
}
