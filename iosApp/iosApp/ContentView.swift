import SwiftUI

struct ContentView: View {
    @ObservedObject var txt1 = MyString(name:"void")
    var ipCallback:()->Void = {}
    var countryCallback:()->Void = {}
    var locationCallback:()->Void = {}
    var platformCallback:()->Void = {}
    
    var body: some View {
        VStack {
            
            HStack{
                Button(action: { self.ipCallback()}) { Text("IP").foregroundColor(Color.white) }.padding(8).cornerRadius(10).background(Color.black)
                Button(action: { self.countryCallback()}) { Text("COUNTRY").foregroundColor(Color.white) }.padding(8).cornerRadius(10).background(Color.black)
                Button(action: { self.locationCallback()}) { Text("LOCATION").foregroundColor(Color.white) }.padding(8).cornerRadius(10).background(Color.black)
                Button(action: { self.platformCallback()}) { Text("PLATFORM").foregroundColor(Color.white) }.padding(8).cornerRadius(10).background(Color.black)
            }
            Text(txt1.str).padding(20)
            
        }
    }
    
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
