//
//  UserController.swift
//  Photos
//
//  Created by Adam Clark on 4/5/18.
//  Copyright © 2018 Adam Clark. All rights reserved.
//

import Foundation
import UIKit

public class UserController: UIViewController{
    override public func viewDidLoad() {
        super.viewDidLoad()
        
        NSLog("Woot!!!")
        let storyboard = UIStoryboard.init(name: "User Section", bundle: nil);
        let uctrl = storyboard.instantiateViewController(withIdentifier: "User Controller");
        uctrl.loadViewIfNeeded();
        self.view.addSubview(uctrl.view);
    }
}

public class UserSectionController: UIViewController{
    @IBOutlet weak var imgView: UIImageView!
    
    private var tmpView: UIView?;
    
    @IBAction func unwind(segue: UIStoryboardSegue){
        // unwind
        
    }
    
    override public func viewDidLoad() {
        super.viewDidLoad()
    }
}
