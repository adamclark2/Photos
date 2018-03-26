//
//  ImageProvider.swift
//  Photos
//
//  Created by Adam Clark on 3/19/18.
//  Copyright © 2018 Adam Clark. All rights reserved.
//

import Foundation
import UIKit.UIImage

/*
public class URLImageProvider : ImageProvider{
    public func getImageFromMetadata(metadata: ImageMetadata, closure: @escaping (UIImage) -> Void) {
        URLSession.shared.dataTask(with:
            URLProvider.getURLProvider().getImageUrl(id: metadata._imageId!, width: 200,height: 200)){
            (data, nsURLResponse, err) -> Void in
            closure(UIImage(data: data!)!)
        }.resume()
    }
    
    public func getImageList(closure: @escaping ([ImageMetadata]) -> Void) {
        NSLog("Getting list...");
        URLSession.shared.dataTask(with: URLProvider.getURLProvider().getImagesUrl())
        { (data, nsUrlResponse, error) -> Void in
            let str = String(data: data!, encoding: .utf8)!
            NSLog("Got list..." + str);
            NSLog(String(describing: str.last))
            do{
                let deco = JSONDecoder();
                let arr = try deco.decode(Array<ImageMetadata>.self, from: data!);
                closure(arr);
            }catch let dataCorrupted {
                // TODO
                NSLog("Error" + dataCorrupted.localizedDescription)
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
    
}*/
