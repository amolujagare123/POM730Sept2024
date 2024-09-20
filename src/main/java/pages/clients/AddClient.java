package pages.clients;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddClient {

    @FindBy(xpath="//input[@id='client_name']")
    WebElement clientName;

    @FindBy(xpath="//input[@id='client_surname']")
    WebElement clientSurname;

    @FindBy(xpath="//input[@id='client_address_1']")
    WebElement streetAddress1;

    @FindBy(xpath="//input[@id='client_address_2']")
    WebElement streetAddress2;
}
