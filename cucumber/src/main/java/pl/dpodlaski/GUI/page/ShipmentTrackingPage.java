package pl.dpodlaski.GUI.page;

import pl.dpodlaski.GUI.driver.manager.DriverManager;
import org.openqa.selenium.By;

public class ShipmentTrackingPage extends Page{

    private static final By LAST_STATUS_TEXT = By.xpath("(//div[@class='message-box messageBox'])[1]");
    private static final By NUMBER_SHIPMENT = By.xpath("//*[@class='parcel--statuses--list singleParcelStatusesList -ready']");


    public String getTextStatus(){
        return getText(LAST_STATUS_TEXT);
    }

    public boolean isTextStatusVisible(){
        return isVisible(LAST_STATUS_TEXT);
    }

    public boolean isShipmentNumberVisible(){
        return DriverManager.getWebDriver().findElement(NUMBER_SHIPMENT).isDisplayed();
    }

}
