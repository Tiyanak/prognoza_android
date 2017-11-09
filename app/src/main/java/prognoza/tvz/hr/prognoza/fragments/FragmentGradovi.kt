package prognoza.tvz.hr.prognoza.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_tabbed.*
import prognoza.tvz.hr.prognoza.R
import prognoza.tvz.hr.prognoza.adapter.VrijemeAdapter
import prognoza.tvz.hr.prognoza.model.Grad

/**
 * Created by ifarszky@croz.net on 9.11.2017..
 */
class FragmentGradovi : Fragment() {

    lateinit var llManager : LinearLayoutManager
    lateinit var gradoviAdapter: VrijemeAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_tabbed, container, false)
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        llManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        val gradovi : ArrayList<Grad> = arrayListOf<Grad>()
        gradovi.add(Grad(1, "Zagreb", "hr"))
        gradovi.add(Grad(2, "London", "uk"))

        gradoviAdapter = VrijemeAdapter(gradovi)

        rv_view.layoutManager = llManager
        rv_view.adapter = gradoviAdapter

    }

    companion object {
        fun newInstance() = FragmentGradovi()
    }
}