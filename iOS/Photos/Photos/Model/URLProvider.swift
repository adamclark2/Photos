//
//  URLProvider.swift
//  Photos
//
//  Created by Adam Clark on 3/19/18.
//  Copyright © 2018 Adam Clark. All rights reserved.
//

import Foundation

public class URLProvider {
    private static var urlProv: URLProvider? = nil;
    
    public static func getURLProvider() -> URLProvider {
        if(urlProv == nil){
            urlProv = URLProvider();
        }
        
        return urlProv!;
    }
    
    public func getImagesUrl() -> URL{
        return URL(string: self.getBaseUrl() + "/images?pageNumber=0&numberOfItemsPerPage=12")!;
    }
    
    public func getMetadataUrl(id: Int) -> URL{
        return URL(string: self.getBaseUrl() + "/images/" + String(id))!;
    }
    
    public func getImageUrl(id: Int, width: Int, height: Int) -> URL{
        return URL(string: self.getBaseUrl() + "/images/" + String(id) + "-" + String(width) + "x" + String(height) + ".jpg")!;
    }
    
    public func getBaseUrl() -> String{
        // Get the URL ...
        // This will be changed in the `final` version
        return ProcessInfo.processInfo.environment["baseURL"]!
    }
}
