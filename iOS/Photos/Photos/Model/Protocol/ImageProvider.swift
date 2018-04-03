//
//  ImageProvider.swift
//  Photos
//
//  Created by Adam Clark on 3/16/18.
//  Copyright © 2018 Adam Clark. All rights reserved.
//

import Foundation
import UIKit.UIImage

/**
     A provider of images
 
     A conformer to this protocol will be able to do stuff to an image from a data-source.
     These things include
 
     - Get a list of images to display
     - Get image metadata from an id
     - Get a UIImage from image metadata
 */
public protocol ImageProvider{
    
    /// Get a list of images that should be displayed to the user
    func getImageList(closure: @escaping ([ImageMetadata]) -> Void);
    
    /// Given an id from wherever (getImageList() or ImageMetadata) get ImageMetadata
    func getImageFromId(id:Int, closure: @escaping (ImageMetadata) -> Void) -> Void;
    
    /// Get Image from a MetadataObject
    func getImageFromMetadata(metadata: ImageMetadata, closure: @escaping (UIImage) -> Void);
    
    /// Is the provider available to take requests
    func isAvailable() -> Bool;
    
    /// upvote something
    func doUpvote(id: Int)
    
    /// Add something
    func add(title: String, image: UIImage) -> Void
}
