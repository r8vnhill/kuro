package cl.ravenhill.kuro.levels

import cl.ravenhill.kuro.logging.Level
import io.kotest.core.spec.style.WordSpec

class FatalSpec : WordSpec({
    "A Fatal level with a logging method" should {
        "log a message for the trace method" {
            checkNoLevelMessage(Level.Fatal()::trace)
        }

        "log a message for the debug method" {
            checkNoLevelMessage(Level.Fatal()::debug)
        }

        "log a message for the info method" {
            checkNoLevelMessage(Level.Fatal()::info)
        }

        "log a message for the warn method" {
            checkNoLevelMessage(Level.Fatal()::warn)
        }

        "log a message for the error method" {
            checkNoLevelMessage(Level.Fatal()::error)
        }

        "log a message for the fatal method" {
            checkLevelMessage(Level.Fatal()::fatal)
        }
    }
})