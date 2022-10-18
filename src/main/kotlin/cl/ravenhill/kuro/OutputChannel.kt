package cl.ravenhill.kuro

/** Channel where messages can be written to.   */
interface OutputChannel {
    /** Writes a message to the channel.    */
    fun write(message: String)
}

class CompositeOutputChannel(private vararg val outputStreams: OutputChannel) : OutputChannel {
    override fun write(message: String) = outputStreams.forEach { it.write(message) }
}

class BufferedOutputChannel : OutputChannel {
    private val buffer = StringBuilder()

    override fun write(message: String) {
        buffer.append(message)
    }

    override fun toString() = buffer.toString()

    fun clear() {
        buffer.clear()
    }
}

class StdoutOutputStream : OutputChannel {
    override fun write(message: String) {
        print(message)
    }
}