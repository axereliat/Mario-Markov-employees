package app.core;

/**
 * @author axereliat on 4.10.22
 */
public class ConsoleWriter implements Writer {

    @Override
    public void write(String text) {
        System.out.println(text);
    }
}
