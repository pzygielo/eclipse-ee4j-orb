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

package org.omg.CORBA;

/**
* The interface for <tt>IDLType</tt>.  For more information on 
* Operations interfaces, see <a href="doc-files/generatedfiles.html#operations">
* "Generated Files: Operations files"</a>.
*/
 
/*
 tempout/org/omg/CORBA/IDLTypeOperations.java
 Generated by the IBM IDL-to-Java compiler, version 1.0
 from ../../Lib/ir.idl
 Thursday, February 25, 1999 2:11:23 o'clock PM PST
*/

/**
 * This interface must be implemented by all IDLType objects.
 * The IDLType is inherited by all IR objects that 
 * represent IDL types, including interfaces, typedefs, and 
 * anonymous types.
 * @see IDLType
 * @see IRObject
 * @see IRObjectOperations
 */

public interface IDLTypeOperations  extends org.omg.CORBA.IRObjectOperations
{
    /**
     * The type attribute describes the type defined by an object
     * derived from <code>IDLType</code>.
     * @return the <code>TypeCode</code> defined by this object.
     */
    org.omg.CORBA.TypeCode type ();
} // interface IDLTypeOperations
