package QATest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.annotations.*;

public class Four {
    public static void main(String[] args) {

    }

        @Test
        public void testCase1() {
            System.out.println("Executing test case 1");
        }

        @Test
        public void testCase2() {
            System.out.println("Executing test case 2");
        }

        @BeforeMethod
        public void beforeMethod() {
            System.out.println("Executing beforeMethod");
        }

        @AfterMethod
        public void afterMethod() {
            System.out.println("Executing afterMethod");
        }

        @BeforeClass
        public static void beforeClass() {
            System.out.println("Executing beforeClass");
        }

        @AfterClass
        public static void afterClass() {
            System.out.println("Executing afterClass");
        }

        @BeforeTest
        public void beforeTest() {
            System.out.println("Executing beforeTest");
        }

        @AfterTest
        public void afterTest() {
            System.out.println("Executing afterTest");
        }

        @BeforeSuite
        public void beforeSuite() {
            System.out.println("Executing beforeSuite");
        }

        @AfterSuite
        public void afterSuite() {
            System.out.println("Executing afterSuite");
        }
}
