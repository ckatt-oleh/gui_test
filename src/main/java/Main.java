import utils.elements.init.ConfigProcesing;
import utils.elements.init.Runner;
import utils.elements.init.reader.ConsoleReader;
import utils.elements.init.reader.IReader;

public class Main {

    public static void main(String[] args) {



        IReader reader = new ConsoleReader(args);
        ConfigProcesing configProcessing = new ConfigProcesing(reader.read());

        Runner runner = new Runner(
                configProcessing.getConfigsApp(),
                configProcessing.getConfigsDriver(),
                configProcessing.getTests()
        );
        runner.init();
        runner.runTests();
    }

}
