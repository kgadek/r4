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
// Generated from file `DevicePrx.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package generated.devices;

public interface DevicePrx extends Ice.ObjectPrx
{
    public void getControl(String userName)
        throws generated.exceptions.DeviceAlreadyInUseException;

    public void getControl(String userName, java.util.Map<String, String> __ctx)
        throws generated.exceptions.DeviceAlreadyInUseException;

    public Ice.AsyncResult begin_getControl(String userName);

    public Ice.AsyncResult begin_getControl(String userName, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getControl(String userName, Ice.Callback __cb);

    public Ice.AsyncResult begin_getControl(String userName, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_getControl(String userName, Callback_Device_getControl __cb);

    public Ice.AsyncResult begin_getControl(String userName, java.util.Map<String, String> __ctx, Callback_Device_getControl __cb);

    public void end_getControl(Ice.AsyncResult __result)
        throws generated.exceptions.DeviceAlreadyInUseException;

    public void releaseControl(String userName)
        throws generated.exceptions.IncorrectUserNameException;

    public void releaseControl(String userName, java.util.Map<String, String> __ctx)
        throws generated.exceptions.IncorrectUserNameException;

    public Ice.AsyncResult begin_releaseControl(String userName);

    public Ice.AsyncResult begin_releaseControl(String userName, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_releaseControl(String userName, Ice.Callback __cb);

    public Ice.AsyncResult begin_releaseControl(String userName, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_releaseControl(String userName, Callback_Device_releaseControl __cb);

    public Ice.AsyncResult begin_releaseControl(String userName, java.util.Map<String, String> __ctx, Callback_Device_releaseControl __cb);

    public void end_releaseControl(Ice.AsyncResult __result)
        throws generated.exceptions.IncorrectUserNameException;

    public void startObservation(ObserverPrx obs)
        throws generated.exceptions.UserAlreadyObserveException;

    public void startObservation(ObserverPrx obs, java.util.Map<String, String> __ctx)
        throws generated.exceptions.UserAlreadyObserveException;

    public Ice.AsyncResult begin_startObservation(ObserverPrx obs);

    public Ice.AsyncResult begin_startObservation(ObserverPrx obs, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_startObservation(ObserverPrx obs, Ice.Callback __cb);

    public Ice.AsyncResult begin_startObservation(ObserverPrx obs, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_startObservation(ObserverPrx obs, Callback_Device_startObservation __cb);

    public Ice.AsyncResult begin_startObservation(ObserverPrx obs, java.util.Map<String, String> __ctx, Callback_Device_startObservation __cb);

    public void end_startObservation(Ice.AsyncResult __result)
        throws generated.exceptions.UserAlreadyObserveException;

    public void stopObservation(ObserverPrx obs)
        throws generated.exceptions.IncorrectUserNameException;

    public void stopObservation(ObserverPrx obs, java.util.Map<String, String> __ctx)
        throws generated.exceptions.IncorrectUserNameException;

    public Ice.AsyncResult begin_stopObservation(ObserverPrx obs);

    public Ice.AsyncResult begin_stopObservation(ObserverPrx obs, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_stopObservation(ObserverPrx obs, Ice.Callback __cb);

    public Ice.AsyncResult begin_stopObservation(ObserverPrx obs, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_stopObservation(ObserverPrx obs, Callback_Device_stopObservation __cb);

    public Ice.AsyncResult begin_stopObservation(ObserverPrx obs, java.util.Map<String, String> __ctx, Callback_Device_stopObservation __cb);

    public void end_stopObservation(Ice.AsyncResult __result)
        throws generated.exceptions.IncorrectUserNameException;

    public void actionPerformed();

    public void actionPerformed(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_actionPerformed();

    public Ice.AsyncResult begin_actionPerformed(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_actionPerformed(Ice.Callback __cb);

    public Ice.AsyncResult begin_actionPerformed(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_actionPerformed(Callback_Device_actionPerformed __cb);

    public Ice.AsyncResult begin_actionPerformed(java.util.Map<String, String> __ctx, Callback_Device_actionPerformed __cb);

    public void end_actionPerformed(Ice.AsyncResult __result);

    public String getStatus();

    public String getStatus(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getStatus();

    public Ice.AsyncResult begin_getStatus(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getStatus(Ice.Callback __cb);

    public Ice.AsyncResult begin_getStatus(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_getStatus(Callback_Device_getStatus __cb);

    public Ice.AsyncResult begin_getStatus(java.util.Map<String, String> __ctx, Callback_Device_getStatus __cb);

    public String end_getStatus(Ice.AsyncResult __result);

    public boolean isUsed();

    public boolean isUsed(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_isUsed();

    public Ice.AsyncResult begin_isUsed(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_isUsed(Ice.Callback __cb);

    public Ice.AsyncResult begin_isUsed(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_isUsed(Callback_Device_isUsed __cb);

    public Ice.AsyncResult begin_isUsed(java.util.Map<String, String> __ctx, Callback_Device_isUsed __cb);

    public boolean end_isUsed(Ice.AsyncResult __result);

    public boolean canBeEvicted();

    public boolean canBeEvicted(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_canBeEvicted();

    public Ice.AsyncResult begin_canBeEvicted(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_canBeEvicted(Ice.Callback __cb);

    public Ice.AsyncResult begin_canBeEvicted(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_canBeEvicted(Callback_Device_canBeEvicted __cb);

    public Ice.AsyncResult begin_canBeEvicted(java.util.Map<String, String> __ctx, Callback_Device_canBeEvicted __cb);

    public boolean end_canBeEvicted(Ice.AsyncResult __result);

    public String[] getInterfaceInfo();

    public String[] getInterfaceInfo(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getInterfaceInfo();

    public Ice.AsyncResult begin_getInterfaceInfo(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getInterfaceInfo(Ice.Callback __cb);

    public Ice.AsyncResult begin_getInterfaceInfo(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_getInterfaceInfo(Callback_Device_getInterfaceInfo __cb);

    public Ice.AsyncResult begin_getInterfaceInfo(java.util.Map<String, String> __ctx, Callback_Device_getInterfaceInfo __cb);

    public String[] end_getInterfaceInfo(Ice.AsyncResult __result);
}
