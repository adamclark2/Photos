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
            for(_, element) in arr.enumerated(){
                let controller: ImageViewController = storyBoard.instantiateViewController(withIdentifier: "ImageViewController") as! ImageViewController;
                imgPro.getImageFromId(id: element, closure: {meta -> Void in
                    controller.setLabelText(text: (meta._imageName)! +  "  id:" + String(element));
                    imgPro.getImageFromMetadata(metadata: meta, closure: {(img: UIImage) -> Void in
                        controller.setImage(image: img);
                        self.stackView.addArrangedSubview(controller.view)
                    });
                });
            }});
        
        DispatchQueue.main.async {
            let ms: UInt32 = 1000;
            usleep(1250 * ms);
            loadCtrl.view!.isHidden = true;
        }
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
