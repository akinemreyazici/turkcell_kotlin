package com.works.days_17.ui.aboutus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.works.days_17.databinding.FragmentAboutusBinding



class AboutusFragment : Fragment() {

    companion object {
        fun newInstance() = AboutusFragment()
    }

    private var _binding : FragmentAboutusBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: AboutusViewModel
    private lateinit var text_aboutus: TextView
    private lateinit var txt_deneme : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(AboutusViewModel::class.java)

        _binding = FragmentAboutusBinding.inflate(inflater, container,false)

        val root : View = binding.root

        text_aboutus = binding.textAboutus
        txt_deneme = binding.txtDeneme


        viewModel.text.observe(viewLifecycleOwner){
            text_aboutus.text = it

        }

        viewModel.text2.observe(viewLifecycleOwner){
            txt_deneme.text = it
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}