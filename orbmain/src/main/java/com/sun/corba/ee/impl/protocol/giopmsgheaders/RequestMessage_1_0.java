/*
 * Copyright (c) 1997, 2020 Oracle and/or its affiliates.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0, or the Eclipse Distribution License
 * v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License v2.0
 * w/Classpath exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause OR GPL-2.0 WITH
 * Classpath-exception-2.0
 */

package com.sun.corba.ee.impl.protocol.giopmsgheaders;


import com.sun.corba.ee.spi.servicecontext.ServiceContextDefaults;
import com.sun.corba.ee.spi.servicecontext.ServiceContexts;

import com.sun.corba.ee.spi.ior.iiop.GIOPVersion;

import com.sun.corba.ee.spi.orb.ORB;

import com.sun.corba.ee.spi.orb.ObjectKeyCacheEntry;

/**
 * This implements the GIOP 1.0 Request header.
 *
 * @author Ram Jeyaraman 05/14/2000
 * @version 1.0
 */

public final class RequestMessage_1_0 extends Message_1_0
        implements RequestMessage {

    // Instance variables

    private ORB orb = null;
    private ServiceContexts service_contexts = null;
    private int request_id = (int) 0;
    private boolean response_expected = false;
    private byte[] object_key = null;
    private String operation = null;
    @SuppressWarnings({"deprecation"})
    private org.omg.CORBA.Principal requesting_principal = null;
    private ObjectKeyCacheEntry entry = null;

    // Constructor

    RequestMessage_1_0(ORB orb) {
        this.orb = orb;
        service_contexts = ServiceContextDefaults.makeServiceContexts( orb ) ;
    }

    @SuppressWarnings({"deprecation"})
    RequestMessage_1_0(ORB orb, ServiceContexts _service_contexts,
            int _request_id, boolean _response_expected, byte[] _object_key,
            String _operation, org.omg.CORBA.Principal _requesting_principal) {
        super(Message.GIOPBigMagic, false, Message.GIOPRequest, 0);
        this.orb = orb;
        service_contexts = _service_contexts;
        request_id = _request_id;
        response_expected = _response_expected;
        object_key = _object_key;
        operation = _operation;
        requesting_principal = _requesting_principal;
    }

    // Accessor methods (RequestMessage interface)

    public ServiceContexts getServiceContexts() {
        return this.service_contexts;
    }

    public void setServiceContexts(ServiceContexts sc) {
         this.service_contexts = sc;
    }

    public int getRequestId() {
        return this.request_id;
    }

    public boolean isResponseExpected() {
        return this.response_expected;
    }

    public byte[] getReserved() {
        // REVISIT Should we throw an exception or return null ?
        return null;
    }

    public ObjectKeyCacheEntry getObjectKeyCacheEntry() {
        if (this.entry == null) {
            // this will raise a MARSHAL exception upon errors.
            this.entry = orb.extractObjectKeyCacheEntry(object_key);
        }

        return this.entry;
    }

    public String getOperation() {
        return this.operation;
    }

    @SuppressWarnings({"deprecation"})
    public org.omg.CORBA.Principal getPrincipal() {
        return this.requesting_principal;
    }


    // Mutators
    
    public void setThreadPoolToUse(int poolToUse) {
        // No-op, must be GIOP Version 1.1 or greater
        // to support this SUN PROPRIETARY EXTENSION.
    }

    // IO methods

    public void read(org.omg.CORBA.portable.InputStream istream) {
        super.read(istream);
        this.service_contexts = ServiceContextDefaults.makeServiceContexts(
            (org.omg.CORBA_2_3.portable.InputStream) istream);
        this.request_id = istream.read_ulong();
        this.response_expected = istream.read_boolean();
        int _len0 = istream.read_long();
        this.object_key = new byte[_len0];
        istream.read_octet_array(this.object_key, 0, _len0);
        this.operation = istream.read_string();
        this.requesting_principal = istream.read_Principal();
    }

    public void write(org.omg.CORBA.portable.OutputStream ostream) {
        super.write(ostream);
        service_contexts.write(
            (org.omg.CORBA_2_3.portable.OutputStream) ostream,
            GIOPVersion.V1_0);
        ostream.write_ulong(this.request_id);
        ostream.write_boolean(this.response_expected);
        nullCheck(this.object_key);
        ostream.write_long(this.object_key.length);
        ostream.write_octet_array(this.object_key, 0, this.object_key.length);
        ostream.write_string(this.operation);
        if (this.requesting_principal != null) {
            ostream.write_Principal(this.requesting_principal);
        } else {
            ostream.write_long(0);
        }
    }

    public void callback(MessageHandler handler)
        throws java.io.IOException
    {
        handler.handleInput(this);
    }
} // class RequestMessage_1_0
