package com.jimmyhowe.jhlog;

/**
 * Log Entry to contain the type and the message in order to filter
 *
 * @author Jimmy Howe
 */
public class LogEntry
{
    /**
     * Type of entry
     */
    private String type;

    /**
     * Log message
     */
    private String message;

    /**
     * Message filter
     */
    private Modifier modifier;

    /**
     * @param group    Type of entry
     * @param message  Type of message
     * @param modifier Message filter
     */
    public LogEntry(String group, String message, Modifier modifier)
    {
        this.type = group;
        this.message = message;
        this.modifier = modifier;
    }

    /**
     * @return Entry type
     */
    public String getType()
    {
        return type;
    }

    /**
     * @return Log message
     */
    public String getMessage()
    {
        return modifier == null ? message : modifier.run(message);
    }

    /**
     * @return Log message
     */
    public String getRawMessage()
    {
        return message;
    }
}
