import Foundation
import ComposeApp

@objc public class SwiftCryptoBridge: NSObject {
    @objc public static func setup() {
        ComposeApp.SwiftCryptoBridge.shared.encryptHandler = { input, key in
            AESHelper.encrypt(string: input, key: key)
        }

        ComposeApp.SwiftCryptoBridge.shared.decryptHandler = { base64, key in
            AESHelper.decrypt(base64: base64, key: key)
        }
    }
}