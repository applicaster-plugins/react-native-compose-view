//
//  SwiftUIViewProxy.swift
//  react-native-compose-view
//
//  Created by Avi Levin on 26/10/2021.
//

import Foundation
import SwiftUI

@objcMembers class SwiftUIViewProxy: NSObject {
    private var vc = UIHostingController(rootView: SwiftUIView())
    var view: UIView {
        return vc.view
    }
}
