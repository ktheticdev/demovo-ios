package com.gontones.demovo;

import org.robovm.apple.foundation.NSUserDefaults;
import org.robovm.apple.uikit.*;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBAction;
import org.robovm.objc.annotation.IBOutlet;
import java.security.NoSuchAlgorithmException;

@CustomClass("MainViewController")
public class MainViewController extends UIViewController {
    UIPasteboard pasteboard = UIPasteboard.getGeneralPasteboard();
    static NSUserDefaults MainViewClassHelloWorldstandardUserDefaults = NSUserDefaults.getStandardUserDefaults();
    @IBOutlet
    private UITextView outputField;
    @IBOutlet
    private UITextField inputField;

    @IBAction
    private void encodeClicked() throws NoSuchAlgorithmException {
        String input = inputField.getText();
        outputField.setText(CipherUtils.base64encode(CipherUtils.aescipher(MainViewClassHelloWorldstandardUserDefaults.getString("key2"), CipherUtils.caesarEncode(input, MainViewClassHelloWorldstandardUserDefaults.getString("key1")), MainViewClassHelloWorldstandardUserDefaults.getString("salt"))));
    }

    @IBAction
    private void decodeClicked() {
        String input = inputField.getText();
        try{
            outputField.setText(CipherUtils.caesarDecode(CipherUtils.aesdecipher(MainViewClassHelloWorldstandardUserDefaults.getString("key2"), CipherUtils.base64decode(input), MainViewClassHelloWorldstandardUserDefaults.getString("salt")), MainViewClassHelloWorldstandardUserDefaults.getString("key1")));
        } catch (Exception e) {
            outputField.setText("Input is not a ciphertext, or keys you've entered are wrong.");
        }
    }

    @IBAction
    private void copyClicked() {
        pasteboard.setString(outputField.getText());
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();
        // When the view first loads, display the placeholder text that's in the
        // text field in the label.
        //

        if (MainViewClassHelloWorldstandardUserDefaults.get("key1") == null && MainViewClassHelloWorldstandardUserDefaults.get("key2") == null) {
                MainViewClassHelloWorldstandardUserDefaults.put("key1", "228");
                MainViewClassHelloWorldstandardUserDefaults.put("key2", "1488");
                MainViewClassHelloWorldstandardUserDefaults.put("salt", "defaultsalt");
        }
    }
}
