package com.celestial.uas2010072.app


import com.celestial.uas2010072.model.ResponseFurnitur
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded

    @GET("furnitur")
    fun getFurnitur(): Call<ResponseFurnitur>

}
