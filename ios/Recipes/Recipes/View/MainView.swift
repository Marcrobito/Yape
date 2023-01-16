//
//  MainView.swift
//  Recipes
//
//  Created by Marco Antonio Martinez Gutierrez on 03/01/23.
//
import SwiftUI

struct MainView: View {
    
    @State var meal:String = ""
    @State var results:Int = 0
    
    var body: some View {
        VStack(
            alignment: .center,
                spacing: 10
        ){
            HStack(){
                TextField("Meal", text: $meal)
                Button("Search", action: {})
            }.padding()
            //if
            Text("\(results) results found")
            
        }
    }
}

struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        MainView()
    }
}
