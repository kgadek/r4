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
// Generated from file `_CertSignerDelM.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package SR;

public final class _CertSignerDelM extends Ice._ObjectDelM implements _CertSignerDel
{
    public byte[]
    signCSR(String name, String surname, byte[] csrFile, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               DataTooLong,
               IncorrectCSRFile
    {
        IceInternal.Outgoing __og = __handler.getOutgoing("signCSR", Ice.OperationMode.Normal, __ctx);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(name);
                __os.writeString(surname);
                Ice.ByteSeqHelper.write(__os, csrFile);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                if(!__ok)
                {
                    try
                    {
                        __og.throwUserException();
                    }
                    catch(DataTooLong __ex)
                    {
                        throw __ex;
                    }
                    catch(IncorrectCSRFile __ex)
                    {
                        throw __ex;
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
                    }
                }
                IceInternal.BasicStream __is = __og.is();
                __is.startReadEncaps();
                byte[] __ret;
                __ret = Ice.ByteSeqHelper.read(__is);
                __is.endReadEncaps();
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __handler.reclaimOutgoing(__og);
        }
    }
}
