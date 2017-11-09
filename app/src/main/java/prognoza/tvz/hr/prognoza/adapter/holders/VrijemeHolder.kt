package prognoza.tvz.hr.prognoza.adapter.holders

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.rv_item.view.*
import prognoza.tvz.hr.prognoza.activity.GradVrijemeActivity
import prognoza.tvz.hr.prognoza.model.Grad

/**
 * Created by ifarszky@croz.net on 9.11.2017..
 */
class VrijemeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(grad: Grad) = with(itemView){

        rv_tv_broj.text = grad.broj.toString()
        rv_tv_grad.text = grad.grad
        rv_tv_kratica.text = grad.kratica

        rv_ll_item.setOnClickListener {
            var intent = Intent(context, GradVrijemeActivity::class.java)

            intent.putExtra("broj", grad.broj)
            intent.putExtra("grad", grad.grad)
            intent.putExtra("kratica", grad.kratica)

            context.startActivity(intent)

        }

    }

}