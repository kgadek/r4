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
// Generated from file `RGBTelescopePrx.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package generated.telescopes;

public interface RGBTelescopePrx extends TelescopePrx
{
    public String getColor();

    public String getColor(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getColor();

    public Ice.AsyncResult begin_getColor(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getColor(Ice.Callback __cb);

    public Ice.AsyncResult begin_getColor(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_getColor(Callback_RGBTelescope_getColor __cb);

    public Ice.AsyncResult begin_getColor(java.util.Map<String, String> __ctx, Callback_RGBTelescope_getColor __cb);

    public String end_getColor(Ice.AsyncResult __result);
}
