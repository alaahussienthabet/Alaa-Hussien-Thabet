package JawwyTest;

import Moduls.FilesReaders.ExcelFileReader;
import Pages.PackagePage;

import UI.UiActions;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;


/**
 * test scenario to validate the package specification
 */
public class TestScenario extends BaseClass {

    PackagePage packagePage = new PackagePage(); //Instantiation of packagePage object

    @BeforeMethod
    public void setSiteLanguage() {
        packagePage.changeLanguage();

    }

    /**
     * <p> Test Scenario </p>
     * <p> Step.1) Open Url </p>
     * <p> Step.2) Chose Country Name = UAE </p>
     * <p> Step.3) Validate The packages Type </p>
     * <p> Step.4) Validate The packages Price </p>
     * <p> Step.5) Validate The packages Currency </p>
     * <p> Step.6) Close the browser window </p>
     */
    @Attachment(value = "Screenshot", type = "image/png")
    @Test(dataProvider = "UAE")
    public void validatePackagesOfUAE(String packageCode, String packageName, String PriceValue) {
        String packageTypeValue = packageCode;
        System.out.println(packageTypeValue);
        packagePage.changeCountry("ae");
        String packageType = packagePage.setPackageType(packageTypeValue).getTextOfElement();
        Allure.addAttachment("Page Screenshot",
                new ByteArrayInputStream(((TakesScreenshot) UiActions.driver).getScreenshotAs(OutputType.BYTES)));
        Assert.assertEquals(packageType, packageName, "can't find package name ");

        String packagePrice = packagePage.getPackagePrice(packageTypeValue).getTextOfElement();
        Assert.assertEquals(packagePrice, PriceValue, "can't find package price ");

        String packageCurrency = packagePage.getPackageCurrency().getTextOfElement();
        Assert.assertEquals(packageCurrency, "USD/month", "can't find package currency ");


    }

    /**
     * <p> Test Scenario </p>
     * <p> Step.1) Open Url </p>
     * <p> Step.2) Chose Country Name = Jordan </p>
     * <p> Step.3) Validate The packages Type </p>
     * <p> Step.4) Validate The packages Price </p>
     * <p> Step.5) Validate The packages Currency </p>
     * <p> Step.6) Close the browser window </p>
     */
    @Attachment(value = "Screenshot", type = "image/png")
    @Test(dataProvider = "Jordan")
    public void validatePackagesOfJordan(String packageCode, String packageName, String PriceValue) {
        String packageTypeValue = packageCode;

        packagePage.changeCountry("jo");
        String packageType = packagePage.setPackageType(packageTypeValue).getTextOfElement();
        Allure.addAttachment("Page Screenshot",
                new ByteArrayInputStream(((TakesScreenshot) UiActions.driver).getScreenshotAs(OutputType.BYTES)));
        Assert.assertEquals(packageType, packageName, "can't find package name ");

        packagePage.scrollDownFirst_Page();
        String packagePrice = packagePage.getPackagePrice(packageTypeValue).getTextOfElement();
        Assert.assertEquals(packagePrice, PriceValue, "can't find package price ");

        String packageCurrency = packagePage.getPackageCurrency().getTextOfElement();
        Assert.assertEquals(packageCurrency, "USD/month", "can't find package currency ");


    }

    /**
     * <p> Test Scenario </p>
     * <p> Step.1) Open Url </p>
     * <p> Step.2) Chose Country Name = Morocco </p>
     * <p> Step.3) Validate The packages Type </p>
     * <p> Step.4) Validate The packages Price </p>
     * <p> Step.5) Validate The packages Currency </p>
     * <p> Step.6) Close the browser window </p>
     */
    @Attachment(value = "Screenshot", type = "image/png")
    @Test(dataProvider = "Morocco")
    public void validatePackagesOfMorocco(String packageCode, String packageName, String PriceValue) {
        String packageTypeValue = packageCode;

        packagePage.changeCountry("ma");
        String packageType = packagePage.setPackageType(packageTypeValue).getTextOfElement();
        Allure.addAttachment("Page Screenshot",
                new ByteArrayInputStream(((TakesScreenshot) UiActions.driver).getScreenshotAs(OutputType.BYTES)));
        Assert.assertEquals(packageType,packageName, "can't find package name ");

        String packagePrice = packagePage.getPackagePrice(packageTypeValue).getTextOfElement();
        Assert.assertEquals(packagePrice, PriceValue, "can't find package price ");

        String packageCurrency = packagePage.getPackageCurrency().getTextOfElement();
        Assert.assertEquals(packageCurrency, "USD/month", "can't find package currency ");


    }

    /**
     * to get test data from excel file (external file ) for specific test (UAE)
     *
     * @return test data of test
     */
    @DataProvider(name = "UAE")
    Object[][] getDataFromExcelForUAE() {
        Object[][] data = ExcelFileReader.excelReader("src/test/resources/DataDriven/UAETestData.xlsx");
        return data;
    }

    /**
     * to get test data from excel file (external file ) for specific test (Jordan)
     *
     * @return test data of test
     */
    @DataProvider(name = "Jordan")
    Object[][] getDataFromExcelForJordan() {
        Object[][] data = ExcelFileReader.excelReader("src/test/resources/DataDriven/jordonTestData.xlsx");
        return data;
    }

    /**
     * to get test data from excel file (external file ) for specific test (Morocco)
     *
     * @return test data of test
     */
    @DataProvider(name = "Morocco")
    Object[][] getDataFromExcelForMorocco() {
        Object[][] data = ExcelFileReader.excelReader("src/test/resources/DataDriven/moroccoTestData.xlsx");
        return data;
    }
}


