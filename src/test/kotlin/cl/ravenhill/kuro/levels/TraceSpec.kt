package cl.ravenhill.kuro.levels

import cl.ravenhill.kuro.logging.Logger
import io.kotest.core.spec.style.StringSpec


class TraceSpec : StringSpec({
    lateinit var logger: Logger

    beforeEach {
        logger = Logger.instance("TraceSpec")
    }

})