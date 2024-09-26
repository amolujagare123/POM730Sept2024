package DBTesting;

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
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static util.Conversion.*;
import static util.ForDataProvider.getMyData;

public class AddClientDBTest {
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
           ) throws ClassNotFoundException, SQLException, ParseException {
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

        ArrayList<String> expected = new ArrayList<>();
        expected.add(clientName);
        expected.add(clientSurname);
        expected.add(language.toLowerCase());
        expected.add(streetAddress1);
        expected.add(streetAddress2);
        expected.add(city);
        expected.add(state);
        expected.add(zipCode);
        expected.add(country);
        expected.add(gender);
        expected.add(birthDate);
        expected.add(phoneNumber);
        expected.add(faxNumber);
        expected.add(mobileNumber);
        expected.add(emailAddress);
        expected.add(webAddress);
        expected.add(vatId);
        expected.add(taxesCode);

        Class.forName("com.mysql.cj.jdbc.Driver");
        String user = "root";
        String password = "root";
        String connUrl = "jdbc:mysql://localhost:3306/ip";

        Connection con = DriverManager.getConnection(connUrl,user,password);
        Statement st = con.createStatement();
        String sql = "SELECT * FROM ip_clients where client_name='"+clientName+"'";
        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while (rs.next()) {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));

            String countryShort = rs.getString("client_country");
            String countryFullForm = convertCountry(countryShort) ;
            actual.add(countryFullForm);


            actual.add( getGender(rs.getString("client_gender")) );


            actual.add(convertDate(rs.getString("client_birthdate")));


            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);



        Assert.assertEquals(actual,expected);
    }

    @DataProvider
    public Object[][] getData() throws IOException {
      return getMyData("Data/IpData.xlsx","DB Testing");
    }
}
