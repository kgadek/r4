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
// Generated from file `ObserverPrx.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package generated.devices;

public interface ObserverPrx extends Ice.ObjectPrx
{
    public void updateStatus(String status);

    public void updateStatus(String status, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_updateStatus(String status);

    public Ice.AsyncResult begin_updateStatus(String status, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_updateStatus(String status, Ice.Callback __cb);

    public Ice.AsyncResult begin_updateStatus(String status, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_updateStatus(String status, Callback_Observer_updateStatus __cb);

    public Ice.AsyncResult begin_updateStatus(String status, java.util.Map<String, String> __ctx, Callback_Observer_updateStatus __cb);

    public void end_updateStatus(Ice.AsyncResult __result);
}