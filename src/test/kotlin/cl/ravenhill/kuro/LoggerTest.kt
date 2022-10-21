package cl.ravenhill.kuro

import cl.ravenhill.kuro.logging.Logger
import com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldMatch
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.property.Arb
import io.kotest.property.arbitrary.Codepoint
import io.kotest.property.arbitrary.alphanumeric
import io.kotest.property.arbitrary.string
import io.kotest.property.assume
import io.kotest.property.checkAll
import java.lang.Thread.currentThread

/**
 * Test specification for [Logger].
 */
class LoggerTest : WordSpec({
    beforeEach {
        Logger.clearActiveLoggers()
    }

    "A Logger instance" should {
        "be singleton" {
            checkAll<String> { name ->
                Logger.instance(name) shouldBe Logger.instance(name)
                Logger.instance(name) shouldBeSameInstanceAs Logger.instance(name)
            }
        }

        "be unique" {
            checkAll<String, String> { name1, name2 ->
                assume(name1 != name2)
                Logger.instance(name1) shouldNotBe Logger.instance(name2)
            }
        }

        "is created if it doesn't exist" {
            checkAll<String> { name ->
                assume(!Logger.isActive(name))
                Logger.instance(name)
                Logger.isActive(name) shouldBe true
            }
        }
    }

    "A DEBUG message" should {
        "be logged to stdout" {
            checkAll(
                Arb.string(0..100, Codepoint.alphanumeric()),
                Arb.string(0..100_000, Codepoint.alphanumeric())
            ) { name, message ->
                val logger = Logger.instance(name)
                val out = tapSystemOut {
                    logger.debug { message }
                }
                val dateRegex = "[0-9]{4}-(0[0-9]|1[0-2])-(3[0-1]|[0-2][0-9])"
                val timeRegex = "(2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9].[0-9]*{9}"
                out shouldMatch "${dateRegex}T$timeRegex \\[${currentThread().name}] DEBUG $name - $message".toRegex()
            }
        }
    }
})
