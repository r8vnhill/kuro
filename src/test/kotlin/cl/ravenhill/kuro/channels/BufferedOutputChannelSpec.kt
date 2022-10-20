package cl.ravenhill.kuro.channels

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.chunked
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll


class BufferedOutputChannelSpec : StringSpec({
    "BufferedOutputChannel should write to buffer" {
        checkAll(Arb.string().chunked(0, 1000)) { messages ->
            val bufferedOutputChannel = BufferedOutputChannel()
            messages.forEach { bufferedOutputChannel.write(it) }
            bufferedOutputChannel.toString() shouldBe messages.joinToString("")
        }
    }

    "BufferedOutputChannel should clear buffer" {
        checkAll(Arb.string().chunked(0, 1000)) { messages ->
            val bufferedOutputChannel = BufferedOutputChannel()
            messages.forEach { bufferedOutputChannel.write(it) }
            bufferedOutputChannel.clear()
            bufferedOutputChannel.toString() shouldBe ""
        }
    }
})