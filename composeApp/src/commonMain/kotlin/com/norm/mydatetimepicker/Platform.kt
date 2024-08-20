package com.norm.mydatetimepicker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform