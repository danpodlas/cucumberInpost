package pl.dpodlaski.GUI.page;

import pl.dpodlaski.GUI.waits.WaitForElement;
import org.openqa.selenium.By;

public class CareerPage extends Page{

    public static final By BUTTON_SEARCH = By.xpath("//button[@class='btn--primary jobsSelectTrigger']");
    public static final By TEAM_SEARCH = By.xpath("//select[@id='filter-departments-main']");
    public static String TEAM_OPTION_SEARCH = "//option[@value='%s']";
    public static final By BUTTON_APPLY_FIRS_ROW = By.xpath("(//*[@class='link--component -smallmobile'])[1]");

    private static final By BUTTON_ACCEPT_COOKIES = By.id("onetrust-accept-btn-handler");

    public CareerPage clickButtonAcceptCookies() {
        click(BUTTON_ACCEPT_COOKIES);

        return new CareerPage();
    }

    public CareerPage clickSearchButton() {
        click(BUTTON_SEARCH);
        return new CareerPage();
    }

    public CareerPage selectTeam(String arg0) {
        click(TEAM_SEARCH);
        click(By.xpath(String.format(TEAM_OPTION_SEARCH,arg0)));
        return new CareerPage();
    }

    public DetailsOfOfferPage clickApplyInFirstRow() {
        click(BUTTON_APPLY_FIRS_ROW);
        return new DetailsOfOfferPage();
    }

}
