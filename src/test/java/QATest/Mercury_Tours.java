package QATest;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Mercury_Tours {

    WebDriver driver;
    @BeforeSuite
    public void initValues() throws IOException {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");
    }


    @Test(description = "new user register")
    public void register() {
        driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Anuja");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Pandey");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9876565412");
        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("anuja.pandey@tothenew.com");
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("C-6, Sector-30");
        driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("Arun Vihar, Noida");
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Noida");
        driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Uttar Pradesh");
        driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("201301");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("anuja.pandey@tothenew.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("qwerty@123");
        driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("qwerty@123");

        WebElement countryDropDown = driver.findElement(By.xpath("//select[@name='country']"));
        Select countryDropDownOption= new Select(countryDropDown);
        countryDropDownOption.selectByValue("92");
        driver.findElement(By.name("register")).click();

    }
    @Test(description = "Login with valid credentials", dependsOnMethods = "register", priority = 1)
    public void login(){
        driver.get("http://newtours.demoaut.com/");
        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("anuja.pandey@tothenew.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("qwerty@123");
        driver.findElement(By.xpath("//input[@name='login']")).click();
    }


    @Test(description = "end-to-end Flight Booking with valid credentials", dependsOnMethods = {"register","login"}, priority = 2)
    public void flightBooking() {

        driver.findElements(By.xpath("//input[@name='tripType']")).get(0).click();

        //Passengers
        WebElement numPass = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select numPassOption = new Select(numPass);
        numPassOption.selectByValue("2");

        //Departing
        WebElement departFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departFromOption = new Select(departFrom);
        departFromOption.selectByValue("New York");

        //departing(date)
        WebElement departMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select departMonthOption = new Select(departMonth);
        departMonthOption.selectByValue("2");

        WebElement departDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select departDayOption = new Select(departDay);
        departDayOption.selectByValue("22");

        // ARRIVING IN
        WebElement arrivTo = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivToOption= new Select(arrivTo);
        arrivToOption.selectByValue("London");

        //Returning date
        WebElement arrivMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select arrivMonthOption = new Select(arrivMonth);
        arrivMonthOption.selectByValue("2");

        WebElement arrivDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select arrivDayOption = new Select(arrivDay);
        arrivDayOption.selectByValue("25");

        //Service class
        driver.findElements(By.xpath("//input[@type='radio']")).get(1).click();

        //Airline
        WebElement flightType = driver.findElement(By.xpath("//select[@name='airline']"));
        Select flightTypeOption = new Select(flightType);
        flightTypeOption.selectByVisibleText("No Preference");

        //continue button
        driver.findElement(By.xpath("//input[@name='findFlights']")).click();

        //Depart to
        driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$361$271$7:10']")).click();

        //Arrive to
        driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$630$270$12:23']")).click();

        //continue button clicked
        driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();

        //payment details
        driver.findElement(By.xpath("//input[@name='passFirst0']")).sendKeys("anuja");
        driver.findElement(By.xpath("//input[@name='passLast0']")).sendKeys("pandey");

        WebElement passOneMeal = driver.findElement(By.xpath("//select[@name='pass.0.meal']"));
        Select passOneMealOption = new Select(passOneMeal);
        passOneMealOption.selectByValue("BLML");

        driver.findElement(By.xpath("//input[@name='passFirst1']")).sendKeys("PALLAVI");
        driver.findElement(By.xpath("//input[@name='passLast1']")).sendKeys("tripathi");

        WebElement passTwoMeal = driver.findElement(By.xpath("//select[@name='pass.1.meal']"));
        Select passTwoMealOption = new Select(passTwoMeal);
        passOneMealOption.selectByValue("BLML");

        WebElement creditCard = driver.findElement(By.xpath("//select[@name='creditCard']"));
        Select creditCardOption = new Select(creditCard);
        creditCardOption.selectByValue("IK");

        driver.findElement(By.xpath("//input[@name='creditnumber']")).sendKeys("1234567890123456");
        WebElement creditExpDate = driver.findElement(By.xpath("//select[@name='cc_exp_dt_mn']"));
        Select creditExpDateOption = new Select(creditExpDate);
        creditExpDateOption.selectByVisibleText("01");

        WebElement creditExpYear = driver.findElement(By.xpath("//select[@name='cc_exp_dt_yr']"));
        Select creditExpYearOption = new Select(creditExpYear);
        creditExpYearOption.selectByVisibleText("2001");

        driver.findElement(By.xpath("//input[@name='cc_frst_name']")).sendKeys("Anuja");
        driver.findElement(By.xpath("//input[@name='cc_last_name']")).sendKeys("Pandey");

        driver.findElement(By.xpath("//input[@name='buyFlights']")).click();
    }

    //******Departure and arrival city not same
    @Test(description = "departure and arival city negative test case", dependsOnMethods = {"register","login"}, priority = 3)
    public void city() {

        driver.get("http://newtours.demoaut.com/mercuryreservation.php?osCsid=8af1e1a6f13b5cf11b3a39847c952e8e");
        driver.findElements(By.name("tripType")).get(0).click();
        //Passengers
        WebElement numPass = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select numPassOption = new Select(numPass);
        numPassOption.selectByValue("2");

        //Departing
        WebElement departFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departFromOption = new Select(departFrom);
        departFromOption.selectByValue("New York");

        //departing(date)
        WebElement departMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select departMonthOption = new Select(departMonth);
        departMonthOption.selectByValue("2");

        WebElement departDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select departDayOption = new Select(departDay);
        departDayOption.selectByValue("22");


        // ARRIVING IN
        WebElement arrivTo = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivToOption= new Select(arrivTo);
        arrivToOption.selectByValue("New York");

        //Returning date
        WebElement arrivMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select arrivMonthOption = new Select(arrivMonth);
        arrivMonthOption.selectByValue("2");

        WebElement arrivDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select arrivDayOption = new Select(arrivDay);
        arrivDayOption.selectByValue("25");

        //Service class
        driver.findElements(By.xpath("//input[@type='radio']")).get(1).click();

        //Airline
        WebElement flightType = driver.findElement(By.xpath("//select[@name='airline']"));
        Select flightTypeOption = new Select(flightType);
        flightTypeOption.selectByVisibleText("No Preference");


        //continue button
        driver.findElement(By.xpath("//input[@name='findFlights']")).click();

        //Depart to
        driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$361$271$7:10']")).click();

        //Arrive to
        driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$630$270$12:23']")).click();

        //continue button clicked
        driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();

        try {
            // Making the test fail
            Assert.assertEquals(departFrom.getAttribute("value"), arrivTo.getAttribute("value"));
        } catch (StaleElementReferenceException e) {

            departFrom = driver.findElement(By.name("fromPort"));
            arrivTo = driver.findElement(By.name("toPort"));
            System.out.println(departFrom.getAttribute("value"));
            System.out.println(arrivTo.getAttribute("value"));
            Assert.assertNotEquals(departFrom.getAttribute("value"), arrivTo.getAttribute("value"));

            // Following lines will be printed when the assert condition fails
            System.out.println("test case");
            System.out.println("Error message: " + e.toString());

            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            System.out.println("city end ");
        }
    }


//*******Arrival and Departure date


    @Test(description = "Departure date should be less than arrival date ", dependsOnMethods = {"register","login"}, priority = 4)
    public void date(){

        driver.get("http://newtours.demoaut.com/mercuryreservation.php?osCsid=8af1e1a6f13b5cf11b3a39847c952e8e");
        driver.findElements(By.xpath("//input[@name='tripType']")).get(0).click();

        //Passengers
        WebElement numPass = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select numPassOption = new Select(numPass);
        numPassOption.selectByValue("2");

        //Departing
        WebElement departFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departFromOption = new Select(departFrom);
        departFromOption.selectByValue("New York");

        //departing(date)
        WebElement departMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select departMonthOption = new Select(departMonth);
        departMonthOption.selectByValue("2");

        WebElement departDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select departDayOption = new Select(departDay);
        departDayOption.selectByValue("22");

        String month_depart = departMonth.getAttribute("value");
        String day_depart = departDay.getAttribute("value");

        // ARRIVING IN
        WebElement arrivTo = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivToOption= new Select(arrivTo);
        arrivToOption.selectByValue("London");

        //Returning date
        WebElement arrivMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select arrivMonthOption = new Select(arrivMonth);
        arrivMonthOption.selectByValue("2");

        WebElement arrivDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select arrivDayOption = new Select(arrivDay);
        arrivDayOption.selectByValue("22");

        //SerClass
        driver.findElements(By.xpath("//input[@type='radio']")).get(1).click();

        //Airline
        WebElement flightType = driver.findElement(By.xpath("//select[@name='airline']"));
        Select flightTypeOption = new Select(flightType);
        flightTypeOption.selectByVisibleText("No Preference");


        //continue button
        driver.findElement(By.xpath("//input[@name='findFlights']")).click();

        //Depart to
        driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$361$271$7:10']")).click();

        //Arrive to
        driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$630$270$12:23']")).click();

        //continue button clicked
        driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();

        String actual_url = driver.getCurrentUrl();
        String expected_url = "http://newtours.demoaut.com/mercuryreservation.php?osCsid=b7dd10f493813134cb2c66e437e63b0d";
        Assert.assertEquals(actual_url, expected_url);
    }

    //******Empty passengers field
    @Test(description = "empty passengers field", dependsOnMethods = {"register","login"}, priority = 3)
    public void book_flight()   {

        driver.get("http://newtours.demoaut.com/mercuryreservation.php?osCsid=8af1e1a6f13b5cf11b3a39847c952e8e");
        driver.findElements(By.xpath("//input[@name='tripType']")).get(0).click();

        //Passengers
        WebElement numPass = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select numPassOption = new Select(numPass);
        numPassOption.selectByValue("2");

        //Departing
        WebElement departFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departFromOption = new Select(departFrom);
        departFromOption.selectByValue("New York");

        //departing(date)
        WebElement departMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select departMonthOption = new Select(departMonth);
        departMonthOption.selectByValue("2");

        WebElement departDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select departDayOption = new Select(departDay);
        departDayOption.selectByValue("22");

        // ARRIVING IN
        WebElement arrivTo = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivToOption= new Select(arrivTo);
        arrivToOption.selectByValue("London");

        //Returning date
        WebElement month1 = driver.findElement(By.name("toMonth"));
        WebElement day1 = driver.findElement(By.name("toDay"));
        new Select(month1).selectByVisibleText("May");
        new Select(day1).selectByVisibleText("10");

        //Service class
        driver.findElements(By.xpath("//input[@name='servClass']")).get(2).click();

        //Airline
        WebElement flightType = driver.findElement(By.xpath("//select[@name='airline']"));
        Select flightTypeOption = new Select(flightType);
        flightTypeOption.selectByVisibleText("No Preference");

        //continue button
        driver.findElement(By.xpath("//input[@name='findFlights']")).click();

        //Depart to
        driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$361$271$7:10']")).click();

        //Arrive to
        driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$630$270$12:23']")).click();

        //continue button clicked
        driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();



        driver.findElement(By.name("buyFlights")).click();

        String expected_result=driver.getCurrentUrl();

        String actual_result = "http://newtours.demoaut.com/mercurypurchase.php";


        Assert.assertEquals(expected_result,actual_result);


    }
    }
