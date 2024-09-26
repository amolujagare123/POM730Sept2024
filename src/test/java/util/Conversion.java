package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {

    public static  String convertCountry(String shortCountry)
    {
        String convertedCountry="";

        switch (shortCountry)
        {
            case "IN" : convertedCountry ="India";break;
            case "US": convertedCountry = "United States"; break;
            case "GB": convertedCountry = "United Kingdom"; break;
            case "CA": convertedCountry = "Canada"; break;
            case "AU": convertedCountry = "Australia"; break;
            case "FR": convertedCountry = "France"; break;
            case "DE": convertedCountry = "Germany"; break;
            case "JP": convertedCountry = "Japan"; break;
            case "CN": convertedCountry = "China"; break;
            case "BR": convertedCountry = "Brazil"; break;
            case "ZA": convertedCountry = "South Africa"; break;
            case "MX": convertedCountry = "Mexico"; break;
            case "RU": convertedCountry = "Russia"; break;
            case "IT": convertedCountry = "Italy"; break;
            case "ES": convertedCountry = "Spain"; break;
            case "SG": convertedCountry = "Singapore"; break;
            default:  break;
        }


        return convertedCountry;
    }

    public static  String getGender(String genderID)
    {
        String gender = "";

        switch (genderID)
        {
            case "0" : gender ="Male";break;
            case "1" : gender ="Female";break;
            case "2" : gender ="Other";break;
        }

        return gender;

    }

    // dd/MM/yyyy

    public static  String convertDate(String dbDateStr) throws ParseException // yyyy-MM-dd
    {
        Date dbDate = new SimpleDateFormat("yyyy-MM-dd").parse(dbDateStr);

        return new SimpleDateFormat("dd/MM/yyyy").format(dbDate);
    }
}
