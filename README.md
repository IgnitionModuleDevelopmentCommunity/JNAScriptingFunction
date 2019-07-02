# JNAScriptingFunction

**Overview**

The JNA (Java Native Access) Example module provides users with two examples for using a Dynamic Link Library (DLL) in Ignition, including the use of a standard Windows DLL (kernel32.dll) as well as a user-provided DLL. This project exposes one function from each of those two libraries in the form of a scripting function in Ignition. This module is able to load DLLs written in C or C++. 

**Need to use a DLL written in C#?**

JNA can load DLLs that use C linkage, and therefore will not natively support DLLs written in C#. To use a C# DLL, users can enable COM Interop in their build and then create a wrapper DLL in C/C++ that calls the C# DLL. 

*Alternatively, there is a 3rd party Visual Studio package available that may help simplify this process:https://www.nuget.org/packages/UnmanagedExports*

**Included Files**

Module Source Code

Example DLL Source Code written in C

Example DLL compiled in 32bit and 64bit versions

**Requirements**

Ignition 8.0.2 or later
