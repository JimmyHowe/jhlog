package com.jimmyhowe.jhlog;

import org.jetbrains.annotations.NotNull;

public interface Modifier
{
    @NotNull String run(String message);
}
