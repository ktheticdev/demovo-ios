package com.gontones.demovo;

import org.robovm.apple.uikit.UITextField;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBAction;
import org.robovm.objc.annotation.IBOutlet;

@CustomClass("SettingsViewController")
public class SettingsViewController extends UIViewController {
    @IBOutlet
    private UITextField saltfield;

    @IBOutlet
    private UITextField key1field;

    @IBOutlet UITextField key2field;

    @IBAction
    void saveSettingsOnClick() {
        MainViewController.MainViewClassHelloWorldstandardUserDefaults.put("key1", key1field.getText());
        MainViewController.MainViewClassHelloWorldstandardUserDefaults.put("key2", key2field.getText());
        MainViewController.MainViewClassHelloWorldstandardUserDefaults.put("salt", saltfield.getText());

    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        key1field.setText(MainViewController.MainViewClassHelloWorldstandardUserDefaults.getString("key1"));
        key2field.setText(MainViewController.MainViewClassHelloWorldstandardUserDefaults.getString("key2"));
        saltfield.setText(MainViewController.MainViewClassHelloWorldstandardUserDefaults.getString("salt"));
    }
}
