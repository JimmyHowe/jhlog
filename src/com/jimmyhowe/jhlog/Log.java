package com.jimmyhowe.jhlog;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Log
{
    private static final String NOTE = "note";

    private static final String INFO = "info";

    private static final String DEBUG = "debug";

    private static final String ERROR = "ERROR";

    private List<LogEntry> logEntries = new ArrayList<>();

    private Map<String, Modifier> filters = new LinkedHashMap<>();

    /**
     * Logs a message to the defined group
     *
     * @param group   Group name
     * @param message Log message
     */
    public void group(String group, String message)
    {
        this.logEntries.add(new LogEntry(group, message, filters.getOrDefault(group, null)));
    }

    /**
     * Sets the group modifier
     *
     * @param group    Group name
     * @param modifier Log message modifier
     */
    public void group(String group, Modifier modifier)
    {
        filters.put(group, modifier);
    }

    /**
     * Logs a note
     *
     * @param message log message
     */
    public void note(String message)
    {
        group("note", message);
    }

    /**
     * Sets the note modifier
     *
     * @param modifier Group modifier
     */
    public void onNote(Modifier modifier)
    {
        group(NOTE, modifier);
    }

    /**
     * Logs an info entry
     *
     * @param message Log message
     */
    public void info(String message)
    {
        group(INFO, message);
    }

    /**
     * Sets the info modifier
     *
     * @param modifier Group modifier
     */
    public void onInfo(Modifier modifier)
    {
        group(INFO, modifier);
    }

    /**
     * logs a debug message
     *
     * @param message Log message
     */
    public void debug(String message)
    {
        group(DEBUG, message);
    }

    /**
     * Sets the debug modifier
     *
     * @param modifier Group modifier
     */
    public void onDebug(Modifier modifier)
    {
        group(DEBUG, modifier);
    }

    /**
     * logs an error entry
     *
     * @param message Log message
     */
    public void error(String message)
    {
        group(ERROR, message);
    }

    /**
     * Sets the error modifier
     *
     * @param modifier Group modifier
     */
    public void onError(Modifier modifier)
    {
        group(ERROR, modifier);
    }

    /**
     * @return Log entries
     */
    public List<LogEntry> getLogEntries()
    {
        return logEntries;
    }

    /**
     * @return The last entry
     */
    public LogEntry getLastEntry()
    {
        return logEntries.get(logEntries.size() - 1);
    }

    /**
     * outputs to console
     */
    public void toConsole()
    {
        for ( LogEntry logEntry : logEntries )
        {
            System.out.println(logEntry.getMessage());
        }
    }

    /**
     * Outputs the log entries by group
     *
     * @param group Group name
     */
    public void toConsole(String group)
    {
        for ( LogEntry logEntry : getByGroup(group) )
        {
            System.out.println(logEntry.getMessage());
        }
    }

    /**
     * Filters the log entries by group
     *
     * @param group group name
     *
     * @return filtered log entries
     */
    private List<LogEntry> getByGroup(String group)
    {
        return this.logEntries.stream()
                              .filter(logEntry -> logEntry.getType().equalsIgnoreCase(group))
                              .collect(Collectors.toList());
    }
}
