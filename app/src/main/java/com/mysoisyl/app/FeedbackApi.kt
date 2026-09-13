package com.mysoisyl.app

import java.net.HttpURLConnection
import java.net.URL

object FeedbackApi {
    fun sendFeedback(userId: String, message: String, callback: (Boolean) -> Unit) {
        Thread {
            val ok = runCatching {
                val connection = URL(ApiConfig.FEEDBACK_URL).openConnection() as HttpURLConnection
                connection.requestMethod = "POST"
                connection.setRequestProperty("Content-Type", "application/json; charset=utf-8")
                connection.doOutput = true
                val json = """{"+userId+":"${escape(userId)}","message":"${escape(message)}"}"""
                connection.outputStream.use { it.write(json.toByteArray()) }
                connection.responseCode in 200..299
            }.getOrDefault(false)
            callback(ok)
        }.start()
    }

    private fun escape(value: String): String =
        value.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n")
}