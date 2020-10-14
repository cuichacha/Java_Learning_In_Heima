package Day18.Code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4JDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(Log4JDemo.class);

    public static void main(String[] args) {
        LOGGER.debug("debug");
        LOGGER.info("info");
        LOGGER.warn("warn");
        LOGGER.error("error");
    }
}
