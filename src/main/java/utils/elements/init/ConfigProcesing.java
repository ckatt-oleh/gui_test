package utils.elements.init;


import tests.webdriver.PosNegTest;

import java.util.*;

public class ConfigProcesing {

    private static HashMap<String, String> configsApp = new HashMap<String, String>();
    private HashMap<String, String> configsDriver = new HashMap<String, String>();
    private ArrayList<Class> tests = new ArrayList<Class>();

    public ConfigProcesing(String[] args) {

        if (args.length == 0) {
            args = new String[] {
                    "-tests", "PosNegTest",
                    "-browser", "chrome",
                    "-driverPath", "C:\\chromedriver\\chromedriver.exe",
                    "-baseUrl", "http://my-sandbox.maxpay.com"
            };
        }

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-browser")) {

                if (i < args.length - 1) {
                    String browserName = args[i + 1].toLowerCase();

                    if (browserName.equals("chrome") || browserName.equals("firefox")) {
                        configsDriver.put("browser", browserName);
                    }
                }

            } else if (args[i].equals("-driverPath")) {

                if (i < args.length - 1) {
                    String driverPath = args[i + 1];

                    configsDriver.put("driverPath", driverPath);
                }

            } else if (args[i].equals("-baseUrl")) {

                if (i < args.length - 1) {
                    String baseUrl = args[i + 1];

                    configsApp.put("baseUrl", baseUrl);

                }

            } else if (args[i].equals("-tests")) {

                for (int k = i + 1; k < args.length; k++) {
                    if (args[k].startsWith("-")) {
                        break;
                    }

                    if (args[k].equals("PosNegTest")) {
                        tests.add(PosNegTest.class);
                    } else if (args[k].equals("NextTest")) {
//                         tests.add(NextTest.class);
                    } else {
                        // .....
                    }

                }

            } else {
                if (args[i].startsWith("-")) {
                    System.err.println("Unrecognized option: " + args[i]);
                }
            }
        }
    }

    public static HashMap<String, String> getConfigsApp() {
        return configsApp;
    }

    public HashMap<String, String> getConfigsDriver() {
        return this.configsDriver;
    }

    public ArrayList<Class> getTests() {
        return this.tests;
    }

}
