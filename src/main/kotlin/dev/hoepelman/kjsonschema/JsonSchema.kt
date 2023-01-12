package dev.hoepelman.kjsonschema

/** Representation of an object JSON Schema. */
abstract class JsonSchema {
    val `$schema`: String? = null
    val `$id`: String? = null
    val title: String? = null


    data class `2020-12`(
        override val `$id`: String?,
        override val title: String?
    ): JsonSchema {
        override val `$schema`: String = "https://json-schema.org/draft/2020-12/schema"
    }
}
