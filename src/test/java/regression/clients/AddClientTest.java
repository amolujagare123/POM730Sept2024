package regression.clients;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import pages.clients.AddClient;
import util.DoLogin;

public class AddClientTest extends DoLogin {


    @Test
    public void addClientTest()
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClientPage = new AddClient(driver);
        // Fill out the client information

        addClientPage.setClientName("John"); // Client already exists!
        addClientPage.setClientSurname("Doe");
        addClientPage.setLanguage("Thai");
        addClientPage.setStreetAddress1("123 Elm St");
        addClientPage.setStreetAddress2("Apt 4B");
        addClientPage.setCity("New York");
        addClientPage.setState("NY");
        addClientPage.setZipCode("10001");
        addClientPage.setCountry("Japan");
        addClientPage.setGender("Female");
        addClientPage.setBirthDate("05/09/1985");
        addClientPage.setPhoneNumber("1234567890");
        addClientPage.setFaxNumber("0987654321");
        addClientPage.setMobileNumber("1231231234");
        addClientPage.setEmailAddress("john.doe@example.com");
        addClientPage.setWebAddress("http://example.com");
        addClientPage.setVATID("VAT123456");
        addClientPage.setTaxesCode("TAX654321");

        // Submit the form
        addClientPage.clickSave();

        String expected = "Client already exists!";
        String actual = "";
        try {
             actual = driver.findElement(By.xpath("//div[contains(@class,'alert')]")).getText();
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected);
    }
}
