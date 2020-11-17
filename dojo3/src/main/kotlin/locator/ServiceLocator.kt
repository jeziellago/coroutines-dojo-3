package locator

import kotlin.reflect.KClass

interface ServiceLocator {

    fun <T: Any> get(clazz: KClass<T>): T

}