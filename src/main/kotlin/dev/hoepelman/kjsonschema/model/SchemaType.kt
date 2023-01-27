package dev.hoepelman.kjsonschema.model


/** JSON schema "simple" types
 * @see <a href="https://json-schema.org/draft/2020-12/json-schema-validation.html#name-type">validation type keyword</a>
 * */
enum class SchemaType {
  ARRAY,
  BOOLEAN,
  INTEGER,
  NULL,
  NUMBER,
  OBJECT,
  STRING;

  override fun toString(): String {
    return this.name.lowercase()
  }
}
