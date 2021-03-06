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
import android.support.annotation.Nullable;

import org.onepf.opfmaps.delegate.model.IndoorLevelDelegate;

/**
 * Represents a level in a building.
 *
 * @author Roman Savin
 * @since 30.07.2015
 */
public final class OPFIndoorLevel implements IndoorLevelDelegate {

    @NonNull
    private final IndoorLevelDelegate delegate;

    public OPFIndoorLevel(@NonNull final IndoorLevelDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Sets this level as the visible level in its building. If a level is enclosed in several buildings,
     * then all those buildings will have this level set as active.
     */
    @Override
    public void activate() {
        delegate.activate();
    }

    /**
     * Localized display name for the level, e.g. "Ground floor". Returns an empty string if no name is defined.
     *
     * @return The name of the level.
     */
    @Override
    @Nullable
    public String getName() {
        return delegate.getName();
    }

    /**
     * Localized short display name for the level, e.g. "1". Returns an empty string if no shortName is defined.
     *
     * @return The short name of the level.
     */
    @Override
    @Nullable
    public String getShortName() {
        return delegate.getShortName();
    }

    @Override
    public boolean equals(final Object other) {
        return other != null
                && (other == this || other instanceof OPFIndoorLevel
                && delegate.equals(((OPFIndoorLevel) other).delegate));
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
