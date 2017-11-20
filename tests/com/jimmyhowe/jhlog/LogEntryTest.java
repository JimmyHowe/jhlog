package com.jimmyhowe.jhlog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogEntryTest
{
    @BeforeEach
    void setUp()
    {
    }

    @Test
    void it_can_be_used_without_setup()
    {
        Log log = new Log();

        log.note("note");
        log.info("info");
        log.debug("debug");
        log.error("error");

        assertEquals("note", log.getLogEntries().get(0).getMessage());
        assertEquals("info", log.getLogEntries().get(1).getMessage());
        assertEquals("debug", log.getLogEntries().get(2).getMessage());
        assertEquals("error", log.getLogEntries().get(3).getMessage());
    }

    @Test
    void it_can_use_modifiers()
    {
        Log log = new Log();

        log.onNote(message -> "> " + message);
        log.onInfo(message -> "i " + message);
        log.onDebug(message -> "D " + message);
        log.onError(message -> "! " + message);

        log.note("note");
        log.info("info");
        log.debug("debug");
        log.error("error");

        assertEquals("> note", log.getLogEntries().get(0).getMessage());
        assertEquals("i info", log.getLogEntries().get(1).getMessage());
        assertEquals("D debug", log.getLogEntries().get(2).getMessage());
        assertEquals("! error", log.getLogEntries().get(3).getMessage());
    }

    @Test
    void it_can_be_extended()
    {
        QueryLog queryLog = new QueryLog();

        queryLog.onQuery(String::toUpperCase);

        queryLog.query("select * from users");

        assertEquals("SELECT * FROM USERS", queryLog.getLastEntry().getMessage());
    }

    @Test
    void it_can_output_to_screen()
    {
        Log log = new Log();

        log.onNote(message -> {
            System.out.println(message);
            return message;
        });
    }

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
}