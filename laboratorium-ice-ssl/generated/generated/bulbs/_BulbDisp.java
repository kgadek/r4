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
// Generated from file `_BulbDisp.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package generated.bulbs;

public abstract class _BulbDisp extends Ice.ObjectImpl implements Bulb
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
        throws java.lang.CloneNotSupportedException
    {
        throw new java.lang.CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::generated::bulbs::Bulb",
        "::generated::devices::Device"
    };

    public boolean
    ice_isA(String s)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean
    ice_isA(String s, Ice.Current __current)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[]
    ice_ids()
    {
        return __ids;
    }

    public String[]
    ice_ids(Ice.Current __current)
    {
        return __ids;
    }

    public String
    ice_id()
    {
        return __ids[1];
    }

    public String
    ice_id(Ice.Current __current)
    {
        return __ids[1];
    }

    public static String
    ice_staticId()
    {
        return __ids[1];
    }

    public final void
    turnOff()
    {
        turnOff(null);
    }

    public final void
    turnOn()
    {
        turnOn(null);
    }

    public final void
    actionPerformed()
    {
        actionPerformed(null);
    }

    public final boolean
    canBeEvicted()
    {
        return canBeEvicted(null);
    }

    public final void
    getControl(String userName)
        throws generated.exceptions.DeviceAlreadyInUseException
    {
        getControl(userName, null);
    }

    public final String[]
    getInterfaceInfo()
    {
        return getInterfaceInfo(null);
    }

    public final String
    getStatus()
    {
        return getStatus(null);
    }

    public final boolean
    isUsed()
    {
        return isUsed(null);
    }

    public final void
    releaseControl(String userName)
        throws generated.exceptions.IncorrectUserNameException
    {
        releaseControl(userName, null);
    }

    public final void
    startObservation(generated.devices.ObserverPrx obs)
        throws generated.exceptions.UserAlreadyObserveException
    {
        startObservation(obs, null);
    }

    public final void
    stopObservation(generated.devices.ObserverPrx obs)
        throws generated.exceptions.IncorrectUserNameException
    {
        stopObservation(obs, null);
    }

    public static Ice.DispatchStatus
    ___turnOff(Bulb __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        __inS.is().skipEmptyEncaps();
        __obj.turnOff(__current);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___turnOn(Bulb __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        __inS.is().skipEmptyEncaps();
        __obj.turnOn(__current);
        return Ice.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
        "actionPerformed",
        "canBeEvicted",
        "getControl",
        "getInterfaceInfo",
        "getStatus",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "isUsed",
        "releaseControl",
        "startObservation",
        "stopObservation",
        "turnOff",
        "turnOn"
    };

    public Ice.DispatchStatus
    __dispatch(IceInternal.Incoming in, Ice.Current __current)
    {
        int pos = java.util.Arrays.binarySearch(__all, __current.operation);
        if(pos < 0)
        {
            throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return generated.devices._DeviceDisp.___actionPerformed(this, in, __current);
            }
            case 1:
            {
                return generated.devices._DeviceDisp.___canBeEvicted(this, in, __current);
            }
            case 2:
            {
                return generated.devices._DeviceDisp.___getControl(this, in, __current);
            }
            case 3:
            {
                return generated.devices._DeviceDisp.___getInterfaceInfo(this, in, __current);
            }
            case 4:
            {
                return generated.devices._DeviceDisp.___getStatus(this, in, __current);
            }
            case 5:
            {
                return ___ice_id(this, in, __current);
            }
            case 6:
            {
                return ___ice_ids(this, in, __current);
            }
            case 7:
            {
                return ___ice_isA(this, in, __current);
            }
            case 8:
            {
                return ___ice_ping(this, in, __current);
            }
            case 9:
            {
                return generated.devices._DeviceDisp.___isUsed(this, in, __current);
            }
            case 10:
            {
                return generated.devices._DeviceDisp.___releaseControl(this, in, __current);
            }
            case 11:
            {
                return generated.devices._DeviceDisp.___startObservation(this, in, __current);
            }
            case 12:
            {
                return generated.devices._DeviceDisp.___stopObservation(this, in, __current);
            }
            case 13:
            {
                return ___turnOff(this, in, __current);
            }
            case 14:
            {
                return ___turnOn(this, in, __current);
            }
        }

        assert(false);
        throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeTypeId(ice_staticId());
        __os.startWriteSlice();
        __os.endWriteSlice();
        super.__write(__os);
    }

    public void
    __read(IceInternal.BasicStream __is, boolean __rid)
    {
        if(__rid)
        {
            __is.readTypeId();
        }
        __is.startReadSlice();
        __is.endReadSlice();
        super.__read(__is, true);
    }

    public void
    __write(Ice.OutputStream __outS)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type generated::bulbs::Bulb was not generated with stream support";
        throw ex;
    }

    public void
    __read(Ice.InputStream __inS, boolean __rid)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type generated::bulbs::Bulb was not generated with stream support";
        throw ex;
    }
}
