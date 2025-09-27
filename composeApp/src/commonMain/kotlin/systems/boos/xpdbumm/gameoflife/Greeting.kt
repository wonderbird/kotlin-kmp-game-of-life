package systems.boos.xpdbumm.gameoflife

class Greeting {
    private val platform = getPlatform()

    fun greet(): String = "Hello, ${platform.name}!"
}