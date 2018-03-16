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
        
        let imgPro: ImageProvider = ImageProviderFactory.getImageProvider();
        let arr: [Int] = imgPro.getImageList();
        
        let storyBoard: UIStoryboard = UIStoryboard.init(name: "ImageView", bundle: nil)
        for(index, element) in arr.enumerated(){
            let controller: ImageViewController = storyBoard.instantiateViewController(withIdentifier: "ImageViewController") as! ImageViewController;
            
            controller.setLabelText(text: (imgPro.getImageFromId(id: element)?._imageName)! +  "  id:" + String(element));
            controller.setImage(image: imgPro.getImageFromMetadata(metadata: imgPro.getImageFromId(id: element)!))
            
            stackView.addArrangedSubview(controller.view)
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
