//
//  ImageTabController.swift
//  Photos
//
//  Created by Adam Clark on 3/16/18.
//  Copyright © 2018 Adam Clark. All rights reserved.
//

import UIKit

class ImageTabController: UIViewController {
    @IBOutlet weak var stackView: UIStackView!
    
    /// Handle loading the view
    @IBOutlet weak var stackHeight: NSLayoutConstraint!
    override func viewDidLoad() {
        super.viewDidLoad()
        addImages();
    }
    
    func addImages(){
        let imgPro: ImageProvider = ImageProviderFactory.getImageProvider();
        let storyBoard: UIStoryboard = UIStoryboard.init(name: "ImageView", bundle: nil)
        
        let loadCtrl = storyBoard.instantiateViewController(withIdentifier: "Loading")
        stackView.addArrangedSubview(loadCtrl.view)
        
        ImageProviderFactory.getImageProvider().getImageList(closure: {(arr) -> Void in
            for(_, meta) in arr.enumerated(){
                let controller: ImageViewController = storyBoard.instantiateViewController(withIdentifier: "ImageViewController") as! ImageViewController;
                NSLog(meta._imageName!)
                controller.setLabelText(text: (meta._imageName)! +  "  \nid:" + String(describing: meta._imageId));
                imgPro.getImageFromMetadata(metadata: meta, closure: {(img: UIImage) -> Void in
                    DispatchQueue.main.async {
                        controller.setImage(image: img);
                        self.stackView.addArrangedSubview(controller.view)
                        
                        // See URLImageProvider.getImageFromMetadata()
                        // This height there is 200
                        self.stackHeight.constant += 300;
                        self.view!.setNeedsLayout()
                        self.view.setNeedsUpdateConstraints()
                    }
                });
            }
            
            // After we got the array
            // hide the load
            DispatchQueue.main.async {
                let ms: UInt32 = 1000;
                usleep(1250 * ms);
                loadCtrl.view!.isHidden = true;
            }
        });
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
