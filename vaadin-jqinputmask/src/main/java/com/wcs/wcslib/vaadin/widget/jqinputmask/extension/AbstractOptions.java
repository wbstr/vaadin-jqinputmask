/*
 * Copyright 2013 Webstar Csoport.
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

import com.vaadin.server.AbstractClientConnector;
import elemental.json.JsonArray;
import elemental.json.JsonObject;
import elemental.json.impl.JreJsonArray;
import elemental.json.impl.JreJsonFactory;
import elemental.json.impl.JreJsonObject;
import elemental.json.impl.JreJsonString;

/**
 *
 * @author kumm
 */
public abstract class AbstractOptions<T extends AbstractOptions> extends JSONObjectWrapper<T> {

    private AbstractClientConnector target;
    private String fn;

    public AbstractOptions(AbstractClientConnector target, String fn) {
        this.target = target;
        this.fn = fn;
    }

    public AbstractOptions() {
    }

    public void apply() {
        JqInputMask.invoke(target, fn, this);
    }

    public T mask(String... mask) {
        for (String m : mask) {
            addMask(m);
        }
        return (T) this;
    }

    private void addMask(String mask) {
        JsonObject json = unwrap();
        JreJsonString strMask = json.get("mask");
        if (strMask != null) {
            JsonArray arrayMask = new JreJsonArray(new JreJsonFactory());
            arrayMask.set(0, strMask.getString());
            arrayMask.set(1, mask);
            put("mask", arrayMask);
        } else {
            JsonArray arrayMask = json.get("mask");
            if (arrayMask == null) {
                put("mask", mask);
            } else {
                arrayMask.set(0, mask);
            }
        }
    }

    public T placeholder(String placeholder) {
        return put("placeholder", placeholder);
    }

    public T clearIncomplete(boolean clearIncomplete) {
        return put("clearIncomplete", clearIncomplete);
    }

    public T repeat(int repeat) {
        return put("repeat", repeat);
    }

    public T greedy(boolean greedy) {
        return put("greedy", greedy);
    }

    public T autoUnmask(boolean autoUnmask) {
        return put("autoUnmask", autoUnmask);
    }

    public T numericInput(boolean numericInput) {
        return put("numericInput", numericInput);
    }

    public T radixPoint(char radixPoint) {
        return put("radixPoint", radixPoint);
    }

    public T rightAlignNumerics(boolean rightAlignNumerics) {
        return put("rightAlignNumerics", rightAlignNumerics);
    }

    public T clearMaskOnLostFocus(boolean clearMaskOnLostFocus) {
        return put("clearMaskOnLostFocus", clearMaskOnLostFocus);
    }

    public T showMaskOnFocus(boolean showMaskOnFocus) {
        return put("showMaskOnFocus", showMaskOnFocus);
    }

    public T showMaskOnHover(boolean showMaskOnHover) {
        return put("showMaskOnHover", showMaskOnHover);
    }

    public T showTooltip(boolean showTooltip) {
        return put("showTooltip", showTooltip);
    }

    public T skipRadixDance(boolean skipRadixDance) {
        return put("skipRadixDance", skipRadixDance);
    }

    public T skipOptionalPartCharacter(char skipOptionalPartCharacter) {
        return put("skipOptionalPartCharacter", skipOptionalPartCharacter);
    }

    public T define(char key, Definition definition) {
        JsonObject definitions = unwrap().getObject("definitions");
        if (definitions == null) {
            definitions = new JreJsonObject(new JreJsonFactory());
            put("definitions", definitions);
        }
        new JSONObjectWrapper(definitions).put("" + key, definition.unwrap());
        return (T) this;
    }

    public T define(char key, String pattern) {
        return define(key, new Definition().validator(pattern).cardinality(1));
    }

}
