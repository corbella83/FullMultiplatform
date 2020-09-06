import UIKit
import SwiftUI
import shared

class SceneDelegate: UIResponder, UIWindowSceneDelegate, ScreenContractView, ScreenContractRouter {
    
    let presenter = BridgeKt.getInjector().inject(clazz: ScreenPresenter.self) as! ScreenPresenter
    
    var window: UIWindow?

    var contentView: ContentView?

    func scene(_ scene: UIScene, willConnectTo session: UISceneSession, options connectionOptions: UIScene.ConnectionOptions) {
        
        // Create the SwiftUI view that provides the window contents.
        contentView = ContentView(
            ipCallback: { self.presenter.onParamClick(param: "ip")},
            countryCallback: { self.presenter.onParamClick(param: "country")},
            locationCallback: { self.presenter.onParamClick(param: "location")},
            platformCallback: { self.presenter.onParamClick(param: "platform")}
        )

        // Use a UIHostingController as window root view controller.
        if let windowScene = scene as? UIWindowScene {
            let window = UIWindow(windowScene: windowScene)
            window.rootViewController = UIHostingController(rootView: contentView)
            self.window = window
            window.makeKeyAndVisible()
        }
        
        presenter.initialize(args: Arguments())
        presenter.attachView(view: self)
    }

    
    func drawValue(name: String) {
        contentView?.txt1.str = name
    }
    

}

