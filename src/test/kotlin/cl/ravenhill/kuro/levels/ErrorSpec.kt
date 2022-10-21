package cl.ravenhill.kuro.levels

import cl.ravenhill.kuro.logging.Level
import io.kotest.core.spec.style.WordSpec

class ErrorSpec : WordSpec({
    "A Trace level with a logging method" should {
        "log a message for the trace method" {
            checkNoLevelMessage(Level.Error()::trace)
        }

        "log a message for the debug method" {
            checkNoLevelMessage(Level.Error()::debug)
        }

        "log a message for the info method" {
            checkNoLevelMessage(Level.Error()::info)
        }

        "log a message for the warn method" {
            checkNoLevelMessage(Level.Error()::warn)
        }

        "log a message for the error method" {
            checkLevelMessage(Level.Error()::error)
        }

        "log a message for the fatal method" {
            checkLevelMessage(Level.Error()::fatal)
        }
    }
})