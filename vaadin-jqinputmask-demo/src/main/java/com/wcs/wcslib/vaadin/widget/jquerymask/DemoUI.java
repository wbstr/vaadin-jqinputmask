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
package com.wcs.wcslib.vaadin.widget.jquerymask;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.wcs.wcslib.vaadin.widget.jqinputmask.extension.Definition;
import com.wcs.wcslib.vaadin.widget.jqinputmask.extension.JqInputMask;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author kumm
 */
@Title("JqInputMask Add-on Demo")
@SuppressWarnings("serial")
@JavaScript({"jquery-1.11.1.min.js", "jquery.inputmask.bundle.2.4.18.min.js"})
public class DemoUI extends UI {

    @WebServlet(value = "/*")
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    private VerticalLayout root = new VerticalLayout();

    @Override
    protected void init(VaadinRequest request) {
        setContent(root);
        root.setMargin(true);

        final TextField textField = new TextField("test");
        JqInputMask.mask(textField, "(999) 999-9999").apply();
        root.addComponent(new HorizontalLayout(textField, new Button("unmask test", new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                JqInputMask.remove(textField);
            }
        })));

        DateField dateField = new DateField("date");
        dateField.setDateFormat("yyyy.MM.dd");
        JqInputMask.date(dateField, "yyyy.mm.dd").placeholder("éééé.hh.nn").apply();
        root.addComponent(dateField);

        TextField ip = new TextField("IP");
        JqInputMask.ip(ip).apply();
        root.addComponent(ip);

        TextField decimal = new TextField("decimal");
        JqInputMask.decimal(decimal)
                .groupSeparator(',')
                .groupSize(3)
                .autoGroup(true)                
                .radixPoint('.')
                .apply();
        root.addComponent(decimal);

        TextField hexa = new TextField("hexa");
        JqInputMask.mask(hexa, "XXXX")
                .define('X', new Definition()
                        .validator("[0-9A-Fa-f]")
                        .cardinality(1)
                        .casingUpper()
                )
                .apply();
        root.addComponent(hexa);

        TextField phone = new TextField("phone");
        JqInputMask.mask(phone, "+99-999[999999999999]")
                .mask("+36-99-999-999[9]")
                .greedy(false)
                .apply();
        root.addComponent(phone);

    }
}
