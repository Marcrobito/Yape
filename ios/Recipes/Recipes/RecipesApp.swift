//
//  RecipesApp.swift
//  Recipes
//
//  Created by Marco Antonio Martinez Gutierrez on 30/12/22.
//

import SwiftUI

@main
struct RecipesApp: App {
    
    let mainModel:MainPresenterToModelProtocol = Model()
    let mainPresenter : MainViewToPresenterProtocol & MainModelToPresenterProtocol = MainPresenter()
    
    let store:MainPresenterDelegate = RecipeStore()
    
    init(){
        mainPresenter.model = mainModel
        mainModel.presenter = mainPresenter
        mainPresenter.delegate = store
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView(store as! RecipeStore, mainPresenter)
        }
    }
}
