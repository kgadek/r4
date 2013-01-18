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
// Generated from file `_DeviceDel.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package generated.devices;

public interface _DeviceDel extends Ice._ObjectDel
{
    void getControl(String userName, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               generated.exceptions.DeviceAlreadyInUseException;

    void releaseControl(String userName, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               generated.exceptions.IncorrectUserNameException;

    void startObservation(ObserverPrx obs, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               generated.exceptions.UserAlreadyObserveException;

    void stopObservation(ObserverPrx obs, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               generated.exceptions.IncorrectUserNameException;

    void actionPerformed(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    String getStatus(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    boolean isUsed(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    boolean canBeEvicted(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    String[] getInterfaceInfo(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;
}
