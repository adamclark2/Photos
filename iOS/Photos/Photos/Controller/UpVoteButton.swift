//
//  UpVoteButton.swift
//  Photos
//
//  Created by Adam Clark on 3/28/18.
//  Copyright © 2018 Adam Clark. All rights reserved.
//

import Foundation
import UIKit

public class UpVoteButton : UIButton{
    
    private var idOfImage: Int = 0;
    
    public func setIdOfImage(id: Int){
        self.idOfImage = id;
    }
    
    required public init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        self.addTarget(self, action: #selector(self.doPush), for: UIControlEvents.touchUpInside)
    }
    
    @objc public func doPush(_ sender: AnyClass?){
        let num = ImageProviderFactory.getImageProvider().doUpvote(id: self.idOfImage);
        NSLog("Has done vote")
    }
}
