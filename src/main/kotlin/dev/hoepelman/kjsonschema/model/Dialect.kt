package dev.hoepelman.kjsonschema.model

enum class Dialect(val uri: String) {
  DRAFT_07("http://json-schema.org/draft-07/schema#"),
  V2019_09("https://json-schema.org/draft/2019-09/schema"),
  V2020_12("https://json-schema.org/draft/2020-12/schema"),

  companion object {
    fun from(uri: String): Dialect? = when(uri) {
      DRAFT_07.uri -> DRAFT_07
      V2019_09.uri -> V2019_09
      V2020_12.uri -> V2020_12
      else -> null
    }
  }
}


