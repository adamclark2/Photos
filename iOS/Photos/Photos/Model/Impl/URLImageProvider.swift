//
//  ImageProvider.swift
//  Photos
//
//  Created by Adam Clark on 3/19/18.
//  Copyright © 2018 Adam Clark. All rights reserved.
//

import Foundation
import UIKit.UIImage


public class URLImageProvider : ImageProvider{
    public func getImageFromMetadata(metadata: ImageMetadata, closure: @escaping (UIImage) -> Void) {
        URLSession.shared.dataTask(with: URLProvider.getURLProvider().getImagesUrl()){
            (data, nsURLResponse, err) -> Void in
            closure(UIImage(data: data!)!)
        }.resume()
    }
    
    public func getImageList(closure: @escaping ([Int]) -> Void) {
        URLSession.shared.dataTask(with: URLProvider.getURLProvider().getImagesUrl())
        { (data, nsUrlResponse, error) -> Void in
            do{
                closure(try JSONDecoder.init().decode([Int].self, from: data!));
            }catch _ {
                // TODO
            }
        }.resume();
    }
    
    public func getImageFromId(id: Int, closure: @escaping (ImageMetadata) -> Void) {
        URLSession.shared.dataTask(with: URLProvider.getURLProvider().getMetadataUrl(id: id)){
            (data, nsURLResponse, err) -> Void in
            do{
                closure(try JSONDecoder.init().decode(ImageMetadata.self, from: data!))
            }catch _{
                // TODO
            }
        }.resume()
    }
    
}
