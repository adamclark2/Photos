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
    public func getImageList() -> [Int] {
        return [1, 2, 3, 4, 5, 6, 222]
    }
    
    public func getImageFromId(id: Int) -> ImageMetadata? {
        do{
            let json: String = "{\"imageId\":" + String(id) + ", \"imageName\": \"Hello World\" }"
            return try JSONDecoder.init().decode(ImageMetadata.self, from: json.data(using: .utf8)!)
        } catch _{
            // TODO fix this
            return nil;
        }
    }
    
    public func getImageFromMetadata(metadata: ImageMetadata) -> UIImage {
        if(metadata._imageId! % 2 == 0){
            return #imageLiteral(resourceName: "ic_info_48pt");
        }else{
            return #imageLiteral(resourceName: "ic_filter_48pt");
        }
    }
    
    
}
