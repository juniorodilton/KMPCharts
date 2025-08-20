package com.juniorodilton.kmpcharts

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform