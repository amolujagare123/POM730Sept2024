package UITesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenURL;

import static util.UITestUtil.*;

public class LoginTest  extends OpenURL {



    Login login;

    @BeforeClass
    public void initLogin() {

        login = new Login(driver);
    }


    @Test
    public void txtUsernameCheckVisibility()
    {
        boolean expected = true;
        boolean  actual = false;
        try {
             actual = login.txtUsername.isDisplayed();
        }
        catch(Exception e)
        {
            //actual = false;
        }
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void txtUsernameCheckVisibility2()
    {
        boolean expected = true;
        boolean  actual = checkVisibility(login.txtUsername);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void txtPasswordCheckVisibility()
    {
        boolean expected = true;
        boolean  actual = checkVisibility(login.txtPassword);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void lblEmailSpellCheck()
    {
        String expected = "Email";
        String actual = checkText(login.lblEmail);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void lblPasswordSpellCheck()
    {
        String expected = "Password";
        String actual = checkText(login.lblPassword);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void buttonTextSpellCheck()
    {
        String expected = "Login";
        String actual = checkText(login.btnLogin);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void txtEmailPlaceholderCheck()
    {
        String expected = "Email";
        String actual = checkAttributeValue(login.txtUsername,"placeholder");
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void txtPasswordPlaceholderCheck()
    {
        String expected = "Password";
        String actual = checkAttributeValue(login.txtPassword,"placeholder");
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void lblEmailFontSizeCheck()
    {
        String expected = "14px";
        String actual = checkStyleValue(login.lblEmail,"font-size");
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void lblPasswordFontSizeCheck()
    {
        String expected = "14px";
        String actual = checkStyleValue(login.lblPassword,"font-size");
        Assert.assertEquals(actual,expected);
    }


    @Test
    public void lblPasswordFontFamilyCheck()
    {
        String expected = "-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";
        String actual = checkStyleValue(login.lblPassword,"font-family");
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void btnLoginColorCheck()
    {
        String expected = "#2C8EDD";
        String myColor = checkStyleValue(login.btnLogin,"background-color");

        String actual = Color.fromString(myColor).asHex().toUpperCase();


        Assert.assertEquals(actual,expected);
    }






}
