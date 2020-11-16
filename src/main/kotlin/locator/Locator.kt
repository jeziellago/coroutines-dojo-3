package locator

import kotlin.reflect.KClass

object Locator : ServiceLocator {

    private val definitions = mutableMapOf<KClass<*>, () -> Any>()

    fun <T: Any> put(clazz: KClass<T>, instance: () -> T) {
        definitions[clazz] = instance as () -> Any
    }

    override fun <T : Any> get(clazz: KClass<T>): T {
        @Suppress("UNCHECKED_CAST")
        return checkNotNull((definitions[clazz] as? () -> T)?.invoke())
    }
}