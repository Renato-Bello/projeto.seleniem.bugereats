package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotUtil {

    public static void screenShot(WebDriver driver, String featureName, String testCaseName) {
        // data e hora do servidor
        String timestamp = new SimpleDateFormat("yyyyMMdd" + "HHmmss").format(new Date());

        // nome do arquivo
        String fileName = testCaseName + "_" + timestamp + ".png";

        // local para armazenar evidências
        String dirPath = "target/evidencias" + featureName;

        try {
            Path directory = Paths.get(dirPath);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path destinationPath = Paths.get(dirPath,fileName);
            Files.copy(screenshot.toPath(), destinationPath);

        } catch (Exception e) {
            System.err.println("erro ao salvar screenshot" + e.getMessage());

        }
    }
}
