package cl.ravenhill.kuro.logging

import cl.ravenhill.kuro.levels.checkLevelMessage
import cl.ravenhill.kuro.levels.checkNoLevelMessage
import io.kotest.core.spec.style.WordSpec

class WarnSpec : WordSpec({

    "A Warn level with a logging method" should {
        "not log a message for the trace method" {
            checkNoLevelMessage(Level.Warn()::trace)
        }

        "not log a message for the debug method" {
            checkNoLevelMessage(Level.Warn()::debug)
        }

        "not log a message for the info method" {
            checkNoLevelMessage(Level.Warn()::info)
        }

        "log a message for the warn method" {
            checkLevelMessage(Level.Warn()::warn)
        }

        "log a message for the error method" {
            checkLevelMessage(Level.Warn()::error)
        }

        "log a message for the fatal method" {
            checkLevelMessage(Level.Warn()::fatal)
        }
    }
})
