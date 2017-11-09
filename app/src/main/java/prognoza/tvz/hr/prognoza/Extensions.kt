package prognoza.tvz.hr.prognoza

import android.app.Activity
import android.widget.Toast

/**
 * Created by ifarszky@croz.net on 9.11.2017..
 */
class Extensions {
    companion object {
        fun Activity.pokaziToast() {
            Toast.makeText(this, "bok", Toast.LENGTH_LONG)
        }
    }
}
