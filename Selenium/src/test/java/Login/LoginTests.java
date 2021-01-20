package Login;

import Base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTest {
    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage=homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage=loginPage.clickLoginButton();
        secureAreaPage.getAlertText();
        assertEquals(secureAreaPage.getAlertText(),"You logged into a secure area! x","Alert text is incorrect");
    }
}
