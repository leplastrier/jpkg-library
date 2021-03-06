/*
 * Jpkg - Java library and tools for operating system package creation.
 *
 * Copyright (c) 2007-2008 Three Rings Design, Inc.
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
package com.threerings.jpkg.ant.dpkg.dependencies;

import com.threerings.antidote.property.StringProperty;
import com.threerings.jpkg.ant.dpkg.dependencies.conditions.Condition;
import com.threerings.jpkg.debian.PackageInfo;
import com.threerings.jpkg.debian.dependency.PackageConflict;

/**
 * The &lt;dependencies&gt; &lt;conflict&gt; field. Indicates a package conflict.
 */
public class Conflict extends BaseDependency<PackageConflict>
{
    // from Field
    public String getFieldName ()
    {
        return "conflict";
    }

    // from PackageInfoDependency
    public void addToPackageInfo (PackageInfo info)
    {
        info.addConflict(getDependency());
    }

    @Override // from BaseDependency
    protected PackageConflict createDependency (StringProperty packageName)
    {
        return new PackageConflict(packageName.getValue());
    }

    @Override // from BaseDependency
    protected PackageConflict createDependency (StringProperty packageName, Condition condition)
    {
        return new PackageConflict(packageName.getValue(), condition.getVersion(), condition.getRelationship());
    }
}
