package utils.elements.init.reader;

public class ConsoleReader implements IReader {

    private String[] strArgs;

    public ConsoleReader(String[] strArgs) {
        this.strArgs = strArgs;
    }

    public String[] read() {
        return strArgs;
    }
}
