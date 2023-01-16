//
//  Extencions.swift
//  Recipes
//
//  Created by Marco Antonio Martinez Gutierrez on 03/01/23.
//

import Foundation
import SwiftUI

extension String {
    func loadImage() -> UIImage {
        do {
            guard let url = URL(string: self) else {
                return UIImage()
            }
            let data:Data = try Data(contentsOf: url)
            return UIImage(data: data) ?? UIImage()
        } catch {
            
        }
        return UIImage()
    }
}
