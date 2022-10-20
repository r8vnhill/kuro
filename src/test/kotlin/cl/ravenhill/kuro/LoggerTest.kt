package cl.ravenhill.kuro

import cl.ravenhill.kuro.logging.Logger
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.property.assume
import io.kotest.property.checkAll

/**
 * Test specification for [Logger].
 */
class LoggerTest : StringSpec({
    beforeEach {
        Logger.clearActiveLoggers()
    }

    "Logger instance should be singleton" {
        checkAll<String> { name ->
            Logger.instance(name) shouldBe Logger.instance(name)
            Logger.instance(name) shouldBeSameInstanceAs Logger.instance(name)
        }
    }

    "Logger instance should be unique" {
        checkAll<String, String> { name1, name2 ->
            assume(name1 != name2)
            Logger.instance(name1) shouldNotBe Logger.instance(name2)
        }
    }

    "A logger is created if it doesn't exist" {
        checkAll<String> { name ->
            assume(!Logger.isActive(name))
            Logger.instance(name)
            Logger.isActive(name) shouldBe true
        }
    }
})
