package prognoza.tvz.hr.prognoza

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import prognoza.tvz.hr.prognoza.model.Vrijeme
import prognoza.tvz.hr.prognoza.retrofit.PrognozaAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.openweathermap.org/")
                .build()

        val prognozaApi : PrognozaAPI = retrofit.create(PrognozaAPI::class.java)
        val call : Call<Vrijeme> = prognozaApi.getVrijeme("Zagreb,hr", "hr", getString(R.string.api_key), "metric")

        call?.enqueue(object : Callback<Vrijeme> {

            override fun onResponse(call: Call<Vrijeme>?, response: Response<Vrijeme>?) {

                if (response != null && response.isSuccessful) {
                    var vrijeme: Vrijeme? = response.body();
//                    setWeather(weatherData)
                    tv_mjesto.text = vrijeme?.city?.name
                    tv_temp.text = vrijeme?.list?.get(0)?.main?.temp.toString()
                }

            }

            override fun onFailure(call: Call<Vrijeme>?, t: Throwable?) {
                Log.i("CallbackFailure", t?.message)
            }
        })


    }


}
