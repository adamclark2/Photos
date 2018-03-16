//
//  ImageMetadata.swift
//  Photos
//
//  Created by Adam Clark on 3/16/18.
//  Copyright © 2018 Adam Clark. All rights reserved.
//

import Foundation

public class ImageMetadata: Codable{
    private var imageId: Int? = nil;
    private var imageName: String? = nil;
    
    /// get the ImageId
    public var _imageId: Int?{
        get{return self.imageId}
    }
    
    /// get the Image Name
    public var _imageName: String?{
        get{return imageName}
    }
    
    public init(){
        
    }
}
