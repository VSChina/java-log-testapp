package com.microsoft.azure;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Log4JLogWriter {
    private static final Logger LOGGER = Logger.getLogger(Log4JLogWriter.class);

    public static void writeLogs() {
        checkAllLogLevels();

        writeLog(Level.INFO);
        writeLog(Level.DEBUG);
        writeLog(Level.TRACE);

        writeExceptionLog();
    }

    public static void writeLog(Level level, String msg) {
        LOGGER.log(level, msg);
    }

    private static void writeLog(Level level) {
        LOGGER.log(level, getLogMsg(level));
    }

    private static void writeExceptionLog() {
        final Exception exception = new FakeException("Fake exception from " + Log4JLogWriter.class);

        LOGGER.log(Level.FATAL, getLogMsg(Level.FATAL), exception);
        LOGGER.log(Level.ERROR, getLogMsg(Level.ERROR), exception);
    }

    private static void checkLogLevel(Level level) {
        if (!LOGGER.isEnabledFor(level)) {
            // As every level will be tested, if not loggable, throw exception
            throw new IllegalStateException("Level " + level + " is not loggable.");
        }
    }

    private static void checkAllLogLevels(){
        checkLogLevel(Level.INFO);
        checkLogLevel(Level.DEBUG);
        checkLogLevel(Level.ERROR);
        checkLogLevel(Level.FATAL);
        checkLogLevel(Level.TRACE);
    }

    private static String getLogMsg(Level level) {
        return String.format(Log4JLogWriter.class + " %s log by %s", level, LOGGER.getClass().getCanonicalName());
    }
}
