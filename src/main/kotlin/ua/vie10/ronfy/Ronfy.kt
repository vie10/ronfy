package ua.vie10.ronfy

import java.io.Closeable
import java.util.concurrent.ConcurrentHashMap
import kotlin.reflect.KClass

/**
 * Object to interact with Ronfy.
 * Avoid using it at places where you use file functions.
 * @author vie10
 */
object Ronfy : Iterable<Any>, Closeable {

    private val containerMap: MutableMap<KClass<*>, Any> = ConcurrentHashMap()

    /**
     * Uploads the object to Ronfy.
     * @receiver The object to upload.
     */
    fun <T : Any> T.uploadToRonfy() {
        containerMap[this::class] = this
    }

    /**
     * Loads the object of the class from Ronfy if has been uploaded.
     * @receiver The class of the object you're looking for.
     * @return The uploaded object or null if wasn't uploaded.
     */
    fun <T : Any> KClass<T>.loadFromRonfy(): T? = containerMap[this] as T?

    /**
     * Clears the object of the class in Ronfy.
     * @receiver The class of the object to clear.
     * @return The object that has been cleared or null if no object has been found.
     */
    fun <T : Any> KClass<T>.clearInRonfy(): T? = containerMap.remove(this) as T?

    /**
     * Deletes all the containing values from Ronfy.
     */
    fun clear() {
        containerMap.clear()
    }

    /**
     * Invokes [Ronfy.clear].
     */
    override fun close() {
        clear()
    }

    /**
     * Returns iterator of all the values that Ronfy contains.
     */
    override fun iterator(): Iterator<Any> = containerMap.values.iterator()
}
