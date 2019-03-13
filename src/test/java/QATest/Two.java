package QATest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Two {
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "/home/ttn/IdeaProjects/Selenium/chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///home/ttn/Downloads/Registration.html");

        Properties prop = new Properties();
        File filePath = new File("/home/ttn/IdeaProjects/Selenium/src/TableProperties/Property");
        FileInputStream fileInputStream = new FileInputStream(filePath);
        prop.load(fileInputStream);

        WebElement firstNameTxtBox= driver.findElement(By.xpath("//*[@ng-model='FirstName']"));
        WebElement lastNameTxtBox= driver.findElement(By.xpath("//*[@ng-model='LastName']"));
        WebElement emailAdressTxtBox=driver.findElement(By.xpath("//*[@ng-model='EmailAdress']"));
        WebElement pwdTxtBox=driver.findElement(By.xpath("//*[@ng-model='Password']"));
        WebElement cnfrmPwdTxtBox=driver.findElement(By.xpath("//*[@ng-model='CPassword']"));
        WebElement phneTxtBox=driver.findElement(By.xpath("//*[@ng-model='Phone']"));
        WebElement hobbyCheckBox1=driver.findElement(By.id("checkbox1"));
        WebElement hobbyCheckBox2=driver.findElement(By.id("checkbox2"));
        WebElement hobbyCheckBox3=driver.findElement(By.id("checkbox3"));

        firstNameTxtBox.sendKeys(prop.getProperty("FirstName"));
        lastNameTxtBox.sendKeys(prop.getProperty("LastName"));
        driver.findElement(By.xpath("//*[@ng-model='Adress']")).sendKeys(prop.getProperty("Adress"));
        emailAdressTxtBox.sendKeys(prop.getProperty("EmailAdress"));
        pwdTxtBox.sendKeys(prop.getProperty("Password"));
        cnfrmPwdTxtBox.sendKeys(prop.getProperty("CPassword"));
        phneTxtBox.sendKeys(prop.getProperty("Phone"));

        List<WebElement> genderOption = driver.findElements(By.xpath("//*[@ng-model='radiovalue']"));
        for (int i = 0; i < genderOption.size(); i++) {
            if (genderOption.get(i).getAttribute("value").equals(prop.getProperty("value")))
                driver.findElements(By.xpath("//*[@ng-model='radiovalue']")).get(i).click();
        }

        if ((hobbyCheckBox1.getAttribute("value").equals(prop.getProperty("Hobby"))) || (hobbyCheckBox1.getAttribute("value").equals(prop.getProperty("hobbies"))))
            hobbyCheckBox1.click();
        if ((hobbyCheckBox2.getAttribute("value").equals(prop.getProperty("Hobby"))) || (hobbyCheckBox2.getAttribute("value").equals(prop.getProperty("hobbies"))))
            hobbyCheckBox2.click();
        if ((hobbyCheckBox3.getAttribute("value").equals(prop.getProperty("Hobby"))) || (hobbyCheckBox3.getAttribute("value").equals(prop.getProperty("hobbies"))))
            driver.findElement(By.id("checkbox3")).click();

    }
}
