package prognoza.tvz.hr.prognoza.activity

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import prognoza.tvz.hr.prognoza.MyDatabase
import prognoza.tvz.hr.prognoza.R
import prognoza.tvz.hr.prognoza.model.Vrijeme
import prognoza.tvz.hr.prognoza.model.entity.VrijemeEntity
import prognoza.tvz.hr.prognoza.retrofit.PrognozaAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GradVrijemeActivity : AppCompatActivity() {

    lateinit var grad: String
    lateinit var kratica: String
    lateinit var myDatabase: MyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grad_vrijeme)

        initExtras()


        myDatabase = Room.databaseBuilder(this, MyDatabase::class.java, "moja-baza").allowMainThreadQueries().build()

        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.openweathermap.org/")
                .build()

        val prognozaApi : PrognozaAPI = retrofit.create(PrognozaAPI::class.java)
        val mjesto = grad + "," + kratica
        val call : Call<Vrijeme> = prognozaApi.getVrijeme(mjesto, "hr", getString(R.string.api_key), "metric")

        call?.enqueue(object : Callback<Vrijeme> {

            override fun onResponse(call: Call<Vrijeme>?, response: Response<Vrijeme>?) {

                if (response != null && response.isSuccessful) {
                    var vrijeme: Vrijeme? = response.body();
                    tv_mjesto.text = vrijeme?.city?.name
                    tv_temp.text = vrijeme?.list?.get(0)?.main?.temp.toString()
//                    saveToDB(vrijeme)
                }
            }

            override fun onFailure(call: Call<Vrijeme>?, t: Throwable?) {
                Log.i("CallbackFailure", t?.message)
                prikaziIzDB()
            }
        })

    }

    fun initExtras() {

        grad = intent.getStringExtra("grad")
        kratica = intent.getStringExtra("kratica")
    }

    fun saveToDB(vrijeme: Vrijeme?) {
        val vrijemeEnt = VrijemeEntity(
                1, vrijeme?.city?.name, vrijeme?.country,
                vrijeme?.list?.get(0)?.main?.temp, vrijeme?.list?.get(0)?.main?.temp_max,
                vrijeme?.list?.get(0)?.weather?.get(0)?.description, vrijeme?.list?.get(0)?.main?.humidity,
                vrijeme?.list?.get(0)?.wind?.speed, vrijeme?.list?.get(0)?.dt_txt)

        myDatabase.vrijemeDao().insertVrijeme(vrijemeEnt)
    }

    fun prikaziIzDB() {
        val vrijemeLista = myDatabase.vrijemeDao().fetchVremena()

        if (vrijemeLista.isNotEmpty()) {
            val vrijemeEnt = vrijemeLista.get(0)

            tv_mjesto.text = vrijemeEnt.grad
        }
    }
}
