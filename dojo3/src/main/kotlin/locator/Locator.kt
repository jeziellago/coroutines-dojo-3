package locator

import kotlin.reflect.KClass


inline fun <reified T: Any> get() = Locator.get(T::class)
inline fun <reified T: Any> inject() = lazy { get<T>() }
inline fun <reified T: Any> provides(noinline instance: () -> T) =
    Locator.put(T::class, instance)

object Locator : ServiceLocator {

    private val definitions = mutableMapOf<KClass<*>, () -> Any>()

    fun <T: Any> put(clazz: KClass<T>, instance: () -> T) {
        definitions[clazz] = instance as () -> Any
    }

    override fun <T : Any> get(clazz: KClass<T>): T {
        @Suppress("UNCHECKED_CAST")
        return checkNotNull((definitions[clazz] as? () -> T)?.invoke()) {
            "Instance not found from ${clazz.simpleName}"
        }
    }
}