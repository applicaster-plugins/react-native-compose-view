//
//  SwiftUIView.swift
//  react-native-compose-view
//
//  Created by Avi Levin on 27/10/2021.
//

import SwiftUI

struct SwiftUIView: View {
    let bundle: Bundle
    
    var body: some View {
        ZStack {
            VStack(alignment: .leading) {
                Image("applicaster_image", bundle: bundle)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(height: 150.0)
                
                Text("Hello Applicaster!")
                
                Divider()
                
                Text("This is a Compose view added in RN enviroment")
            }
        }
    }
}
