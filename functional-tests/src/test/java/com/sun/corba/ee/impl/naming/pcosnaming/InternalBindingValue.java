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

package com.sun.corba.ee.impl.naming.pcosnaming;

import org.omg.CosNaming.BindingType;
import java.io.Serializable;

/**
 * Class InternalBindingKey acts as a container for two objects, namely
 * a org.omg.CosNaming::Binding and an CORBA object reference, which are the two
 * components associated with the binding.
 */
public class InternalBindingValue
                implements Serializable
{
    private static final long serialVersionUID = -2545360261776178726L;

    public BindingType theBindingType;
    // The value stores both Stringified Object Reference and
    // Non-Stringified Object Reference. This is done to avoid
    // calling orb.string_to_object( ) everytime. Instead it
    // will be set once and then the result will be used everytime.
    public String strObjectRef;
    transient private org.omg.CORBA.Object theObjectRef;
  
    // Default constructor
    public InternalBindingValue() {
    }

    // Normal constructor
    public InternalBindingValue(BindingType b, String o) {
        // Objectreference or Context
        theBindingType = b;
        strObjectRef = o;
    }

    public org.omg.CORBA.Object getObjectRef( )
    {
        return theObjectRef;
    }

    public void setObjectRef( org.omg.CORBA.Object ObjectRef )
    {
        theObjectRef = ObjectRef;
    }
    
}
