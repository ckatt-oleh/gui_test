package utils.elements.init;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Runner {

    private HashMap<String, String> configsApp;
    private HashMap<String, String> configsDriver;
    private ArrayList<Class> tests;

    public Runner(HashMap<String, String> configsApp, HashMap<String, String> configsDriver, ArrayList<Class> tests) {
        this.configsApp = configsApp;
        this.configsDriver = configsDriver;
        this.tests = tests;
    }

    public void init() {
        BrowserInit.initializeDriver(this.configsDriver);
        BrowserInit.setPropertyWindow();
    }

    public void runTests() {
        if (!this.tests.isEmpty()) {
            Result result = JUnitCore.runClasses(
                    this.tests.toArray(new Class[this.tests.size()])
            );

            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }

            System.out.println(result.wasSuccessful());
        } else {
            System.out.println("No Test class exist");
        }
    }

}
