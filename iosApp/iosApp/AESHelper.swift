import Foundation
import CryptoKit
@objc public class AESHelper: NSObject {
    @objc public static func encrypt(string: String, key: String) -> String? {
        guard let keyData = Data(base64Encoded: key) else {
            print("Invalid base64 key")
            return nil
        }
        let symmetricKey = SymmetricKey(data: keyData)
        guard let data = string.data(using: .utf8) else {
            print("Invalid input string")
            return nil
        }
        guard let sealedBox = try? AES.GCM.seal(data, using: symmetricKey) else {
            print("Encryption failed")
            return nil
        }
        return sealedBox.combined?.base64EncodedString()
    }

    @objc public static func decrypt(base64: String, key: String) -> String? {
        guard let data = Data(base64Encoded: base64),
              let keyData = Data(base64Encoded: key),
              let sealedBox = try? AES.GCM.SealedBox(combined: data),
              let decryptedData = try? AES.GCM.open(sealedBox, using: SymmetricKey(data: keyData))
        else {
            print("Decryption failed")
            return nil
        }
        return String(data: decryptedData, encoding: .utf8)
    }
}
