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
    private var upvoteLabel: UILabel? = nil;
    
    public func setRefs(id: Int, label: UILabel){
        self.idOfImage = id;
        self.upvoteLabel = label;
    }
    
    required public init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        self.addTarget(self, action: #selector(self.doPush), for: UIControlEvents.touchUpInside)
    }
    
    @objc public func doPush(_ sender: AnyClass?){
        ImageProviderFactory.getImageProvider().doUpvote(id: self.idOfImage);
        ImageProviderFactory.getImageProvider().getImageFromId(id: idOfImage, closure: { (e: ImageMetadata) -> Void in
            if(self.upvoteLabel != nil){
                self.upvoteLabel?.text = String(e.UpVotes);
            }
        });
    }
    
}
