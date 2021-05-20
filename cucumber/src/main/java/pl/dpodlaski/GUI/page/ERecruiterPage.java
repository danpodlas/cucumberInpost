package pl.dpodlaski.GUI.page;

import pl.dpodlaski.GUI.POJO.UserPOJO;
import pl.dpodlaski.GUI.driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ERecruiterPage extends Page {

    private static String INPUT_FIELD = "(//div[@id='pnlPage1']//input)[%s]";
    private static final By SELECT_COUNTRY = By.xpath("//div[@id='countriesDivConData']//select");
    private static String SELECT_COUNTRY_OPTION = "//div[@id='countriesDivConData']//*[contains(text(),'%s')]";
    private static final By SELECT_REGION = By.xpath("//div[@id='regionsDivConData']//select");
    private static String SELECT_REGION_OPTION = "//div[@id='regionsDivConData']//*[contains(text(),'%s')]";
    private static final By FILE_BUTTON = By.xpath("//input[@type='file']");
    private static final By INPUT_MONEY = By.xpath("(//textarea)[1]");
    private static final By TIME_WHEN_CAN_START = By.xpath("//div[@class='quasiContent']//*[@type='checkbox']");
    private static final By INFO_OFFER = By.xpath("//div[@class='quasiContent']//*[@type='radio']");
    private static final By CLAUSE_CHECKBOX = By.xpath("//div[@class='other-consents']//input");

    public ERecruiterPage completeTheForm() {
        UserPOJO userPOJO = new UserPOJO().generateRandomUser();

        ArrayList<String> tabs2 = new ArrayList<String>(DriverManager.getWebDriver().getWindowHandles());
        DriverManager.getWebDriver().switchTo().window(tabs2.get(2));

        completePersonalData(userPOJO);
        completeContact(userPOJO);
        completeCVFile(userPOJO.getPathCV());
        completeMoney(userPOJO.getMoney());

        selectRandomCheckBoxStartJob();
        selectRandomCheckInfoOffer();

        selectCheckBoxClause();

        return new ERecruiterPage();
    }

    private void selectCheckBoxClause() {
        click(CLAUSE_CHECKBOX);
    }

    private void selectRandomCheckInfoOffer() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, driver.findElements(INFO_OFFER).size());
        WebElement element = driver.findElements(INFO_OFFER).get(randomNum);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    private void selectRandomCheckBoxStartJob() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, driver.findElements(TIME_WHEN_CAN_START).size());
        WebElement element = driver.findElements(TIME_WHEN_CAN_START).get(randomNum);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    private void completeMoney(String money) {
        sendKeys(INPUT_MONEY, money);
    }

    private void completeCVFile(String pathCV) {
        String pathFile = new File(pathCV).getAbsolutePath();
        sendKeys(FILE_BUTTON, pathFile);
    }

    private void completeContact(UserPOJO userPOJO) {
        click(SELECT_COUNTRY);

        click(By.xpath(String.format(SELECT_COUNTRY_OPTION, userPOJO.getCountry())));

        click(SELECT_REGION);
        click(By.xpath(String.format(SELECT_REGION_OPTION, userPOJO.getRegion())));

        sendKeys(By.xpath(String.format(INPUT_FIELD, 6)), userPOJO.getCity());
    }

    private void completePersonalData(UserPOJO userPOJO) {
        sendKeys(By.xpath(String.format(INPUT_FIELD, 1)), userPOJO.getName());
        sendKeys(By.xpath(String.format(INPUT_FIELD, 2)), userPOJO.getSurname());
        sendKeys(By.xpath(String.format(INPUT_FIELD, 3)), userPOJO.getEmail());
        sendKeys(By.xpath(String.format(INPUT_FIELD, 4)), userPOJO.getPhone());
    }

    public boolean isExistFile(String fileName) {
        return new File("src/main/resources/screenshots/screen" + fileName + ".png").exists();
    }


}
