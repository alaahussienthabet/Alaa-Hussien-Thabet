package Pages;

import UI.UiActions;
import org.openqa.selenium.By;

/**
 * navigate to Jawwy package page and check the package specifications
 */
public class PackagePage {


    UiActions action = new UiActions();
    private final By translateBtn = By.id("translation-btn");

    private final By countryBtn = By.id("country-btn");
    private final String countryName = "%s-contry-lable";

    private final String planName = "name-%s";

    private final String packagePrice = "//div[@id='currency-%s']//b";

    private final By packageCurrency = By.xpath("//div[@id='currency-lite']//i");

    /**
     * change site language
     */
    public void changeLanguage() {

        action.waitFunction(translateBtn, "waitVisibility");
        action.findElement(translateBtn)
                .actionOnElement("click");
    }

    /**
     * change site country
     */
    public void changeCountry(String countryCode) {


        action.waitFunction(countryBtn, "waitVisibility");
        action.findElement(countryBtn)
                .actionOnElement("click");

        By country = By.id(String.format(countryName,countryCode));
         action.findElement(country).actionOnElement("click");
    }

    /**
     * set Package Type
     * @param packageName
     * @return
     */
    public UiActions setPackageType(String packageName) {

        By plan = By.id(String.format(planName,packageName));
        return action.findElement(plan);

    }
    /**
     * Scroll Down to Bottom of the page
     */

    public void scrollDownFirst_Page() {
        action.scrollDownToBottom();
    }

    /**
     *  get Package Price
     * @return
     */
    public UiActions getPackagePrice(String packageName) {
        By packagePriceValue = By.xpath(String.format(packagePrice,packageName));
        action.waitFunction(packagePriceValue, "waitVisibility");
       return action.findElement(packagePriceValue);
    }

    /**
     * get Package Currency
     * @return
     */
    public UiActions getPackageCurrency() {

        action.waitFunction(packageCurrency, "waitVisibility");
        return action.findElement(packageCurrency);
    }
    
}
