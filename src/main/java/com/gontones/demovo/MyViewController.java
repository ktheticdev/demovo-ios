/*
 * Copyright (C) 2013-2015 RoboVM AB
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 * Portions of this code is based on Apple Inc's HelloWorld sample (v1.8)
 * which is copyright (C) 2008-2010 Apple Inc.
 */
package com.gontones.demovo;

import org.robovm.apple.foundation.NSSet;
import org.robovm.apple.uikit.*;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBOutlet;

@CustomClass("MyViewController")
public class MyViewController extends UIViewController {
    @IBOutlet
    private UITextField textField;
    @IBOutlet
    private UILabel label;
    @IBOutlet
    private UITextView outputField;
    private String string;

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // When the view first loads, display the placeholder text that's in the
        // text field in the label.
        label.setText(textField.getPlaceholder());
    }



    @Override
    public void touchesBegan(NSSet<UITouch> touches, UIEvent event) {
        // Dismiss the keyboard when the view outside the text field is touched.
        textField.resignFirstResponder();
        // Revert the text field to the previous value.
        textField.setText(string);
        super.touchesBegan(touches, event);
    }
}
