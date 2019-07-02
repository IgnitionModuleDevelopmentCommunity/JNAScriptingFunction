package org.ignitionmdc.jnaexample;

import com.sun.jna.Library;

public interface IExampleLibrary extends Library
{

    Integer GetVersion();
}
