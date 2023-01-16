//
//  ContentView.swift
//  Recipes
//
//  Created by Marco Antonio Martinez Gutierrez on 30/12/22.
//

import SwiftUI
import Alamofire

struct ContentView: View {
    
    @State var meal:String = ""
    @State var items:Int = 0
    
    var presenter: MainViewToPresenterProtocol?
    @ObservedObject var store: RecipeStore
    
    init(_ store: RecipeStore, _ presenter: MainViewToPresenterProtocol? = nil) {
        self.store = store
        self.presenter = presenter
    }
    
    var body: some View {
        VStack(
            alignment: .center,
                spacing: 10
        ){
            HStack(){
                TextField("Meal", text: $meal)
                Button("Search", action: {
                    presenter?.searchRecipe(recipe:"\(meal)")
                })
            }.padding()
        }
        
        NavigationView { () -> AnyView in
            switch store.state {
            case .loading:
                return AnyView(Text("loading"))
            case .error(let message):
                return AnyView(Text(message))
            case .loaded(let recipes): return AnyView(RecipeGrid(recipes: recipes))
            default: return AnyView(Text(""))
            }
            
        }
    }
}

/*struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        //ContentView()
    }
}*/
