/*
 * Copyright 2013 kumm.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wcs.wcslib.vaadin.widget.jqinputmask.extension;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author kumm
 */
class JSONObjectWrapper<T extends JSONObjectWrapper> {
    private JSONObject json;

    public JSONObjectWrapper() {
        this(new JSONObject());
    }

    public JSONObjectWrapper(JSONObject json) {
        this.json = json;
    }

    protected T put(String key, Object value) {
        try {
            json.put(key, value);
        } catch (JSONException ex) {
            throw new RuntimeException(ex);
        }
        return (T)this;
    }

    protected JSONObject unwrap() {
        return json;
    }
    
}
