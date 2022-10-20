package cl.ravenhill.kuro.logging

import cl.ravenhill.kuro.channels.StdoutChannel
import java.util.Objects

/** Entity that logs messages to an output stream.  */
class Logger private constructor(private val name: String) {
    var outputStream = StdoutChannel()

    /** Logs a message at the DEBUG level.  */
    fun debug(message: () -> String) =
        outputStream.write("[${Thread.currentThread().name}] DEBUG $name - ${message()}")

    override fun toString() = "Logger { name: '$name' }"

    override fun equals(other: Any?) = when {
        this === other -> true
        other !is Logger -> false
        Logger::class != other::class -> false
        name != other.name -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(Logger::class, name)

    companion object {
        private val activeLoggers = mutableMapOf<String, Logger>()

        /** Returns a unique instance of a logger for the given name.   */
        fun instance(name: String) =
            activeLoggers.getOrDefault(name, Logger(name)).also { activeLoggers[name] = it }

        /** Returns true if a logger with the given name is active. */
        fun isActive(name: String): Boolean = name in activeLoggers

        /** Clears all active loggers.  */
        internal fun clearActiveLoggers() = activeLoggers.clear()
    }
}
