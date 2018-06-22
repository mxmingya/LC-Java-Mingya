/**
 * Created by mingyama on 10/12/17.
 */

import java.util.*;

public class Logger {

    List<String> log;
    List<String> warning;
    public Logger() {
        log = new LinkedList<>();
        warning = new LinkedList<>();
    }

    private void write(String message) {
        log.add(message);
    }

    private void warn(String message) {
        warning.add(message);
    }

}
