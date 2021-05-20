package pl.dpodlaski.GUI.page;

import org.openqa.selenium.By;

public class MainPage extends Page{

    private static final By BUTTON_SEARCH = By.xpath("//*[@class='btncontainer']//button");
    private static final By INPUT_SEARCH = By.xpath("//input[@name='number']");

    private static final By BUTTON_ACCEPT_COOKIES = By.id("onetrust-accept-btn-handler");


    public MainPage sendKeysToInputSearch(String txt) {
        sendKeys(INPUT_SEARCH, txt);
        return new MainPage();
    }

    public ShipmentTrackingPage clickButtonSearch() {
        click(BUTTON_SEARCH);
        return new ShipmentTrackingPage();
    }

    public MainPage clickButtonAcceptCookies() {
        click(BUTTON_ACCEPT_COOKIES);
        return new MainPage();
    }


}
