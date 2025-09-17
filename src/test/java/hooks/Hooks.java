package hooks;

import drivers.DriverManager;
import io.cucumber.java.AfterAll;

public class Hooks {
    @AfterAll
    public static void fecharNavegador() {
        DriverManager.quitDriver();
    }
}
