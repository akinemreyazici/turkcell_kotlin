package com.works.vize3.ui.homepage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import androidx.navigation.fragment.findNavController
import com.works.vize3.adapter.ExpendableListViewAdapter
import com.works.vize3.databinding.FragmentHomepageBinding
import com.works.vize3.rest.configs.ApiClient
import com.works.vize3.models.Item
import com.works.vize3.rest.services.IMusicService


class HomepageFragment : Fragment() {
    var groupTitles = mutableListOf<String>()
    var childTitles = hashMapOf<String, List<Item>>()


    private var _binding: FragmentHomepageBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: HomepageViewModel
    lateinit var adapter: ExpendableListViewAdapter

    lateinit var listView: ExpandableListView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(HomepageViewModel::class.java)
        viewModel.getContext(requireContext())
        _binding = FragmentHomepageBinding.inflate(inflater, container, false)
        val root: View = binding.root

        listView = binding.musicCategoriesList

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.musicService = ApiClient.getClient().create(IMusicService::class.java)


        listView.setOnChildClickListener { expandableListView, view, groupPosition, childPosition, id ->
            val expandableListAdapter =
                expandableListView.expandableListAdapter as ExpandableListAdapter
            val selectedMusic = expandableListAdapter.getChild(
                groupPosition,
                childPosition
            ) as Item // Veriyi adapterden alın
            val url = selectedMusic.url
            val title = selectedMusic.title
            val id = selectedMusic.ID

            Log.d("groupPosition", groupPosition.toString())
            Log.d("childPosition", childPosition.toString())
            Log.d("SelectedMusic", selectedMusic.title)

            navigateToMusicDetailFragment(url, title, id)
            true
        }

        Thread {
            Thread.sleep(2000)
            viewModel.getMusics()
        }.start()

        viewModel.groupTitles.observe(viewLifecycleOwner) {
            groupTitles = it
            adapter.submitGroupList(it)
        }

        viewModel.childTitles.observe(viewLifecycleOwner) {
            childTitles = it
            adapter.submitChildList(it)
        }

        adapter = ExpendableListViewAdapter(requireContext())
        adapter.makeListView(listView)
        listView.setAdapter(adapter)

    }

    fun navigateToMusicDetailFragment(url: String, title: String, id: String) {
        val action =
            HomepageFragmentDirections.actionHomepageFragmentToMusicDetailFragment(url, title, id)
        findNavController().navigate(action)
    }

}