/*
 * Jpkg - Java library and tools for operating system package creation.
 *
 * Copyright (c) 2007 Three Rings Design, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the copyright owner nor the names of contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.threerings.jpkg.debian;

import org.junit.Test;

import com.threerings.jpkg.debian.dependency.DependencyRelationships;
import com.threerings.jpkg.debian.dependency.PackageDependency;

import static org.junit.Assert.assertEquals;

public class DependencyTest
{
    @Test
    public void testSimpleDependency ()
        throws Exception
    {
        final PackageDependency dependency = new PackageDependency(TEST_PKG_NAME);
        assertEquals(TEST_PKG_NAME, dependency.asString());
    }

    @Test
    public void testRelationshipDependency ()
        throws Exception
    {
        final PackageDependency dependency = new PackageDependency(TEST_PKG_NAME, TEST_PKG_VERSION, DependencyRelationships.EARLIER_OR_EQUAL);
        assertEquals(TEST_PKG_NAME + " (" + DependencyRelationships.EARLIER_OR_EQUAL.getOperator() +
            " " + TEST_PKG_VERSION + ")",
            dependency.asString());
    }

    /** A PackageName and PackageVersion for testing. */
    private static final String TEST_PKG_NAME = "otherpkg";
    private static final String TEST_PKG_VERSION = "1.1";
}
