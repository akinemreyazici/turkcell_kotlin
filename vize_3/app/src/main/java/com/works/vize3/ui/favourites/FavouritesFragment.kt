package com.works.vize3.ui.favourites


import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.works.vize3.adapter.FavoriteMusicListViewAdapter
import com.works.vize3.databinding.FragmentFavouritesBinding
import com.works.vize3.extensions.AlertTools.AlertTools.showAlertDialog
import com.works.vize3.models.FavoriteMusic

class FavouritesFragment : Fragment() {

    private var _binding: FragmentFavouritesBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: FavouritesViewModel
    lateinit var listview: ListView
    var adapter: FavoriteMusicListViewAdapter? = null
    var list: MutableList<FavoriteMusic> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(FavouritesViewModel::class.java)
        _binding = FragmentFavouritesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listview = binding.favouritesList

        Thread {
            viewModel.getAllFavorites()
        }.start()

        viewModel.favoriteMusicList.observe(viewLifecycleOwner) {
            list = it
            adapter = FavoriteMusicListViewAdapter(requireActivity(), list)
            listview.adapter = adapter
        }

        listview.setOnItemLongClickListener { adapterView, view, i, l ->
            val selectedMusic = listview.getItemAtPosition(i) as FavoriteMusic
            val id = selectedMusic.ID
            this.showAlertDialog(
                "Favorilerden çıkar",
                "Favorilerden çıkarmak istediğinize emin misiniz?",
                "Evet",
                "Hayır",
                { _, _ ->
                    list.remove(selectedMusic)
                    viewModel.deleteFromFavorites(id)
                    adapter?.notifyDataSetChanged()
                }
            )
            true
        }
    }

    override fun onResume() {
        super.onResume()
        adapter?.makeListView(listview)
    }


}