//
//  MyString.swift
//  iosApp
//
//  Created by Pau Corbella on 30/08/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation

class MyString: ObservableObject {
    @Published var str : String
    
    init(name:String) {
        str = name
    }
}

