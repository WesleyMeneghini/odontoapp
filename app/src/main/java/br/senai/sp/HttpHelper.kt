package br.senai.sp

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

object HttpHelper {

    private val myHeaders = MediaType.parse("application/json; charset=utf-8")

    var client = OkHttpClient()

    // Fazer um POST com JSON
    fun post(url: String, json: String) : String {

        val body = RequestBody.create(myHeaders, json)

        val request = Request
            .Builder()
            .url(url)
            .post(body)
            .build()

        return "OK"
    }
}