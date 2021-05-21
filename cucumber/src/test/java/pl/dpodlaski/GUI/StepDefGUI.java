package pl.dpodlaski.GUI;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import pl.dpodlaski.GUI.driver.manager.DriverManager;
import pl.dpodlaski.GUI.driver.manager.DriverUtils;
import pl.dpodlaski.GUI.page.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class StepDefGUI {

    MainPage page;
    ShipmentTrackingPage shipmentTrackingPage;
    CareerPage careerPage;
    DetailsOfOfferPage detailsOfOffer;
    ERecruiterPage eRecruiterPage;

    @Before("@ToTest")
    public void setUp() throws IOException {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();

//        try {
//            FileUtils.cleanDirectory(new File("src/main/resources/screenshots"));
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//            Files.createDirectory(Paths.get("src/main/resources/screenshots"));
//        }
    }

    @Given("^Użytkownik jest na stronie kariera$")
    public void użytkownikJestNaStronieKariera() {
        DriverUtils.navigateToPage("https://inpost.pl/kariera");
    }

    @When("Użytwkonik wybiera zespół {string}")
    public void użytwkonikWybieraZespół(String arg0) {
        careerPage = new CareerPage();
        careerPage.clickButtonAcceptCookies();
        careerPage.selectTeam(arg0);
        careerPage.clickSearchButton();
    }

    @And("Użytwkonik wybiera pierwszą ofertę na liście i klika aplikuje")
    public void użytwkonikWybieraPierwsząOfertęNaLiścieIKlikaAplikuje() {
        detailsOfOffer = careerPage.clickApplyInFirstRow();
    }

    @And("Użytwkonik uzupełnia formularz")
    public void użytwkonikUzupełniaFormularz() {
        eRecruiterPage = detailsOfOffer.clickApply();
        eRecruiterPage.completeTheForm();
    }

    @Then("Zapisywany jest screen")
    public void zapisywanyJestScreen() {
        String fileName = "CarrerAppplication" + RandomStringUtils.randomAlphanumeric(3);
        takeScreenshot(fileName);

        assertTrue(eRecruiterPage.isExistFile(fileName));
    }

    @Given("Użytkownik jest na stronie głównej")
    public void użytkownikJestNaStronieGłównej() {
        DriverUtils.navigateToPage("https://inpost.pl/");
    }

    @When("Użytwkonik wpowadza numer paczki {string}")
    public void użytwkonikWpowadzaNumerPaczki(String arg0) {
        page = new MainPage();
        page.clickButtonAcceptCookies()
                .sendKeysToInputSearch(arg0);
    }

    @Then("Paczka została znaleziona")
    public void paczkaZostałaZnaleziona() {
        shipmentTrackingPage = page.clickButtonSearch();
        assertTrue(shipmentTrackingPage.isTextStatusVisible());
    }

    @And("Status paczki zawiera słowo {string}")
    public void statusPaczkiZawieraSłowo(String arg0) {
        assertTrue(shipmentTrackingPage.getTextStatus().contains(arg0));
    }

    @Then("Paczka nie została znaleziona")
    public void paczkaNieZostałaZnaleziona() {
        assertFalse(page.clickButtonSearch().isShipmentNumberVisible());
    }


    public void takeScreenshot() {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(DriverManager.getWebDriver());
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File("src/main/resources/screenshots/screen" + LocalDateTime.now().getDayOfYear()
                    + RandomStringUtils.randomAlphanumeric(9) + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshot(String fileName) {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(DriverManager.getWebDriver());
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File("src/main/resources/screenshots/screen" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After("@ToTest")
    public void tearDown() {
        takeScreenshot();
        DriverManager.disposeDriver();
    }

}
