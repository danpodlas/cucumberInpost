package pl.dpodlaski.OOP;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.AssertJUnit.assertTrue;

public class StepDefUnit {

    Laptops l;
    Phone p;
    double newPrice;

    @Given("Użytkownik posiada produkt {string} {string} {string} {string}")
    public void użytkownikPosiadaProdukt(String arg0, String arg1, String arg2, String arg3) {

        if (arg0.equals("Laptops")) {
            l = new Laptops(arg1, Double.parseDouble(arg2), arg3);
        } else if (arg0.equals("Phone")) {
            p = new Phone(arg1, Double.parseDouble(arg2), arg3);
        }
    }

    @When("System przelicza cenę i podaje ją użytkownikowi {string}")
    public void systemPrzeliczaCenęIPodajeJąUżytkownikowi(String arg0) {
        if (arg0.equals("Laptops")) {
            newPrice = l.getPrice();
        } else if (arg0.equals("Phone")) {
            newPrice = p.getPrice();
        }
    }

    @Then("Cena poprawna {string}")
    public void cenaPoprawna(String arg0) {
        assertTrue(newPrice==Double.parseDouble(arg0));
    }

}
