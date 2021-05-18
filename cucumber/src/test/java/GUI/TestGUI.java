package GUI;

import GUI.page.InPost;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TestGUI extends TestBase{

    @Test
    public void FirstTest(){
        InPost inpost = new InPost();

        assertTrue("Sprawdzenie widoczności elementu", inpost.isInputSearchDisplayed());
    }

}
