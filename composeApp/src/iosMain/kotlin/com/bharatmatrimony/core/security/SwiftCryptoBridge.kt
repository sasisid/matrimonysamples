package com.bharatmatrimony.core.security

import kotlin.experimental.ExperimentalObjCName

@OptIn(ExperimentalObjCName::class)
@ObjCName("SwiftCryptoBridge", exact = true)
object SwiftCryptoBridge {
    var encryptHandler: ((String, String) -> String?)? = null
    var decryptHandler: ((String, String) -> String?)? = null
}