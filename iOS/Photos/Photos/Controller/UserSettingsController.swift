//
//  UserSettingsController.swift
//  Photos
//
//  Created by Adam Clark on 4/9/18.
//  Copyright © 2018 Adam Clark. All rights reserved.
//

import Foundation
import UIKit

public class UserSettingsController : UIViewController,UINavigationControllerDelegate, UIImagePickerControllerDelegate{
    @IBOutlet weak var btnGallary: UIButton!
    private var imagePicker: UIImagePickerController = UIImagePickerController();
    private var userCtrl: UserSectionController? = nil;
    
    
    public func setUserSectionController(_ ctrl: UserSectionController){
        self.userCtrl = ctrl;
    }
    
    @IBAction func btnAddFromCamera(_ sender: Any) {
        if(UIImagePickerController.isSourceTypeAvailable(UIImagePickerControllerSourceType.camera)){
            imagePicker =  UIImagePickerController()
            imagePicker.delegate = self;
            imagePicker.sourceType = UIImagePickerControllerSourceType.camera;
            
            present(imagePicker, animated: true, completion: nil)
        }else{
            // oops todo
        }
    }
    
    @IBAction func btnAddFromGallary(_ sender: Any) {
        NSLog("Gal");
        if(UIImagePickerController.isSourceTypeAvailable(UIImagePickerControllerSourceType.photoLibrary)){
            imagePicker =  UIImagePickerController()
            imagePicker.delegate = self;
            imagePicker.sourceType = UIImagePickerControllerSourceType.photoLibrary;
            imagePicker.modalPresentationStyle = UIModalPresentationStyle.popover;
            
            let pop = imagePicker.popoverPresentationController;
            pop?.sourceView = btnGallary;
            pop?.permittedArrowDirections = .any;
            
            present(imagePicker, animated: true, completion: nil)
        }else{
            // oops todo
        }
    }
    
    public func imagePickerController(_ picker: UIImagePickerController,
                                      didFinishPickingMediaWithInfo info: [String : Any]){
        NSLog("Image Picked");
        let image = info[UIImagePickerControllerOriginalImage] as! UIImage;
        userCtrl?.setImage(img: image);
        
        imagePicker.dismiss(animated: true, completion: nil)
    }
}
