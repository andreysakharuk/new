package consumer.porch;


import consumer.porch.pages.LevelOnePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class PorchTests {
    private static final String HINT_ZIP = "Please enter a ZIP code.";
    private static final String HINT_SERVICING = "Please enter a search query.";
    private static final String URL_LEVEL_ONE_PAGE = "http://www.consumerreports.org/home-services/";
    private static final String URL_LEVEL_TWO_PAGE_PLUMBERS = "http://www.consumerreports.org/home-services/plumbers/";
    private static final String URL_LEVEL_TWO_PAGE_PLUMBER_SERVICES = "http://www.consumerreports.org/home-services/"
                                                                      + "plumbing-services";
    private static final String URL_CUSTOMER_CARE_PAGE = "http://www.consumerreports.org/customer-care/";
    private static final String URL_TERMS_OF_SERVICES_PAGE = "https://porch.com/about/terms/";
    private static final String URL_PRIVACY_POLICY_PAGE = "https://porch.com/about/privacy";
    private static final String PLACEHOLDER_SERVICING = "What type of pro do you need?";
    private static final String PLACEHOLDER_ZIP = "ZIP code";
    private static final String VALUE_SERVICING = "Plumbers";
    private static final String VALUE_ZIP = "10701";
    private LevelOnePage page1;
    private WebDriver driver;

    @BeforeMethod (description = "open browser with 10sec implicit wait and 20sec load page wait")
    public void setUp(){
        this.driver = new FirefoxDriver();
        page1 = new LevelOnePage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test (description = "Verify that placeholders are displayed in Servicing/Zip fields by default")
    public void PlaceholdersAreInServicingAndZipFields() {
        page1.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(page1.getPlaceholderServicing(), PLACEHOLDER_SERVICING);
        Assert.assertEquals(page1.getPlaceholderZip(), PLACEHOLDER_ZIP);
    }

    @Test (description = "Verify that hint under empty Zip field appears after clicking Search button")
    public void HintAppearsUnderEmptyZipField(){
        page1.openPage(URL_LEVEL_ONE_PAGE);
        page1.enterValueInServicingField(VALUE_SERVICING);
        page1.clickSearchButton();
        Assert.assertEquals(page1.getZipHint(), HINT_ZIP);
    }

    @Test (description = "Verify that hint under empty Servicing field appears after clicking Search button")
    public void HintAppearsUnderEmptyServicingField() {
        page1.openPage(URL_LEVEL_ONE_PAGE);
        page1.enterValueInZipField(VALUE_ZIP);
        page1.clickSearchButton();
        Assert.assertEquals(page1.getServicingHint(), HINT_SERVICING);
    }

    @Test (description = "Verify that hints under empty Servicing/Zip fields appear after clicking Search button")
    public void HintsAppearUnderEmptyServicingAndZipFields() {
        page1.openPage(URL_LEVEL_ONE_PAGE);
        page1.clickSearchButton();
        Assert.assertEquals(page1.getServicingHint(), HINT_SERVICING);
        Assert.assertEquals(page1.getZipHint(), HINT_ZIP);
    }

    @Test (description = "Verify that Customer care page is opened after clicking Customer Care link")
    public void CustomerCareLinkNavigatesToCustomerCarePage() {
        page1.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(page1.getUrlAfterClickingCustomerCareLink(), URL_CUSTOMER_CARE_PAGE);
    }

    @Test (description = "Verify that Privacy Policy page is opened after clicking Privacy Policy link")
    public void TermsOfServiceLinkNavigatesToTermsOfServicePage(){
        page1.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(page1.getUrlAfterClickingTermsOfServiceLink(), URL_TERMS_OF_SERVICES_PAGE);
    }

    @Test (description = "Verify that page refreshes after clicking link in breadcrumb")
    public void HomeServiceLinkInBreadCrumbRefreshesPage(){
        page1.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(page1.getUrlAfterClickingBreadcrumbLink(), URL_LEVEL_ONE_PAGE);
    }










/*
+    @Test
    public void HintAppearsUnderEmptyZipField(){
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getActualZipHint(), ZIP_HINT , "actual Hint under empty Zip field doesn't match the example.");
    }

+    @Test
    public void HintAppearsUnderEmptyServicingField(){
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getActualServicingHint(), SERVICING_HINT, "actual Hints under empty Servicing field doesn't match the example.");
    }

    @Test
+    public void HintsAppearUnderEmptyZipAndServicingFields(){
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getActualHints(),  ZIP_HINT + SERVICING_HINT, "actual Hints under empty Servicing and Zip fields don't match the example.");
    }

-    @Test
    public void ProTypeLinkNavigatesToLevelTwoPage(){
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getActualProTypeUrl(), URL_LEVEL_TWO_PAGE_PLUMBERS);
    }

-    @Test
        public void ServiceTypeLinkNavigatesToLevelTwoPage(){
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getActualServiceTypeUrl(), URL_LEVEL_TWO_PAGE_PLUMBER_SERVICES);
    }

    @Test
+    public void CustomerCareLinkNavigatesToCustomerCarePage(){
            steps.openPage(URL_LEVEL_ONE_PAGE);
            Assert.assertEquals(steps.getActualCustomerCareUrl(), URL_CUSTOMER_CARE_PAGE);
    }

-    @Test
    public void TermsOfServiceLinkNavigatesToTermsOfServicePage(){
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getActualTermsOfServiceUrl(), URL_TERMS_OF_SERVICES_PAGE);
    }

-    @Test
    public void PrivacyPolicyLinkNavigatesToPrivacyPolicyPage(){
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getActualPrivacyPolicyUrl(), URL_PRIVACY_POLICY_PAGE);
    }


    @Test
    public void WhatIsPorchCustomerCareLinkNavigatesToCustomerCarePage(){
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getWhatIsPorchActualCustomerCareUrl(), URL_CUSTOMER_CARE_PAGE);
    }


+    @Test
    public void PlaceholderIsInServicingField() {
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getActualPlaceholderServicingField(), PLACEHOLDER_SERVICING_FIELD);
    }

+    @Test
    public void PlaceholderIsInZipField() {
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getActualPlaceholderZipField(), PLACEHOLDER_ZIP_FIELD);
    }

+    @Test
    public void HomeServiceLinkInBreadCrumbRefreshesPage(){
        steps.openPage(URL_LEVEL_ONE_PAGE);
    }

*/

    @AfterMethod (description = "close browser")
    public void tearDown(){
        driver.close();
    }



}
