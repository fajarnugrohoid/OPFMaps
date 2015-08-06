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

package org.onepf.maps.amazon.delegate.model;

import android.os.Parcel;
import android.support.annotation.NonNull;
import com.amazon.geo.mapsv2.model.LatLng;
import com.amazon.geo.mapsv2.model.LatLngBounds;
import com.amazon.geo.mapsv2.model.VisibleRegion;
import org.onepf.opfmaps.delegate.model.VisibleRegionDelegate;
import org.onepf.opfmaps.model.OPFLatLng;
import org.onepf.opfmaps.model.OPFLatLngBounds;

/**
 * @author Roman Savin
 * @since 06.08.2015
 */
public final class AmazonVisibleRegionDelegate implements VisibleRegionDelegate {

    public static final Creator<AmazonVisibleRegionDelegate> CREATOR = new Creator<AmazonVisibleRegionDelegate>() {
        @Override
        public AmazonVisibleRegionDelegate createFromParcel(final Parcel source) {
            return new AmazonVisibleRegionDelegate(source);
        }

        @Override
        public AmazonVisibleRegionDelegate[] newArray(final int size) {
            return new AmazonVisibleRegionDelegate[size];
        }
    };

    @NonNull
    private final VisibleRegion visibleRegion;

    public AmazonVisibleRegionDelegate(@NonNull final OPFLatLng nearLeft,
                                       @NonNull final OPFLatLng nearRight,
                                       @NonNull final OPFLatLng farLeft,
                                       @NonNull final OPFLatLng farRight,
                                       @NonNull final OPFLatLngBounds latLngBounds) {
        this.visibleRegion = new VisibleRegion(
                new LatLng(nearLeft.getLat(), nearLeft.getLng()),
                new LatLng(nearRight.getLat(), nearRight.getLng()),
                new LatLng(farLeft.getLat(), farLeft.getLng()),
                new LatLng(farRight.getLat(), farRight.getLng()),
                new LatLngBounds(
                        new LatLng(latLngBounds.getSouthwest().getLat(), latLngBounds.getNortheast().getLng()),
                        new LatLng(latLngBounds.getNortheast().getLat(), latLngBounds.getNortheast().getLng())
                )
        );
    }

    public AmazonVisibleRegionDelegate(@NonNull final VisibleRegion visibleRegion) {
        this.visibleRegion = visibleRegion;
    }

    private AmazonVisibleRegionDelegate(@NonNull final Parcel parcel) {
        this.visibleRegion = parcel.readParcelable(VisibleRegion.class.getClassLoader());
    }

    @NonNull
    @Override
    public OPFLatLng getFarLeft() {
        return new OPFLatLng(new AmazonLatLngDelegate(visibleRegion.farLeft));
    }

    @NonNull
    @Override
    public OPFLatLng getFarRight() {
        return new OPFLatLng(new AmazonLatLngDelegate(visibleRegion.farRight));
    }

    @NonNull
    @Override
    public OPFLatLngBounds getLatLngBounds() {
        return new OPFLatLngBounds(new AmazonLatLngBoundsDelegate(
                new LatLngBounds(visibleRegion.latLngBounds.southwest, visibleRegion.latLngBounds.northeast)
        ));
    }

    @NonNull
    @Override
    public OPFLatLng getNearLeft() {
        return new OPFLatLng(new AmazonLatLngDelegate(visibleRegion.nearLeft));
    }

    @NonNull
    @Override
    public OPFLatLng getNearRight() {
        return new OPFLatLng(new AmazonLatLngDelegate(visibleRegion.nearRight));
    }

    @Override
    public int describeContents() {
        return visibleRegion.describeContents();
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeParcelable(visibleRegion, flags);
    }

    //CHECKSTYLE:OFF
    @SuppressWarnings("PMD.IfStmtsMustUseBraces")
    @Override
    public boolean equals(final Object other) {
        if (other == null) return false;
        if (other == this) return true;
        //noinspection SimplifiableIfStatement
        if (!(other instanceof AmazonVisibleRegionDelegate)) return false;

        return visibleRegion.equals(((AmazonVisibleRegionDelegate) other).visibleRegion);
    }
    //CHECKSTYLE:ON

    @Override
    public int hashCode() {
        return visibleRegion.hashCode();
    }

    @Override
    public String toString() {
        return visibleRegion.toString();
    }
}
