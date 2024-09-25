package pages.clients;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {

    WebDriver driver ;

    public AddClient(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@id='client_name']")
    WebElement clientName;

    @FindBy(xpath="//input[@id='client_surname']")
    WebElement clientSurname;

    @FindBy(xpath="//input[@id='client_address_1']")
    WebElement streetAddress1;

    @FindBy(xpath="//input[@id='client_address_2']")
    WebElement streetAddress2;

    @FindBy(xpath="//input[@id='client_city']")
    WebElement city;

    @FindBy(xpath="//input[@id='client_state']")
    WebElement state;

    @FindBy(xpath="//input[@id='client_zip']")
    WebElement zipCode;

    @FindBy(xpath="//input[@id='client_phone']")
    WebElement phoneNumber;

    @FindBy(xpath="//input[@id='client_fax']")
    WebElement faxNumber;

    @FindBy(xpath="//input[@id='client_mobile']")
    WebElement mobileNumber;

    @FindBy(xpath="//input[@id='client_email']")
    WebElement emailAddress;

    @FindBy(xpath="//input[@id='client_web']")
    WebElement webAddress;

    @FindBy(xpath="//input[@id='client_vat_id']")
    WebElement vATID;

    @FindBy(xpath="//input[@id='client_tax_code']")
    WebElement taxesCode;

    @FindBy(xpath="//button[@id='btn-submit']")
    WebElement save;

    @FindBy(xpath="//span[@id='select2-client_language-container']")
    WebElement languageContainer;
    @FindBy(xpath="//input[@role='searchbox']")
    WebElement searchBox;

    public void setLanguage(String language)
    {
        languageContainer.click();
        searchBox.sendKeys(language);
       // String xpath = "//li[normalize-space()='"+language+"']";
       // driver.findElement(By.xpath(xpath)).click();
        searchBox.sendKeys(Keys.ENTER);
    }
    @FindBy(xpath="//span[@id='select2-client_country-container']")
    WebElement countryContainer;

    public void setCountry(String country)
    {
        countryContainer.click();
        searchBox.sendKeys(country);
        String xpath = "//li[normalize-space()='"+country+"']";
        driver.findElement(By.xpath(xpath)).click();
    }
    @FindBy(xpath="//span[@id='select2-client_gender-container']")
    WebElement genderContainer;

    public void setGender(String gender)
    {
        genderContainer.click();
        String xpath = "//li[normalize-space()='"+gender+"']";
        driver.findElement(By.xpath(xpath)).click();
    }

    @FindBy(xpath="//input[@id='client_birthdate']")
    WebElement birthdate;

    public void setBirthDate(String bDate)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+bDate+"')",birthdate);
    }

    // Method to set client name
    public void setClientName(String name) {
        clientName.sendKeys(name);
    }

    // Method to set client surname
    public void setClientSurname(String surname) {
        clientSurname.sendKeys(surname);
    }

    // Method to set street address 1
    public void setStreetAddress1(String address1) {
        streetAddress1.sendKeys(address1);
    }

    // Method to set street address 2
    public void setStreetAddress2(String address2) {
        streetAddress2.sendKeys(address2);
    }

    // Method to set city
    public void setCity(String cityName) {
        city.sendKeys(cityName);
    }

    // Method to set state
    public void setState(String stateName) {
        state.sendKeys(stateName);
    }

    // Method to set zip code
    public void setZipCode(String zip) {
        zipCode.sendKeys(zip);
    }

    // Method to set phone number
    public void setPhoneNumber(String phone) {
        phoneNumber.sendKeys(phone);
    }

    // Method to set fax number
    public void setFaxNumber(String fax) {
        faxNumber.sendKeys(fax);
    }

    // Method to set mobile number
    public void setMobileNumber(String mobile) {
        mobileNumber.sendKeys(mobile);
    }

    // Method to set email address
    public void setEmailAddress(String email) {
        emailAddress.sendKeys(email);
    }

    // Method to set web address
    public void setWebAddress(String web) {
        webAddress.sendKeys(web);
    }

    // Method to set VAT ID
    public void setVATID(String vat) {
        vATID.sendKeys(vat);
    }

    // Method to set taxes code
    public void setTaxesCode(String taxCode) {
        taxesCode.sendKeys(taxCode);
    }

    // Method to click the save button
    public void clickSave() {
        save.click();
    }
}
