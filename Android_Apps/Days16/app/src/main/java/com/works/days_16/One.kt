package com.works.days_16

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.works.days_16.configs.ApiClient
import com.works.days_16.models.AddBasket
import com.works.days_16.models.BasketResult
import com.works.days_16.models.Product
import com.works.days_16.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [One.newInstance] factory method to
 * create an instance of this fragment.
 */
class One : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var txtOneTitle: TextView
    lateinit var btnOneAddBasket: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments.let {
            //val data = it?.getString("key1")
            //Log.d("data",data!!)
        }
        val bundle = arguments
        val data = bundle!!.getString("key1")
        Log.d("data", data!!)
        val view: View = inflater.inflate(R.layout.fragment_one, container, false)
        txtOneTitle = view.findViewById(R.id.txtOneTitle)
        btnOneAddBasket = view.findViewById(R.id.btnOneAddBasket)

        txtOneTitle.text = data

        btnOneAddBasket.setOnClickListener {
            //Log.d("basket","add basket")
            val pro1 = Product(10, 2)
            val basketList = mutableListOf<Product>(pro1)
            val sendBasket = AddBasket(1, basketList)

            val dummyService = ApiClient.getClient().create(DummyService::class.java)
            dummyService.addBasket(sendBasket).enqueue(object : Callback<BasketResult> {
                override fun onResponse(
                    call: Call<BasketResult>,
                    response: Response<BasketResult>
                ) {
                    if (response.isSuccessful) {
                        val basketResult = response.body()
                        Log.d("basketResult", basketResult.toString())
                    }
                }

                override fun onFailure(call: Call<BasketResult>, t: Throwable) {
                    Log.e("error", t.toString())
                }
            })
        }

        // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment One.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            One().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}