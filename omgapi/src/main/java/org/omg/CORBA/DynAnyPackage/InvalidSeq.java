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

package org.omg.CORBA.DynAnyPackage;

/**
 * The InvalidSeq exception is thrown by all operations on dynamic
 * anys that take a sequence (Java array) as an argument, when that
 * sequence is invalid.
 */
// @SuppressWarnings({"serial"})
public final class InvalidSeq
    extends org.omg.CORBA.UserException {

    /**
     * Constructs an <code>InvalidSeq</code> object.
     */
    public InvalidSeq() {
        super();
    }

    /**
     * Constructs an <code>InvalidSeq</code> object.
     * @param reason  a <code>String</code> giving more information
     * regarding the exception.
     */
    public InvalidSeq(String reason) {
        super(reason);
    }
}
