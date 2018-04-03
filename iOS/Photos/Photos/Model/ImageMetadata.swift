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
    private var title: String = "";
    private var url: String = "";
    private var upvotes: Int = 0;
    
    /// get the ImageId
    public var _imageId: Int?{
        get{return self.imageId}
    }
    
    /// get the Image Name
    public var _imageName: String{
        get{return title}
    }
    
    /// get the Image Name
    public var URL: String{
        get{return url}
    }
    
    public var UpVotes: Int{
        get{return self.upvotes}
    }
    
    public init(){
        
    }
    
    public init(imageId: Int, title: String, url: String, upvotes: Int){
        self.imageId = imageId;
        self.title = title;
        self.url = url;
        self.upvotes = upvotes;
    }
    
    public static func getDebug() -> ImageMetadata{
        let data = ImageMetadata();
        data.imageId = 1;
        data.title = "Debug"
        data.url = "http://example.com/images/1.png"
        
        return data;
    }
}
