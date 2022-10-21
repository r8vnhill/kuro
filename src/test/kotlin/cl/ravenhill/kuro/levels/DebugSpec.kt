package cl.ravenhill.kuro.levels

import cl.ravenhill.kuro.logging.Level
import io.kotest.core.spec.style.WordSpec


class DebugSpec : WordSpec({

    "A Trace level with a logging method" should {
        "log a message for the trace method" {
            checkNoLevelMessage(Level.Debug()::trace)
        }

        "log a message for the debug method" {
            checkLevelMessage(Level.Debug()::debug)
        }

        "log a message for the info method" {
            checkLevelMessage(Level.Debug()::info)
        }

        "log a message for the warn method" {
            checkLevelMessage(Level.Debug()::warn)
        }

        "log a message for the error method" {
            checkLevelMessage(Level.Debug()::error)
        }

        "log a message for the fatal method" {
            checkLevelMessage(Level.Debug()::fatal)
        }
    }
})