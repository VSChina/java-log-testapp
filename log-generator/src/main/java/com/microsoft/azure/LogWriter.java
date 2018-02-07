package com.microsoft.azure;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

public class LogWriter {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogWriter.class);

    public static void writeLogs() {
        if(LOGGER.isInfoEnabled()) {
            LOGGER.info(getLogMsg(Level.INFO));
        }

        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug(getLogMsg(Level.ERROR));
        }

        if(LOGGER.isTraceEnabled()) {
            LOGGER.trace(getLogMsg(Level.TRACE));
        }

        writeExceptionLog();
    }

    private static void writeExceptionLog() {
        final Exception exception = new FakeException("Fake exception from LogWriter.");

        if(LOGGER.isWarnEnabled()) {
            LOGGER.warn(getLogMsg(Level.WARN), exception);
        }

        if(LOGGER.isErrorEnabled()) {
            LOGGER.error(getLogMsg(Level.ERROR), exception);
        }
    }

    private static String getLogMsg(Level level) {
        return String.format("LogWriter log with level %s ", level.name());
    }
}
