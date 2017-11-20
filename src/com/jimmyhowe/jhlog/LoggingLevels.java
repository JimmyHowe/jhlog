package com.jimmyhowe.jhlog;

class LoggingLevels
{
    /**
     * Other runtime errors or unexpected conditions. Expect these to be immediately visible on a status console.
     */
    static final String ERROR = "ERROR";

    /**
     * Use of deprecated APIs, poor use of API, 'almost' errors, other runtime situations that are undesirable or
     * unexpected, but not necessarily "wrong". Expect these to be immediately visible on a status console.
     */
    static final String WARN = "WARN";

    /**
     * Interesting runtime events (startup/shutdown). Expect these to be immediately visible on a console, so be
     * conservative and keep to a minimum.
     */
    static final String INFO = "INFO";

    /**
     * detailed information on the flow through the system. Expect these to be written to logs only.
     */
    static final String DEBUG = "DEBUG";

    /**
     * more detailed information. Expect these to be written to logs only.
     */
    static final String TRACE = "TRACE";

    /**
     * Any other note
     */
    static final String NOTE = "NOTE";
}