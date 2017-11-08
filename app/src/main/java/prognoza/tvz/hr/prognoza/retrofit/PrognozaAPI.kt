package prognoza.tvz.hr.prognoza.retrofit

import prognoza.tvz.hr.prognoza.model.Vrijeme
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by ifarszky@croz.net on 8.11.2017..
 */

interface PrognozaAPI {

    @GET("/data/2.5/forecast")
    fun getVrijeme(@Query("q") cityLocation: String,
                   @Query("lan") lan: String,
                   @Query("APPID") appid: String,
                   @Query("units") units: String) : Call<Vrijeme>



}