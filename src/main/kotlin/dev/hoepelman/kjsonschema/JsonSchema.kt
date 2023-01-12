package dev.hoepelman.kjsonschema



data class JsonSchema(
    val `$schema`: String? = null,
    val `$id`: String? = null,
    val title: String? = null,
) {
    private constructor(builder: Builder): this(builder.`$schema`, builder.`$id`, builder.title)

    companion object {
        inline fun jsonSchema(dialect: Dialect = Dialect.V2020_12, block: Builder.() -> Unit) = Builder(dialect).apply(block).build()
    }

    enum class Dialect(val uri: String) {
        DRAFT_07("http://json-schema.org/draft-07/schema#"),
        V2019_09("https://json-schema.org/draft/2019-09/schema"),
        V2020_12("https://json-schema.org/draft/2020-12/schema"),
    }

    class Builder(dialect: Dialect) {
        var `$schema`: String? = null
        var `$id`: String? = null
        var title: String? = null
        fun build() = JsonSchema(this)

        init {
            `$schema` = dialect.uri
        }
    }
}


