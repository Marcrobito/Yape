//
//  MVP.swift
//  Recipes
//
//  Created by Marco Antonio Martinez Gutierrez on 14/01/23.
//

import Foundation

protocol MainViewToPresenterProtocol: AnyObject {
    var model:MainPresenterToModelProtocol? { get set }
    var delegate: MainPresenterDelegate? { get set }
    func searchRecipe(recipe:String)
}

protocol MainPresenterToViewProtocol: AnyObject {
    
}

protocol MainPresenterDelegate: AnyObject {
  func render(errorMessage: String)
  func renderLoading()
  func render(recipes: [RecipeViewEntity])
}


protocol MainPresenterToModelProtocol: AnyObject {
    var presenter:MainModelToPresenterProtocol? { get set }
    func searchRecipe(recipe:String)
}

protocol MainModelToPresenterProtocol: AnyObject {
    func fetchRecipe(recipes:[RecipeViewEntity])
    func errorFetchingProducts(error:String)
}
