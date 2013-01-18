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
// Generated from file `_CertSignerOperations.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package SR;

public interface _CertSignerOperations
{
    byte[] signCSR(String name, String surname, byte[] csrFile, Ice.Current __current)
        throws DataTooLong,
               IncorrectCSRFile;
}
