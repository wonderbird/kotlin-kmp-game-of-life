package systems.boos.xpdbumm.gameoflife

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform