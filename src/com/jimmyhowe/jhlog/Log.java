package com.jimmyhowe.jhlog;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Log
{
    /**
     * List of log entries containing the messages.
     */
    @NotNull
    private List<LogEntry> logEntries = new ArrayList<>();

    /**
     * Map of filters containing the callbacks to use to modify log messages.
     */
    @NotNull
    private Map<String, Modifier> filters = new LinkedHashMap<>();

    /**
     * Logs a message to the defined group.
     *
     * @param group   Group name
     * @param message Log message
     */
    public void group(String group, String message)
    {
        this.logEntries.add(
                new LogEntry(
                        group,
                        message,
                        filters.getOrDefault(group, null)
                )
        );
    }

    /**
     * Sets the group modifier.
     *
     * @param group    Group name
     * @param modifier Log message modifier
     */
    public void group(String group, Modifier modifier)
    {
        filters.put(group, modifier);
    }

    /**
     * Logs a note.
     *
     * @param message log message
     */
    public void note(String message)
    {
        group(LoggingLevels.NOTE, message);
    }

    /**
     * Sets the note modifier.
     *
     * @param modifier Group modifier
     */
    public void onNote(Modifier modifier)
    {
        group(LoggingLevels.NOTE, modifier);
    }

    /**
     * Logs an info entry.
     *
     * @param message Log message
     */
    public void info(String message)
    {
        group(LoggingLevels.INFO, message);
    }

    /**
     * Sets the info modifier.
     *
     * @param modifier Group modifier
     */
    public void onInfo(Modifier modifier)
    {
        group(LoggingLevels.INFO, modifier);
    }

    /**
     * logs a debug message.
     *
     * @param message Log message
     */
    public void debug(String message)
    {
        group(LoggingLevels.DEBUG, message);
    }

    /**
     * Sets the debug modifier.
     *
     * @param modifier Group modifier
     */
    public void onDebug(Modifier modifier)
    {
        group(LoggingLevels.DEBUG, modifier);
    }

    /**
     * logs an error entry.
     *
     * @param message Log message
     */
    public void error(String message)
    {
        group(LoggingLevels.ERROR, message);
    }

    /**
     * Sets the error modifier.
     *
     * @param modifier Group modifier
     */
    public void onError(Modifier modifier)
    {
        group(LoggingLevels.ERROR, modifier);
    }

    /**
     * @return Log entries
     */
    @NotNull
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
     * @param index Index
     *
     * @return Type
     */
    public String getTypeAt(int index)
    {
        return logEntries.get(index).getType();
    }

    /**
     * @param index Index
     *
     * @return Message
     */
    public String getMessageAt(int index)
    {
        return logEntries.get(index).getMessage();
    }

    /**
     * @param index Index
     *
     * @return Raw message
     */
    public String getRawMessageAt(int index)
    {
        return logEntries.get(index).getRawMessage();
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
        for ( LogEntry logEntry : getLogEntriesByGroup(group) )
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
    private List<LogEntry> getLogEntriesByGroup(String group)
    {
        return this.logEntries.stream()
                              .filter(entry -> entry.getType().equalsIgnoreCase(group))
                              .collect(Collectors.toList());
    }
}
