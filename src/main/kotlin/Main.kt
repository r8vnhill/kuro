import cl.ravenhill.kuro.logging.Logger

fun main() {
    val logger = Logger.instance("Main")
    logger.debug { "Hello, world!" }
}