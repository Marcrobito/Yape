//
//  MainPresenter.swift
//  Recipes
//
//  Created by Marco Antonio Martinez Gutierrez on 14/01/23.
//

import Foundation

class MainPresenter:MainViewToPresenterProtocol{
    var model: MainPresenterToModelProtocol?
    
    weak var delegate: MainPresenterDelegate?
    
    func searchRecipe(recipe: String) {
        model?.searchRecipe(recipe: recipe)
        self.delegate?.renderLoading()
    }
    

}

extension MainPresenter: MainModelToPresenterProtocol{
    func fetchRecipe(recipes: [RecipeViewEntity]) {
        print(recipes)
        if recipes.isEmpty {
            self.delegate?.render(errorMessage: "No se encontraron productos")
            return
        }
        
        self.delegate?.render(recipes: recipes)
    }
    
    func errorFetchingProducts(error: String) {
        self.delegate?.render(errorMessage: error)
    }
    
}
