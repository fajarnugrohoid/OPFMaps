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

package org.onepf.maps.yandexweb.listener;

import android.support.annotation.NonNull;
import org.onepf.opfmaps.model.OPFMapType;

/**
 * @author Roman Savin
 * @since 08.09.2015
 */
public interface OnMapTypeChangeListener {

    void onTypeChange(@NonNull final OPFMapType type);
}
