/* 
 * Copyright 2013 kumm.
 *
 * Licensed under the Apache License, Version 2_0 (the "License");
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

window.com_wcs_wcslib_vaadin_widget_jqinputmask_extension_JqInputMask_JqInputMaskExtension =
function() {

    this.inputmask = function(fn, options) {
        getJqInput().inputmask(fn, options);
    };
    this.define = function(key, definition) {
        $.inputmask.defaults.definitions[key] = definition;
    };
    this.extend = function(options) {
        $.extend($.inputmask.defaults, options);
    };

    var $input = null;
    var me = this;
    var getJqInput = function() {
        if ($input === null) {
            var domElement = me.getElement(me.getParentId());
            //find the first text input in the descendant hierarchy including self
            $input = $(domElement).find("*").addBack().filter("input[type=text]").first()
                //fixes issue #1. Don't ask why!
                .on("change", function(){});
        }
        return $input;
    };

};
