package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

public class LoggerExample {
    public static final Logger LOGGER = Logger.getLogger(LoggerExample.class.getName());

    public static void main(String[] args) throws IOException {
//        LogManager.getLogManager().readConfiguration(new FileInputStream(new File("log.properties")));



        LOGGER.setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(getCustomForm());
        consoleHandler.setFilter(e -> !e.getMessage().contains("lvl"));
        System.out.println(consoleHandler.getLevel());
        consoleHandler.setLevel(Level.FINEST);
        FileHandler fileHandler = new FileHandler();

        LOGGER.setLevel(Level.ALL);
        LOGGER.addHandler(consoleHandler);
//        LOGGER.addHandler(fileHandler);

        LOGGER.severe("severe lvl");
        LOGGER.severe("severe 1");
        LOGGER.severe("severe 2");
        LOGGER.severe("severe lvl");
        LOGGER.warning("warning lvl");
        LOGGER.info("info lvl");
        LOGGER.finest("finest lvl");

        try{
            int x = 100/0;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Exception", e);
        }
        LOGGER.log(Level.INFO, "test info");

    }

    public static Formatter getCustomForm() {
        Formatter formatter = new Formatter() {
            @Override
            public String format(LogRecord record) {
                return "\u001B[31m*****" + record.getMessage() + "******\u001B[0m\n";
            }
        };
        return formatter;
    }
}
