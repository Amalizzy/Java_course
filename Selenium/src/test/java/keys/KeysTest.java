package keys;

import Base.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class KeysTest extends BaseTest {

    @Test
    public void testBackspace(){
        var keypage=homePage.clickKeyPresses();
        keypage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keypage.getResult(),"You entered: BACK_SPACE");
    }
    @Test
    public void testPi(){
        var keyPage=homePage.clickKeyPresses();
        keyPage.enterPi();
    }
}
