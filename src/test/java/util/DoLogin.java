package util;

import org.testng.annotations.BeforeClass;
import pages.Login;

public class DoLogin extends OpenURL {

    @BeforeClass
    public void doLogin()
    {
        Login login = new Login(driver);
        login.setTxtUsername("amolujagare@gmail.com");
        login.setTxtPassword("admin123");
        login.clickLogin();
    }
}
