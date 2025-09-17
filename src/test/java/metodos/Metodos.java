package metodos;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.Normalizer;
import java.time.Duration;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Metodos {

    private WebDriver driver;

    public Metodos(WebDriver driver){

        this.driver = driver;
    }


    public void preencher(By locator,String texto){
       try {
           driver.findElement(locator).clear();
           driver.findElement(locator).sendKeys(texto);
       } catch (Exception e) {
           System.out.println("****** MSG DE ERRO ******" + e.getMessage());
           throw new NoSuchElementException("Elemento não encontrado" + locator);
       }
    }



    public void clicar(By locator) {
        try {
            driver.findElement(locator).click();
        } catch (Exception e) {
            System.out.println("****** MSG DE ERRO ******" + e.getMessage());
            throw new NoSuchElementException("Elemento não encontrado");
        }
    }


    public void clicarConstainsTexto(String texto) {

        By locator = By.xpath(
                "//ul[@class='delivery-method']" +
                        "//*[contains(text(),'" + texto + "')]"
        );

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(locator))
                    .click();
        } catch (Exception e) {
            System.out.println("****** MSG DE ERRO ****** " + e.getMessage());
            throw new NoSuchElementException("Elemento não encontrado: " + texto);
        }
    }

    public void uploadArquivo(String caminho) {
        try {
            Robot robot = new Robot();
            robot.delay(1000);

            StringSelection ss = new StringSelection(caminho);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(1000);

        } catch (AWTException e) {
            throw new RuntimeException("Erro ao tentar usar o Robot: " + e.getMessage(), e);
        }
    }

    private String normaliza(String s){
        if (s == null) return "";
        String semAcento = java.text.Normalizer.normalize(s, java.text.Normalizer.Form.NFD)
                .replaceAll("\\p{M}+", "");
        return semAcento.toLowerCase().trim();
    }

    public void validarValorContem(By locator, String trechoEsperado){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(8));

        wait.until(d -> {
            String v = driver.findElement(locator).getAttribute("value");
            return v != null && !v.isBlank();
        });

        String value = driver.findElement(locator).getAttribute("value");
        String valNorm = normaliza(value);
        String expNorm = normaliza(trechoEsperado);

        if (!valNorm.contains(expNorm)) {
            throw new AssertionError(
                    "Valor não contém o trecho esperado.\n" +
                            "Esperado conter: " + trechoEsperado + "\n" +
                            "Value atual:     " + value
            );
        }
    }

    public void validarValorContem2(By locator, String trechoEsperado){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(8));

        wait.until(d -> {
            String v = driver.findElement(locator).getAttribute("validationMessage");
            return v != null && !v.isBlank();
        });

        String value = driver.findElement(locator).getAttribute("validationMessage");
        String valNorm = normaliza(value);
        String expNorm = normaliza(trechoEsperado);

        if (!valNorm.contains(expNorm)) {
            throw new AssertionError(
                    "Valor não contém o trecho esperado.\n" +
                            "Esperado conter: " + trechoEsperado + "\n" +
                            "Value atual:     " + value
            );
        }
    }

    public void validarTexto(String textoEsperado, By elemento) {
        try {
            assertEquals(textoEsperado, driver.findElement(elemento).getText());
        } catch (Exception e) {
            System.out.println("****** MSG DE ERRO ******" + e.getMessage());
            throw new NoSuchElementException("Elemento não encontrado" + textoEsperado);
        }
    }
 }


