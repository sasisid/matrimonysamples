package com.bharatmatrimony.config

expect  fun loadProperties(path: String): Map<String, String>
expect  fun resourceExists(path: String): Boolean

