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
// Generated from file `_DeviceOperationsNC.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package generated.devices;

public interface _DeviceOperationsNC
{
    void getControl(String userName)
        throws generated.exceptions.DeviceAlreadyInUseException;

    void releaseControl(String userName)
        throws generated.exceptions.IncorrectUserNameException;

    void startObservation(ObserverPrx obs)
        throws generated.exceptions.UserAlreadyObserveException;

    void stopObservation(ObserverPrx obs)
        throws generated.exceptions.IncorrectUserNameException;

    void actionPerformed();

    String getStatus();

    boolean isUsed();

    boolean canBeEvicted();

    String[] getInterfaceInfo();
}
