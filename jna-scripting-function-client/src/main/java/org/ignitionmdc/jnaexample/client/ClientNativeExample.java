package org.ignitionmdc.jnaexample.client;


import com.inductiveautomation.ignition.client.gateway_interface.ModuleRPCFactory;
import com.inductiveautomation.ignition.common.script.hints.ScriptFunction;
import org.ignitionmdc.jnaexample.INativeExample;

public class ClientNativeExample implements INativeExample {

    private final INativeExample rpc;
    public ClientNativeExample()
    {
        rpc = ModuleRPCFactory.create(
                "org.ignitionmdc.jnaexample.jna-scripting-function",
                INativeExample.class);
    }

    @ScriptFunction(docBundlePrefix = "ClientNativeExample")
    public String[] RunningProcesses()
    {

        return rpc.RunningProcesses();
    }

    @Override
    public Integer customDll() {
        return rpc.customDll();
    }


}
