package dev.hoepelman.kjsonschema

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialFormat
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.modules.SerializersModule

@OptIn(ExperimentalSerializationApi::class)
class KJsonSchema(
  override val serializersModule: SerializersModule = defaultModule,
) : SerialFormat {
  fun <T> generate(
    serializer: SerializationStrategy<T>,
  ): Any {
    throw NotImplementedError()
  }

  companion object {
    val defaultModule = SerializersModule { }
  }
}
