package org.pinkpanther.oauth2.client.util;

import java.io.PrintStream;

/**
 * @author ben
 * @version 1.0
 */
public class Logger {

    private static PrintStream errStream;
    private static PrintStream logStream;

    public static PrintStream getErrStream() {
        return errStream;
    }

    public static void setErrStream(PrintStream errStream) {
        Logger.errStream = errStream;
    }

    public static PrintStream getLogStream() {
        return logStream;
    }

    public static void setLogStream(PrintStream logStream) {
        Logger.logStream = logStream;
    }

    static void log(String msg) {
        if (logStream != null) {
            logStream.println(msg);
        }
    }

    static void error(String msg) {
        if (errStream != null) {
            errStream.println(msg);
        }
    }

    static void error(Exception e) {
        if (errStream != null) {
            errStream.println(e.getMessage());
            e.printStackTrace(errStream);
        }
    }


}
