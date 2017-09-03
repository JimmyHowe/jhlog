package com.jimmyhowe.jhlog;

import com.jimmyhowe.colorconsole.Console;

public class Main
{
    public static void main(String[] args)
    {
        Log log = new Log();

        log.group("error", Console::red);

        log.group("error", "Alert !!!");

        log.toConsole();
    }
}
