package prognoza.tvz.hr.prognoza

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import prognoza.tvz.hr.prognoza.dao.VrijemeDao
import prognoza.tvz.hr.prognoza.model.entity.VrijemeEntity

/**
 * Created by ifarszky@croz.net on 9.11.2017..
 */
@Database(entities = arrayOf(VrijemeEntity::class), version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun vrijemeDao() : VrijemeDao
}