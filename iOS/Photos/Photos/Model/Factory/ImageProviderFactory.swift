//
//  ImageProviderFactory.swift
//  Photos
//
//  Created by Adam Clark on 3/16/18.
//  Copyright © 2018 Adam Clark. All rights reserved.
//

import Foundation
import UIKit.UIImage

/**
 * The recomended way to get a ImageProvider
 *
 * Call getImageProvider() to get a ImageProvider
 * The implementation is not relevant
 */
public class ImageProviderFactory{
    private static let ip = MockImageProvider();
    /**
        Get an ImageProvider
     
     - Returns: a implementation of ImageProvider relevant to the application
     - **Note:**
        The ImageProvider returned could be any implementation, however the implementation is relevant to the application
    */
    public static func getImageProvider() -> ImageProvider{
        return self.ip;
    }
}
