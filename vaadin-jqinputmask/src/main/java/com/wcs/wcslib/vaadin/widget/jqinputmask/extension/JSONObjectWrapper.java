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

import elemental.json.JsonException;
import elemental.json.JsonObject;
import elemental.json.JsonValue;
import elemental.json.impl.JreJsonFactory;
import elemental.json.impl.JreJsonObject;

/**
 *
 * @author kumm
 */
class JSONObjectWrapper<T extends JSONObjectWrapper> {

    private JsonObject json;

    public JSONObjectWrapper() {
        this(new JreJsonObject(new JreJsonFactory()));
    }

    public JSONObjectWrapper(JsonObject json) {
        this.json = json;
    }

    protected T put(String key, JsonValue value) {
        try {
            json.put(key, value);
        } catch (JsonException ex) {
            throw new RuntimeException(ex);
        }
        return (T) this;
    }

    protected T put(String key, char value) {
        try {
            json.put(key, String.valueOf(value));
        } catch (JsonException ex) {
            throw new RuntimeException(ex);
        }
        return (T) this;
    }

    protected T put(String key, int value) {
        try {
            json.put(key, value);
        } catch (JsonException ex) {
            throw new RuntimeException(ex);
        }
        return (T) this;
    }

    protected T put(String key, boolean value) {
        try {
            json.put(key, value);
        } catch (JsonException ex) {
            throw new RuntimeException(ex);
        }
        return (T) this;
    }

    protected T put(String key, String value) {
        try {
            json.put(key, value);
        } catch (JsonException ex) {
            throw new RuntimeException(ex);
        }
        return (T) this;
    }

    protected JsonObject unwrap() {
        return json;
    }

}
