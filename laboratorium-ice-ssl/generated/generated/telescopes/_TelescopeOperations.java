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
// Generated from file `_TelescopeOperations.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package generated.telescopes;

public interface _TelescopeOperations extends generated.devices._DeviceOperations
{
    void turn(double angle, Ice.Current __current);

    void zoom(short zoomLevel, Ice.Current __current);
}