package cl.ravenhill.kuro.levels

import cl.ravenhill.kuro.logging.Level
import io.kotest.core.spec.style.WordSpec


class InfoSpec : WordSpec({
    "A Info level with a logging method" should {
        "log a message for the trace method" {
            checkNoLevelMessage(Level.Info()::trace)
        }
        "log a message for the debug method" {
            checkNoLevelMessage(Level.Info()::debug)
        }
        "log a message for the info method" {
            checkLevelMessage(Level.Info()::info)
        }
        "log a message for the warn method" {
            checkLevelMessage(Level.Info()::warn)
        }
        "log a message for the error method" {
            checkLevelMessage(Level.Info()::error)
        }
        "log a message for the fatal method" {
            checkLevelMessage(Level.Info()::fatal)
        }
    }
})
