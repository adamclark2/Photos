//
//  UserController.swift
//  Photos
//
//  Created by Adam Clark on 4/5/18.
//  Copyright © 2018 Adam Clark. All rights reserved.
//

import Foundation
import UIKit

public class UserSectionController: UIViewController, UINavigationControllerDelegate, UIImagePickerControllerDelegate {
    @IBOutlet weak var btnGallary: UIButton!
    @IBOutlet weak var imgView: UIImageView!
    private var imagePicker: UIImagePickerController!;
    
    @IBAction func unwind(segue: UIStoryboardSegue){
        // unwind
        
    }
    
    public func setImage(img: UIImage){
        imgView.image = img;
    }
    
    @IBAction func cameraAdd(_ sender: Any) {
        if(UIImagePickerController.isSourceTypeAvailable(UIImagePickerControllerSourceType.camera)){
            imagePicker =  UIImagePickerController()
            imagePicker.delegate = self;
            imagePicker.sourceType = UIImagePickerControllerSourceType.camera;
            
            present(imagePicker, animated: true, completion: nil)
        }else{
            // oops todo
        }
    }
    @IBAction func btnAddImageFromGallary(_ sender: Any) {
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
    
    @IBAction func btnAddImage(_ sender: Any) {
        if(UIImagePickerController.isSourceTypeAvailable(UIImagePickerControllerSourceType.camera)){
            imagePicker =  UIImagePickerController()
            imagePicker.delegate = self;
            imagePicker.sourceType = UIImagePickerControllerSourceType.camera;
            
            present(imagePicker, animated: true, completion: nil)
        }else{
            // oops todo
        }
    }
    
    public func imagePickerController(_ picker: UIImagePickerController,
                                      didFinishPickingMediaWithInfo info: [String : Any]){
        NSLog("Image Picked");
        let image = info[UIImagePickerControllerOriginalImage] as! UIImage;
        ImageProviderFactory.getImageProvider().add(title: "Hello World", image: image)
        
        imagePicker.dismiss(animated: true, completion: nil)
    }
    
    override public func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override public func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let settings = segue.destination as! UserSettingsController;
        settings.setUserSectionController(self);
    }
}
