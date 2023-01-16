//
//  RecipeIdentifiable.swift
//  Recipes
//
//  Created by Marco Antonio Martinez Gutierrez on 15/01/23.
//

import Foundation
import SwiftUI

struct RecipeViewEntity:Identifiable{
    var id = UUID()
    
    var idMeal:String
    var name:String
    var region:String
    var imageView: Image
}
