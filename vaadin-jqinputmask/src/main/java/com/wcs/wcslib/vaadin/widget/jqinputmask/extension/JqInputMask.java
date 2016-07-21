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

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractJavaScriptExtension;
import com.vaadin.server.Extension;
import com.vaadin.ui.UI;
import elemental.json.JsonObject;
import java.util.Collection;

/**
 *
 * @author kumm
 */
public class JqInputMask {

    @JavaScript("jqinputmask-connector.js")
    static class JqInputMaskExtension extends AbstractJavaScriptExtension {

        JqInputMaskExtension(AbstractClientConnector target) {
            extend(target);
        }

        private JsonObject unwrapJSON(JSONObjectWrapper wrapper) {
            return wrapper != null ? wrapper.unwrap() : null;
        }

        void inputmask(String fn, JSONObjectWrapper options) {
            callFunction("inputmask", fn, unwrapJSON(options));
        }

        void define(Character key, Definition definition) {
            callFunction("define", key, unwrapJSON(definition));
        }

        void extend(JSONObjectWrapper options) {
            callFunction("extend", unwrapJSON(options));
        }
    }

    public static Options mask(AbstractClientConnector target, String pattern) {
        return new Options(target, "mask").mask(pattern);
    }

    public static DecimalOptions decimal(AbstractClientConnector target) {
        return new DecimalOptions(target, "decimal");
    }

    public static DecimalOptions integer(AbstractClientConnector target) {
        return new DecimalOptions(target, "integer");
    }

    public static RegexOptions regex(AbstractClientConnector target) {
        return new RegexOptions(target, "Regex");
    }

    public static DateOptions date(AbstractClientConnector target, String datePattern) {
        return new DateOptions(target, datePattern);
    }

    public static Options ip(AbstractClientConnector target) {
        return new Options(target, "ip");
    }

    public static UrlOptions url(AbstractClientConnector target) {
        return new UrlOptions(target, "url");
    }

    public static PhoneOptions phone(AbstractClientConnector target) {
        return new PhoneOptions(target, "phone");
    }

    public static void remove(AbstractClientConnector target) {
        JqInputMaskExtension instance = findExtensionInstance(target);
        if (instance == null) {
            return;
        }
        instance.inputmask("remove", null);
    }

    public static void invoke(AbstractClientConnector target, String fn, AbstractOptions options) {
        final JqInputMaskExtension instance = findOrCreateExtensionInstance(target);
        instance.inputmask(fn, options);
    }

    public static class Config {

        private final JqInputMaskExtension extensionOnUI;

        private Config(JqInputMaskExtension extensionOnUI) {
            this.extensionOnUI = extensionOnUI;
        }

        public Config define(Character key, Definition definition) {
            extensionOnUI.define(key, definition);
            return this;
        }

        public Config define(Character key, String pattern) {
            define(key, new Definition().validator(pattern).cardinality(1));
            return this;
        }

        public Config extend(AbstractOptions options) {
            extensionOnUI.extend(options);
            return this;
        }
    }

    public static Config getConfig() {
        UI currentUI = UI.getCurrent();
        JqInputMaskExtension instance = findOrCreateExtensionInstance(currentUI);
        return new Config(instance);
    }

    private static JqInputMaskExtension findExtensionInstance(final AbstractClientConnector target) {
        Collection<Extension> extensions = target.getExtensions();
        for (Extension extension : extensions) {
            if (extension.getClass().isAssignableFrom(JqInputMaskExtension.class)) {
                return (JqInputMaskExtension) extension;
            }
        }
        return null;
    }

    private static JqInputMaskExtension findOrCreateExtensionInstance(final AbstractClientConnector target) {
        JqInputMaskExtension instance = findExtensionInstance(target);
        if (instance == null) {
            instance = new JqInputMaskExtension(target);
        }
        return instance;
    }
}
