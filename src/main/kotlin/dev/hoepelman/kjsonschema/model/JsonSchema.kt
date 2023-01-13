package dev.hoepelman.kjsonschema.model

/** A JSON Schema. */
sealed interface JsonSchema {
  /** A normal (object) JSON Schema. */
  data class Schema(
    val `$schema`: String? = null,
    val `$id`: String? = null,
    val title: String? = null,
    val properties: Map<String, JsonSchema>? = null,
    val type: List<SimpleType>? = null,
  ) : JsonSchema {
    private constructor(builder: Builder) : this(
      builder.`$schema`,
      builder.`$id`,
      builder.title,
      builder.properties,
      builder.type
    )

    class Builder(dialect: Dialect) {
      var `$schema`: String? = null
      var `$id`: String? = null
      var title: String? = null
      val properties: Map<String, JsonSchema>? = null
      var type: List<SimpleType>? = null
      fun build() = Schema(this)

      init {
        `$schema` = dialect.uri
      }
    }
  }

  /** A boolean JSON Schema. */
  @JvmInline value class BooleanSchema(val value: Boolean) : JsonSchema

  companion object {
    inline fun jsonSchema(
      dialect: Dialect = Dialect.V2020_12,
      block: Schema.Builder.() -> Unit
    ): Schema = Schema.Builder(dialect).apply(block).build()
    fun jsonSchema(value: Boolean): JsonSchema = BooleanSchema(value)
  }
}
