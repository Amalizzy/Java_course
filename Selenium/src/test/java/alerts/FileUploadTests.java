package alerts;

import Base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTest {

    @Test
    public void testFileUpload(){
        var uploadPage=homePage.clickFileUpload();
        uploadPage.uploadFile("C:\\Users\\zenbook\\Desktop\\test\\Selenium\\resources\\chromedriver.exe");

        assertEquals(uploadPage.getUploadedFiles(),"chromedriver", "Uploaded files incorrect");
    }
}
