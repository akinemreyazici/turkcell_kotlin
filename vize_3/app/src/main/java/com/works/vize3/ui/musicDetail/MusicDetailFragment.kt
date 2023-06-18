package com.works.vize3.ui.musicDetail

import android.media.MediaPlayer
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.works.vize3.common.GlideImage
import com.works.vize3.databinding.FragmentMusicDetailBinding
import com.works.vize3.extensions.AlertTools.AlertTools.showToast
import com.works.vize3.models.FavoriteMusic


class MusicDetailFragment : Fragment() {

    private val argument: MusicDetailFragmentArgs by navArgs()


    private var _binding: FragmentMusicDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MusicDetailViewModel
    lateinit var mediaPlayer: MediaPlayer
    var volume: Int = 50
    var isFavourite = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("url", argument.url)
        Log.d("title", argument.title)
        viewModel = ViewModelProvider(this).get(MusicDetailViewModel::class.java)
        viewModel.getContext(requireContext())

        _binding = FragmentMusicDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val txtMusicTitle = binding.txtMusicTitle
        txtMusicTitle.setText(argument.title)

        val addFavButton = binding.imgBtnAddFav
        val delFavButton = binding.imgBtnDelFav

        val volumeImageView = binding.volumeImageView
        val imgMusicPlayer = binding.imgMusicPlayer
        val muiscPlayBtn = binding.MusicPlayBtn
        val muiscPauseBtn = binding.MusicPauseBtn

        val glide = GlideImage
        Glide.with(requireContext()).load(glide.musicImage).into(imgMusicPlayer)
        Glide.with(requireContext()).load(glide.volumeBar).into(volumeImageView)
        Glide.with(requireContext()).load(glide.playButton).into(muiscPlayBtn)
        Glide.with(requireContext()).load(glide.pauseButton).into(muiscPauseBtn)

        val volSeekBar = binding.volSeekBar
        mediaPlayer = MediaPlayer.create(requireContext(), Uri.parse(argument.url))


        Thread {
            volume = viewModel.getVolume()
            Log.d("first volume", volume.toString())
            val volumeFraction = volume.toFloat() / 100
            mediaPlayer.setVolume(volumeFraction, volumeFraction)
            volSeekBar.progress = volume
        }.start()




        volSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                // Kullanıcının ses seviyesini değiştirdiği sürece burası çağrılır
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {
                volume = p0?.progress ?: 50
                val f1 = volume.toFloat() / 100
                mediaPlayer.setVolume(f1, f1)
            }

        })

        muiscPlayBtn.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            }
        }

        muiscPauseBtn.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            }
        }
        viewModel.isFavourite.observe(viewLifecycleOwner) {
            viewModel.checkIfMusicIsFavorited(argument.id)
            isFavourite = it
            Log.d("isFavourite", isFavourite.toString())
        }



        addFavButton.setOnClickListener {
            if (isFavourite != true) {
                addFavButton.visibility = View.INVISIBLE
                delFavButton.visibility = View.VISIBLE
            }
            val favMusic = FavoriteMusic(argument.id, argument.title, argument.url)

            viewModel.addToFavorites(favMusic)
            this.showToast("Favorilere başarıyla eklendi")

        }

        delFavButton.setOnClickListener {
            if (isFavourite == true) {
                addFavButton.visibility = View.VISIBLE
                delFavButton.visibility = View.INVISIBLE
            }
            viewModel.deleteFromFavorites(argument.id)
            this.showToast("Favorilerden başarıyla çıkarıldı")
        }


        return root
    }

    override fun onDestroy() {
        mediaPlayer.stop()
        viewModel.saveVolume(volume)
        Log.d("last volume", volume.toString())
        super.onDestroy()

    }

}


