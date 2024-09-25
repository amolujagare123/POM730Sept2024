package regression.clients;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import pages.clients.AddClient;

import java.io.IOException;

import static util.ForDataProvider.getMyData;

public class AddClientDataProviderTest {
    WebDriver driver;
    @BeforeClass
    public void doLogin()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/ip");

        Login login = new Login(driver);
        login.setTxtUsername("amolujagare@gmail.com");
        login.setTxtPassword("admin123");
        login.clickLogin();
    }

    @Test (dataProvider = "getData")
    public void addClientTest(
            String clientName, String clientSurname, String language, String streetAddress1,
            String streetAddress2, String city, String state, String zipCode, String country,
            String gender, String birthDate, String phoneNumber, String faxNumber,
            String mobileNumber, String emailAddress, String webAddress, String vatId, String taxesCode
            ,String expected,String xpathActual,String errorMsg)
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClientPage = new AddClient(driver);
        // Fill out the client information

        // Set the client details using the provided data
        addClientPage.setClientName(clientName);
        addClientPage.setClientSurname(clientSurname);
        addClientPage.setLanguage(language);
        addClientPage.setStreetAddress1(streetAddress1);
        addClientPage.setStreetAddress2(streetAddress2);
        addClientPage.setCity(city);
        addClientPage.setState(state);
        addClientPage.setZipCode(zipCode);
        addClientPage.setCountry(country);
        addClientPage.setGender(gender);
        addClientPage.setBirthDate(birthDate);
        addClientPage.setPhoneNumber(phoneNumber);
        addClientPage.setFaxNumber(faxNumber);
        addClientPage.setMobileNumber(mobileNumber);
        addClientPage.setEmailAddress(emailAddress);
        addClientPage.setWebAddress(webAddress);
        addClientPage.setVATID(vatId);
        addClientPage.setTaxesCode(taxesCode);

        // Submit the form
       addClientPage.clickSave();

        String actual = "";
        try {
            actual = driver.findElement(By.xpath(xpathActual)).getText();
        }
        catch (Exception e)
        {

        }
        System.out.println("actual="+actual);
        System.out.println("expected="+expected);
        Assert.assertEquals(actual,expected,errorMsg);
    }

    @DataProvider
    public Object[][] getData() throws IOException {
      return getMyData("Data/IpData.xlsx","IpData");
    }
}
