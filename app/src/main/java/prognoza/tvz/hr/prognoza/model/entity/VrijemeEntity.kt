package prognoza.tvz.hr.prognoza.model.entity

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import prognoza.tvz.hr.prognoza.model.City

/**
 * Created by ifarszky@croz.net on 9.11.2017..
 */
@Entity(tableName = "vrijeme")
data class VrijemeEntity(@PrimaryKey var id: Int,
                         var grad: String?,
                         var zemlja: String?,
                         var temp: Double?,
                         var temp_max: Double?,
                         var vrijeme: String?,
                         var vlaznost: Int?,
                         var vjetar: Double?,
                         var datum: String?)