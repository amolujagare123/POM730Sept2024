package util;

import org.openqa.selenium.WebElement;

public class UITestUtil {

    public static boolean checkVisibility(WebElement element)
    {
        boolean  result = false;
        try {
            result = element.isDisplayed();
        }
        catch(Exception e)
        {

        }

        return result;
    }

    public static String checkText(WebElement element)
    {
        String result="";
        try {
            result = element.getText();;
        }
        catch(Exception e)
        {

        }
        return result;
    }

    public static String checkAttributeValue(WebElement element,String attribute)
    {
        String result="";
        try {
            result = element.getAttribute(attribute);
        }
        catch(Exception e)
        {

        }
        return result;
    }

    public static String checkStyleValue(WebElement element,String property)
    {
        String result="";
        try {
            result = element.getCssValue(property);
        }
        catch(Exception e)
        {

        }
        return result;
    }

}
