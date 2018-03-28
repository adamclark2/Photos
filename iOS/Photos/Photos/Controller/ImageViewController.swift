//
//  ImageViewController.swift
//  Photos
//
//  Created by Adam Clark on 3/16/18.
//  Copyright © 2018 Adam Clark. All rights reserved.
//

import UIKit

class ImageViewController: UIViewController {
    
    @IBOutlet weak var btnUpVote: UIButton!
    @IBOutlet weak var btnDownVotes: UIButton!
    @IBOutlet weak var labelUpVotes: UILabel!
    @IBOutlet weak var labelDownVotes: UILabel!
    
    @IBOutlet var theLabel: UILabel!
    @IBOutlet var theImageView: UIImageView!

    @IBOutlet weak var Spinner: UIActivityIndicatorView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        btnUpVote.setTitle("Hello", for: UIControlState.normal)
        labelUpVotes.text = "55-";
        
        self.btnUpVote.addTarget(self, action: #selector(self.onTapUpVote), for: UIControlEvents.allEvents)
    }
    
    @objc func onTapUpVote(_ sender: AnyClass?) {
        NSLog("Hellow");
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    public func setImage(image: UIImage){
        // All this MUST be done on main
        DispatchQueue.main.async {
            self.loadViewIfNeeded()
            self.Spinner.isHidden = true;
            self.theImageView.isHidden = false;
            self.theImageView.image = image
        }
    }
    
    public func setId(id: Int){
        self.loadViewIfNeeded()
        (self.btnUpVote as! UpVoteButton).setIdOfImage(id: id);
    }
    
    public func setLabelText(text: String){
        DispatchQueue.main.async {
            self.loadViewIfNeeded()
            self.theLabel.text = text
        }
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
