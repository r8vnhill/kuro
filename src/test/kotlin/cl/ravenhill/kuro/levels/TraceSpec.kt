package cl.ravenhill.kuro.levels

import cl.ravenhill.kuro.logging.Level
import io.kotest.core.spec.style.WordSpec


class TraceSpec : WordSpec({

    "A Trace level with a logging method" should {
        "log a message for the trace method" {
            checkLevelMessage(Level.Trace()::trace)
        }

        "log a message for the debug method" {
            checkLevelMessage(Level.Trace()::debug)
        }

        "log a message for the info method" {
            checkLevelMessage(Level.Trace()::info)
        }

        "log a message for the warn method" {
            checkLevelMessage(Level.Trace()::warn)
        }

        "log a message for the error method" {
            checkLevelMessage(Level.Trace()::error)
        }

        "log a message for the fatal method" {
            checkLevelMessage(Level.Trace()::fatal)
        }
    }
})