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

package org.onepf.opfmaps.yandexweb.jsi;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import org.onepf.opfmaps.yandexweb.listener.OnMapReadyCallback;

/**
 * @author Roman Savin
 * @since 04.09.2015
 */
public final class JSIOnMapReadyCallback {

    public static final String JS_INTERFACE_NAME = "OnMapReadyCallback";

    @NonNull
    private final OnMapReadyCallback callback;

    @NonNull
    private final Handler handler = new Handler(Looper.getMainLooper());

    public JSIOnMapReadyCallback(@NonNull final OnMapReadyCallback callback) {
        this.callback = callback;
    }

    @JavascriptInterface
    public void onMapReady(final double offsetX, final double offsetY) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                callback.onMapReady(offsetX, offsetY);
            }
        });
    }
}
