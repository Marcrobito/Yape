//
//  Model.swift
//  Recipes
//
//  Created by Marco Antonio Martinez Gutierrez on 14/01/23.
//

import Foundation
import Alamofire

class Model: MainPresenterToModelProtocol{
    
    let BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    var presenter: MainModelToPresenterProtocol?
    
    func fetchRecipes(recipe:String){
        
    }
    
    func searchRecipe(recipe: String) {
        AF.request("\(BASE_URL)search.php?s=\(recipe)").responseDecodable(of: RecipeResponse.self) { response in
            switch response.result {
            case .success:
                do{
                    let result = try JSONDecoder().decode(RecipeResponse.self, from: response.data!)
                    self.presenter?.fetchRecipe(recipes: result.meals.map { meal in
                        meal.toRecipeViewEntity()
                    })
                }catch {
                    self.presenter?.errorFetchingProducts(error: error.localizedDescription)
                }
            case .failure(let error):
                self.presenter?.errorFetchingProducts(error:  error.errorDescription ?? "No se logro completar la consulta")
            }
            
        }
    }
    
    
}
