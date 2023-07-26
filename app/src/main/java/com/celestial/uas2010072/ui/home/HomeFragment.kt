package com.celestial.uas2010072.ui.home
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.celestial.uas2010072.app.ApiConfig
import com.celestial.uas2010072.R
import com.celestial.uas2010072.adapter.AdapterFurnitur
import com.celestial.uas2010072.model.FurniturModel
import com.celestial.uas2010072.model.ResponseFurnitur

import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {

    //
    lateinit var  rvFurnitur: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        init(view)
        getFurnitur()
        return view
    }

    private var listFurnitur: ArrayList<FurniturModel> = ArrayList()

    fun getFurnitur(){
        ApiConfig.instanceRetrofit.getFurnitur().enqueue(object :
            retrofit2.Callback<ResponseFurnitur> {

            override fun onResponse(call: Call<ResponseFurnitur>, response: Response<ResponseFurnitur>) {
                val res = response.body()!!
                listFurnitur = res.furnitur
                displayFurnitur()
            }
            override fun onFailure(call: Call<ResponseFurnitur>, t: Throwable) {
                Toast.makeText(requireActivity(), "Error :"+t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun displayFurnitur() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

         rvFurnitur.adapter = AdapterFurnitur(requireActivity(), listFurnitur)
         rvFurnitur.layoutManager = layoutManager
    }

    fun init(view: View) {
        //rvBarang = view.findViewById(R.id.recyler_view)
         rvFurnitur=view.findViewById(R.id.recyler_furnitur)
    }

}
