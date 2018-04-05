//
//  MockImageProvider.swift
//  Photos
//
//  Created by Adam Clark on 3/16/18.
//  Copyright © 2018 Adam Clark. All rights reserved.
//

import Foundation
import UIKit.UIImage

/**
 A MockImageProvider for testing
 
 This ImageProvider will return *fake* values to allow for texting
 */
public class MockImageProvider: ImageProvider{
    var metadata: [ImageMetadata] = [];
    var images: [UIImage] = [];
    
    public init(){
        let meta = ImageMetadata(imageId: 0, title: "Hello World", url: "http://google.com", upvotes: 55);
        let metaOne = ImageMetadata(imageId: 1, title: "Version Two", url: "http://google.com", upvotes: 0);
        
        metadata.append(meta)
        metadata.append(metaOne)
        
        self.images.append(#imageLiteral(resourceName: "ic_info_48pt"))
        self.images.append(#imageLiteral(resourceName: "ic_filter_48pt"))
    }
    
    public func getImageList(closure: @escaping ([ImageMetadata]) -> Void){
        closure(metadata);
    }
    
    public func getImageFromId(id:Int, closure: @escaping (ImageMetadata) -> Void) -> Void{
        closure(metadata[id])
    }
    
    public func getImageFromMetadata(metadata: ImageMetadata, closure: @escaping (UIImage) -> Void){
        DispatchQueue.global().async {
            DispatchQueue.global().asyncAfter(deadline: DispatchTime.now() + 2){
                closure(self.images[metadata._imageId!])
            }
        }
    }
    
    public func isAvailable() -> Bool {
        return true;
    }
    
    public func doUpvote(id: Int) {
        metadata[id] = ImageMetadata(imageId: id, title: metadata[id]._imageName, url: metadata[id].URL, upvotes: metadata[id].UpVotes + 1);
    }
    
    public func add(title: String, image: UIImage){
        let id = metadata.count;
        let meta = ImageMetadata(imageId: id, title: title, url: "http://google.com", upvotes: 0);
        metadata.append(meta);
        images.append(image);
    }
}
