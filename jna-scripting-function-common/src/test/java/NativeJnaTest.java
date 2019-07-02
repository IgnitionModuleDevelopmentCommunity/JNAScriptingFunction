import com.sun.jna.Native;
import org.ignitionmdc.jnaexample.IExampleLibrary;
import org.ignitionmdc.jnaexample.NativeExample;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NativeJnaTest {

    @Test
    void predefinedJnaExample(){
        //This example uses Kernel32 to list any processes running on the system
        NativeExample nativeExample = new NativeExample();
        String[] processes = nativeExample.RunningProcesses();
        assertTrue(processes.length > 0, "should have at least 1 running process");
        for (String process: processes
             )
        {
            System.out.println(process);

        }

    }


    @Test
    void customDll(){

        IExampleLibrary exampleLibrary = (IExampleLibrary) Native.load(
                "c:\\Windows\\System32\\kernel32.dll", IExampleLibrary.class);

        Integer version = exampleLibrary.GetVersion();

        System.out.println(version);
        assertTrue(version > 0, "version number should return positive value");
    }


}
