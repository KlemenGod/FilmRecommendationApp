package com.example.filmrecomendationapp.network

import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.io.IOException


private val client = OkHttpClient()


val JSON = "application/json; charset=utf-8".toMediaType()

fun getRequest(success: (String?) -> Unit){
    //val body = RequestBody.create(JSON, "{\"data\":\"$data\"}")
    val request = Request.Builder()
        .url("https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc")
        .get()
        .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyZjIwNDk4NjYxMDcwZWVkYWQzZDllZTdmOTA1ZmUxOSIsIm5iZiI6MTczNTU4Njk5Ni4yMDEsInN1YiI6IjY3NzJmNGI0NWYxYzRmYTQ3MzYxODBhMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.sv5Qfbktu5Xudlord3PC8Yo4zpqzWgaNulrsoFRUy8o")
        //.post(body)
        .build()

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            // Handle request failure here
            println("Request failed: ${e.message}")
        }

        override fun onResponse(call: Call, response: Response) {
            // Handle successful response here
            success(response.body?.string())
        }
    })
    //println(response.request)
    //println(response.body!!.string())
    //return response.body!!.string()
}
