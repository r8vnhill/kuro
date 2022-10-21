package cl.ravenhill.kuro.levels

import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll

suspend fun checkLevelMessage(logFn: (() -> String) -> String) = checkAll<String> {
    val msg = logFn { it }
    msg shouldBe it
}

suspend fun checkNoLevelMessage(logFn: (() -> String) -> String) = checkAll<String> {
    val msg = logFn { it }
    msg.length shouldBe 0
}