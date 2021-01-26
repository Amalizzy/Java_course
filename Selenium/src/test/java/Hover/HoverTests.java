package Hover;

import Base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HoverTests extends BaseTest {

    @Test
    public void testHowerUser1(){
        var hoversPage=homePage.clickHover();
        var caption=hoversPage.hoverOverFigure(1);

        assertTrue(caption.isCaptionDisplayed(),"Caption not displayed");
        assertEquals(caption.getTitle(),"name: user1", "Caption title incorrect");
        assertEquals(caption.getLinkText(),"View profile", "caption link text incorrect");
        assertTrue(caption.getLink().endsWith("/user/1"), "link incorrect");
    }
}
