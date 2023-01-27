package dev.hoepelman.kjsonschema.model

/** A JSON Schema. */
sealed interface JsonSchema {

  /** A normal (object) JSON Schema. */
  interface Schema: JsonSchema {
    val `$schema`: String?
    val `$id`: String?
    val title: String?
    val type: List<SchemaType>?

    val properties: Map<String, JsonSchema>?

    val otherFields: Map<String, Any>?

    val dialect: Dialect?
      get() = `$schema`?.let(Dialect::from)
  }


  data class Builder(
    override var `$schema`: String? = null,
    override var `$id`: String? = null,
    override var title: String? = null,
    override var properties: Map<String, JsonSchema>? = null,
    override var type: List<SchemaType>? = null,
  ) : Schema {
    override var dialect: Dialect?
      get() = super.dialect
      set(dialect) { `$schema` = dialect?.uri }
  }

  /** A boolean JSON Schema. */
  @JvmInline
  value class BooleanSchema(val value: Boolean = true) : JsonSchema {}

  companion object {
    inline fun jsonSchema(
      block: Builder.() -> Unit
    ): Schema = Builder().apply(block)

    fun jsonSchema(value: Boolean): JsonSchema = BooleanSchema(value)
  }

  /** A non-exhaustive enum of all defined fields in a JSON schema.*/
  enum class KnownField(val fieldName: String) {
    SCHEMA_VERSION("\$schema"),
    ID("\$id"),
    TITLE("title"),
    TYPE("type"),
    PROPERTIES("properties");


  }
}
