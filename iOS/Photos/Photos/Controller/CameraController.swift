//
//  CameraController.swift
//  Photos
//
//  Created by Adam Clark on 4/3/18.
//  Copyright © 2018 Adam Clark. All rights reserved.
//

import Foundation
import UIKit

public class CameraController : UIViewController,UINavigationControllerDelegate, UIImagePickerControllerDelegate {
    @IBOutlet weak var cameraButton: UIButton!
    
    var imagePicker: UIImagePickerController!;
    
    @IBOutlet weak var errLabel: UILabel!
    @IBOutlet weak var imageView: UIImageView!
    @IBAction func takePhoto(_ sender: Any) {
        if(UIImagePickerController.isSourceTypeAvailable(UIImagePickerControllerSourceType.camera)){
            imagePicker =  UIImagePickerController()
            imagePicker.delegate = self;
            imagePicker.sourceType = UIImagePickerControllerSourceType.camera;
            
            present(imagePicker, animated: true, completion: nil)
        }else{
            errLabel.isHidden = false;
            imageView.isHidden = true;
        }
    }
    
    public func imagePickerController(_ picker: UIImagePickerController,
                                      didFinishPickingMediaWithInfo info: [String : Any]){
        NSLog("Image Picked");
        let image = info[UIImagePickerControllerOriginalImage] as! UIImage;
        imageView.image = image;
        imageView.isHidden = false;
        
        ImageProviderFactory.getImageProvider().add(title: "Hello Addition", image: image)
        
        imagePicker.dismiss(animated: true, completion: nil)
    }
    
    public func imagePickerControllerDidCancel(_ picker: UIImagePickerController){
        errLabel.text = "Canceled!";
        errLabel.isHidden = false;
        imagePicker.dismiss(animated: true, completion: nil)
    }
}
