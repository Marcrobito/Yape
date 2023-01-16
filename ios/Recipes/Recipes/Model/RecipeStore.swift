//
//  RecipeState.swift
//  Recipes
//
//  Created by Marco Antonio Martinez Gutierrez on 14/01/23.
//

import Foundation

class RecipeStore: ObservableObject {
    enum State {
        case loading
        case error(message: String)
        case loaded(_ recipes: [RecipeViewEntity])
        case notInitializated
    }
    
    @Published var state: State = .notInitializated
}

extension RecipeStore: MainPresenterDelegate{
    func render(errorMessage: String) {
        self.state = .error(message: errorMessage)
    }
    
    func renderLoading() {
        self.state = .loading
    }
    
    func render(recipes: [RecipeViewEntity]) {
        self.state = .loaded(recipes)
    }
}
