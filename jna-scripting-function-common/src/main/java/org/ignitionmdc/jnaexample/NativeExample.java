package org.ignitionmdc.jnaexample;

import com.inductiveautomation.ignition.common.script.hints.ScriptFunction;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Tlhelp32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.win32.W32APIOptions;

import java.util.ArrayList;


public class NativeExample implements INativeExample
{



    @ScriptFunction(docBundlePrefix = "NativeExample")
    @Override
    public String[] RunningProcesses()
    {
        // Predefined JNA Example using Windows Kernel32
        // Get all running processes and return as single list
        ArrayList<String> processes = new ArrayList<>();

        // Load Kernel32 using JNA - System32\kernel32.dll is either 32bit or 64bit depending on your Windows version
        Kernel32 kernel32 = Native.load(Kernel32.class, W32APIOptions.UNICODE_OPTIONS);
        // PROCESSENTRY32 is declared in tlhelp32.h header
        Tlhelp32.PROCESSENTRY32.ByReference processEntry = new Tlhelp32.PROCESSENTRY32.ByReference();
        WinNT.HANDLE snapshot = kernel32.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPPROCESS, new WinDef.DWORD(0));
        try  {
            while (kernel32.Process32Next(snapshot, processEntry)) {
                processes.add(processEntry.th32ProcessID + "\t" + Native.toString(processEntry.szExeFile));
            }
        }
        finally {
            kernel32.CloseHandle(snapshot);
        }
        return processes.toArray(new String[processes.size()]);
    }

    public Integer customDll(){
        // This loads a given DLL file and maps it to the custom defined interface
        IExampleLibrary exampleLibrary = (IExampleLibrary) Native.load(
                "c:\\Windows\\System32\\kernel32.dll", IExampleLibrary.class);

        Integer version = exampleLibrary.GetVersion();
        return version;
    }
}
