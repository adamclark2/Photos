//
//  ImageViewController.swift
//  Photos
//
//  Created by Adam Clark on 3/16/18.
//  Copyright © 2018 Adam Clark. All rights reserved.
//

import UIKit

class ImageViewController: UIViewController {

    @IBOutlet var theLabel: UILabel!
    @IBOutlet var theImageView: UIImageView!
    @IBOutlet weak var Spinner: UIActivityIndicatorView!
    
    override func viewDidLoad() {
        
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    public func setImage(image: UIImage){
        loadViewIfNeeded()
        Spinner.isHidden = true;
        theImageView.isHidden = false;
        theImageView.image = image
    }
    
    public func setLabelText(text: String){
        loadViewIfNeeded()
        theLabel.text = text
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
