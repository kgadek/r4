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
// Generated from file `DeviceAlreadyInUseException.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package generated.exceptions;

public class DeviceAlreadyInUseException extends Ice.UserException
{
    public DeviceAlreadyInUseException()
    {
    }

    public DeviceAlreadyInUseException(Throwable cause)
    {
        super(cause);
    }

    public DeviceAlreadyInUseException(String message)
    {
        this.message = message;
    }

    public DeviceAlreadyInUseException(String message, Throwable cause)
    {
        super(cause);
        this.message = message;
    }

    public String
    ice_name()
    {
        return "generated::exceptions::DeviceAlreadyInUseException";
    }

    public String message;

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeString("::generated::exceptions::DeviceAlreadyInUseException");
        __os.startWriteSlice();
        __os.writeString(message);
        __os.endWriteSlice();
    }

    public void
    __read(IceInternal.BasicStream __is, boolean __rid)
    {
        if(__rid)
        {
            __is.readString();
        }
        __is.startReadSlice();
        message = __is.readString();
        __is.endReadSlice();
    }

    public void
    __write(Ice.OutputStream __outS)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "exception generated::exceptions::DeviceAlreadyInUseException was not generated with stream support";
        throw ex;
    }

    public void
    __read(Ice.InputStream __inS, boolean __rid)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "exception generated::exceptions::DeviceAlreadyInUseException was not generated with stream support";
        throw ex;
    }
}
