package commonLibs.Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenshotUtils {
    private TakesScreenshot camera;
    public ScreenshotUtils (WebDriver driver) {
        camera=(TakesScreenshot)driver;
    }
    public void captureAndSaveScreenshot(String fileName) throws Exception{
        fileName=fileName.trim();
        File imgFile,tmpFile;
        imgFile=new File(fileName);
        if(imgFile.exists()) {

            throw new Exception("File alrady Exist");
        }
        tmpFile=camera.getScreenshotAs(OutputType.FILE);
        FileUtils.moveFile(tmpFile, imgFile);
    }

}
