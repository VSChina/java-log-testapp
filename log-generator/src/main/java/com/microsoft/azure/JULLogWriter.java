package com.microsoft.azure;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JULLogWriter {
    private static final Logger LOGGER = Logger.getLogger(JULLogWriter.class.getName());

    public static void writeLogs() {
        checkAllLogLevels();

        writeLog(Level.INFO);
        writeLog(Level.FINE);
        writeLog(Level.FINER);
        writeLog(Level.FINEST);

        writeExceptionLog();
    }

    public static void writeLog(Level level, String msg) {
        LOGGER.log(level, msg);
    }

    private static void writeLog(Level level) {
        LOGGER.log(level, getLogMsg(level));
    }

    private static void writeExceptionLog() {
        final Exception exception = new FakeException("Fake exception from JULLogWriter.");

        LOGGER.log(Level.WARNING, getLogMsg(Level.WARNING), exception);
        LOGGER.log(Level.SEVERE, getLogMsg(Level.SEVERE), exception);
    }

    private static void checkLogLevel(Level level) {
        if (!LOGGER.isLoggable(level)) {
            // As every level will be tested, if not loggable, throw exception
            throw new IllegalStateException("Level " + level.getName() + " is not loggable.");
        }
    }

    private static void checkAllLogLevels(){
        checkLogLevel(Level.INFO);
        checkLogLevel(Level.FINE);
        checkLogLevel(Level.FINER);
        checkLogLevel(Level.FINEST);
        checkLogLevel(Level.WARNING);
        checkLogLevel(Level.SEVERE);
    }

    private static String getLogMsg(Level level) {
        return String.format("JULLogWriter %s log by %s ", level.getName(), LOGGER.getClass().getCanonicalName());
    }
}
