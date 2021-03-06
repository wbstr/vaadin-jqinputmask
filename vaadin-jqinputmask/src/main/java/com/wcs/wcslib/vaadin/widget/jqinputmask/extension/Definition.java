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

import elemental.json.JsonArray;
import elemental.json.impl.JreJsonArray;
import elemental.json.impl.JreJsonFactory;
import java.util.regex.Pattern;

/**
 *
 * @author kumm
 */
public class Definition extends JSONObjectWrapper<Definition> {

    public Definition validator(Pattern pattern) {
        return validator(pattern.toString());
    }

    public Definition validator(String pattern) {
        return put("validator", Pattern.compile(pattern).toString());
    }

    public Definition cardinality(Integer cardinality) {
        return put("cardinality", cardinality);
    }

    public Definition definitionSymbol(Character definitionSymbol) {
        return put("definitionSymbol", definitionSymbol);
    }

    public Definition casingUpper() {
        return put("casing", "upper");
    }

    public Definition casingLower() {
        return put("casing", "lower");
    }

    public Definition prevalidator(Definition definition) {
        JsonArray prevalidator = unwrap().get("prevalidator");
        if (prevalidator == null) {
            prevalidator = new JreJsonArray(new JreJsonFactory());
            put("prevalidator", prevalidator);
        }
        prevalidator.set(0, definition.unwrap());
        return this;
    }

}
