package com.orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GivenTask {


    private final WebDriver driver = new ChromeDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public void login() {
        System.setProperty("webdriver.chrome.driver", "/Users/nikolajgarc/Downloads/chromedriver");

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='username']"))).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }

    public void admin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-main-menu-item"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/span"))).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[5]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button"))).click();
    }

    public void newUser() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input"))).sendKeys("Stewie Griffin");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div/input")).click();
        for(int i = 0; i < 3; i++){
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div[2]/div[1]/i[2]")).click();
        }
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/i[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div/div/div[2]/div/div[1]/input")).sendKeys("Odis Adalwin");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/button[2]")).click();
    }

    public Boolean checkUser() {
        try {
            String stringXpath = "//div[contains(.,\"Stewie Griffin\")]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(stringXpath))).click();
        } catch (TimeoutException e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public void deleteUser() {
        driver.findElement(By.xpath("//div[@class=\"oxd-table-row oxd-table-row--with-border\" and ./div/div[contains(text(), \"Stewie Griffin\")]]//i[@class=\"oxd-icon bi-trash\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(., \"Yes, Delete\")]"))).click();
        driver.close();
    }
}
