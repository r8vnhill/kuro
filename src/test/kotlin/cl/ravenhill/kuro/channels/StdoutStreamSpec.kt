package cl.ravenhill.kuro.channels

import com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.chunked
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll

class StdoutStreamSpec : StringSpec({
    "StdoutStream should write to stdout" {
        checkAll(Arb.string().chunked(0, 1000)) { messages ->
            val stdoutStream = StdoutChannel()
            val out = tapSystemOut { messages.forEach { stdoutStream.write(it) } }
            out shouldBe messages.joinToString("")
        }
    }
})