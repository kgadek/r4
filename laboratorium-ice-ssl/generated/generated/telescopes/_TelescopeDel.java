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
// Generated from file `_TelescopeDel.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package generated.telescopes;

public interface _TelescopeDel extends generated.devices._DeviceDel
{
    void turn(double angle, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void zoom(short zoomLevel, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;
}
