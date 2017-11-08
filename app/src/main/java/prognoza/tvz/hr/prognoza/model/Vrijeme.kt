package prognoza.tvz.hr.prognoza.model

/**
 * Created by ifarszky@croz.net on 8.11.2017..
 */

data class Vrijeme(val city: City,
                   val coord: Coord,
                   val county: String,
                   val cod: Int,
                   val message: Double,
                   val cnt: Int,
                   val list: List<VrijemeDetalji>)

data class City(val id: Int, val name: String)
data class Coord(val lon: Double, val lat: Double)
data class VrijemeDetalji(val dt: Int,
                          val main: Main,
                          val weather: List<VrijemeVrijeme>,
                          val clouds: Cloud,
                          val wind: Wind,
                          val sys: Sys,
                          val dt_txt: String)

data class Main(val temp: Double,
                val temp_min: Double,
                val temp_max: Double,
                val pressure: Double,
                val sea_level: Double,
                val grnd_level: Double,
                val humidity: Int,
                val temp_kf: Double)

data class VrijemeVrijeme(val id: Int,
                          val main: String,
                          val description: String,
                          val icon: String)

data class Cloud(val all: Int)
data class Wind(val speed: Double,
                val deg: Double)
data class Sys(val pod: String)
