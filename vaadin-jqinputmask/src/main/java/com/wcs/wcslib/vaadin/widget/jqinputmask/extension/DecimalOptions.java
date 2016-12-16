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

/**
 *
 * @author kumm
 */
public class DecimalOptions extends AbstractOptions<DecimalOptions> {

    public DecimalOptions(AbstractClientConnector target, String fn) {
        super(target, fn);
    }

    public DecimalOptions() {
    }

    public DecimalOptions groupSeparator(char groupSeparator) {
        return put("groupSeparator", groupSeparator);
    }

    public DecimalOptions groupSize(int groupSize) {
        return put("groupSize", groupSize);
    }

    public DecimalOptions autoGroup(boolean autoGroup) {
        return put("autoGroup", autoGroup);
    }

    public DecimalOptions allowMinus(boolean allowMinus) {
        return put("allowMinus", allowMinus);
    }

    public DecimalOptions allowPlus(boolean allowPlus) {
        return put("allowPlus", allowPlus);
    }

    public DecimalOptions fractionalDigits(int fractionalDigits) {
        return put("digits", fractionalDigits);
    }
    
    public DecimalOptions prefix(String prefix) {
        return put("prefix", prefix);
    }

    public DecimalOptions suffix(String suffix) {
        return put("suffix", suffix);
    }
}
