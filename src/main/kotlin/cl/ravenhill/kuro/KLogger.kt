package cl.ravenhill.kuro

/**
 * Entity that logs messages to an output stream.
 */
class Logger private constructor(private val name: String) {
    var outputStream = StdoutOutputStream()

    fun debug(message: () -> String) {

    }

    companion object {
        private val activeLoggers = mutableMapOf<String, Logger>()

        /** Returns a unique instance of a logger for the given name.   */
        fun instance(name: String) = if (name in activeLoggers && activeLoggers[name] != null) {
            activeLoggers[name]
        } else {
            Logger(name).apply { activeLoggers[name] = this }
        }

        /** Returns true if a logger with the given name is active. */
        fun isActive(name: String): Boolean = name in activeLoggers

        internal fun clearActiveLoggers() {
            activeLoggers.clear()
        }
    }
}
