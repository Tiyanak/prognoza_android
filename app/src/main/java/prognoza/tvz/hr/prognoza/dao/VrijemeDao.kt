package prognoza.tvz.hr.prognoza.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import prognoza.tvz.hr.prognoza.model.entity.VrijemeEntity

/**
 * Created by ifarszky@croz.net on 9.11.2017..
 */
@Dao
interface VrijemeDao {

    @Insert
    fun insertVrijeme(vrijeme: VrijemeEntity)

    @Update
    fun updateVrijeme(vrijeme: VrijemeEntity)

    @Query("SELECT * FROM vrijeme")
    fun fetchVremena(): List<VrijemeEntity>

}