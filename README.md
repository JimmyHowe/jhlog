# JHLOG: Java Logging Library

## Usage

    Log log = new Log();
    
    log.note("note");
    log.info("info");
    log.debug("debug");
    log.error("error");
    
    List<LogEntry> logEntries = log.getLogEntries();
    
## Modifiers

    Log log = new Log();
    
    log.onNote(message -> "> " + message);

    log.note("note"); // Produces "> note"
    
## Outputting to console

    Log log = new Log();
    
    log.onNote(message -> {
        System.out.println(message);
        return message;
    });

## Helper Functions

    getLastEntry()              // Returns the last entry
    getTypeAt(int index)        // Gets type at index
    getMessageAt(int index)     // Gets message at index
    getRawMessageAt(int index)  // return unmodified message
    
    toConsole()                 // Outputs log to console
    toConsole(String group)     // Outputs log by group to console

## Extending

    private class QueryLog extends Log
    {
        public static final String QUERY = "QUERY";

        public void onQuery(Modifier modifier)
        {
            group(QUERY, modifier);
        }

        public void query(String message)
        {
            group(QUERY, message);
        }
    }