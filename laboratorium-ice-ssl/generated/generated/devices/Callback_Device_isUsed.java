// **********************************************************************
//
// Copyright (c) 2003-2011 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.4.2
//
// <auto-generated>
//
// Generated from file `Callback_Device_isUsed.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package generated.devices;

public abstract class Callback_Device_isUsed extends Ice.TwowayCallback
{
    public abstract void response(boolean __ret);

    public final void __completed(Ice.AsyncResult __result)
    {
        DevicePrx __proxy = (DevicePrx)__result.getProxy();
        boolean __ret = false;
        try
        {
            __ret = __proxy.end_isUsed(__result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret);
    }
}
