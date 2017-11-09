package prognoza.tvz.hr.prognoza.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import prognoza.tvz.hr.prognoza.R
import prognoza.tvz.hr.prognoza.adapter.holders.VrijemeHolder
import prognoza.tvz.hr.prognoza.model.Grad
import java.util.zip.Inflater

/**
 * Created by ifarszky@croz.net on 9.11.2017..
 */
class VrijemeAdapter(var gradovi: List<Grad>) : RecyclerView.Adapter<VrijemeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VrijemeHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.rv_item, parent, false)

        return VrijemeHolder(itemView)
    }

    override fun onBindViewHolder(holder: VrijemeHolder?, position: Int) {
        var grad = gradovi.get(position)

        holder?.bind(grad)
    }

    override fun getItemCount(): Int {
        return gradovi.size
    }

}