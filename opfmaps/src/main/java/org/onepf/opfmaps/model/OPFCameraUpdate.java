/*
 * Copyright 2012-2015 One Platform Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.onepf.opfmaps.model;

import android.support.annotation.NonNull;

import org.onepf.opfmaps.delegate.model.CameraUpdateDelegate;

/**
 * Defines a camera move. To obtain a camera update use the factory class {@link OPFCameraUpdateFactory}.
 *
 * @author Roman Savin
 * @since 06.08.2015
 */
public final class OPFCameraUpdate {

    @NonNull
    private final CameraUpdateDelegate delegate;

    public OPFCameraUpdate(@NonNull final CameraUpdateDelegate delegate) {
        this.delegate = delegate;
    }

    @NonNull
    public CameraUpdateDelegate getDelegate() {
        return delegate;
    }

    @Override
    public boolean equals(final Object other) {
        return other != null
                && (other == this || other instanceof OPFCameraUpdate
                && delegate.equals(((OPFCameraUpdate) other).delegate));
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }

    @Override
    public String toString() {
        return delegate.toString();
    }
}
