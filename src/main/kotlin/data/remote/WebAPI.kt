package data.remote

import io.ktor.client.*
import io.ktor.client.engine.cio.*

class WebAPI {
    private val httpClient = HttpClient(CIO)
    fun getHttpClient(): HttpClient = httpClient
}