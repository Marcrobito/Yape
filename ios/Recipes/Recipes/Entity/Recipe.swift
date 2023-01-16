//
//  RecipeResponse.swift
//  Recipes
//

//  Created by Marco Antonio Martinez Gutierrez on 03/01/23.
//

import Foundation
import SwiftUI

struct Recipe:Hashable, Codable {
    var idMeal:String
    var strMeal:String
    var strArea:String
    var strMealThumb: String
    /*var imageView: Image {
        Image(uiImage: strMealThumb.loadImage())
    }*/
}

struct RecipeResponse: Codable {
    var meals:[Recipe]
}

extension Recipe{
    func toRecipeViewEntity() -> RecipeViewEntity{
        return RecipeViewEntity(idMeal: idMeal, name: strMeal, region: strArea, imageView:  Image(uiImage: strMealThumb.loadImage()))
    }
}

