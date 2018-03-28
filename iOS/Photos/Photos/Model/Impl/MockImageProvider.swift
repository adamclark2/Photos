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
    public func getImageList(closure: @escaping ([ImageMetadata]) -> Void){
        let meta: [ImageMetadata] = [ImageMetadata.getDebug(), ImageMetadata.getDebug()];
        closure(meta);
    }
    
    public func getImageFromId(id:Int, closure: @escaping (ImageMetadata) -> Void) -> Void{
        do{
            let json: String = "{\"imageId\":" + String(id) + ", \"imageName\": \"Hello World\" }"
            do{
                closure(try JSONDecoder.init().decode(ImageMetadata.self, from: json.data(using: .utf8)!))
            }
        } catch _{
            // TODO fix this
        }
    }
    
    public func getImageFromMetadata(metadata: ImageMetadata, closure: @escaping (UIImage) -> Void){
        if(metadata._imageId! % 2 == 0){
            closure(#imageLiteral(resourceName: "ic_info_48pt"));
        }else{
            closure(#imageLiteral(resourceName: "ic_filter_48pt"));
        }
    }
    
    public func isAvailable() -> Bool {
        return true;
    }
    
    public func doUpvote(id: Int) -> Int {
        return 999;
    }
}
