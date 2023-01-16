//
//  RecipeGrid.swift
//  Recipes
//
//  Created by Marco Antonio Martinez Gutierrez on 15/01/23.
//

import SwiftUI

struct RecipeGrid: View {
    var recipes:[RecipeViewEntity]
    init(recipes:[RecipeViewEntity]){
        self.recipes = recipes
    }
    
    private var gridItemLayout = [GridItem(.flexible()), GridItem(.flexible())]
    
    var body: some View {
        ScrollView {
            LazyVGrid(columns: gridItemLayout, spacing: 20) {
                ForEach(self.recipes){ recipe in
                    ZStack(alignment: Alignment.bottom){
                        recipe.imageView
                            .resizable()
                            .frame(maxWidth:.infinity, maxHeight:120)
                        Text(recipe.name).foregroundColor(.white).background(Color( red: 0.0, green: 0.0, blue: 0.0, opacity: 0.6))
                    }
                }
            }.padding(.horizontal)
        }
    }
    
}

/*struct ProductsList: View {
    var products:[Product]
    var body: some View {
        List(products){ product in
            ProductRow(product: product)
        }
    }
}
*/
